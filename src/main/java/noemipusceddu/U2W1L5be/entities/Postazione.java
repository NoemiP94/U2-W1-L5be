package noemipusceddu.U2W1L5be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPostazione;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToOne(mappedBy = "postazione")
    private Prenotazione prenotazione;

    public Postazione(String descrizione, Tipo tipo, int maxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                " - idPostazione: " + idPostazione +
                " - descrizione: " + descrizione + '\'' +
                " - tipo: " + tipo +
                " - maxOccupanti: " + maxOccupanti +
                " - edificio: " + edificio +
                " - città: " + edificio.getCitta() +
                '}';
    }
}
