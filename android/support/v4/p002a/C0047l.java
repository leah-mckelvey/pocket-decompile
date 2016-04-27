package android.support.v4.p002a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.a.l */
final class C0047l implements Creator {
    C0047l() {
    }

    public C0046k m302a(Parcel parcel) {
        return new C0046k(parcel);
    }

    public C0046k[] m303a(int i) {
        return new C0046k[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m302a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m303a(i);
    }
}
