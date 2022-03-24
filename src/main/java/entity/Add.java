package entity;

import java.util.Date;

/**
 * 添加数据的数据模型
 */

public class Add {
    private int id;
    private int TN1;
    private int TN2;
    private int TN3;
    private int TN4;
    private int TN5;
    private int TN6;
    private int TN7;
    private String date;

    public Add() {
    }


    public Add(int id, int TN1, int TN2, int TN3, int TN4, int TN5, int TN6, int TN7, String date) {
        this.id = id;
        this.TN1 = TN1;
        this.TN2 = TN2;
        this.TN3 = TN3;
        this.TN4 = TN4;
        this.TN5 = TN5;
        this.TN6 = TN6;
        this.TN7 = TN7;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTN1() {
        return TN1;
    }

    public void setTN1(int TN1) {
        this.TN1 = TN1;
    }

    public int getTN2() {
        return TN2;
    }

    public void setTN2(int TN2) {
        this.TN2 = TN2;
    }

    public int getTN3() {
        return TN3;
    }

    public void setTN3(int TN3) {
        this.TN3 = TN3;
    }

    public int getTN4() {
        return TN4;
    }

    public void setTN4(int TN4) {
        this.TN4 = TN4;
    }

    public int getTN5() {
        return TN5;
    }

    public void setTN5(int TN5) {
        this.TN5 = TN5;
    }

    public int getTN6() {
        return TN6;
    }

    public void setTN6(int TN6) {
        this.TN6 = TN6;
    }

    public int getTN7() {
        return TN7;
    }

    public void setTN7(int TN7) {
        this.TN7 = TN7;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
