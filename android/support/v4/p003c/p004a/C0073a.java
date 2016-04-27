package android.support.v4.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.a.a */
public class C0073a {
    static final C0074c f329a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 22) {
            f329a = new C0079g();
        } else if (i >= 21) {
            f329a = new C0078f();
        } else if (i >= 19) {
            f329a = new C0077e();
        } else if (i >= 11) {
            f329a = new C0076d();
        } else {
            f329a = new C0075b();
        }
    }

    public static void m466a(Drawable drawable) {
        f329a.m475a(drawable);
    }

    public static void m467a(Drawable drawable, float f, float f2) {
        f329a.m476a(drawable, f, f2);
    }

    public static void m468a(Drawable drawable, int i) {
        f329a.m477a(drawable, i);
    }

    public static void m469a(Drawable drawable, int i, int i2, int i3, int i4) {
        f329a.m478a(drawable, i, i2, i3, i4);
    }

    public static void m470a(Drawable drawable, ColorStateList colorStateList) {
        f329a.m479a(drawable, colorStateList);
    }

    public static void m471a(Drawable drawable, Mode mode) {
        f329a.m480a(drawable, mode);
    }

    public static void m472a(Drawable drawable, boolean z) {
        f329a.m481a(drawable, z);
    }

    public static boolean m473b(Drawable drawable) {
        return f329a.m482b(drawable);
    }

    public static Drawable m474c(Drawable drawable) {
        return f329a.m483c(drawable);
    }
}
