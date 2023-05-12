package br.com.targettrust.aula01.service;

import br.com.targettrust.aula01.model.Endereco;
import br.com.targettrust.aula01.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Declara um bean no spring de tipo service (lógica de negócio)
// Por padrão os beans tem escopo singleton. O que significa que uma instancia é criada
// e compartilhada em todos as classes que injetam o bean
@Service
//@Scope("prototype")
public class EnderecoService {
    private final EnderecoRepository repository;


    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    //    @Autowired
//    private JdbcTemplate jdbcTemplate;
    public List<Endereco> buscarEnderecos() {
        System.out.println("Busca no banco");;
        return repository.listarEndereco();
    }

    public void alteraEnderecoCompartilhado(String novoNome) {
        repository.setEnderecoCompartilhado(novoNome);
    }
}
