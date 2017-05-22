package com.juliemenge.animalquiz.UI;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.juliemenge.animalquiz.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName(); //create a tag to be used for logging

    //submit button
    private Button mSubmitButton;

    //question 1 options
    private RadioGroup mQuestion1RadioGroup;
    private RadioButton mQuestion1Button1;
    private RadioButton mQuestion1Button2;
    private RadioButton mQuestion1Button3;
    private RadioButton mQuestion1Button4;
    private RadioButton mQuestion1Button5;

    //radio button to store the answer the user chooses
    private RadioButton mQuestion1SelectionButton;

    //question 2 options




    //question 3 options




    //question 4 options




    //question 5 options


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //submit button
        mSubmitButton = (Button) findViewById(R.id.submitButton);

        //question 1 options
        mQuestion1RadioGroup = (RadioGroup) findViewById(R.id.question1RadioGroup);
        mQuestion1Button1 = (RadioButton) findViewById(R.id.question1Button1);
        mQuestion1Button2 = (RadioButton) findViewById(R.id.question1Button2);
        mQuestion1Button3 = (RadioButton) findViewById(R.id.question1Button3);
        mQuestion1Button4 = (RadioButton) findViewById(R.id.question1Button4);
        mQuestion1Button5 = (RadioButton) findViewById(R.id.question1Button5);

        //use animal result method to determine animal based on options (if answer 1 = 5, then monkey, etc)
        //send that answer into intent to show animal activity

        //TO DO
        //make all questions required
        //determine animal based on answers
        //add a caption to the animal based on answer
        //add a toast "You are a ___" based on answer

        //when the submit button is clicked, determine the results and show the activity
        // with the animal based on your choices
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what answer was chosen
                String mChoiceText = findQuestionChoice();

                //determine the animal based on choices
                calculateAnimalResults(mChoiceText);

                //start the new activity to display the animal
                startShowAnimal(mChoiceText);
            }
        });

    }

    private String findQuestionChoice() {
        int selectedId = mQuestion1RadioGroup.getCheckedRadioButtonId();
        mQuestion1SelectionButton = (RadioButton) findViewById(selectedId);
        String choice = (String) mQuestion1SelectionButton.getText();

        return choice;
    }

    private void calculateAnimalResults(String choice) {
        if(choice.equals("1")) {
            Log.i(TAG, "Your animal IS a dolphin");
        } else Log.i (TAG, "Your animal is not a dolphin");
    }

    //creating the intent to show the animal activity
    private void startShowAnimal(String choice) {
        Intent intent = new Intent(this, ShowAnimalActivity.class);

        //set up a resources object so we can use string resources
        Resources resources = getResources();
        String key = "Question1"; //seting up a key variable using string resources

        intent.putExtra(key, choice); //passing along the key and value, so Question1 and 4, for example

        startActivity(intent);
    }
}
