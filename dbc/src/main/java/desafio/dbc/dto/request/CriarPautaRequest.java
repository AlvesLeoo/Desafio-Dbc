package desafio.dbc.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarPautaRequest implements Serializable {

    @JsonProperty("titulo")
    private String titulo;

}
