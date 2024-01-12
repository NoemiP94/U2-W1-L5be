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
    private LocalDate data;
    private LocalDate dataOccupazionePostazione;

    @ManyToOne
    @JoinColumn(name= "utente_id")
    private Utente utente;

    @OneToOne
    @JoinColumn(name= "postazione_id")
    private Postazione postazione;

    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataOccupazionePostazione) {
        this.data = LocalDate.now();
        this.utente = utente;
        this.postazione = postazione;
        this.dataOccupazionePostazione = dataOccupazionePostazione;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                " - idPrenotazione: " + idPrenotazione +
                " - prenotato il: " + data +
                " - data occupazione postazione: " + dataOccupazionePostazione +
                " - utente: " + utente.getNomeCompleto() +
                " -  postazione: " + postazione +
                '}';
    }
}
