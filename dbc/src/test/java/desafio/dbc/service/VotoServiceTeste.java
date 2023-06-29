package desafio.dbc.service;

import desafio.dbc.domain.Pauta;
import desafio.dbc.domain.Voto;
import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.exceptions.CooperadoJaVotouException;
import desafio.dbc.exceptions.PautaNaoEncontradaException;
import desafio.dbc.exceptions.SessaoDeVotacaoEncerradaException;
import desafio.dbc.repository.PautaRepository;
import desafio.dbc.repository.VotoRepository;
import desafio.dbc.service.impl.VotoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VotoServiceTeste {
    @InjectMocks
    VotoServiceImpl tested;

    @Mock
    VotoRepository votoRepository;

    @Mock
    PautaRepository pautaRepository;

    @Captor
    ArgumentCaptor<Voto> votoCaptor;

    @Test
    public void temQueSalvarVoto() {
        VotoRequest votoRequest = new VotoRequest(1L, 1L, true);
        Pauta pauta = new Pauta();
        pauta.setEncerramento(1);
        when(pautaRepository.findById(votoRequest.getPautaId())).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByCooperadoIdAndPautaId(votoRequest.getCooperadoId(), votoRequest.getPautaId())).thenReturn(false);

        tested.votar(votoRequest);

        verify(votoRepository).save(votoCaptor.capture());

        assertEquals(votoRequest.getPautaId(), votoCaptor.getValue().getPautaId());
        assertEquals(votoRequest.getCooperadoId(), votoCaptor.getValue().getCooperadoId());
        assertEquals(votoRequest.isVotoSim(), votoCaptor.getValue().isVotoSim());
    }

    @Test(expected = PautaNaoEncontradaException.class)
    public void deveLancarPautaNotFoundException() {
        VotoRequest votoRequest = new VotoRequest(1L, 1L, true);

        when(pautaRepository.findById(votoRequest.getPautaId())).thenReturn(Optional.empty());

        tested.votar(votoRequest);
    }

    @Test(expected = CooperadoJaVotouException.class)
    public void deveLancarCooperadoJaVotouException() {
        VotoRequest votoRequest = new VotoRequest(1L, 1L, true);
        Pauta pauta = new Pauta();
        pauta.setEncerramento(1);
        when(pautaRepository.findById(votoRequest.getPautaId())).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByCooperadoIdAndPautaId(votoRequest.getCooperadoId(), votoRequest.getPautaId())).thenReturn(true);

        tested.votar(votoRequest);
    }

    @Test(expected = SessaoDeVotacaoEncerradaException.class)
    public void deveLancarSessaoDeVotacaoEncerradaException() {
        VotoRequest votoRequest = new VotoRequest(1L, 1L, true);

        Pauta pauta = new Pauta();
        pauta.setEncerramento(-5);
        when(pautaRepository.findById(votoRequest.getPautaId())).thenReturn(Optional.of(pauta));

        tested.votar(votoRequest);
    }
}
