package com.example.loic.gissippool;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LOIC on 09/07/2015.
 */
public class RumeurAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String [] titre ;

    // declaration d'un ViewHolder adaptateur
    static class ViewHolder {
        public TextView textc;

        public TextView tests;
    }

    // declaration du constructeur de la classe housechoise
    public RumeurAdapter(Activity context,
                       String[] titre) {
        super(context, R.layout.activity_main, titre);  // initialisation des attributs de la super classe
        //initialisation des attribut du constructeur
        this.context = context;
        this.titre = titre;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View rowView = view;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.listrumeur, null);
            // configuration du view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tests = (TextView) rowView.findViewById(R.id.textsujet);
            viewHolder.textc  = (TextView) rowView.findViewById(R.id.textchoix);

            rowView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = titre[position];
        holder.tests.setText(s);
        holder.textc.setText(s);



        return rowView;
    }
}




