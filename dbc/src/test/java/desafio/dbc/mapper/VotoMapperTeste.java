package desafio.dbc.mapper;

import desafio.dbc.domain.Voto;
import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VotoMapperTeste {
    @Test
    public void testToDomain() {
        VotoRequest votoRequest = new VotoRequest();
        votoRequest.setPautaId(1L);
        votoRequest.setCooperadoId(100L);
        votoRequest.setVotoSim(true);

        Voto voto = VotoMapper.toDomain(votoRequest);

        Assert.assertEquals(1L, voto.getPautaId().longValue());
        Assert.assertEquals(100L, voto.getCooperadoId().longValue());
        Assert.assertTrue(voto.isVotoSim());
    }

    @Test
    public void testToResponse() {
        Voto voto = new Voto();
        voto.setId(1L);

        VotoResponse votoResponse = VotoMapper.toResponse(voto);

        Assert.assertEquals(1L, votoResponse.getId().longValue());
    }
}
