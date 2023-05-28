package com.example.aplikasi_pesan_tiket;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class TiketModel implements Parcelable {
    private String name;
    private int price;

    private int img;
    private List<String> type;

    public TiketModel() {

    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    protected TiketModel(Parcel in){
        this.name =in.readString();
        this.price = in.readInt();
        this.img = in.readInt();
        this.type = in.createStringArrayList();
    }

    public static final Creator<TiketModel> CREATOR = new Creator<TiketModel>() {
        @Override
        public TiketModel createFromParcel(Parcel in) {
            return new TiketModel(in);
        }

        @Override
        public TiketModel[] newArray(int size) {
            return new TiketModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(img);
        dest.writeStringList(type);
    }
}
