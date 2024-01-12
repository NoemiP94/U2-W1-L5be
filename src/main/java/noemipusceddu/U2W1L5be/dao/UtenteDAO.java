package noemipusceddu.U2W1L5be.dao;

import noemipusceddu.U2W1L5be.entities.Utente;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Long> {
}
