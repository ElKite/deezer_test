package vtarreau.deezerplaylist;


import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

/**
 * Created by Vincent on 12/02/2017.
 */


class User {
    @SerializedName("name") private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Playlist {

    @SerializedName("data") private Data data;
    @SerializedName("picture") private URL imageUrl;
    @SerializedName("title") private String titre;
    @SerializedName("nb_tracks") private int pistes;
    @SerializedName("creator") private User proprietaire;
    @SerializedName("creation_date") private String date;


    public String getProprietaireName () {
        return proprietaire.getName();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL image) {
        this.imageUrl = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPistes() {
        return Integer.toString(pistes);
    }

    public void setPistes(int pistes) {
        this.pistes = pistes;
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
