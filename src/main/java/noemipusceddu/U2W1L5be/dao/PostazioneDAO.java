package noemipusceddu.U2W1L5be.dao;

import noemipusceddu.U2W1L5be.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
}
