package com.juliemenge.animalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitButton);

        //TO DO
        //make all questions required
        //determine animal based on answers
        //add a caption to the animal
        //add a toast "You are a ___"

        //when the submit button is clicked, show the activity with the animal based on your choices
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start the new activity
                startShowAnimal();
            }
        });

    }

    //creating the intent to show the animal activity
    private void startShowAnimal() {
        Intent intent = new Intent(this, ShowAnimalActivity.class);
        startActivity(intent);
    }
}
