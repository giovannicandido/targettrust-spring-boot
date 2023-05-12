package br.com.targettrust.aula01.repository;

import br.com.targettrust.aula01.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.List;
// declara um bean do tipo Repository que seria para acesso a dados
@Repository
public class EnderecoRepository {
    private String enderecoCompartilhado = "Primeiro nome";
    public List<Endereco> listarEndereco() {
        return List.of(
                new Endereco(enderecoCompartilhado, 100),
                new Endereco("attilio", 200),
                new Endereco("Castelo Branco", 1000)
        );
    }

    public void setEnderecoCompartilhado(String novoEndereco) {
        this.enderecoCompartilhado = novoEndereco;
    }

}
