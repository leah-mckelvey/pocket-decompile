package android.support.v4.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* renamed from: android.support.v4.c.a.l */
class C0084l {
    public static Drawable m515a(Drawable drawable) {
        return drawable instanceof GradientDrawable ? new C0089q(drawable) : drawable;
    }

    public static void m516a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m517a(Drawable drawable, int i) {
        if (drawable instanceof C0089q) {
            C0081i.m507a(drawable, i);
        } else {
            drawable.setTint(i);
        }
    }

    public static void m518a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m519a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0089q) {
            C0081i.m508a(drawable, colorStateList);
        } else {
            drawable.setTintList(colorStateList);
        }
    }

    public static void m520a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0089q) {
            C0081i.m509a(drawable, mode);
        } else {
            drawable.setTintMode(mode);
        }
    }
}
