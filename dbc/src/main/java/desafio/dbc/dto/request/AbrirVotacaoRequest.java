package desafio.dbc.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbrirVotacaoRequest implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("duracao")
    private int duracao;
}
