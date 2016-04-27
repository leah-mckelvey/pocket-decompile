package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

/* renamed from: android.support.v7.internal.widget.e */
class C0264e extends BaseSavedState {
    public static final Creator CREATOR;
    long f1195a;
    int f1196b;

    static {
        CREATOR = new C0266f();
    }

    C0264e(Parcel parcel) {
        super(parcel);
        this.f1195a = parcel.readLong();
        this.f1196b = parcel.readInt();
    }

    C0264e(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f1195a + " position=" + this.f1196b + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f1195a);
        parcel.writeInt(this.f1196b);
    }
}
