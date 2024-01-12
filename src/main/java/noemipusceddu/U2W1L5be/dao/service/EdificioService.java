package noemipusceddu.U2W1L5be.dao.service;

import lombok.extern.slf4j.Slf4j;
import noemipusceddu.U2W1L5be.dao.EdificioDAO;
import noemipusceddu.U2W1L5be.entities.Edificio;
import noemipusceddu.U2W1L5be.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioDAO edificioDAO;

    public void saveEdificio(Edificio edificio){
        edificioDAO.save(edificio);
        log.info("Edificio salvato!");
    }

    public Edificio findEdificioById(long id) throws ItemNotFoundException {
        return edificioDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Edificio> findAll(){
        return edificioDAO.findAll();
    }
}
