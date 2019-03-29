package com.example.jmc.childlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class WarningScreen extends AppCompatActivity {
    ProgressBar progressBar;
    int prpgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_warning_screen);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                StartApp();
            }
        });
        thread.start();
    }
    public void doWork(){
        for (prpgress = 20;prpgress <=100;prpgress = prpgress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(prpgress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void StartApp(){
        Intent intent = new Intent(WarningScreen.this,MainActivity.class);
        startActivity(intent);

        finish();
    }
}
