package noemipusceddu.U2W1L5be;

import com.github.javafaker.Faker;
import noemipusceddu.U2W1L5be.dao.service.EdificioService;
import noemipusceddu.U2W1L5be.entities.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        Edificio edificio = new Edificio(faker.company().name(), faker.address().fullAddress(), faker.country().capital());
        edificioService.save(edificio);
    }


}
