package br.com.targettrust.aula01.controller;

import br.com.targettrust.aula01.repository.EnderecoRepository;
import br.com.targettrust.aula01.service.EnderecoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoControllerTest {

    @Test
    void enderecos() {
        EnderecoController enderecoController = new EnderecoController(
                new EnderecoService(
                        new EnderecoRepository()
                )
        );

        enderecoController.enderecos();
    }
}