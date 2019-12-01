package com.jimmel.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class Papers extends AppCompatActivity {
    private Button paper1, paper2, homepage;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);
        desc = findViewById(R.id.description);
        paper1= findViewById(R.id.paper1);
        paper2 =findViewById(R.id.paper2);
        homepage=findViewById(R.id.homepageBTN);

        paper1.setOnClickListener(new Button_Clicker());
        paper2.setOnClickListener(new Button_Clicker());
        homepage.setOnClickListener(new Button_Clicker());
    }

    class Button_Clicker implements Button.OnClickListener{
        public void onClick(View v){
            if(v==paper1){
                desc.setText(R.string.Paper1Desc);
            }
            else if(v==paper2){
                desc.setText(R.string.Paper2Desc);
            }
            else if(v==homepage){
                Intent intent5 = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent5);
            }
        }
    }
}
