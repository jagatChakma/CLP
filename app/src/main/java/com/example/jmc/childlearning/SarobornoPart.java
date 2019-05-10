package com.example.jmc.childlearning;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.UUID;

public class SarobornoPart extends AppCompatActivity implements View.OnClickListener {
    private CanvasView canvasView;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saroborno_part);

        canvasView = findViewById(R.id.canvasViewId);
        imageView1 = findViewById(R.id.previrwImageButton);
        imageView2 = findViewById(R.id.clearImageCanvas);
        imageView3 = findViewById(R.id.penImageButton);
        imageView4 = findViewById(R.id.speakerImageButton);
        imageView5 = findViewById(R.id.saveImageButton);
        imageView6 = findViewById(R.id.nextImageButton);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.sound1);

        switch (v.getId()){
            case R.id.previrwImageButton:
                Toast.makeText(this, "Preview", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clearImageCanvas:
                canvasView.clearCanvas();
                break;
            case R.id.penImageButton:
                Toast.makeText(this, "pancil tuch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.speakerImageButton:
                mp1.start();
                //Toast.makeText(this, "pancil tuch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.saveImageButton:
                saveImageButtonAction();
                break;
            case R.id.nextImageButton:
                Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveImageButtonAction() {
        AlertDialog.Builder saveAlertDilog = new AlertDialog.Builder(this);
        saveAlertDilog.setTitle("Save ?");
        saveAlertDilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                canvasView.setDrawingCacheEnabled(true);
                String imageSave = MediaStore.Images.Media.insertImage(
                        getContentResolver(),canvasView.getDrawingCache(), UUID.randomUUID().toString()+".png","drawing");
                if (imageSave != null){
                    Toast saveToast = Toast.makeText(SarobornoPart.this, "Save", Toast.LENGTH_SHORT);
                    saveToast.show();
                }else {
                    Toast unSave = Toast.makeText(SarobornoPart.this, "Opps, error..", Toast.LENGTH_SHORT);
                    unSave.show();
                }
                canvasView.destroyDrawingCache();
                // make score alow in manifests file to use-permission in store  ->     <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
            }
        });
        saveAlertDilog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        saveAlertDilog.show();
    }
}
