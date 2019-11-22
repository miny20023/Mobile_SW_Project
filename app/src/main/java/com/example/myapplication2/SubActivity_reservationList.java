package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity_reservationList extends AppCompatActivity {

    TextView daynight1, daynight2, hour1, hour2, min1, min2, char1, char2;

    TextView TextViewCheckbox;
    CheckBox checkBox;
    LinearLayout linearlayout1, linearlayout2;

    Button addBtn, listSaveBtn;
    int startHour, startMin, endHour, endMin;

    private int reservationListOk;
    int brightnessSwitchOk;
    int seekbarProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation_list);


        daynight1 = (TextView)findViewById(R.id.daynight1);
        daynight2 = (TextView)findViewById(R.id.daynight2);
        hour1 = (TextView)findViewById(R.id.hour1);
        hour2 = (TextView)findViewById(R.id.hour2);
        min1 = (TextView)findViewById(R.id.min1);
        min2 = (TextView)findViewById(R.id.min2);
        char1 = (TextView)findViewById(R.id.char1);
        char2 = (TextView)findViewById(R.id.char2);
        TextViewCheckbox = (TextView) findViewById(R.id.TextViewCheckbox);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        listSaveBtn = (Button) findViewById(R.id.listSaveBtn);
        addBtn = (Button) findViewById(R.id.addButton);
        linearlayout1 = (LinearLayout) findViewById(R.id.linearlayout1);
        linearlayout2 = (LinearLayout) findViewById(R.id.linearlayout2);

        checkBox.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked() == true) {
                    linearlayout1.setVisibility(View.VISIBLE);
                    linearlayout2.setVisibility(View.VISIBLE);
                    addBtn.setVisibility(View.VISIBLE);
                    listSaveBtn.setVisibility(View.VISIBLE);

                    reservationListOk = 50;
                } else {
                    linearlayout1.setVisibility(View.INVISIBLE);
                    linearlayout2.setVisibility(View.INVISIBLE);
                    addBtn.setVisibility(View.INVISIBLE);

                    reservationListOk = 51;
                }
            }
        });

        listSaveBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reservationListOk == 50) {
                    Intent outIntent = new Intent();
                    outIntent.putExtra("reservationOK", reservationListOk);

                    outIntent.putExtra("startHour", startHour);
                    outIntent.putExtra("startMin", startMin);
                    outIntent.putExtra("endHour", endHour);
                    outIntent.putExtra("endMin", endMin);

                    outIntent.putExtra("seekbarProgress", seekbarProgress);
                    outIntent.putExtra("brightnessSwitchOk", brightnessSwitchOk);

                    setResult(RESULT_OK, outIntent);

                    finish();
                } else if (reservationListOk == 51) {
                    finish();
                } else {
                    Toast.makeText(SubActivity_reservationList.this, "예약설정 실패", Toast.LENGTH_SHORT).show();
                }


            }
        });


//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

//    public void reservationListOnClick(View v){
//        finish();
//    }

    // 리스트 추가(plus button) 버튼 눌렀을 경우 실행되는 액티비티
    public void reservationOnClick(View v) {
        Intent intent = new Intent(SubActivity_reservationList.this, SubActivity_reservation.class);
        startActivityForResult(intent, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);

        if (requestCode == 1001) {
            if (resultCode == RESULT_OK) {
                startHour = Data.getIntExtra("startHour", 0);
                startMin = Data.getIntExtra("startMin", 0);
                endHour = Data.getIntExtra("endHour", 0);
                endMin = Data.getIntExtra("endMin", 0);

                brightnessSwitchOk = Data.getIntExtra("brightnessSwitchOk", 0);
                seekbarProgress = Data.getIntExtra("seekbarProgress", 0);

                min1.setText(String.valueOf(startMin));
                min2.setText(String.valueOf(endMin));

                if (startHour > 12) {
                    hour1.setText(String.valueOf(startHour - 12));

                    daynight1.setText("오후");
                } else {
                    hour2.setText(String.valueOf(startHour));
                    daynight1.setText("오전");
                }

                if (endHour > 12) {
                    hour2.setText(String.valueOf(endHour - 12));
                    daynight2.setText("오후");
                } else {
                    hour2.setText(String.valueOf(endHour));
                    daynight2.setText("오전");
                }
            }
        }
    }
}
