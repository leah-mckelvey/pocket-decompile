package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bb implements Creator {
    bb() {
    }

    public ba m2283a(Parcel parcel) {
        return new ba(parcel);
    }

    public ba[] m2284a(int i) {
        return new ba[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2283a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2284a(i);
    }
}
