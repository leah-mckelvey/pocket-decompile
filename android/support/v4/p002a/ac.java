package android.support.v4.p002a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* renamed from: android.support.v4.a.ac */
final class ac implements Parcelable {
    public static final Creator CREATOR;
    final String f93a;
    final int f94b;
    final boolean f95c;
    final int f96d;
    final int f97e;
    final String f98f;
    final boolean f99g;
    final boolean f100h;
    final Bundle f101i;
    Bundle f102j;
    C0048m f103k;

    static {
        CREATOR = new ad();
    }

    public ac(Parcel parcel) {
        boolean z = true;
        this.f93a = parcel.readString();
        this.f94b = parcel.readInt();
        this.f95c = parcel.readInt() != 0;
        this.f96d = parcel.readInt();
        this.f97e = parcel.readInt();
        this.f98f = parcel.readString();
        this.f99g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f100h = z;
        this.f101i = parcel.readBundle();
        this.f102j = parcel.readBundle();
    }

    public ac(C0048m c0048m) {
        this.f93a = c0048m.getClass().getName();
        this.f94b = c0048m.f247g;
        this.f95c = c0048m.f256p;
        this.f96d = c0048m.f264x;
        this.f97e = c0048m.f265y;
        this.f98f = c0048m.f266z;
        this.f99g = c0048m.f218C;
        this.f100h = c0048m.f217B;
        this.f101i = c0048m.f249i;
    }

    public C0048m m185a(C0052p c0052p, C0048m c0048m) {
        if (this.f103k != null) {
            return this.f103k;
        }
        if (this.f101i != null) {
            this.f101i.setClassLoader(c0052p.getClassLoader());
        }
        this.f103k = C0048m.m305a((Context) c0052p, this.f93a, this.f101i);
        if (this.f102j != null) {
            this.f102j.setClassLoader(c0052p.getClassLoader());
            this.f103k.f245e = this.f102j;
        }
        this.f103k.m317a(this.f94b, c0048m);
        this.f103k.f256p = this.f95c;
        this.f103k.f258r = true;
        this.f103k.f264x = this.f96d;
        this.f103k.f265y = this.f97e;
        this.f103k.f266z = this.f98f;
        this.f103k.f218C = this.f99g;
        this.f103k.f217B = this.f100h;
        this.f103k.f260t = c0052p.f269b;
        if (C0059w.f291a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f103k);
        }
        return this.f103k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f93a);
        parcel.writeInt(this.f94b);
        parcel.writeInt(this.f95c ? 1 : 0);
        parcel.writeInt(this.f96d);
        parcel.writeInt(this.f97e);
        parcel.writeString(this.f98f);
        parcel.writeInt(this.f99g ? 1 : 0);
        if (!this.f100h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f101i);
        parcel.writeBundle(this.f102j);
    }
}
