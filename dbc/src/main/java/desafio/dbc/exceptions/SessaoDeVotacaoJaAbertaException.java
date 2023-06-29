package desafio.dbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SessaoDeVotacaoJaAbertaException extends RuntimeException{
    public SessaoDeVotacaoJaAbertaException() {
        super("Sessão de votação já está aberta.");
    }
}
