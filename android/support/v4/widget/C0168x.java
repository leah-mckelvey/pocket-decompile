package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.x */
public class C0168x {
    static final ab f500a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            f500a = new aa();
        } else if (i >= 17) {
            f500a = new C0145z();
        } else {
            f500a = new C0144y();
        }
    }

    public static void m1137a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f500a.m1016a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
