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

    int seekbarProgress;
    int brightnewssSwitchOk;
    int reservationListOk;
    int startHour, startMin, endHour, endMin;

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
        startActivityForResult(intent, 1000);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);

        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                reservationListOk = Data.getIntExtra("reservationListOk", 0);

                startHour = Data.getIntExtra("startHour", 0);
                startMin = Data.getIntExtra("startMin", 0);
                endHour = Data.getIntExtra("endHour", 0);
                endMin = Data.getIntExtra("endMin", 0);

                seekbarProgress = Data.getIntExtra("seekbarProgress", 0);
                brightnewssSwitchOk = Data.getIntExtra("brightnewssSwitchOk", 0);




            }
        }
    }
}
