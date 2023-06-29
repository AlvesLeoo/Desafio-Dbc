package desafio.dbc.mapper;

import desafio.dbc.domain.Pauta;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;

public class PautaMapper {

    public static Pauta toDomain(CriarPautaRequest criarPautaRequest) {
        return new Pauta(criarPautaRequest.getTitulo());
    }

    public static PautaResponse toResponse(Pauta pauta) {
        return new PautaResponse(pauta.getId());
    }

    public static ResultadoResponse toResultadoResponse(Pauta pauta) {
        int totalVotos = pauta.getVotosSim() + pauta.getVotosNao();
        double percentualSim = ((double) pauta.getVotosSim() / totalVotos) * 100;
        double percentualNao = ((double) pauta.getVotosNao() / totalVotos) * 100;

        String percentualSimString = String.format("%.2f", percentualSim) + "%";
        String percentualNaoString = String.format("%.2f", percentualNao) + "%";
        return new ResultadoResponse(pauta.getTitulo(), totalVotos, pauta.getVotosSim(), pauta.getVotosNao(), percentualSimString, percentualNaoString);
    }
}
