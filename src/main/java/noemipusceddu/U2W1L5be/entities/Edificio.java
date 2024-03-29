package noemipusceddu.U2W1L5be.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Scope()
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEdificio;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy= "edificio")
    private List<Postazione> postazioni;

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                " - idEdificio: " + idEdificio +
                " - nome: " + nome + '\'' +
                " - indirizzo: " + indirizzo + '\'' +
                " - città: " + citta + '\'' +
                '}';
    }
}
