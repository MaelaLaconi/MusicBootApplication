package com.masteril.springdb.dao;


import com.masteril.springdb.model.Musique;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusiqueRepository extends CrudRepository<Musique, Integer> {


    Iterable<Musique> findByChanteur(String chanteur);

    /**
     * get all the music in the db
     * @return list of music
     */
    List<Musique> findAll();

    /**
     * get a music by its id
     * @param id of the music
     * @return a single music
     */
    Musique findById(int id);


    /**
     * delete a music by id
     * @param id of the music
     */
    void deleteById(int id);
}
