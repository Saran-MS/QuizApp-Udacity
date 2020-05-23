package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ScrollView scroll;
    private RadioGroup radio1;
    private RadioGroup radio2;
    private RadioGroup radio3;
    private RadioGroup radio4;
    private RadioGroup radio5;
    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question5;
    private CheckBox question7_1;
    private CheckBox question7_2;
    private CheckBox question7_3;
    private CheckBox question7_4;
    private EditText question6;
    private int correctAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = (ScrollView) findViewById(R.id.Scroll);

        question1 = (RadioButton) findViewById(R.id.q1ans);
        question2 = (RadioButton) findViewById(R.id.q2ans);
        question3 = (RadioButton) findViewById(R.id.q3ans);
        question4 = (RadioButton) findViewById(R.id.q4ans);
        question5 = (RadioButton) findViewById(R.id.q5ans);
        question6 = (EditText) findViewById(R.id.ans6);
        question7_2 = (CheckBox) findViewById(R.id.q7ans1);
        question7_3 = (CheckBox) findViewById(R.id.q7ans2);
        question7_1 = (CheckBox) findViewById(R.id.q7wrng1);
        question7_4 = (CheckBox) findViewById(R.id.q7wrng2);
        radio1 = (RadioGroup) findViewById(R.id.radio1);
        radio2 = (RadioGroup) findViewById(R.id.radio2);
        radio3 = (RadioGroup) findViewById(R.id.radio3);
        radio4 = (RadioGroup) findViewById(R.id.radio4);
        radio5 = (RadioGroup) findViewById(R.id.radio5);

    }

    public void submit(View v) {
        String answerSix = getResources().getString(R.string.answer6);
        String wrongAnswers = "Check :";
        if (question1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q1\n";
        }
        if (question2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q2\n";
        }
        if (question3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q3\n";
        }

        if (question4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q4\n";
        }

        if (question5.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q5\n";
        }

        if (answerSix.equals(question6.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q6\n";
        }

        if (!(question7_1.isChecked()) && question7_2.isChecked() && question7_3.isChecked() && !(question7_4.isChecked())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q7\n";
        }


        if (correctAnswers == 7) {
            Toast.makeText(this, "Congrats, All Answers Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + " /7\n" + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        reset(findViewById(R.id.reset));

    }

    public void reset(View v) {

        correctAnswers = 0;
        question6.getText().clear();

        radio1.clearCheck();
        radio2.clearCheck();
        radio3.clearCheck();
        radio4.clearCheck();
        radio5.clearCheck();

        if (question7_1.isChecked()) {
            question7_1.toggle();
        }

        if (question7_2.isChecked()) {
            question7_2.toggle();
        }

        if (question7_3.isChecked()) {
            question7_3.toggle();
        }

        if (question7_4.isChecked()) {
            question7_4.toggle();
        }

        scroll.fullScroll(ScrollView.FOCUS_UP);
    }


}
