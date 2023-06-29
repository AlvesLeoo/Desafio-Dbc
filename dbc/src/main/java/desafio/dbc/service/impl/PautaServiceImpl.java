package desafio.dbc.service.impl;


import desafio.dbc.domain.Pauta;
import desafio.dbc.dto.request.AbrirVotacaoRequest;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;
import desafio.dbc.mapper.PautaMapper;
import desafio.dbc.repository.PautaRepository;
import desafio.dbc.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaServiceImpl implements PautaService {

    @Autowired
    PautaRepository pautaRepository;

    @Override
    public PautaResponse criarPauta(CriarPautaRequest criarPautaRequest) {
        Pauta pauta = PautaMapper.toDomain(criarPautaRequest);
        pautaRepository.save(pauta);
        return PautaMapper.toResponse(pauta);
    }

    @Override
    public PautaResponse abrirVotacao(AbrirVotacaoRequest abrirVotacaoRequest) {
        Pauta pauta = pautaRepository.findById(abrirVotacaoRequest.getId()).get();
        pauta.setSessaoAberta(true);
        calcularEncerramento(abrirVotacaoRequest.getDuracao(), pauta);
        pautaRepository.save(pauta);
        ;
        return PautaMapper.toResponse(pauta);
    }

    @Override
    public ResultadoResponse obterResultado(Long id) {
        Pauta pauta = pautaRepository.findById(id).get();
        return PautaMapper.toResultadoResponse(pauta);
    }

    private void calcularEncerramento(int duracao, Pauta pauta) {
        if (duracao == 0)
            pauta.setEncerramento();
        else
            pauta.setEncerramento(duracao);

    }

}
