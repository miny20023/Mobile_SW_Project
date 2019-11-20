package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class SubActivity_reservationList extends AppCompatActivity {

    private RecyclerAdapter adapter;
    int[] timeArr = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_reservation_list);

        init();

        SubActivity_reservation subReservation = new SubActivity_reservation();
        // 예약설정 -> 시작시간, 끝나는시간이 int 배열에 들어가있음
        timeArr = subReservation.sendTimeData();

        ItemList itemList = new ItemList(timeArr);

        getItem(timeArr);
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getItem(int[] timeArr) {

        List<Integer> list = Arrays.asList(timeArr[0], timeArr[1], timeArr[2], timeArr[3]);

        for (int i = 0; i < list.size(); i ++) {
            ItemList item = new ItemList();
            item.setStartHour(list.get(i));
            item.setStartMin(list.get(i));
            item.setEndHour((list.get(i)));
            item.setEndMin(list.get(i));



            adapter.addItem(item);
        }

        // adapter의 값이 변경되었다는 것을 알려줌
        adapter.notifyDataSetChanged();
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
