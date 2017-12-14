package com.example.r4a1.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CAPTURE_IMAGE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンクリック時に呼ばれる
        Button button = (Button) findViewById(R.id.button_c);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Intentオブジェクトの生成
                Intent intent = new Intent();
                // カメラアプリケーションの呼び出し
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                //カメラアプリケーション用のアクティビティーを起動
                startActivityForResult(intent, REQUEST_CAPTURE_IMAGE);
            }
        });
    }

    //新規のアクティビティーの終了時に呼ばれる
    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {
        if(REQUEST_CAPTURE_IMAGE ==requestCode
                && resultCode == Activity.RESULT_OK) {
            Bitmap capturedImage =
                    (Bitmap) data.getExtras().get("data");
            ((ImageView) findViewById(R.id.image)).setImageBitmap(capturedImage);
        }
    }
}
