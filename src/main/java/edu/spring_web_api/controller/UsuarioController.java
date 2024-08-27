package edu.spring_web_api.controller;

import edu.spring_web_api.model.Usuario;
import edu.spring_web_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// o Controller é apenas um proxy, ele dá o direcionamento para a funcionalidade específica na aplicação
@RestController

@RequestMapping("/users") //como perceebmo que todas as requisições tem o mesmo inicio, podemos adiciona essa anotação com o parâmetro que se repetira na classe
public class UsuarioController {
    //Instânciar um obejto com o @autowired para termos acessos aos métodos da classe
    @Autowired
    private UsuarioRepository repository;
    //criaremos um método para apresentar uma lista, e escolheremos o "método HTTP" para  manipulá-lo
    //@GetMapping("/users")//adição de URI para não haver confusão entre os @GetMapping presentes aqui e na classe UsuarioRepository
    @GetMapping() //Depois da inclusão do @RequestMapping
    public List<Usuario>getUsers(){
        return repository.findAll();
    }
    //@GetMapping("/users/{username}") //indicação dentro das chaves para que o valor seja usado como uma variável
    @GetMapping("/{username}") //Depois da inclusão do @RequestMapping
    public Usuario getOne(@PathVariable("username")String username){
        return repository.findByUsername(username);
    }

    // para realizar as operações "delete" é necessário obtermos um "CLIENT" como POSTMAN, pois o "delete" não pode ser executada no navegador como as método Get ou Put
    //@DeleteMapping("/users/{id}")
    @DeleteMapping("/{id}")//Depois da inclusão do @RequestMapping
    public void deleteUser(@PathVariable("id") Integer id){//a anotação permite que o indiquemos na URI da requisição um parâmetro, nesse caso,
                                                            // o "id" que será usado como argumento no método deleteById();
        repository.deleteById(id);
    }
    //
    //@PostMapping("/users")
    @PostMapping()//Depois da inclusão do @RequestMapping
    public void postUser(@RequestBody Usuario usuario){//a anotação garante a conversão da resposta "JSON" para o formato do objeto "Usuário"
        repository.save(usuario);
    }

    @PutMapping
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}

