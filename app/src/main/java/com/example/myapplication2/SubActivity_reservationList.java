package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity_reservationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation_list);
    }

    public void reservationListOnClick(View v){
        finish();
    }



    // 리스트 추가(plus button) 버튼 눌렀을 경우 실행되는 액티비티
    public void reservationOnClick(View v) {
        Intent intent = new Intent(this, SubActivity_reservation.class);
        startActivity(intent);
    }



}
