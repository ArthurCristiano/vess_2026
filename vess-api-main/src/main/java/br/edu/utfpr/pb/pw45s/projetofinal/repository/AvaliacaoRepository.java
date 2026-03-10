package br.edu.utfpr.pb.pw45s.projetofinal.repository;

import br.edu.utfpr.pb.pw45s.projetofinal.model.Avaliacao;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AvaliacaoRepository extends CrudRepository<Long, Avaliacao> {
    @Query("SELECT DISTINCT a FROM Avaliacao a LEFT JOIN FETCH a.amostras WHERE a.id = :id")
    Optional<Avaliacao> findByIdWithAmostras(@Param("id") Long id);
}
