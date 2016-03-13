package mycinema.myapplicationcinema.Objects;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;

import java.util.List;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.activities.MovieActivity;
import mycinema.myapplicationcinema.loadImagesWithVolley.LoadImagesWithVolley;
import mycinema.myapplicationcinema.objectFromJSON.Soon;

/**
 * Created by jean on 09/03/16.
 */

public class SoonAdapter extends RecyclerView.Adapter<SoonAdapter.ViewHolder>{

    private List<Soon> soonFilms;
    private Context context;
    private ImageLoader mImageLoader;

    public SoonAdapter(Context context, List<Soon> filmToPrint) {
        this.soonFilms = filmToPrint;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titre;
        public TextView duree;
        public ImageView affiche;

        public ViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.titre);
            duree = (TextView) view.findViewById(R.id.duree);
            affiche = (ImageView) view.findViewById(R.id.affiche);
        }
    }

    public void add(int position, Soon film) {
        soonFilms.add(position, film);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = soonFilms.indexOf(item);
        soonFilms.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public SoonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_soon, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Soon film = soonFilms.get(position);
        holder.titre.setText(film.getTitre());
        String urlToDownLoad = film.getAffiche();
        loadImageBitmap(holder,urlToDownLoad);

        holder.titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieActivity.class).putExtra("filmIdToPrint", film.getId());
                context.startActivity(intent);
            }
        });

        holder.affiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieActivity.class).putExtra("filmIdToPrint", film.getId());
                context.startActivity(intent);
            }
        });
    }

    public void loadImageBitmap(final ViewHolder holder, String urlToDownload) {

        ImageRequest request = new ImageRequest(urlToDownload,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        holder.affiche.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        holder.affiche.setImageResource(R.drawable.polaroid);
                    }
                });
        LoadImagesWithVolley.getInstance(context).addToRequestQueue(request);

    }

    @Override
    public int getItemCount() {
        return soonFilms.size();
    }

}