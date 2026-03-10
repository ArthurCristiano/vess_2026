package br.edu.utfpr.pb.pw45s.projetofinal.repository;

import br.edu.utfpr.pb.pw45s.projetofinal.model.Amostra;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AmostraRepository extends CrudRepository<Long, Amostra> {


    @Query("SELECT a FROM Amostra a JOIN FETCH a.avaliacao WHERE a.id = " +
            "(SELECT MIN(a2.id) FROM Amostra a2 WHERE a2.avaliacao = a.avaliacao) " +
            "AND a.localizacao LIKE '%,%'")
    List<Amostra> findFirstSampleOfEachAvaliacaoWithLocation();
}
