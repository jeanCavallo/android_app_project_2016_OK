package mycinema.myapplicationcinema.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import mycinema.myapplicationcinema.objectFromJSON.Seances;
import mycinema.myapplicationcinema.objectFromJSON.Soon;

/**
 * Created by jean on 09/03/16.
 */
public class SoonAdapter extends ArrayAdapter<Soon> {

    public SoonAdapter(Context context, List<Soon> soonList) {
        super(context, 0, soonList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.one_soon,parent, false);
        }

        SoonViewHolder viewHolder = (SoonViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SoonViewHolder();
            viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
            viewHolder.affiche = (ImageView) convertView.findViewById(R.id.affiche);
            convertView.setTag(viewHolder);
        }

        Soon soon = getItem(position);

        // To load the picture
        URL url = null;
        try {
            url = new URL(soon.getAffiche());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewHolder.titre.setText(soon.getTitre());
        viewHolder.affiche.setImageBitmap(bmp); // TODO solve the issue here



        return convertView;
    }

    private class SoonViewHolder{
        public TextView titre;
        public ImageView affiche;
    }
}