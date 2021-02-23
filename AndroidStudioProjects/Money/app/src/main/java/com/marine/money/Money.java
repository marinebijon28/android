package com.marine.money;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Money implements Parcelable {
    public final int image;
    public final float change;
    public final String symbole;

    public Money(int image, float change, String symbole) {
        this.image = image;
        this.change = change;
        this.symbole = symbole;
    }

    protected Money(Parcel in) {
        image = in.readInt();
        change = in.readFloat();
        symbole = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeFloat(change);
        dest.writeString(symbole);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Money> CREATOR = new Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel in) {
            return new Money(in);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };
}
