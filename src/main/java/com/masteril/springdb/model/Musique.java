package com.masteril.springdb.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MUSIQUE")

public class Musique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String chanteur;

    // constructeur par défaut
    protected Musique(){}

    public Musique(int id, String name, String chanteur) {
        this.titre = name;
        this.id = id;
        this.chanteur = chanteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String name) {
        this.titre = name;
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

        return  "Nom='" + titre + '\'' +
                ", Chanteur='" + chanteur + '\'' +
                ", id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musique musique = (Musique) o;
        return id == musique.id && Objects.equals(titre, musique.titre) && Objects.equals(chanteur, musique.chanteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, id, chanteur);
    }
}
