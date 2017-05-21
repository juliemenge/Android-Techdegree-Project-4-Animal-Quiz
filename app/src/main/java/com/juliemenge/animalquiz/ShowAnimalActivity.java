package com.juliemenge.animalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ShowAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animal);

        //get the intent used to start this activity
        Intent intent = getIntent();

        Toast.makeText(this, "You are a dolphin!", Toast.LENGTH_SHORT).show();
    }
}
