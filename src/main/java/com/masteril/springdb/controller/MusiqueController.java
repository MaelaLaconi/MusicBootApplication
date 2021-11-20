package com.masteril.springdb.controller;


import com.masteril.springdb.dao.MusiqueRepository;
import com.masteril.springdb.model.Musique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusiqueController {

    @Autowired
    private MusiqueRepository dao;

    /**
     * display all the music
     * @return list of musics
     */
    @GetMapping(value = "/Musiques")
    // List ou iterable ??
    public List<Musique> getMusiques(){
        return dao.findAll();
    }

    /**
     * display a music by id
     * @param id of the music to display
     * @return a single music
     */
    @GetMapping(value = "/Musiques/{id}")
    public Musique getMusiqueById(@PathVariable int id){
        return dao.findById(id);
    }

    /**
     * add a music to the db
     * @param musique to save
     */
    @PostMapping(value = "/Musiques")
    public void addMusique(@RequestBody Musique musique){
        dao.save(musique);
    }


    /**
     * delete a music by id
     * @param id of the music to delete
     */
    @DeleteMapping(value = "/Musiques/{id}")
    public void deleteMusique(@PathVariable int id){
        dao.deleteById(id);
    }

}
