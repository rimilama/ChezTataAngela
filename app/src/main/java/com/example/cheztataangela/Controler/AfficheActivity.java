package com.example.cheztataangela.Controler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cheztataangela.Model.Patisseries;
import com.example.cheztataangela.R;

public class AfficheActivity extends AppCompatActivity {

    //Variable--------------------------------------

    private ImageView Image;
    private TextView Name;
    private TextView Description;
    private TextView Ingredient;
    private Button Ok;

    private final String EXTRA_MIAM = "miam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        Intent intent = getIntent();

        Image = (ImageView)findViewById(R.id.activity_affiche_image);
        Name = (TextView)findViewById(R.id.activity_affiche_name);
        Description = (TextView)findViewById(R.id.activity_affiche_description);
        Ingredient = (TextView)findViewById(R.id.activity_affiche_ingredient);
        Ok = (Button)findViewById(R.id.activity_affiche_but);

        Patisseries patisserie = intent.getParcelableExtra(EXTRA_MIAM);
        Image.setImageResource(patisserie.getPatisserieImage());
        Name.setText(patisserie.getPatisserieName());
        Description.setText(patisserie.getPatisserieDescritpion());
        Ingredient.setText("Liste d'ingredient : \n" + patisserie.getPatisserieIngredient());

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
