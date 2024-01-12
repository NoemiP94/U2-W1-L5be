package noemipusceddu.U2W1L5be.dao;

import noemipusceddu.U2W1L5be.entities.Postazione;
import noemipusceddu.U2W1L5be.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {

    //cercare postazione per tipo
    List<Postazione> findByTipo(Tipo tipo);
}
