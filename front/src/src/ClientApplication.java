package src;

import src.mode.Musique;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientApplication {

    public ClientApplication() {
    }


    public String getABook(int id) throws IOException {
        
        return "";
    }

    public void deleteMusic(int id) throws IOException {
        URL url = new URL("http://localhost:8080/Musiques/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.getResponseCode();
    }

    public void updateLivre(Musique l){




    }
    public void callAjouter(Musique l){


    }



}
