package noemipusceddu.U2W1L5be.dao.service;

import lombok.extern.slf4j.Slf4j;
import noemipusceddu.U2W1L5be.dao.PostazioneDAO;
import noemipusceddu.U2W1L5be.entities.Postazione;
import noemipusceddu.U2W1L5be.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione){
        postazioneDAO.save(postazione);
        log.info("Postazione salvata!");
    }

    public Postazione findPostazioneById(long id) throws ItemNotFoundException {
        return postazioneDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Postazione> findAll(){
        return postazioneDAO.findAll();
    }
}
