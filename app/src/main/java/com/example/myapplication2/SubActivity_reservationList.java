package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubActivity_reservationList extends AppCompatActivity {

//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    RecyclerAdapter recyclerAdapter;
//    private RecyclerAdapter adapter;
//    int[] timeArr = new int[4];
    TextView daynight1, daynight2, hour1, hour2, min1, min2, char1, char2, TextViewStart;
    int startHour, startMin, endHour, endMin;

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
        TextViewStart = (TextView)findViewById(R.id.TextViewStart);
        //end = (TextView)findViewById(R.id.end);




//        recyclerView = findViewById(R.id.recyclerView);
//        linearLayoutManager = new LinearLayoutManager(this);
//
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        // <ItemList> or <Integer> ?
//        List<ItemList> itemLists = new ArrayList<>();
//            itemLists.add(new ItemList(timeArr));
//
//        recyclerAdapter = new RecyclerAdapter(this, itemLists);
//        recyclerView.setAdapter(recyclerAdapter);

    }

    public void reservationListOnClick(View v){
        finish();
    }

    // 리스트 추가(plus button) 버튼 눌렀을 경우 실행되는 액티비티
    public void reservationOnClick(View v) {
        Intent intent = new Intent(this, SubActivity_reservation.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);

        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                startHour = Data.getIntExtra("startHour", 0);
                startMin = Data.getIntExtra("startMin", 0);
                endHour = Data.getIntExtra("endHour", 0);
                endMin = Data.getIntExtra("endMin", 0);

                hour1.setText(startHour - 12);
                min1.setText(new StringBuilder().append(startMin));

                hour2.setText(new StringBuilder().append(endHour));
                min2.setText(new StringBuilder().append(endMin));

                if (startHour > 12) {
                    daynight1.setText(new StringBuilder().append("오후"));
                } else {
                    daynight1.setText(new StringBuilder().append("오전"));
                }

                if (endHour > 12) {
                    daynight2.setText(new StringBuilder().append("오후"));
                } else {
                    daynight2.setText(new StringBuilder().append("오전"));
                }
            }
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//
//    }

}
