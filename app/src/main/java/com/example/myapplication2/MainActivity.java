package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    ToggleButton onoffbtn;
    Button passiveBtn, reservationBtn, timeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeBtn = (Button) findViewById(R.id.timeBtn);

        onoffbtn = (ToggleButton) findViewById(R.id.onoffbtn);

        onoffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onoffbtn.isChecked()) {
                    onoffbtn.setBackgroundDrawable(
                            getResources().getDrawable(R.drawable.onbtn3)
                    );
                } else {
                    onoffbtn.setBackgroundDrawable(
                            getResources().getDrawable(R.drawable.offbtn3)
                    );
                }
            }
        });


        /*
        * timeBtn2.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeBtn2.setVisibility(View.INVISIBLE);
                }
            });
        *
        * */

    }

    // 현재 시간 설정 버튼 눌렀을 때 TimeSetting 액티비티 실행
    public void timeOnClick(View v) {
        Intent intent = new Intent(this, SubActivity_timesetting.class);
        startActivity(intent);
    }

    // 수동설정 버튼 눌렀을 경우 실행되는 액티비티
    public void passiveOnClick(View v) {
        Intent intent = new Intent(this, SubActivity_passive.class);
        startActivity(intent);
    }

    // 예약설정 버튼 눌렀을 경우 실행되는 액티비티
    public void reservationListOnClick(View v) {
        Intent intent = new Intent(this, SubActivity_reservationList.class);
        startActivity(intent);
    }
}
