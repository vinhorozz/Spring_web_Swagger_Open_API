package edu.spring_web_api.handler;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem) {
        super(mensagem); // Chama o construtor da superclasse com a mensagem
    }
    public BusinessException(String mensagem, Object... params) {//a reticência, aqui, representa um "varargs"
        //que permite que o método aceite um número variável de argumentos

        super(String.format(mensagem, params)); // Chama o construtor da superclasse com a mensagem formatada
    }

    //Usar "super" garante que a parte da superclasse do objeto seja corretamente inicializada,
    // o que é essencial para o funcionamento correto da herança em Java12.

}
