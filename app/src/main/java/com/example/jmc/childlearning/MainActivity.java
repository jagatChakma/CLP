package com.example.jmc.childlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    LinearLayout layout_bangla, layout_english, layout_math, layout_etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Child Learnin");

        layout_bangla = findViewById(R.id.bangla_button);
        layout_english = findViewById(R.id.english_button);
        layout_math = findViewById(R.id.math__button);
        layout_etc = findViewById(R.id.etc_button);

        layout_bangla.setOnClickListener(this);
        layout_english.setOnClickListener(this);
        layout_math.setOnClickListener(this);
        layout_etc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bangla_button){
            Intent intent = new Intent(MainActivity.this,BanglaActivity.class);
            startActivity(intent);
        }if (v.getId() == R.id.english_button){
            Intent intent = new Intent(MainActivity.this,EnglishActivity.class);
            startActivity(intent);
        }if (v.getId() == R.id.math__button){
            Intent intent = new Intent(MainActivity.this,KobitaActivity.class);
            startActivity(intent);
        }if (v.getId() == R.id.etc_button){
            Intent intent = new Intent(MainActivity.this,MathActivity.class);
            startActivity(intent);
        }

    }
}
