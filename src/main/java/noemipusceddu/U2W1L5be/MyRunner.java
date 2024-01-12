package noemipusceddu.U2W1L5be;

import com.github.javafaker.Faker;
import noemipusceddu.U2W1L5be.dao.service.EdificioService;
import noemipusceddu.U2W1L5be.dao.service.PostazioneService;
import noemipusceddu.U2W1L5be.dao.service.PrenotazioneService;
import noemipusceddu.U2W1L5be.dao.service.UtenteService;
import noemipusceddu.U2W1L5be.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    UtenteService utenteService;
    @Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random rnd = new Random();

        //salvataggio dati

        Edificio edificio = new Edificio(faker.company().name(), faker.address().fullAddress(), faker.country().capital());
        //edificioService.saveEdificio(edificio);

        Postazione postazione = new Postazione("Descrizione postazione", Tipo.SALA_RIUNIONI, rnd.nextInt(5,50),edificio );
        //postazioneService.savePostazione(postazione);
        Postazione postazione2 = postazioneService.findPostazioneById(2);

        Utente utente = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        //utenteService.saveUtente(utente);
        Utente utente2 = utenteService.findUtenteById(2);

        Prenotazione prenotazione = new Prenotazione(utente2, postazione2);
        prenotazioneService.savePrenotazione(prenotazione);




    }


}
