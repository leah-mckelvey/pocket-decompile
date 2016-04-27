package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ba extends BaseSavedState {
    public static final Creator CREATOR;
    public int f1457a;
    public boolean f1458b;

    static {
        CREATOR = new bb();
    }

    public ba(Parcel parcel) {
        super(parcel);
        this.f1457a = parcel.readInt();
        this.f1458b = parcel.readInt() != 0;
    }

    public ba(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1457a);
        parcel.writeInt(this.f1458b ? 1 : 0);
    }
}
