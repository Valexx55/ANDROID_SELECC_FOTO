package com.example.formador.seleccionfoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intentpidefoto = new Intent ();
        intentpidefoto.setAction(Intent.ACTION_PICK);
        intentpidefoto.setType("image/*");//TIPO MIME

        startActivityForResult(intentpidefoto, 30);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            //El usuario ha seleccionado una foto
            Uri uri = data.getData();

            try {
                Bitmap  bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ImageView imageView = (ImageView)findViewById(R.id.foto_sel);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }  else {
            Log.e("ERROR" , "El usuario le dio a salir ");
        }
    }
}
