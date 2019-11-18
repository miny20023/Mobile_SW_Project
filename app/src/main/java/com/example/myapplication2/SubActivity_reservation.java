package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_reservation extends AppCompatActivity {

    TimePicker timePicker;
    Button cancelBtn, completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        completeBtn = (Button) findViewById(R.id.completeBtn);

        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

    }



    public void reservationOnClick(View v){
        finish();
    }

    // 취소버튼 눌렀을 때 뒤로가기 기능
    public void cancelOnClick(View v) {
        finish();
    }

    // 완료버튼 눌렀을 때 이전 액티비티로 이동 + 리스트 추가 기능 넣어야함
    public void completeOnClick(View v) {
        finish();
    }


}
