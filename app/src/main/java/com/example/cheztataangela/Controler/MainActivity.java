package com.example.cheztataangela.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.cheztataangela.Model.PatisserieAdapter;
import com.example.cheztataangela.Model.Patisseries;
import com.example.cheztataangela.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //Variable-----------------------------

    private PatisserieAdapter adapter;
    private final String EXTRA_MIAM = "miam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView messageEmptyList = (TextView) findViewById(R.id.activity_main_empty);

        //Affichage de la liste--------------------------------------------
        ArrayList<Patisseries> patisserie = new ArrayList<Patisseries>();
        initList(patisserie);
        adapter = new PatisserieAdapter(this, R.layout.layout_list, patisserie);
        ListView list = (ListView) findViewById(R.id.activity_main_list);
        list.setAdapter(adapter);

        //Changement d'activité au clique
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AfficheActivity.class);
                Patisseries selectedItem = (Patisseries) adapter.getItemAtPosition(position);
                intent.putExtra(EXTRA_MIAM, selectedItem);
                startActivity(intent);
            }
        });


        //Mise en place de la fonction de recherche
        SearchView search = (SearchView) findViewById(R.id.activity_main_search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);

                if(adapter.getCount()==0){
                    messageEmptyList.setVisibility(View.VISIBLE);
                }else{
                    messageEmptyList.setVisibility(View.GONE);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                if(adapter.getCount()==0){
                    messageEmptyList.setVisibility(View.VISIBLE);
                }else{
                    messageEmptyList.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }

    //Initialisation de la liste----------------------------------------

    private void initList(ArrayList<Patisseries> patisserie){
        Patisseries Croissant = new Patisseries("Croissant", "Un croissant est une viennoiserie à base d'une pâte levée feuilletée spécifique, la pâte à croissant, qui comporte de la levure et une proportion importante de beurre.", R.drawable.croissant, "Farine, Sucre, Beurre, Levure de boulanger, Eau, Sel");
        patisserie.add(Croissant);

        Patisseries Pain_au_chocolat = new Patisseries("Pain au chocolat", "Le pain au chocolat, chocolatine Écouter ou couque au chocolat est une viennoiserie constituée d'une pâte levée feuilletée, identique à celle du croissant, rectangulaire et enroulée sur une ou plusieurs barres de chocolat.", R.drawable.pain_au_chocolat, "Farine, Beurre, Sucre, Levure de boulanger, Chocolat noir, Sel, Lait, Jaune d'oeuf");
        patisserie.add(Pain_au_chocolat);

        Patisseries Eclair = new Patisseries("Eclair", "Un éclair, anciennement appelé pain à la duchesse (avant 1850) ou petite duchesse, est une pâtisserie d'origine française constituée de pâte à choux allongée et fourrée de crème pâtissière, avec un glaçage sur le dessus.", R.drawable.eclair, "Farine, Lait, Beurre, Chocolat noir, Oeuf, Sucre");
        patisserie.add(Eclair);

        Patisseries Palmier = new Patisseries("Palmier", "Le palmier est une pâtisserie à base de pâte feuilletée, en forme de cœur, largement saupoudrée de sucre qui caramélise à la cuisson. Il est fait d'une double roulade de pâte coupée en tranches, ce qui lui donne sa forme caractéristique évoquant le feuillage du palmier.", R.drawable.palmier, "Pate feuilletée, Beurre, Sucre, Sucre Vanillé");
        patisserie.add(Palmier);
    }
}
