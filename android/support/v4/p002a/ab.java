package android.support.v4.p002a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.a.ab */
final class ab implements Creator {
    ab() {
    }

    public aa m183a(Parcel parcel) {
        return new aa(parcel);
    }

    public aa[] m184a(int i) {
        return new aa[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m183a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m184a(i);
    }
}
