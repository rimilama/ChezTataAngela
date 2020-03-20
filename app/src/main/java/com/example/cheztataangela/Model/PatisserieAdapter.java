package com.example.cheztataangela.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cheztataangela.R;

import java.util.ArrayList;
import java.util.List;

public class PatisserieAdapter extends ArrayAdapter<Patisseries> implements Filterable {

    //Variables--------------------------------

    private Context context;
    private int ViewRes;
    private List<Patisseries> PatisserieListe;
    private List<Patisseries> PatisserieListeTemp;

    //Constructeur--------------------------------------

    public PatisserieAdapter(Context context, int ViewRes, ArrayList<Patisseries> PatisserieListe){
        super(context, ViewRes, PatisserieListe);
        this.context = context;
        this.ViewRes = ViewRes;
        this.PatisserieListe = PatisserieListe;
        this.PatisserieListeTemp = PatisserieListe;
    }

    //Recuperation d'un item de la liste----------------------------------------

    public Patisseries getItemAtPosition(int position){
        return PatisserieListe.get(position);
    }

    //Vue de la liste----------------------------------------------------

    public View getView(int position, View convertView, ViewGroup parent){

        View view = convertView;
        ViewHolder holder;

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(ViewRes, parent, false);
            holder = new ViewHolder();
            holder.Name = (TextView) view.findViewById(R.id.liste_layout_name);
            holder.Description = (TextView) view.findViewById(R.id.liste_layout_description);
            holder.Image = (ImageView) view.findViewById(R.id.liste_layout_image);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Patisseries patisserie = PatisserieListe.get(position);
        if(patisserie != null){
            holder.Name.setText(patisserie.getPatisserieName());
            holder.Description.setText(patisserie.getPatisserieDescritpion());
            holder.Image.setImageResource(patisserie.getPatisserieImage());
        }

        return view;
    }

    //Recupération du nombre d'item dans la liste-----------------------------

    public int getCount(){
        return PatisserieListe.size();
    }

    //Mise en place de la fonction de recherche------------------------------------

    public Filter getFilter(){
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filtreString = constraint.toString();
                if (filtreString.isEmpty()){
                    PatisserieListe = PatisserieListeTemp;
                }else{
                    List<Patisseries> listFiltrer = new ArrayList<>();
                    for(Patisseries pat : PatisserieListeTemp){
                        if(pat.getPatisserieName().toLowerCase().contains(filtreString.toLowerCase())){
                            listFiltrer.add(pat);
                        }
                    }
                    PatisserieListe = listFiltrer;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = PatisserieListe;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                PatisserieListe = (ArrayList<Patisseries>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}

//View Holder----------------------------------

class ViewHolder{
    TextView Name;
    TextView Description;
    ImageView Image;
}