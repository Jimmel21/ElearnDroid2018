package com.jimmel.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Score extends AppCompatActivity {
    private Button button;
    private TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        button = findViewById(R.id.button);
        int squareFive = 5 * 5;
        String returnVal = "Five Squared is "+ Integer.toString(squareFive);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("square", returnVal);
        setResult(Activity.RESULT_OK, returnIntent);
        button.setOnClickListener(new Button_Clicker());
    }

    class Button_Clicker implements Button.OnClickListener{
        public void onClick(View v){
            if (v == button){
                finish();
            }
        }
    }
}
