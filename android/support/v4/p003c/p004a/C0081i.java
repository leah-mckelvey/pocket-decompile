package android.support.v4.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.i */
class C0081i {
    public static Drawable m506a(Drawable drawable) {
        return !(drawable instanceof C0086n) ? new C0086n(drawable) : drawable;
    }

    public static void m507a(Drawable drawable, int i) {
        if (drawable instanceof C0085m) {
            ((C0085m) drawable).setTint(i);
        }
    }

    public static void m508a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0085m) {
            ((C0085m) drawable).setTintList(colorStateList);
        }
    }

    public static void m509a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0085m) {
            ((C0085m) drawable).setTintMode(mode);
        }
    }
}
