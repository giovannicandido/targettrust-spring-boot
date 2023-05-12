package br.com.targettrust.aula01.repository;

import br.com.targettrust.aula01.model.Pessoa;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaRepositoryTest {
   /**
    @Test
    void listAll() {
        PessoaRepository repository = new PessoaRepository(jpaRepository);
        Pessoa joao = new Pessoa();
        joao.setNome("João");
        repository.save(joao);
        Pessoa eliane = new Pessoa();
        joao.setNome("Eliane");
        repository.save(eliane);
        List<Pessoa> pessoas = repository.listAll();
        assertEquals(2, pessoas.size());
    }

    @Test
    void save() {
        PessoaRepository repository = new PessoaRepository(jpaRepository);
        List<Pessoa> pessoas = repository.listAll();
        assertEquals(0, pessoas.size());
        Pessoa joao = new Pessoa();
        joao.setNome("João");
        repository.save(joao);
        pessoas = repository.listAll();
        assertEquals(1, pessoas.size());
        assertEquals("João",pessoas.get(0).getNome());

    }
    **/
}