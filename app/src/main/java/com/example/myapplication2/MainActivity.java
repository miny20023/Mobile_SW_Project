package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton onoffbtn;
    Button passiveBtn, reservationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
