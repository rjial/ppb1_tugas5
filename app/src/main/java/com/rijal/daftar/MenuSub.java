package com.rijal.daftar;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuSub implements Parcelable {
    public int icon;
    public String name;
    public int gambar;

    public MenuSub(int icon, String name, int gambar) {
        this.icon = icon;
        this.name = name;
        this.gambar = gambar;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.icon);
        dest.writeString(this.name);
        dest.writeInt(this.gambar);
    }

    public void readFromParcel(Parcel source) {
        this.icon = source.readInt();
        this.name = source.readString();
        this.gambar = source.readInt();
    }

    protected MenuSub(Parcel in) {
        this.icon = in.readInt();
        this.name = in.readString();
        this.gambar = in.readInt();
    }

    public static final Parcelable.Creator<MenuSub> CREATOR = new Parcelable.Creator<MenuSub>() {
        @Override
        public MenuSub createFromParcel(Parcel source) {
            return new MenuSub(source);
        }

        @Override
        public MenuSub[] newArray(int size) {
            return new MenuSub[size];
        }
    };
}
