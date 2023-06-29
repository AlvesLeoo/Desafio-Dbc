package desafio.dbc.service;

import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;
import org.springframework.stereotype.Service;

@Service
public interface VotoService {
    VotoResponse votar(VotoRequest votoRequest);
}
