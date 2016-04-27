package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.l */
public class C0156l {
    static final C0157o f494a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f494a = new C0159n();
        } else {
            f494a = new C0158m();
        }
    }

    public static void m1084a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f494a.m1085a(popupWindow, view, i, i2, i3);
    }
}
