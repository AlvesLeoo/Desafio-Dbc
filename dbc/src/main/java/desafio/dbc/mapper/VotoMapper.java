package desafio.dbc.mapper;

import desafio.dbc.domain.Voto;
import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;

public class VotoMapper {

    public static Voto toDomain(VotoRequest votoRequest) {
        return new Voto(votoRequest.getPautaId(), votoRequest.getCooperadoId(), votoRequest.isVotoSim());
    }

    public static VotoResponse toResponse(Voto voto) {
        return new VotoResponse(voto.getId());
    }
}
