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
import android.widget.Toast;

import com.juliemenge.animalquiz.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName(); //tag used for logging

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
    private RadioGroup mQuestion2RadioGroup;
    private RadioButton mQuestion2Button1;
    private RadioButton mQuestion2Button2;
    private RadioButton mQuestion2Button3;
    private RadioButton mQuestion2Button4;
    private RadioButton mQuestion2Button5;

    //radio button to store the answer the user chooses
    private RadioButton mQuestion2SelectionButton;

    //question 3 options
    private RadioGroup mQuestion3RadioGroup;
    private RadioButton mQuestion3Button1;
    private RadioButton mQuestion3Button2;
    private RadioButton mQuestion3Button3;
    private RadioButton mQuestion3Button4;
    private RadioButton mQuestion3Button5;

    //radio button to store the answer the user chooses
    private RadioButton mQuestion3SelectionButton;

    //question 4 options
    private RadioGroup mQuestion4RadioGroup;
    private RadioButton mQuestion4Button1;
    private RadioButton mQuestion4Button2;
    private RadioButton mQuestion4Button3;
    private RadioButton mQuestion4Button4;
    private RadioButton mQuestion4Button5;

    //radio button to store the answer the user chooses
    private RadioButton mQuestion4SelectionButton;

    //question 5 options
    private RadioGroup mQuestion5RadioGroup;
    private RadioButton mQuestion5Button1;
    private RadioButton mQuestion5Button2;
    private RadioButton mQuestion5Button3;
    private RadioButton mQuestion5Button4;
    private RadioButton mQuestion5Button5;

    //radio button to store the answer the user chooses
    private RadioButton mQuestion5SelectionButton;


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

        //question 2 options
        mQuestion2RadioGroup = (RadioGroup) findViewById(R.id.question2RadioGroup);
        mQuestion2Button1 = (RadioButton) findViewById(R.id.question2Button1);
        mQuestion2Button2 = (RadioButton) findViewById(R.id.question2Button2);
        mQuestion2Button3 = (RadioButton) findViewById(R.id.question2Button3);
        mQuestion2Button4 = (RadioButton) findViewById(R.id.question2Button4);
        mQuestion2Button5 = (RadioButton) findViewById(R.id.question2Button5);

        //question 3 options
        mQuestion3RadioGroup = (RadioGroup) findViewById(R.id.question3RadioGroup);
        mQuestion3Button1 = (RadioButton) findViewById(R.id.question3Button1);
        mQuestion3Button2 = (RadioButton) findViewById(R.id.question3Button2);
        mQuestion3Button3 = (RadioButton) findViewById(R.id.question3Button3);
        mQuestion3Button4 = (RadioButton) findViewById(R.id.question3Button4);
        mQuestion3Button5 = (RadioButton) findViewById(R.id.question3Button5);

        //question 4 options
        mQuestion4RadioGroup = (RadioGroup) findViewById(R.id.question4RadioGroup);
        mQuestion4Button1 = (RadioButton) findViewById(R.id.question4Button1);
        mQuestion4Button2 = (RadioButton) findViewById(R.id.question4Button2);
        mQuestion4Button3 = (RadioButton) findViewById(R.id.question4Button3);
        mQuestion4Button4 = (RadioButton) findViewById(R.id.question4Button4);
        mQuestion4Button5 = (RadioButton) findViewById(R.id.question4Button5);

        //question 5 options
        mQuestion5RadioGroup = (RadioGroup) findViewById(R.id.question5RadioGroup);
        mQuestion5Button1 = (RadioButton) findViewById(R.id.question5Button1);
        mQuestion5Button2 = (RadioButton) findViewById(R.id.question5Button2);
        mQuestion5Button3 = (RadioButton) findViewById(R.id.question5Button3);
        mQuestion5Button4 = (RadioButton) findViewById(R.id.question5Button4);
        mQuestion5Button5 = (RadioButton) findViewById(R.id.question5Button5);


        //when the submit button is clicked, determine the results and show the activity
        // with the animal based on your choices
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get answers for all 5 questions
                String mChoiceTextQ1 = findQuestionChoices(mQuestion1RadioGroup, mQuestion1SelectionButton);
                String mChoiceTextQ2 = findQuestionChoices(mQuestion2RadioGroup, mQuestion2SelectionButton);
                String mChoiceTextQ3 = findQuestionChoices(mQuestion3RadioGroup, mQuestion3SelectionButton);
                String mChoiceTextQ4 = findQuestionChoices(mQuestion4RadioGroup, mQuestion4SelectionButton);
                String mChoiceTextQ5 = findQuestionChoices(mQuestion5RadioGroup, mQuestion5SelectionButton);

                //determine the animal based on choices, pass in all 5 selections
                String animalType = calculateAnimalResults(mChoiceTextQ1, mChoiceTextQ2, mChoiceTextQ3, mChoiceTextQ4, mChoiceTextQ5);

                //start the new activity to display the animal, pass in all 5 selections
                startShowAnimal(animalType);

            }
        });

    }

    //determine which button was clicked for a question
    private String findQuestionChoices(RadioGroup questionRadioGroup, RadioButton questionSelectionButton) {
        int selectedId = questionRadioGroup.getCheckedRadioButtonId();
        questionSelectionButton = (RadioButton) findViewById(selectedId);
        String choice = (String) questionSelectionButton.getText();
        return choice;

        //remember to check that all questions have been answered
    }

    //based on answers, determine what animal to use
    private String calculateAnimalResults(String choice1, String choice2, String choice3, String choice4, String choice5) {
        String animal = "dolphin";

        if(choice1.equals("5")) {
            animal = "monkey";
        } else if (choice2.equals("5")) {
            animal = "tiger";
        } else if (choice3.equals("5")) {
            animal = "dolphin";
        } else if (choice4.equals("5")) {
            animal = "elephant";
        } else if (choice5.equals("5")) {
            animal = "red panda";
        } else if (choice1.equals("4")) {
            animal = "monkey";
        } else if (choice2.equals("4")) {
            animal="tiger";
        } else if (choice3.equals("4")) {
            animal="dolphin";
        } else if (choice4.equals("4")) {
            animal="elephant";
        } else if (choice4.equals("4")) {
            animal="red panda";
        } else if (choice1.equals("3")) {
            animal="monkey";
        } else if (choice2.equals("3")) {
            animal="tiger";
        } else if (choice3.equals("3")) {
            animal="dolphin";
        } else if (choice4.equals("3")) {
            animal="elephant";
        } else if (choice5.equals("3")) {
            animal="red panda";
        } else if (choice1.equals("2")) {
            animal="monkey";
        } else if (choice2.equals("2")) {
            animal="tiger";
        } else if (choice3.equals("2")) {
            animal="dolphin";
        } else if (choice4.equals("2")) {
            animal="elephant";
        } else if (choice5.equals("2")) {
            animal="red panda";
        } else if (choice1.equals("1")) {
            animal="monkey";
        } else if (choice2.equals("1")) {
            animal="tiger";
        } else if (choice3.equals("1")) {
            animal="dolplhin";
        } else if (choice4.equals("1")) {
            animal="elephant";
        } else animal = "red panda";

        return animal;
    }

    //create the intent to start the animal activity
    private void startShowAnimal(String animal) {
        Intent intent = new Intent(this, ShowAnimalActivity.class); //create the intent
        intent.putExtra("animal", animal); //pass in the key and value, like "animal" and "monkey"
        startActivity(intent); //start the new ShowAnimal
    }
}
