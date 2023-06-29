package desafio.dbc.service;

import desafio.dbc.dto.request.AbrirVotacaoRequest;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    PautaResponse criarPauta(CriarPautaRequest criarPautaRequest);

    PautaResponse abrirVotacao(AbrirVotacaoRequest abrirVotacaoRequest);

    ResultadoResponse obterResultado(Long id);

}

