package noemipusceddu.U2W1L5be.dao.service;

import lombok.extern.slf4j.Slf4j;
import noemipusceddu.U2W1L5be.dao.PrenotazioneDAO;
import noemipusceddu.U2W1L5be.entities.Prenotazione;
import noemipusceddu.U2W1L5be.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){

        Optional<Prenotazione> prenotazioneEsistente = prenotazioneDAO.findByPostazioneAndDataOccupazionePostazione(prenotazione.getPostazione(), prenotazione.getDataOccupazionePostazione()); //se c'è la prenotazione con quella postazione e quella data( può essere null)
        Optional<Prenotazione> dataPrenotataPerUtente = prenotazioneDAO.findByUtenteAndDataOccupazionePostazione(prenotazione.getUtente(), prenotazione.getDataOccupazionePostazione()); //se l'utente ha già una prenotazione per quella data

        if(prenotazioneEsistente.isEmpty() && dataPrenotataPerUtente.isEmpty()){
            prenotazioneDAO.save(prenotazione);
            System.out.println("Prenotazione salvata!");
        }else{
            System.out.println("Cambia la tua prenotazione!");
        }
    }

    public Prenotazione findPrenotazioneById(long id) throws ItemNotFoundException {
        return prenotazioneDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Prenotazione> findAll(){
        return prenotazioneDAO.findAll();
    }

}
