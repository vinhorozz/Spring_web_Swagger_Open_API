package edu.spring_web_api.repository;


import edu.spring_web_api.handler.BusinessException;
import edu.spring_web_api.handler.CampoObrigatorioException;
import org.springframework.stereotype.Repository;
import edu.spring_web_api.model.Usuario;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) {
           //throw new BusinessException("O campo login é obrigatório");// demonstração com mensagens personalizadas
           // throw new RuntimeException("O campo login é obrigatório");// teste com mensagem genérica
            // abaixo uma forma mais dinâmica de testar as exceções através de uma classe
        if(usuario.getLogin()==null)
            throw new CampoObrigatorioException("login");
        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");
        if (usuario.getId() == null)

            System.out.println("SAVE - Recebendo usuário da camada do repositório");
        else
            System.out.println("UPDATE - Recebendo usuário da camada do repositório");

        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE - Recebendo o id: %d para excluir um usuário ",id));
        System.out.println(id);
    }

    public List<Usuario>findAll(){
        System.out.println("LIST - Listando os usuários do sistem");
        List<Usuario>usuarios=new ArrayList<>();
        usuarios.add(new Usuario("vinho","Frfq1"));
        usuarios.add(new Usuario("frank", "faKK#"));
    return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %id para localizar um usuário",id));
        return new Usuario ("vinho", "Frfq1");
    }
    public Usuario findByUsername(String username){
        System.out.println(String.format("FIND/username -  Recebendo o username: %s para localizar um usuário",username));
        return new Usuario("vinho", "Frfq1");
    }
}