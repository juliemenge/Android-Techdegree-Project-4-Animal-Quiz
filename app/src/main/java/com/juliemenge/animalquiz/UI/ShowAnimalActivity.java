package com.juliemenge.animalquiz.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juliemenge.animalquiz.R;

public class ShowAnimalActivity extends AppCompatActivity {

    private String animalType; //store the animal that was determined from MainActivity
    private ConstraintLayout mShowAnimalLayout; // maybe need this for setting background??

    public static final String TAG = ShowAnimalActivity.class.getSimpleName(); //tag for logging

    //caption variables
    private EditText mCaptionEditText;
    private Button mCaptionButton;
    private TextView mCaptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animal);

        mShowAnimalLayout = (ConstraintLayout) findViewById(R.id.showAnimalLayout); //layout

        //caption variables
        mCaptionEditText = (EditText) findViewById(R.id.captionEditText);
        mCaptionButton = (Button) findViewById(R.id.captionButton);
        mCaptionTextView = (TextView) findViewById(R.id.captionTextView);

        mCaptionTextView.setVisibility(View.INVISIBLE); //caption display should be invisible before the user submits something

        //when button is clicked, make caption display visible
        mCaptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caption = mCaptionEditText.getText().toString(); //store what the user entered as the caption
                mCaptionTextView.setText(caption); //set caption display to what the user entered
                mCaptionTextView.setVisibility(View.VISIBLE); //make the caption visible
                mCaptionEditText.setVisibility(View.INVISIBLE); //make the caption editText invisible
                mCaptionButton.setVisibility(View.INVISIBLE); //make the caption submit button invisible

            }
        });

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
