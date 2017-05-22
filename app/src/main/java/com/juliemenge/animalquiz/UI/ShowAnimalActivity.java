package com.juliemenge.animalquiz.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.juliemenge.animalquiz.R;

public class ShowAnimalActivity extends AppCompatActivity {

    private String question1Value;

    public static final String TAG = ShowAnimalActivity.class.getSimpleName(); //create a tag to be used for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animal);

        //get the intent used to start this activity
        Intent intent = getIntent();

        //assign the question choices we passed in to a variable
        question1Value = intent.getStringExtra("Question1");
        //Log.i(TAG, "HERE IT IS HERE" + question1Value);

        Toast.makeText(this, "You are a dolphin!", Toast.LENGTH_SHORT).show();
    }
}
