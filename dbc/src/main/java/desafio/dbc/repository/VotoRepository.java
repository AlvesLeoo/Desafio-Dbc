package desafio.dbc.repository;


import desafio.dbc.domain.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long> {

    boolean existsByCooperadoIdAndPautaId(Long cooperadoId, Long pautaId);

}