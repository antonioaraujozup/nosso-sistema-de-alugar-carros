package br.com.zup.edu.alugacarzup.carro;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String marca;

    @Column
    private String reservadoPara;

    @Column(nullable = false)
    private boolean disponivel;

    public Carro(String modelo, Integer ano, String marca, String reservadoPara) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.reservadoPara = reservadoPara;
        this.disponivel=true;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Carro() {
    }

    public Long getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar(String reservadoPara) {
        if (!this.isDisponivel()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Carro já reservado");
        }

        this.reservadoPara = reservadoPara;
        this.disponivel = false;
    }
}
