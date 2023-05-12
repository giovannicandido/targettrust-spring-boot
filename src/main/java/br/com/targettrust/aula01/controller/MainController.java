package br.com.targettrust.aula01.controller;

import br.com.targettrust.aula01.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * No MVC um controlador é a porta de entrada e orquestração das
 * requisições da aplicação. No spring teremos um controller para cada
 * tipo de dados ou recursos que queiramos retornar ou manipular.
 */
@Controller
public class MainController {
    private final EnderecoService enderecoService;

    public MainController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    /**
     * A anotação requestMapping diz ao spring em qual url o servidor responde
     * ou seja em qual url o método vai ser chamado.
     * @return
     */
    @RequestMapping(path = "/")
    // ResponseBody diz para o spring retornar a string hello world como está
    // Sem ela ele tenta instanciar uma view em html que seria um arquivo de mesmo nome
    @ResponseBody
    public String index() {
        return "Hello World";
    }

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping(path = "/hello") // Retorna recursos do servidor, um html ou uma lista por exemplo
//    @PostMapping(path = "/hello") // recebe informações de formulário criando novo item
//    @PutMapping(path = "/hello") // edita informações alterando um item existem
//    @DeleteMapping(path = "/hello") // Deleta informações por um id
    @ResponseBody
    public String sayHelloWithName(@RequestParam("nome") String name) {
        System.out.println("Dizendo hello world ");
        return "Hello World " + name;
    }

    /**
     * O item vai ser chamado na mesma url do navegador, mas agora com um post.
     * Para simular use o aplicativo postman ou insomia
     * @param nome Nome é um parametro obrigatório passado na url pelo "?nome=Giovanni"
     * @return
     */
    @PostMapping(path = "/hello")
    @ResponseBody
    public String salvar(@RequestParam("nome") String nome) {
        System.out.println("Criando novo item no banco dados");
        return "Pessoa de nome " + nome + " salva com sucesso";
    }

    @PostMapping("/main/alterar")
    @ResponseBody
    public void alterarNomeEndereco(@RequestParam String nomeEndereco) {
        enderecoService.alteraEnderecoCompartilhado(nomeEndereco);
    }
}
