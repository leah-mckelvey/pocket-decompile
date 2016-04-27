package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.View.BaseSavedState;

/* renamed from: android.support.design.widget.g */
public class C0014g extends BaseSavedState {
    public static final Creator CREATOR;
    SparseArray f62a;

    static {
        CREATOR = new C0015h();
    }

    public C0014g(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(C0009b.class.getClassLoader());
        this.f62a = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f62a.append(iArr[i], readParcelableArray[i]);
        }
    }

    public C0014g(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        super.writeToParcel(parcel, i);
        int size = this.f62a != null ? this.f62a.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        while (i2 < size) {
            iArr[i2] = this.f62a.keyAt(i2);
            parcelableArr[i2] = (Parcelable) this.f62a.valueAt(i2);
            i2++;
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
