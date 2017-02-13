package vtarreau.deezerplaylist.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import vtarreau.deezerplaylist.Data;
import vtarreau.deezerplaylist.Playlist;
import vtarreau.deezerplaylist.R;
import vtarreau.deezerplaylist.adapter.MyRecyclerViewAdapter;

/**
 * Created by Vincent on 11/02/2017.
 */


public class PlaylistFragment extends Fragment {

    private RequestQueue requestQueue;
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private ImageLoader myImageLoader;
    private Data myData;

    private String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_playlist, container, false);

        myRecyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);
        myLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(myLayoutManager);

        requestQueue = Volley.newRequestQueue(getContext());
        myImageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });

        Button searchButton = (Button) rootview.findViewById(R.id.searchButton);
        final EditText editText = (EditText) rootview.findViewById(R.id.userId_editText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = editText.getText().toString();
                url = "http://api.deezer.com/user/" + userid + "/playlists";
                retrieveData();
            }
        });

        return rootview;
    }
    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.GET, url, retrieveDataResponse, retrieveDataError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> retrieveDataResponse = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i("onResponse", response);

            Gson gson = new Gson();
            myData = gson.fromJson(response, Data.class);
            myAdapter = new MyRecyclerViewAdapter(myData, myImageLoader);
            myRecyclerView.setAdapter(myAdapter);
        }
    };

    private final Response.ErrorListener retrieveDataError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onErrorResponse" , error.toString());
        }
    };

}
