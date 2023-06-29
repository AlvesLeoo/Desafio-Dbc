package desafio.dbc.service;

import desafio.dbc.domain.Pauta;
import desafio.dbc.dto.request.AbrirVotacaoRequest;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;
import desafio.dbc.exceptions.PautaNaoEncontradaException;
import desafio.dbc.exceptions.SessaoDeVotacaoJaAbertaException;
import desafio.dbc.repository.PautaRepository;
import desafio.dbc.service.impl.PautaServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class PauteServiceTeste {

    @InjectMocks
    PautaServiceImpl tested;

    @Mock
    PautaRepository pautaRepository;

    @Test
    public void deveCriarPauta() {
        CriarPautaRequest criarPautaRequest = new CriarPautaRequest();
        criarPautaRequest.setTitulo("Título da Pauta");

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setTitulo(criarPautaRequest.getTitulo());

        when(pautaRepository.save(any(Pauta.class))).thenAnswer(invocation -> {
            Pauta savedPauta = invocation.getArgument(0);
            savedPauta.setId(pauta.getId());
            return savedPauta;
        });

        PautaResponse response = tested.criarPauta(criarPautaRequest);

        assertNotNull(response);
        assertEquals(pauta.getId(), response.getId());

        verify(pautaRepository).save(any(Pauta.class));
    }

    @Test
    public void deveAbrirVotacaoComSucesso() {
        AbrirVotacaoRequest abrirVotacaoRequest = new AbrirVotacaoRequest();
        abrirVotacaoRequest.setId(6L);
        abrirVotacaoRequest.setDuracao(3);

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setEncerramento(3);
        pauta.setSessaoAberta(false);

        when(pautaRepository.findById(abrirVotacaoRequest.getId())).thenReturn(Optional.of(pauta));
        when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta);

        PautaResponse response = tested.abrirVotacao(abrirVotacaoRequest);

        assertNotNull(response);
        assertTrue(pauta.isSessaoAberta());
        assertNotNull(pauta.getEncerramento());
        assertEquals(pauta.getId(), response.getId());

        verify(pautaRepository).findById(abrirVotacaoRequest.getId());
        verify(pautaRepository).save(any(Pauta.class));
    }

    @Test(expected = SessaoDeVotacaoJaAbertaException.class)
    public void deveLancarSessaoDeVotacaoJaAbertaException() {
        AbrirVotacaoRequest abrirVotacaoRequest = new AbrirVotacaoRequest();
        abrirVotacaoRequest.setId(1L);
        abrirVotacaoRequest.setDuracao(-5);

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setEncerramento(-5);
        pauta.setSessaoAberta(true);

        when(pautaRepository.findById(abrirVotacaoRequest.getId())).thenReturn(Optional.of(pauta));

        tested.abrirVotacao(abrirVotacaoRequest);
    }

    @Test(expected = PautaNaoEncontradaException.class)
    public void testObterResultadoPautaNaoEncontrada() {
        Long idPauta = 2L;
        Mockito.when(pautaRepository.findById(idPauta)).thenReturn(Optional.empty());

        tested.obterResultado(idPauta);
    }

    @Test
    public void testObterResultadoSucesso() {
        Long idPauta = 1L;
        Pauta pauta = new Pauta();
        pauta.setId(idPauta);
        pauta.setTitulo("ABC");
        pauta.setVotosSim(4);
        pauta.setVotosNao(2);

        Mockito.when(pautaRepository.findById(idPauta)).thenReturn(Optional.of(pauta));

        ResultadoResponse resultado = tested.obterResultado(idPauta);

        Assert.assertEquals("ABC", resultado.getTitulo());
        Assert.assertEquals(6, resultado.getTotalVotos());
        Assert.assertEquals(4, resultado.getVotosSim());
        Assert.assertEquals(2, resultado.getVotosNao());
        Assert.assertEquals("66.67%", resultado.getPercentualSim());
        Assert.assertEquals("33.33%", resultado.getPercentualNao());
    }
}
