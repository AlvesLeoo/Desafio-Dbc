package desafio.dbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CooperadoJaVotouException extends RuntimeException {
    public CooperadoJaVotouException() {
        super("Cooperado já votou nesta pauta.");
    }
}
