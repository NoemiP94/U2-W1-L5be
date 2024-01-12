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
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){

        Optional<Prenotazione> prenotazioneEsistente = prenotazioneDAO.findByPostazioneAndData(prenotazione.getPostazione(), prenotazione.getData()); //se c'è la prenotazione con quella postazione e quela data( può essere null)

        //salvare solo se non esiste già una prenotazione per quella postazione in quella data
        if(prenotazioneEsistente.isEmpty()){
            prenotazioneDAO.save(prenotazione);
            log.info("Prenotazione salvata!");
        }else{
            log.info("Postazione già prenotata per quella data!");
        }
    }

    public Prenotazione findPrenotazioneById(long id) throws ItemNotFoundException {
        return prenotazioneDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Prenotazione> findAll(){
        return prenotazioneDAO.findAll();
    }
}
