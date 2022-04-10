package com.rijal.daftar;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu implements Parcelable {
    public static List<Menu> listMenu = Arrays.asList(
            new Menu(R.drawable.game, "Game", Arrays.asList(
                    new MenuSub(R.drawable.dota, "Dota II", R.drawable.dota),
                    new MenuSub(R.drawable.mobile_legend, "Mobile Legend", R.drawable.mobile_legend),
                    new MenuSub(R.drawable.aov, "Arena of Valor", R.drawable.aov),
                    new MenuSub(R.drawable.fgo, "Fate Grand Order", R.drawable.fgo),
                    new MenuSub(R.drawable.azurlane, "Azur Lane", R.drawable.azurlane),
                    new MenuSub(R.drawable.arknight, "Arknights", R.drawable.arknight),
                    new MenuSub(R.drawable.food, "Ke Menu Makanan", R.drawable.food),
                    new MenuSub(R.drawable.exit, "Kembali", R.drawable.exit)
            )),
            new Menu(R.drawable.film, "Film", Arrays.asList(
                    new MenuSub(R.drawable.adventure, "Adventure", R.drawable.adventure),
                    new MenuSub(R.drawable.action, "Action", R.drawable.action),
                    new MenuSub(R.drawable.drama, "Drama", R.drawable.drama),
                    new MenuSub(R.drawable.music, "Ke Menu Music", R.drawable.music),
                    new MenuSub(R.drawable.exit, "Kembali", R.drawable.exit)
            )),
            new Menu(R.drawable.music, "Music", Arrays.asList(
                    new MenuSub(R.drawable.guitar, "Rock", R.drawable.guitar),
                    new MenuSub(R.drawable.reggae, "Reggae", R.drawable.reggae),
                    new MenuSub(R.drawable.jazz, "Jazz", R.drawable.jazz),
                    new MenuSub(R.drawable.film, "Ke Menu Film", R.drawable.film),
                    new MenuSub(R.drawable.exit, "Kembali", R.drawable.exit)
            )),
            new Menu(R.drawable.food, "Makanan", Arrays.asList(
                    new MenuSub(R.drawable.bigmac, "Big Mac",R.drawable.bigmac),
                    new MenuSub(R.drawable.miesedaap, "Mie Sedaap",R.drawable.miesedaap),
                    new MenuSub(R.drawable.ayambakar, "Ayam Bakar",R.drawable.ayambakar),
                    new MenuSub(R.drawable.bakso, "Bakso",R.drawable.bakso),
                    new MenuSub(R.drawable.game, "Ke Menu Game", R.drawable.game),
                    new MenuSub(R.drawable.exit, "Kembali", R.drawable.exit)
            )),
            new Menu(R.drawable.exit, "Keluar", new ArrayList<>())
    );
    public int icon;
    public String name;
    public List<MenuSub> menuSubs;

    public Menu(int icon, String name, List<MenuSub> menuSubs) {
        this.icon = icon;
        this.name = name;
        this.menuSubs = menuSubs;
    }

    public List<MenuSub> getMenuSubs() {
        return menuSubs;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.icon);
        dest.writeString(this.name);
        dest.writeList(this.menuSubs);
    }

    public void readFromParcel(Parcel source) {
        this.icon = source.readInt();
        this.name = source.readString();
        this.menuSubs = new ArrayList<MenuSub>();
        source.readList(this.menuSubs, MenuSub.class.getClassLoader());
    }

    protected Menu(Parcel in) {
        this.icon = in.readInt();
        this.name = in.readString();
        this.menuSubs = new ArrayList<MenuSub>();
        in.readList(this.menuSubs, MenuSub.class.getClassLoader());
    }

    public static final Parcelable.Creator<Menu> CREATOR = new Parcelable.Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
}
