package noemipusceddu.U2W1L5be.dao.service;

import lombok.extern.slf4j.Slf4j;
import noemipusceddu.U2W1L5be.dao.PostazioneDAO;
import noemipusceddu.U2W1L5be.entities.Postazione;
import noemipusceddu.U2W1L5be.entities.Tipo;
import noemipusceddu.U2W1L5be.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione){
        postazioneDAO.save(postazione);
        System.out.println("Postazione salvata!");
    }

    public Postazione findPostazioneById(long id) throws ItemNotFoundException {
        return postazioneDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Postazione> findAll(){
        return postazioneDAO.findAll();
    }

    public List<Postazione> filterByTipo(Tipo tipo){
        return postazioneDAO.findByTipo(tipo);
    }

    public List<Postazione> filterByCitta(String citta){
        return postazioneDAO.findAll().stream()
                .filter(postazione -> postazione.getEdificio().getCitta().equals(citta))
                .collect(Collectors.toList());
    }

    public List<Postazione> filterByTipoAndCitta(Tipo tipo, String citta) {
        List<Postazione> foundByTipo = filterByTipo(tipo);
        return foundByTipo.stream()
                .filter(postazione -> postazione.getEdificio().getCitta().equals(citta))
                .collect(Collectors.toList());
    }
}
