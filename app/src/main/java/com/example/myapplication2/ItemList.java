package com.example.myapplication2;

public class ItemList {
    int startHour;
    int startMin;
    int endHour;
    int endMin;

    // 디폴트 생성자
    public ItemList(){

    }

    public ItemList (int[] timeArr) {
        this.startHour = timeArr[0];
        this.startMin = timeArr[1];
        this.endHour = timeArr[2];
        this.endMin = timeArr[3];
    }

    // getter
    public int getStartHour() {
        return startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getEndMin() {
        return endMin;
    }

    //setter
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }
}
