package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_timesetting extends  AppCompatActivity{

        Button timeBtn, timeBtn2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sub_timesetting);


        }

        // 현재 시간 설정 버튼
        public void timeOnClick (View v) {
            finish();
        }

        public void timeCompleteOnClick (View v) {
            finish();
        }



}
