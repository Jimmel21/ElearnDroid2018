package com.jimmel.elearndroid2018;

import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.Activity;

public class Intentcallback extends AppCompatActivity {
    private Button button, homepage;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentcallback);

        button = findViewById(R.id.tryout);
        homepage = findViewById(R.id.homepageBT);
        text = findViewById(R.id.answer);

        button.setOnClickListener(new Button_Clicker());
        homepage.setOnClickListener(new Button_Clicker());
    }

    class Button_Clicker implements Button.OnClickListener{
        public void onClick(View v){
            if(v == button){
                Intent intent3 = new Intent(getApplicationContext(), Score.class);
                startActivityForResult(intent3, 1);
            }
            else if(v== homepage){
                Intent intent4 = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent4);
            }
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result =data.getStringExtra("square");
                text.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                System.out.println("Error");
            }
        }
    }
}
