package noemipusceddu.U2W1L5be.dao;

import noemipusceddu.U2W1L5be.entities.Postazione;
import noemipusceddu.U2W1L5be.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
}
