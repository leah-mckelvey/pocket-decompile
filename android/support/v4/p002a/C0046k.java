package android.support.v4.p002a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.k */
final class C0046k implements Parcelable {
    public static final Creator CREATOR;
    final int[] f204a;
    final int f205b;
    final int f206c;
    final String f207d;
    final int f208e;
    final int f209f;
    final CharSequence f210g;
    final int f211h;
    final CharSequence f212i;
    final ArrayList f213j;
    final ArrayList f214k;

    static {
        CREATOR = new C0047l();
    }

    public C0046k(Parcel parcel) {
        this.f204a = parcel.createIntArray();
        this.f205b = parcel.readInt();
        this.f206c = parcel.readInt();
        this.f207d = parcel.readString();
        this.f208e = parcel.readInt();
        this.f209f = parcel.readInt();
        this.f210g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f211h = parcel.readInt();
        this.f212i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f213j = parcel.createStringArrayList();
        this.f214k = parcel.createStringArrayList();
    }

    public C0046k(C0059w c0059w, C0040e c0040e) {
        int i = 0;
        for (C0044i c0044i = c0040e.f155c; c0044i != null; c0044i = c0044i.f190a) {
            if (c0044i.f198i != null) {
                i += c0044i.f198i.size();
            }
        }
        this.f204a = new int[(i + (c0040e.f157e * 7))];
        if (c0040e.f164l) {
            i = 0;
            for (C0044i c0044i2 = c0040e.f155c; c0044i2 != null; c0044i2 = c0044i2.f190a) {
                int i2 = i + 1;
                this.f204a[i] = c0044i2.f192c;
                int i3 = i2 + 1;
                this.f204a[i2] = c0044i2.f193d != null ? c0044i2.f193d.f247g : -1;
                int i4 = i3 + 1;
                this.f204a[i3] = c0044i2.f194e;
                i2 = i4 + 1;
                this.f204a[i4] = c0044i2.f195f;
                i4 = i2 + 1;
                this.f204a[i2] = c0044i2.f196g;
                i2 = i4 + 1;
                this.f204a[i4] = c0044i2.f197h;
                if (c0044i2.f198i != null) {
                    int size = c0044i2.f198i.size();
                    i4 = i2 + 1;
                    this.f204a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f204a[i4] = ((C0048m) c0044i2.f198i.get(i2)).f247g;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f204a[i2] = 0;
                }
            }
            this.f205b = c0040e.f162j;
            this.f206c = c0040e.f163k;
            this.f207d = c0040e.f166n;
            this.f208e = c0040e.f168p;
            this.f209f = c0040e.f169q;
            this.f210g = c0040e.f170r;
            this.f211h = c0040e.f171s;
            this.f212i = c0040e.f172t;
            this.f213j = c0040e.f173u;
            this.f214k = c0040e.f174v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0040e m301a(C0059w c0059w) {
        C0040e c0040e = new C0040e(c0059w);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f204a.length) {
            C0044i c0044i = new C0044i();
            int i3 = i2 + 1;
            c0044i.f192c = this.f204a[i2];
            if (C0059w.f291a) {
                Log.v("FragmentManager", "Instantiate " + c0040e + " op #" + i + " base fragment #" + this.f204a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f204a[i3];
            if (i2 >= 0) {
                c0044i.f193d = (C0048m) c0059w.f297f.get(i2);
            } else {
                c0044i.f193d = null;
            }
            i3 = i4 + 1;
            c0044i.f194e = this.f204a[i4];
            i4 = i3 + 1;
            c0044i.f195f = this.f204a[i3];
            i3 = i4 + 1;
            c0044i.f196g = this.f204a[i4];
            int i5 = i3 + 1;
            c0044i.f197h = this.f204a[i3];
            i4 = i5 + 1;
            int i6 = this.f204a[i5];
            if (i6 > 0) {
                c0044i.f198i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0059w.f291a) {
                        Log.v("FragmentManager", "Instantiate " + c0040e + " set remove fragment #" + this.f204a[i4]);
                    }
                    i5 = i4 + 1;
                    c0044i.f198i.add((C0048m) c0059w.f297f.get(this.f204a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0040e.m296a(c0044i);
            i++;
            i2 = i4;
        }
        c0040e.f162j = this.f205b;
        c0040e.f163k = this.f206c;
        c0040e.f166n = this.f207d;
        c0040e.f168p = this.f208e;
        c0040e.f164l = true;
        c0040e.f169q = this.f209f;
        c0040e.f170r = this.f210g;
        c0040e.f171s = this.f211h;
        c0040e.f172t = this.f212i;
        c0040e.f173u = this.f213j;
        c0040e.f174v = this.f214k;
        c0040e.m295a(1);
        return c0040e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f204a);
        parcel.writeInt(this.f205b);
        parcel.writeInt(this.f206c);
        parcel.writeString(this.f207d);
        parcel.writeInt(this.f208e);
        parcel.writeInt(this.f209f);
        TextUtils.writeToParcel(this.f210g, parcel, 0);
        parcel.writeInt(this.f211h);
        TextUtils.writeToParcel(this.f212i, parcel, 0);
        parcel.writeStringList(this.f213j);
        parcel.writeStringList(this.f214k);
    }
}
