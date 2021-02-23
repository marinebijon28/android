package com.marine.money;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class User extends ArrayList<Parcelable> implements Parcelable {
    public final String name;
    public final String version;

    public User(String name, String version) {
        this.name = name;
        this.version = version;
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.version = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @NonNull
    @Override
    public Stream<Parcelable> stream() {
        return null;
    }
}
