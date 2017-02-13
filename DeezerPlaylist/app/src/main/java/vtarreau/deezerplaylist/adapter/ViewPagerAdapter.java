package vtarreau.deezerplaylist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vtarreau.deezerplaylist.fragment.AlbumFragment;
import vtarreau.deezerplaylist.fragment.PlaylistFragment;

/**
 * Created by Vincent on 11/02/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PlaylistFragment();
                break;
            case 1:
                fragment = new AlbumFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = "";
        switch (position) {
            case 0:
                pageTitle = "Playlists";
                break;
            case 1:
                pageTitle = "Albums";
                break;
        }
        return pageTitle;
    }
}
