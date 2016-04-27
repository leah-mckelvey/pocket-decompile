package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.r */
public class C0162r {
    Object f498a;
    C0163s f499b;

    private C0162r(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f499b = new C0166v();
        } else if (i >= 9) {
            this.f499b = new C0165u();
        } else {
            this.f499b = new C0164t();
        }
        this.f498a = this.f499b.m1102a(context, interpolator);
    }

    C0162r(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    public static C0162r m1091a(Context context) {
        return C0162r.m1092a(context, null);
    }

    public static C0162r m1092a(Context context, Interpolator interpolator) {
        return new C0162r(context, interpolator);
    }

    public int m1093a() {
        return this.f499b.m1101a(this.f498a);
    }

    public void m1094a(int i, int i2, int i3, int i4, int i5) {
        this.f499b.m1103a(this.f498a, i, i2, i3, i4, i5);
    }

    public void m1095a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f499b.m1104a(this.f498a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int m1096b() {
        return this.f499b.m1105b(this.f498a);
    }

    public int m1097c() {
        return this.f499b.m1108e(this.f498a);
    }

    public int m1098d() {
        return this.f499b.m1109f(this.f498a);
    }

    public boolean m1099e() {
        return this.f499b.m1106c(this.f498a);
    }

    public void m1100f() {
        this.f499b.m1107d(this.f498a);
    }
}
