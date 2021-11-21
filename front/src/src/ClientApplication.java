package src;

import src.mode.Musique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ClientApplication {

    public ClientApplication() {
    }


    /**
     *
     * @param id
     * @return cherche une musique par son id, retourne une string en json
     * @throws IOException
     */
    public String getAMusic(int id) throws IOException {
        StringBuilder res = new StringBuilder();
        URL url = new URL("http://localhost:8080/Musiques/"+id);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = null;
        if (conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                res.append(strCurrentLine+"\n");
            }
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                res.append(strCurrentLine);
            }
        }
        conn.disconnect();
        return res.toString() ;
    }

    /**
     * supprime une musique par son id
     * @param id
     * @throws IOException
     */
    public void deleteMusic(int id) throws IOException {
        URL url = new URL("http://localhost:8080/Musiques/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.getResponseCode();
    }

    /**
     * modifie une musique
     * @param m
     * @throws IOException
     */
    public void updateMusic(Musique m) throws IOException {
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

    /**
     * ajoute une musique
     * @param m
     * @throws IOException
     */
    public void addMusic(Musique m) throws IOException {
        URL url = new URL("http://localhost:8080/Musiques");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");


        byte[] out = m.toJSON().getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);
        http.getResponseCode();
        http.disconnect();

    }
}
