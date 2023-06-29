package desafio.dbc.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotoResponse implements Serializable {

    @JsonProperty("id")
    private Long id;
}
