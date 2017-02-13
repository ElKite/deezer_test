package vtarreau.deezerplaylist.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import vtarreau.deezerplaylist.Data;
import vtarreau.deezerplaylist.R;

/**
 * Created by Vincent on 12/02/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Data data;
    private ImageLoader imageLoader;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private   TextView titre;
        private  TextView nbr_piste;
        private  TextView creator;
        private  TextView date;
        private NetworkImageView image;

        private ViewHolder(final View view) {
            super(view);

            titre = (TextView) view.findViewById(R.id.title_cell);
            nbr_piste = (TextView) view.findViewById(R.id.piste_cell);
            creator = (TextView) view.findViewById(R.id.creator_cell);
            date = (TextView) view.findViewById(R.id.date_cell);
            image = (NetworkImageView) view.findViewById(R.id.imageView);
        }
    }

    public MyRecyclerViewAdapter(Data data, ImageLoader imageLoader) {
        if (data != null)
            this.data = data;
        else
            this.data = new Data();
        this.imageLoader = imageLoader;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_cell, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titre.setText(data.getPlaylists()[position].getTitre());
        holder.nbr_piste.setText(data.getPlaylists()[position].getPistes());
        holder.creator.setText(data.getPlaylists()[position].getProprietaireName());
        holder.date.setText(data.getPlaylists()[position].getDate());
        holder.image.setImageUrl(data.getPlaylists()[position].getImageUrl().toString(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return data.getPlaylists().length;
    }
}
