package br.com.targettrust.aula01.controller;

import br.com.targettrust.aula01.model.Endereco;
import br.com.targettrust.aula01.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EnderecoController {
    // Injecao usando o @Autowired
    // @Autowired
    private final EnderecoService enderecoService;
    // Injeta a classe endereco service controlada pelo spring,
    // Pode ser usado o construtor, ou o @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    /**
     * Quando acessar a url /enderecos e for um GET
     * Retorna um ModelAndView que diz ao spring para instanciar um html com thymeleaf e dentro
     * dessa view podemos adicionar variaveis para criar nossa página
     * @return
     */
    @GetMapping(path = "/enderecos")
    public ModelAndView enderecos() {
        List<Endereco> enderecoList = enderecoService.buscarEnderecos();
        ModelAndView view = new ModelAndView("enderecos");
        // adiciona uma variavel endereço disponível em nosso template html o arquivo src/main/resource/templates/enderecos.html
        // essa variavel tem a lista de endereços retornada
        view.addObject("enderecos", enderecoList);
        return view;
    }

    @PostMapping("/endereco/alterar")
    @ResponseBody
    public void alterarNomeEndereco(@RequestParam String nomeEndereco) {
        enderecoService.alteraEnderecoCompartilhado(nomeEndereco);
    }
}
