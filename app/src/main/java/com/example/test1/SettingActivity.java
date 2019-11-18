package com.example.test1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.InputStream;

public class SettingActivity extends AppCompatActivity {
    private ImageView imageView1;
    private TextView textView;
    private Bitmap bitmap;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(new ImageView_bitmap(this));
        setContentView(R.layout.activity_setting);


       imageView1 = (ImageView)findViewById(R.id.imageView1);
        AssetManager as = getResources().getAssets();
        InputStream is =null;

        try{
            is=as.open("givemergb1.png");
            bitmap = BitmapFactory.decodeStream(is);
            imageView1.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }

        imageView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.performClick();

                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int pixel = bitmap.getPixel(x,y);

                int red = Color.red(pixel);
                int blue = Color.blue(pixel);
                int green = Color.green(pixel);

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(SettingActivity.this,""+red+"/"+blue+"/"+green,Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        break;
                    default:
                        break;


                }

                return true;
            }
            
        });


       // imageView1.setImageBitmap(bitmap);
    }



}


/*
    public class ImageView_bitmap extends View
    {

        public ImageView_bitmap(SettingActivity settingActivity)
        {
            super(settingActivity);
        }

        protected void onDraw(Canvas canvas)
        {
            int width = canvas.getWidth();
            int height = canvas.getHeight();

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.givemergb);
            Bitmap resize_bitmap = Bitmap.createScaledBitmap(bitmap,width,height,true);

            canvas.drawBitmap(resize_bitmap,0,0,null);
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent)
        {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE)
            {
                int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                 int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b= Color.blue(pixel);

                Intent outIntent = new Intent();
                outIntent.putExtra("data_r", r);
                outIntent.putExtra("data_g", g);
                outIntent.putExtra("data_b", b);
                setResult(RESULT_OK,outIntent);
                finish();
                Toast.makeText(SettingActivity.this,r + "," + g + "," + b,Toast.LENGTH_LONG).show();

            }
            return true;
        }
    }
}*/
