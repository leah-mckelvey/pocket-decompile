package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class bb extends C0264e {
    public static final Creator CREATOR;
    boolean f1197c;

    static {
        CREATOR = new bc();
    }

    private bb(Parcel parcel) {
        super(parcel);
        this.f1197c = parcel.readByte() != null;
    }

    bb(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (this.f1197c ? 1 : 0));
    }
}
