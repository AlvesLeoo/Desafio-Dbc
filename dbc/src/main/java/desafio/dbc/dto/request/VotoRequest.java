package desafio.dbc.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotoRequest implements Serializable {

    @JsonProperty("pautaId")
    private Long pautaId;

    @JsonProperty("cooperadoId")
    private Long cooperadoId;

    @JsonProperty("votoSim")
    private boolean votoSim;
}
