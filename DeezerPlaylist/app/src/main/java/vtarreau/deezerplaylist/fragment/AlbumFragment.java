package vtarreau.deezerplaylist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vtarreau.deezerplaylist.R;

/**
 * Created by Vincent on 11/02/2017.
 */

public class AlbumFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_album, container, false);
        return rootview;
    }
}
