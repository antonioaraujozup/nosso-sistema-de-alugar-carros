package br.com.zup.edu.alugacarzup.carro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ReservarCarroController {

    private final CarroRepository repository;

    public ReservarCarroController(CarroRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/carros/{id}")
    @Transactional
    public ResponseEntity<?> reservar(@PathVariable Long id, @RequestBody @Valid ReservaCarroRequest request) {
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não cadastrado"));

        carro.reservar(request.getReservadoPara());

        return ResponseEntity.noContent().build();
    }
}
