package desafio.dbc.service.impl;


import desafio.dbc.domain.Voto;
import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;
import desafio.dbc.mapper.VotoMapper;
import desafio.dbc.repository.VotoRepository;
import desafio.dbc.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoServiceImpl implements VotoService {

    @Autowired
    VotoRepository votoRepository;

    @Override
    public VotoResponse votar(VotoRequest votoRequest) {

        Voto voto = VotoMapper.toDomain(votoRequest);
        // incrementar logica

        votoRepository.save(voto);
        return VotoMapper.toResponse(voto);
    }
}
