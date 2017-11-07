package com.koreatech.bcsdlab.used_grid;

import android.database.Cursor;

/**
 * Created by wxg12 on 2017-10-10.
 */

public class UsedItem {
    int id;
    int thumbnail;
    String name;
    int price;
    int type;
    String content;
    static int num = 0;

    public UsedItem(String name, int price) {
        this.id = num;
        num++;
        this.name = name;
        this.price = price;
        this.content = name + ", " + price + "원에 판매합니다";
        this.type = 0;
    }

    public UsedItem(String name, int price, int type) {
        this.id = num;
        this.name = name;
        this.price = price;
        this.type = type;
        this.content = name + ", " + price + "원에 판매합니다";
        num++;
    }

    public UsedItem(String name, int price, String content) {
        this.id = num;
        num++;
        this.name = name;
        this.price = price;
        this.content = content;
        this.type = 0;
    }

    public UsedItem(int thumbnail, String name, int price, String content) {
        this.id = num;
        num++;
        this.thumbnail = thumbnail;
        this.name = name;
        this.price = price;
        this.content = content;
        this.type = 0;
    }

    public UsedItem(String name, int price, String content, int type) {
        this.id = num;
        num++;
        this.name = name;
        this.price = price;
        this.content = content;
        this.type = type;
    }

    public UsedItem(int thumbnail, String name, int price, String content, int type) {
        this.id = num;
        num++;
        this.thumbnail = thumbnail;
        this.name = name;
        this.price = price;
        this.content = content;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
