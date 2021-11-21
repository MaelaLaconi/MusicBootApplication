package com.masteril.springdb;

import com.masteril.springdb.dao.MusiqueRepository;
import com.masteril.springdb.model.Musique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdbApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringdbApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringdbApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MusiqueRepository repository){
        return (args -> {
            /*repository.save(new Musique(1, "musique1", "chanteur1"));
            repository.save(new Musique(2, "musique2", "chanteur2"));
            repository.save(new Musique(3, "musique3", "chanteur3"));
            log.info("Affichage de toutes les musiques ------------ findAll()-------------");
            for(Musique m : repository.findAll()){
                log.info(m.toString());
            }

            log.info("Affichage d'une musique par id ------------ findById(1)-------------");
            log.info(repository.findById(2).toString());

            log.info("Affichage d'une musique par chanteur ------------ findByChanteur(chateur1)-------------");
            repository.findByChanteur("chanteur1").forEach(m ->{
                    log.info(m.toString());
                }

            );*/
        });
    }
}
