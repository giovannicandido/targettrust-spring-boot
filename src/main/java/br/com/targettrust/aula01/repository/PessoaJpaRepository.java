package br.com.targettrust.aula01.repository;

import br.com.targettrust.aula01.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaJpaRepository extends JpaRepository<Pessoa, Integer> {
    // O @Query é opcional quando o spring pode seguir uma convensão no nome do metodo para gerar
    // a query
    @Query("SELECT p from Pessoa p where p.nome like :nome")
    List<Pessoa> findByNomeLike(String nome);

    List<Pessoa> findByNome(String nome);
}
