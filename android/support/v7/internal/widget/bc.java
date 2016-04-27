package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bc implements Creator {
    bc() {
    }

    public bb m1969a(Parcel parcel) {
        return new bb(null);
    }

    public bb[] m1970a(int i) {
        return new bb[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1969a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1970a(i);
    }
}
