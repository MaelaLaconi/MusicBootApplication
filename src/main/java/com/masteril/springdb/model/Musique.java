package com.masteril.springdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Musique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String chanteur;

    // constructeur par défaut
    protected Musique(){}

    public Musique(int id, String name, String chanteur) {
        this.name = name;
        this.id = id;
        this.chanteur = chanteur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChanteur() {
        return chanteur;
    }

    public void setChanteur(String chanteur) {
        this.chanteur = chanteur;
    }

    @Override
    public String toString() {

        return  "Nom='" + name + '\'' +
                ", Chanteur='" + chanteur + '\'' +
                ", id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musique musique = (Musique) o;
        return id == musique.id && Objects.equals(name, musique.name) && Objects.equals(chanteur, musique.chanteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, chanteur);
    }
}
