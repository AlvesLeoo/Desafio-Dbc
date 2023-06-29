package desafio.dbc.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultadoResponse implements Serializable {
    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("totalVotos")
    private int totalVotos;

    @JsonProperty("votosSim")
    private int votosSim;

    @JsonProperty("votosNao")
    private int votosNao;

    @JsonProperty("percentualSim")
    private String percentualSim;

    @JsonProperty("percentualNao")
    private String percentualNao;
}
