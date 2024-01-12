package noemipusceddu.U2W1L5be.dao.service;

import lombok.extern.slf4j.Slf4j;
import noemipusceddu.U2W1L5be.dao.UtenteDAO;
import noemipusceddu.U2W1L5be.entities.Utente;
import noemipusceddu.U2W1L5be.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void saveUtente(Utente utente){
        utenteDAO.save(utente);
        System.out.println("Utente salvato!");
    }

    public Utente findUtenteById(long id) throws ItemNotFoundException {
        return utenteDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Utente> findAll(){
        return utenteDAO.findAll();
    }
}
