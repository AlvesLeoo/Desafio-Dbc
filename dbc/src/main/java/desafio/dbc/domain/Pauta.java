package desafio.dbc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pauta")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "sessao_aberta")
    private boolean sessaoAberta;

    @Column(name = "encerramento")
    private LocalDateTime encerramento;

    @Column(name = "voto_sim")
    private int votosSim;

    @Column(name = "voto_nao")
    private int votosNao;

    public Pauta(String titulo) {
        this.titulo = titulo;
        this.sessaoAberta = false;
        this.votosSim = 0;
        this.votosNao = 0;
    }

    public void incrementarVotos(boolean voto) {
        if (voto)
            this.votosSim++;
        else
            this.votosNao++;
    }

    public void setEncerramento(int duracao) {
        this.encerramento = LocalDateTime.now().plusMinutes(duracao);
    }

    public void setEncerramento() {
        this.setEncerramento(1);
    }
}
