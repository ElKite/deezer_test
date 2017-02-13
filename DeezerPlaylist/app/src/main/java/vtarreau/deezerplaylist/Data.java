package vtarreau.deezerplaylist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vincent on 12/02/2017.
 */

public class Data {
    @SerializedName("data") private Playlist[] playlists;

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }
}
