package com.android.sonsofpitches.starbazaar;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class Shop implements Parcelable{

    private int shopLogo;
    private String shopSummary;
    private String shopName;

    public Shop (int shopLogo, String shopSummary, String shopName) {
        this.shopLogo = shopLogo;
        this.shopSummary = shopSummary;
        this.shopName = shopName;
    }

    protected Shop(Parcel in) {
        shopLogo = in.readInt();
        shopSummary = in.readString();
        shopName = in.readString();
    }

    public static final Creator<Shop> CREATOR = new Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel in) {
            return new Shop(in);
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(shopLogo);
        parcel.writeString(shopSummary);
        parcel.writeString(shopName);
    }


    public int getShopLogo() {
        return shopLogo;
    }

    public String getShopSummary() {
        return shopSummary;
    }

    public String getShopName() {
        return shopName;
    }

}

