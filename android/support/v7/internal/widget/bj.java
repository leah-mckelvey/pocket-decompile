package android.support.v7.internal.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.p009g.C0109f;

class bj extends C0109f {
    public bj(int i) {
        super(i);
    }

    private static int m1996b(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    PorterDuffColorFilter m1997a(int i, Mode mode) {
        return (PorterDuffColorFilter) m594a((Object) Integer.valueOf(m1996b(i, mode)));
    }

    PorterDuffColorFilter m1998a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) m595a(Integer.valueOf(m1996b(i, mode)), porterDuffColorFilter);
    }
}
