package com.zxcl.myapplication.序列化和反序列化;

import android.os.Parcel;
import android.os.Parcelable;

public class MyUser implements Parcelable {
    public static final Creator<MyUser> CREATOR = new Creator<MyUser>() {
        @Override
        public MyUser createFromParcel(Parcel in) {
            return new MyUser(in);
        }

        @Override
        public MyUser[] newArray(int size) {
            return new MyUser[size];
        }
    };
    /**
     * 静态变量属于类，不属于实例对象，所以不会被序列化
     */
    public static String name;
    /**
     * transient 短暂的
     */
    transient int age;
    String address;

    protected MyUser(Parcel in) {
        address = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
    }
}
