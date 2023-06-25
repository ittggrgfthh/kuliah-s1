package com.example.firebaseproject;

import java.util.Date;

public class ModelBarang {
    String itemCode;
    String itemName;
    String itemUnit;
    String itemAmount;
    int itemPrice;
    String itemExpired;
    String itemPackaging;
    String itemType;
    String key;

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getItemExpired() {
        return itemExpired;
    }

    public void setItemExpired(String itemExpired) {
        this.itemExpired = itemExpired;
    }

    public String getItemPackaging() {
        return itemPackaging;
    }

    public void setItemPackaging(String itemPackaging) {
        this.itemPackaging = itemPackaging;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
