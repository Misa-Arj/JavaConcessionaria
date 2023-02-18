package JavaConcessionaria.api.model.dto.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{

    public ObjetoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
