package desafio.dbc.mapper;

import desafio.dbc.domain.Pauta;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PautaMapperTeste {
    @Test
    public void testToDomain() {
        CriarPautaRequest criarPautaRequest = new CriarPautaRequest();
        criarPautaRequest.setTitulo("ABC");

        Pauta pauta = PautaMapper.toDomain(criarPautaRequest);

        Assert.assertEquals("ABC", pauta.getTitulo());
    }

    @Test
    public void testToResponse() {
        Pauta pauta = new Pauta();
        pauta.setId(1L);

        PautaResponse pautaResponse = PautaMapper.toResponse(pauta);

        Assert.assertEquals(1L, pautaResponse.getId().longValue());
    }

    @Test
    public void testToResultadoResponse() {
        Pauta pauta = new Pauta();
        pauta.setTitulo("ABC");
        pauta.setVotosSim(4);
        pauta.setVotosNao(2);

        ResultadoResponse resultadoResponse = PautaMapper.toResultadoResponse(pauta);

        Assert.assertEquals("ABC", resultadoResponse.getTitulo());
        Assert.assertEquals(6, resultadoResponse.getTotalVotos());
        Assert.assertEquals(4, resultadoResponse.getVotosSim());
        Assert.assertEquals(2, resultadoResponse.getVotosNao());
        Assert.assertEquals("66.67%", resultadoResponse.getPercentualSim());
        Assert.assertEquals("33.33%", resultadoResponse.getPercentualNao());
    }
}
