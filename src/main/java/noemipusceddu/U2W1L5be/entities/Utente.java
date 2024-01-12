package noemipusceddu.U2W1L5be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtente;
    private String username;
    private String nomeCompleto;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> listaPrenotazioni;

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                " - idUtente: " + idUtente +
                " - username: " + username + '\'' +
                " - nome completo: " + nomeCompleto + '\'' +
                " - email: " + email + '\'' +
                " - lista prenotazioni: " + listaPrenotazioni +
                '}';
    }
}
