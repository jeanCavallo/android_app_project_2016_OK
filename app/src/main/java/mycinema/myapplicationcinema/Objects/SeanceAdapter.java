package mycinema.myapplicationcinema.Objects;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.objectFromJSON.Seances;

/**
 * Created by jean on 08/03/16.
 */
public class SeanceAdapter extends ArrayAdapter<Seances> {

        //seances est la liste des models à afficher
        public SeanceAdapter(Context context, List<Seances> seances) {
            super(context, 0, seances);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.one_seance,parent, false);
            }

            SeanceViewHolder viewHolder = (SeanceViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new SeanceViewHolder();
                viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
                viewHolder.cinema_salle = (TextView) convertView.findViewById(R.id.cinema_salle);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Seance> seances
            Seances seance = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.titre.setText(seance.getTitre());
            viewHolder.cinema_salle.setText(seance.getCinema_salle());
            viewHolder.avatar.setImageDrawable(new ColorDrawable());

            return convertView;
        }

        private class SeanceViewHolder{
            public TextView titre;
            public TextView cinema_salle;
            public ImageView avatar;
        }
}
