package com.jimmel.elearndroid2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Homepage extends AppCompatActivity {
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
         edt = findViewById(R.id.name);
    }
    public void learnMoreBTN(View v){
        String username = edt.getText().toString();
        Intent intent = new Intent(getApplicationContext(), WidgetDescriptions.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void IntentBTN(View v){
        Intent intent6 = new Intent(getApplicationContext(), Intentcallback.class);
        startActivity(intent6);
    }

    public void PapersBTN(View v){
        Intent intent7 = new Intent(getApplicationContext(), Papers.class);
        startActivity(intent7);
    }

}
