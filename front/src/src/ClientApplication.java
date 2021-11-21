package src;

import src.mode.Musique;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ClientApplication {

    public ClientApplication() {
    }


    public String getABook(int id) throws IOException {

        return "";
    }

    // MARCHE
    public void deleteMusic(int id) throws IOException {
        URL url = new URL("http://localhost:8080/Musiques/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.getResponseCode();
    }

    // MARCHE
    public void updateLivre(Musique m) throws IOException {

        System.out.println(m.toJSON());
        URL url = new URL("http://localhost:8080/Musiques");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("PUT");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");


        byte[] out = m.toJSON().getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);
        http.getResponseCode();
        http.disconnect();

    }
    public void addMusic(Musique l){


    }



}
