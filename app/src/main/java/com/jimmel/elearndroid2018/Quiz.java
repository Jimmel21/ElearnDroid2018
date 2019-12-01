package com.jimmel.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Random;
import android.content.Context;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    private TextView que1, que2, que3, que4, que5, highScore;
    private static final String FILENAME = "high_score";
    private RadioGroup g1, g2, g3, g4, g5;
    private int score =0 ;
    private  String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Random r = new Random();
        int rand = r.nextInt(3-1)+1;

        que1 = findViewById(R.id.question1);
        que2 = findViewById(R.id.question);
        que3 = findViewById(R.id.question2);
        que4 = findViewById(R.id.question3);
        que5 = findViewById(R.id.question4);
        highScore = findViewById(R.id.name);

        username = getIntent().getStringExtra("username");


        if(rand == 1){
            que1.setText(R.string.toast1);
            que2.setText(R.string.datePickerQ);
            que3.setText(R.string.imageV2);
            que4.setText(R.string.spinnerQ);
            que5.setText(R.string.buttonQ);
        }
        else if(rand == 2){
            que1.setText(R.string.toast2);
            que2.setText(R.string.imageV1);
            que3.setText(R.string.listV);
            que4.setText(R.string.editTextQ);
            que5.setText(R.string.numPickerQ);
        }


        g1 = findViewById(R.id.radioGroup);
        g2 = findViewById(R.id.group2);
        g3 = findViewById(R.id.group3);
        g4 = findViewById(R.id.group4);
        g5 = findViewById(R.id.group5);
    }



    public void getScore(){
        int ans1, ans2, ans3, ans4, ans5;
        ans1 = g1.getCheckedRadioButtonId();
        ans2 = g2.getCheckedRadioButtonId();
        ans3 = g3.getCheckedRadioButtonId();
        ans4 = g4.getCheckedRadioButtonId();
        ans5 = g5.getCheckedRadioButtonId();

        RadioButton radio1 = findViewById(ans1);
        String one = radio1.getText().toString();

        RadioButton radio2 = findViewById(ans2);
        String two = radio2.getText().toString();

        RadioButton radio3 = findViewById(ans3);
        String three = radio3.getText().toString();

        RadioButton radio4 = findViewById(ans4);
        String four = radio4.getText().toString();

        RadioButton radio5 = findViewById(ans5);
        String five = radio5.getText().toString();

        if(one.equals("False"))
            score++;
        if(two.equals("True"))
            score++;
        if(three.equals("False"))
            score++;
        if(four.equals("True"))
            score++;
        if(five.equals("True"))
            score++;

        String hs = Integer.toString(score);
        Toast t = Toast.makeText(getApplicationContext(), hs, Toast.LENGTH_LONG);
        t.show();
    }

    public void saveFile(View v){
        FileOutputStream fout;
        User u= new User(username);
        try{
            fout = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            getScore();
            u.updateScore(score);
            oos.writeObject(u);
            oos.close();
            Toast t = Toast.makeText(getApplicationContext(), "Score saved to file", Toast.LENGTH_LONG);
            t.show();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void checkUser(View v){
        FileInputStream inputStream;

        try{
            inputStream = openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            User u = (User) ois.readObject();

            if(u.getUsername().equals(username)){
                highScore.setText(Integer.toString(u.getHighScore()));
            }
            else{
                highScore.setText("0");
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void homeBTN(View v){
        Intent intent2 = new Intent(getApplicationContext(), Homepage.class);
        startActivity(intent2);
    }

}
