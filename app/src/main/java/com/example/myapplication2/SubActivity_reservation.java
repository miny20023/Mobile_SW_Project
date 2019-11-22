package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_reservation extends AppCompatActivity implements  TimePicker.OnTimeChangedListener {

    TimePicker timePicker1, timePicker2;
    int startHour, startMin, endHour, endMin;
    Button cancelBtn, completeBtn;
    SeekBar seekBar;
    int seekBarProgress;
    Switch brightnessSwitch;
    int brightnessSwitchOk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker2 = (TimePicker) findViewById(R.id.timePicker2);

        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        completeBtn = (Button) findViewById(R.id.completeBtn);

        brightnessSwitch = (Switch) findViewById(R.id.brightnessSwitch);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        brightnessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (brightnessSwitch.isChecked() == isChecked) {
                    brightnessSwitchOk = 55;
                } else {
                    brightnessSwitchOk = 56;
                }
            }
        });

//        timePicker1.setIs24HourView(false);//12시간 단위
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                startHour = hourOfDay;
                startMin = minute;
            }
        });
//        timePicker2.setIs24HourView(false);//12시간 단위
        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                endHour = hourOfDay;
                endMin = minute;
            }
        });

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent();
                outIntent.putExtra("startHour", startHour);
                outIntent.putExtra("startMin", startMin);
                outIntent.putExtra("endHour", endHour);
                outIntent.putExtra("endMin", endMin);

                // seekbar 값
                outIntent.putExtra("seekBarProgress", seekBarProgress);

                // 조도센서 on / off 값
                outIntent.putExtra("birghtnessSwitchOk", brightnessSwitchOk);

                setResult(RESULT_OK, outIntent);

                finish();
            }
        });
    }


    public void reservationOnClick(View v){
        finish();
    }

    // 취소버튼 눌렀을 때 뒤로가기 기능
    public void cancelOnClick(View v) {
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