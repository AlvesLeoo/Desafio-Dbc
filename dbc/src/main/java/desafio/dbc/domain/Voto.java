package desafio.dbc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pauta_id")
    private Long pautaId;

    @Column(name = "cooperado_id")
    private Long cooperativoId;

    @Column(name = "voto_sim")
    private boolean votoSim;

    public Voto(Long pautaId, Long cooperativoId, boolean votoSim) {
        this.pautaId = pautaId;
        this.cooperativoId = cooperativoId;
        this.votoSim = votoSim;
    }
}