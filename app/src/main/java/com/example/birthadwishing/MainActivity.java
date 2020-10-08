package com.example.birthadwishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button wishbtn;
    EditText editText;
    String Editextvalu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wishbtn=findViewById(R.id.createBirthdayButton);
        editText=findViewById(R.id.nameInput);

        wishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editextvalu=editText.getText().toString();
                Intent intent=new Intent(MainActivity.this,Birhday_Greeting.class);
                intent.putExtra("name",Editextvalu);
                startActivity(intent);
                finish();
            }
        });

    }
}