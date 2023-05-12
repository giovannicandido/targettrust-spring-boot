package br.com.targettrust.aula01.controller;

import br.com.targettrust.aula01.model.Pessoa;
import br.com.targettrust.aula01.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    @GetMapping(path = "/pessoa")
    @ResponseBody
    public List<Pessoa> getPessoas() {
      return pessoaService.listAll();
    }

    @PostMapping(path = "/pessoa")
    @ResponseBody
    public void postPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.save(pessoa);
    }

    @GetMapping(path = "/pessoa/search")
    @ResponseBody
    public List<Pessoa> getPessoaByNome(@RequestParam(value = "nome", required = false) String nome,
                                        @RequestParam(value = "nomeLike", required = false) String nomeLike) {
        if(nomeLike != null && !nomeLike.trim().equals("")) {
            return pessoaService.findByNomeLike(nome);
        }
        return pessoaService.findByNome(nome);
    }
}
