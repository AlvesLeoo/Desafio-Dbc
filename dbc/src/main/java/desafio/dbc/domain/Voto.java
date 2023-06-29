package desafio.dbc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    public Long getId() {
        return id;
    }

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public Long getCooperativoId() {
        return cooperativoId;
    }

    public void setCooperativoId(Long cooperativoId) {
        this.cooperativoId = cooperativoId;
    }

    public boolean isVotoSim() {
        return votoSim;
    }

    public void setVotoSim(boolean votoSim) {
        this.votoSim = votoSim;
    }
}