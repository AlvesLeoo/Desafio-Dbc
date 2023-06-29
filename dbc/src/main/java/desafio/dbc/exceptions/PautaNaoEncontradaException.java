package desafio.dbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PautaNaoEncontradaException extends RuntimeException{
    public PautaNaoEncontradaException() {
        super("Pauta não encontrada.");
    }
}