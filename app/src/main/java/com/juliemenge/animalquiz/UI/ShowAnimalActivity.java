package com.juliemenge.animalquiz.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.Toast;

import com.juliemenge.animalquiz.R;

public class ShowAnimalActivity extends AppCompatActivity {

    private String animalType; //store the animal that was determined from MainActivity
    private ConstraintLayout mShowAnimalLayout; // maybe need this for setting background??

    public static final String TAG = ShowAnimalActivity.class.getSimpleName(); //tag for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animal);

        mShowAnimalLayout = (ConstraintLayout) findViewById(R.id.showAnimalLayout);

        //get the intent used to start this activity
        Intent intent = getIntent();

        //assign the animal type
        animalType = intent.getStringExtra("animal");

        switch (animalType) {
            case "monkey":
                mShowAnimalLayout.setBackgroundResource(R.drawable.monkey);
                break;
            case "tiger":
                mShowAnimalLayout.setBackgroundResource(R.drawable.tiger);
                break;
            case "dolphin":
                mShowAnimalLayout.setBackgroundResource(R.drawable.dolphin);
                break;
            case "elephant":
                mShowAnimalLayout.setBackgroundResource(R.drawable.elephant);
                break;
            case "red panda":
                mShowAnimalLayout.setBackgroundResource(R.drawable.redpanda);
                break;
            default:
                mShowAnimalLayout.setBackgroundResource(R.drawable.dolphin);
        }


        Log.i(TAG, "HERE IT IS HERE" + animalType);

        //toast the animal type
        Toast.makeText(this, "You are a " + animalType + "!", Toast.LENGTH_SHORT).show();
    }
}
