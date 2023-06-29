package desafio.dbc.service.impl;


import desafio.dbc.domain.Pauta;
import desafio.dbc.domain.Voto;
import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;
import desafio.dbc.exceptions.CooperadoJaVotouException;
import desafio.dbc.exceptions.PautaNaoEncontradaException;
import desafio.dbc.exceptions.SessaoDeVotacaoEncerradaException;
import desafio.dbc.mapper.VotoMapper;
import desafio.dbc.repository.PautaRepository;
import desafio.dbc.repository.VotoRepository;
import desafio.dbc.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoServiceImpl implements VotoService {

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    PautaRepository pautaRepository;

    @Override
    public VotoResponse votar(VotoRequest votoRequest) {

        Voto voto = VotoMapper.toDomain(votoRequest);
        Pauta pauta = pautaRepository.findById(voto.getPautaId()).orElseThrow(() -> {
            throw new PautaNaoEncontradaException();
        });

        boolean jaVotou = votoRepository.existsByCooperadoIdAndPautaId(voto.getCooperadoId(), voto.getPautaId());

        if (jaVotou) {
            throw new CooperadoJaVotouException();
        }
        if (pauta.getEncerramento().isBefore(LocalDateTime.now())) {
            throw new SessaoDeVotacaoEncerradaException();
        }

        pauta.incrementarVotos(voto.isVotoSim());
        votoRepository.save(voto);
        pautaRepository.save(pauta);
        return VotoMapper.toResponse(voto);
    }
}
