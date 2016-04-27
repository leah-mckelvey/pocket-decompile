package android.support.v4.p002a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.a.ad */
final class ad implements Creator {
    ad() {
    }

    public ac m186a(Parcel parcel) {
        return new ac(parcel);
    }

    public ac[] m187a(int i) {
        return new ac[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m186a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m187a(i);
    }
}
