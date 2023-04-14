package com.example.warship;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.NumberFormat;
import java.util.Locale;

public class Warship implements Parcelable {
    private String name;
    private String type;
    private int price;
    private String description;
    private String imgUrl;

    protected Warship(Parcel in) {
        name = in.readString();
        type = in.readString();
        price = in.readInt();
        description = in.readString();
        imgUrl = in.readString();
    }

    public Warship(){}

    public static final Creator<Warship> CREATOR = new Creator<Warship>() {
        @Override
        public Warship createFromParcel(Parcel in) {
            return new Warship(in);
        }

        @Override
        public Warship[] newArray(int size) {
            return new Warship[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeInt(price);
        dest.writeString(description);
        dest.writeString(imgUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrencyDollar() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        format.setMaximumFractionDigits(0);
        return format.format(this.price);
    }

    public static String convertIntToDollar(int price) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        format.setMaximumFractionDigits(0);
        return format.format(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
