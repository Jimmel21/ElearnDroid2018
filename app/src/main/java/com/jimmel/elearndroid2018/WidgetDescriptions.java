package com.jimmel.elearndroid2018;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class WidgetDescriptions extends Activity {
    Spinner spinner1;
    ImageView img;
    private String username;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_descriptions);

        username = getIntent().getStringExtra("username");
        description = findViewById(R.id.info);
        img = findViewById(R.id.widgetImage);
        spinner1 = findViewById(R.id.widgetSpinner);

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener{
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
            if(parent.getItemAtPosition(pos).equals("Toast")){
                description.setText(R.string.toast);
                img.setImageResource(R.drawable.toast);
            }
            else if(parent.getItemAtPosition(pos).equals("DatePicker")){
                description.setText(R.string.DatePicker);
                img.setImageResource(R.drawable.date_picker);
            }
            else if(parent.getItemAtPosition(pos).equals("ImageView")){
                description.setText(R.string.ImageView);
                img.setImageResource(R.drawable.image_view);
            }
            else if(parent.getItemAtPosition(pos).equals("ListView")){
                description.setText(R.string.ListView);
                img.setImageResource(R.drawable.list_view);
            }
            else if(parent.getItemAtPosition(pos).equals("Spinner")){
                description.setText(R.string.Spinner);
                img.setImageResource(R.drawable.spinner);
            }
            else if(parent.getItemAtPosition(pos).equals("EditText")){
                description.setText(R.string.EditText);
                img.setImageResource(R.drawable.edit_text);
            }
            else if(parent.getItemAtPosition(pos).equals("Button")){
                description.setText(R.string.Button);
                img.setImageResource(R.drawable.button);
            }
            else if(parent.getItemAtPosition(pos).equals("NumberPicker")){
                description.setText(R.string.NumberPicker);
                img.setImageResource(R.drawable.number_picker);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //
        }
    }
    public void quizBTN(View v){
        Intent intent1 = new Intent(getApplicationContext(), Quiz.class);
        intent1.putExtra("username", username);
        startActivity(intent1);
    }

}
