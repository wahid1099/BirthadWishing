package com.example.birthadwishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Birhday_Greeting extends AppCompatActivity {
String valuefromacityvty;
    Button savephotos;
TextView setbirthdayname;
BitmapDrawable bitmapDrawable;
ImageView cakeImage;
Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_birhday__greeting);
        savephotos=findViewById(R.id.savephotobutton);
        setbirthdayname=findViewById(R.id.birthdayGreeting);
        cakeImage=findViewById(R.id.cake_image);
        valuefromacityvty=getIntent().getExtras().getString("name");
        setbirthdayname.setText("Happy Birthday"+valuefromacityvty);
        savephotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutputStream=null;
            bitmapDrawable=(BitmapDrawable)cakeImage.getDrawable();
            bitmap= bitmapDrawable.getBitmap() ;
            File sdcard= Environment.getExternalStorageDirectory();
            File diractory=new File(sdcard.getAbsolutePath()+"/YourpathName");
            diractory.mkdir();
            String FileName=String.format("%d.jpg",System.currentTimeMillis());
            File outFile=new File(diractory,FileName);
                Toast.makeText(Birhday_Greeting.this, "Image saved Succesfully", Toast.LENGTH_SHORT).show();
                try {
                    fileOutputStream=new FileOutputStream(outFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outFile));
                    sendBroadcast(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}