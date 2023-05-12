package br.com.targettrust.aula01.repository;

import br.com.targettrust.aula01.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaRepository {

    private final PessoaJpaRepository jpaRepository;
//
//    private List<Pessoa> lista = new ArrayList<>();

    public PessoaRepository(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Pessoa> listAll(){
        return jpaRepository.findAll();
    }

    public void save(Pessoa pessoa) {
        jpaRepository.save(pessoa);
    }

    public List<Pessoa> findByNomeLike(String nome) {
        return jpaRepository.findByNomeLike("%" + nome + "%");
    }

    public List<Pessoa> findByNome(String nome) {
        return jpaRepository.findByNome(nome);
    }

//    public void addPessoasRandom(){
////        Pessoa pessoa1 = new Pessoa();
////        pessoa1.setNome("João");
////        pessoa1.setIdade(34);
////        Pessoa pessoa2 = new Pessoa();
////        pessoa2.setNome("Eliane");
////        lista.add(pessoa1);
////        lista.add(pessoa2);
//
//        lista.addAll(List.of(
//                new Pessoa("Fulano 1", 12),
//                new Pessoa("Fulano 3", 24)
//        ));
//    }
}
