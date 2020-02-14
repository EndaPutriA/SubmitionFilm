package com.example.submitionfilm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Film  implements Parcelable{
    private int img;
    private String NameFilm;
    private String DescFilm;

    public Film(ArrayList<Film> films) {
    }

    public Film() {
    }

    public Film(int img, String nameFilm, String descFilm) {
        this.img = img;
        NameFilm = nameFilm;
        DescFilm = descFilm;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNameFilm() {
        return NameFilm;
    }

    public void setNameFilm(String nameFilm) {
        NameFilm = nameFilm;
    }

    public String getDescFilm() {
        return DescFilm;
    }

    public void setDescFilm(String descFilm) {
        DescFilm = descFilm;
    }

    protected Film(Parcel in) {
        img = in.readInt();
        NameFilm = in.readString();
        DescFilm = in.readString();
    }

    public static final Creator<Film> CREATOR = new Film.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(img);
        dest.writeString(NameFilm);
        dest.writeString(DescFilm);
    }
}
