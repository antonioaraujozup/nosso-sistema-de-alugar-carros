package br.com.zup.edu.alugacarzup.carro;

import javax.validation.constraints.NotBlank;

public class ReservaCarroRequest {

    @NotBlank
    private String reservadoPara;

    public ReservaCarroRequest(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public ReservaCarroRequest() {
    }

    public String getReservadoPara() {
        return reservadoPara;
    }
}
