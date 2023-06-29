package desafio.dbc.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VotoDomainTeste {
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
}
