package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class ac {
    private static final ae f20a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f20a = new ag();
        } else {
            f20a = new af();
        }
    }

    static void m24a(ViewGroup viewGroup, View view, Rect rect) {
        f20a.m26a(viewGroup, view, rect);
    }

    static void m25b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m24a(viewGroup, view, rect);
    }
}
