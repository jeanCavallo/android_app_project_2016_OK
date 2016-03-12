package mycinema.myapplicationcinema.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

/**
 * Created by jean on 11/03/16.
 */
public class FilmSeancesAdapter extends ArrayAdapter<FilmSeances> {

    public FilmSeancesAdapter(Context context, List<FilmSeances> films) {
        super(context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.one_seance, parent, false);
            }

            SeanceViewHolder viewHolder = (SeanceViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new SeanceViewHolder();
                viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
                viewHolder.duree = (TextView) convertView.findViewById(R.id.duree);
                viewHolder.affiche = (ImageView) convertView.findViewById(R.id.affiche);
                convertView.setTag(viewHolder);
            }

            FilmSeances film = getItem(position);

            // Pour remplir la vue
            URL url = null;
            try {
                url = new URL(film.getAffiche());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Bitmap bmp = null;
            try {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }


            viewHolder.titre.setText(film.getTitre());
            viewHolder.duree.setText(film.getDuree());
            viewHolder.affiche.setImageBitmap(bmp);
        }

        return convertView;
    }

    private class SeanceViewHolder{
        public TextView titre;
        public TextView duree;
        public ImageView affiche;
    }


}
