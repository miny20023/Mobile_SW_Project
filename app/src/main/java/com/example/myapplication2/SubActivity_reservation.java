package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_reservation extends AppCompatActivity implements  TimePicker.OnTimeChangedListener {

    TimePicker timePicker1, timePicker2;
    //String startHour, startMin, endHour, endMin;
    int startHour, startMin, endHour, endMin;
    Button cancelBtn, completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker2 = (TimePicker) findViewById(R.id.timePicker2);

        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        completeBtn = (Button) findViewById(R.id.completeBtn);

//        timePicker1.setIs24HourView(false);//12시간 단위
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                startHour = hourOfDay;
                startMin = minute;
            }
        });
//
//        timePicker2.setIs24HourView(false);//12시간 단위
        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                endHour = hourOfDay;
                endMin = minute;
            }
        });

//        startHour = timePicker1.getHour();
//        startMin = timePicker1.getMinute();
//        endHour = timePicker2.getHour();
//        endMin = timePicker2.getMinute();

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent();
                outIntent.putExtra("startHour", startHour);
                outIntent.putExtra("startMin", startMin);
                outIntent.putExtra("endHour", endHour);
                outIntent.putExtra("endMin", endMin);

                setResult(RESULT_OK, outIntent);

            }
        });
    }


    public void reservationOnClick(View v){
        finish();
    }

    // 취소버튼 눌렀을 때 뒤로가기 기능
    public void cancelOnClick(View v) {
        this.finish();
    }

    // 완료버튼 눌렀을 때 이전 액티비티로 이동
    public void completeOnClick(View v) {
        finish();
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int min) {
        if(timePicker.getId() == R.id.timePicker1) {
            startHour = hour;
            startMin = min;
        } else if (timePicker.getId() == R.id.timePicker2){
            endHour = hour;
            endMin = min;
        }
    }
}