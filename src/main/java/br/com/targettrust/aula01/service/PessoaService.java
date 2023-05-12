package br.com.targettrust.aula01.service;

import br.com.targettrust.aula01.model.Pessoa;
import br.com.targettrust.aula01.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    public PessoaService(PessoaRepository pessoaRepository,
                         EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoService = enderecoService;
    }

    public List<Pessoa> listAll() {
        return pessoaRepository.listAll();
    }

    public void save(Pessoa pessoa) {
        if(pessoa.getIdade() < 18) {
            throw new RuntimeException("Pessoas menores de idade não podem tirar carteira");
        }

        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findByNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }

    public List<Pessoa> findByNomeLike(String nome) {
        return pessoaRepository.findByNomeLike(nome);
    }
}
