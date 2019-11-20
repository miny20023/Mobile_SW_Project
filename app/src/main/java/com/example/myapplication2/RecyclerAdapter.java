package com.example.myapplication2;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list
    private ArrayList<ItemList> itemList = new ArrayList<>();

    // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킨다
    // return 인자는 ViewHolder
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        //  RecyclerView의 총 개수
        return itemList.size();
    }

//    @Override
    public void addItem(ItemList item) {
        // 외부에서 item을 추가시킬 함수
        itemList.add(item);
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textHour1;
        private  TextView textMin1;
        private  TextView textHour2;
        private  TextView textMin2;

        ItemViewHolder(View itemView) {
            super(itemView);

            textHour1 = itemView.findViewById(R.id.textHour1);
            textMin1 = itemView.findViewById(R.id.textMin1);
            textHour2 = itemView.findViewById(R.id.textHour2);
            textMin2 = itemView.findViewById(R.id.textMin2);
        }

        // TextView에 텍스트 저장
        void onBind(ItemList item) {
            textHour1.setText(item.getStartHour());
            textMin1.setText(item.getStartMin());
            textHour2.setText(item.getEndHour());
            textMin2.setText(item.getEndMin());
        }
    }

}
