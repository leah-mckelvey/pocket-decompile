package android.support.v4.p002a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.a.aa */
final class aa implements Parcelable {
    public static final Creator CREATOR;
    ac[] f90a;
    int[] f91b;
    C0046k[] f92c;

    static {
        CREATOR = new ab();
    }

    public aa(Parcel parcel) {
        this.f90a = (ac[]) parcel.createTypedArray(ac.CREATOR);
        this.f91b = parcel.createIntArray();
        this.f92c = (C0046k[]) parcel.createTypedArray(C0046k.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f90a, i);
        parcel.writeIntArray(this.f91b);
        parcel.writeTypedArray(this.f92c, i);
    }
}
