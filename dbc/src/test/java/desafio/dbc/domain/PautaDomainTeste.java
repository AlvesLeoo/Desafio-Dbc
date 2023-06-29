package desafio.dbc.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PautaDomainTeste {

    @Test
    public void testConstrutorCompleto() {
        Long id = 1L;
        Long pautaId = 2L;
        Long cooperadoId = 3L;
        boolean votoSim = true;

        Voto voto = new Voto(id, pautaId, cooperadoId, votoSim);

        Assert.assertEquals(id, voto.getId());
        Assert.assertEquals(pautaId, voto.getPautaId());
        Assert.assertEquals(cooperadoId, voto.getCooperadoId());
        Assert.assertEquals(votoSim, voto.isVotoSim());
    }

    @Test
    public void testConstrutorSimplificado() {
        Long pautaId = 2L;
        Long cooperadoId = 3L;
        boolean votoSim = true;

        Voto voto = new Voto(pautaId, cooperadoId, votoSim);

        Assert.assertNull(voto.getId());
        Assert.assertEquals(pautaId, voto.getPautaId());
        Assert.assertEquals(cooperadoId, voto.getCooperadoId());
        Assert.assertEquals(votoSim, voto.isVotoSim());
    }

    @Test
    public void testGettersAndSetters() {
        Voto voto = new Voto();
        Long id = 1L;
        Long pautaId = 2L;
        Long cooperadoId = 3L;
        boolean votoSim = true;

        voto.setId(id);
        voto.setPautaId(pautaId);
        voto.setCooperadoId(cooperadoId);
        voto.setVotoSim(votoSim);

        Assert.assertEquals(id, voto.getId());
        Assert.assertEquals(pautaId, voto.getPautaId());
        Assert.assertEquals(cooperadoId, voto.getCooperadoId());
        Assert.assertEquals(votoSim, voto.isVotoSim());
    }

    @Test
    public void testIncrementarVotos() {
        Pauta pauta = new Pauta();
        pauta.setVotosSim(2);
        pauta.setVotosNao(1);

        pauta.incrementarVotos(true);

        Assert.assertEquals(3, pauta.getVotosSim());
        Assert.assertEquals(1, pauta.getVotosNao());
    }

    @Test
    public void testSetEncerramentoComDuracao() {
        Pauta pauta = new Pauta();
        int duracao = 30;

        pauta.setEncerramento(duracao);
        LocalDateTime encerramentoEsperado = LocalDateTime.now().plusMinutes(duracao);

        Assert.assertEquals(encerramentoEsperado, pauta.getEncerramento());
    }

    @Test
    public void testSetEncerramentoSemDuracao() {
        Pauta pauta = new Pauta();

        pauta.setEncerramento();
        LocalDateTime encerramentoEsperado = LocalDateTime.now().plusMinutes(1); // Duracao padrão de 1 minuto

        Assert.assertEquals(encerramentoEsperado, pauta.getEncerramento());
    }
}
