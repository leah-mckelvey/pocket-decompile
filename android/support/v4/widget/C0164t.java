package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.t */
class C0164t implements C0163s {
    C0164t() {
    }

    public int m1110a(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public Object m1111a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public void m1112a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void m1113a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int m1114b(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public boolean m1115c(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void m1116d(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int m1117e(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int m1118f(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
