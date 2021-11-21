package com.masteril.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class MusiqueService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static void main(String[] args){
        SpringApplication.run(MusiqueService.class);
    }

    @PostConstruct
    private void initDb(){
        String sqlStatement[] = {
                "INSERT INTO MUSIQUE (titre, chanteur) VALUES('Add it up', 'Violent Femmes');",
                "INSERT INTO MUSIQUE (titre, chanteur) VALUES('Anonymous', 'Saltriver');",
                "INSERT INTO MUSIQUE (titre, chanteur) VALUES('Cendres', 'MPL');",
                "INSERT INTO MUSIQUE (titre, chanteur) VALUES('Crawl', 'Kings of Leon');",
                "INSERT INTO MUSIQUE (titre, chanteur) VALUES('Dead Sea', 'The Lumineers');"
        };

        Arrays.asList(sqlStatement).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });

        System.out.println("Affiche toutes les Musiques dans musique ---------------------------------------");

        jdbcTemplate.query("select * from musique",
                new RowMapper<Object>() {
                    @Override
                    public Object mapRow(ResultSet musique, int rowNum) throws SQLException {
                        System.out.println("id : "+musique.getString("id")+
                                " titre : "+musique.getString("titre")+
                                " chanteur : "+musique.getString("chanteur"));
                        return null;                    }


                }
        );
    }

}
