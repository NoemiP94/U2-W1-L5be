package noemipusceddu.U2W1L5be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idPrenotazione;
    private LocalDate giornoPrenotazione;

    @ManyToOne
    @JoinColumn(name= "utente_id")
    private Utente utente;

    @OneToOne
    @JoinColumn(name= "postazione_id")
    private Postazione postazione;

    public Prenotazione(LocalDate giornoPrenotazione, Utente utente, Postazione postazione) {
        this.giornoPrenotazione = giornoPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }
}
