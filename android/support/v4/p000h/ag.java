package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.h.ag */
public class ag {
    static final al f391a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f391a = new ak();
        } else if (VERSION.SDK_INT >= 9) {
            f391a = new aj();
        } else if (VERSION.SDK_INT >= 5) {
            f391a = new ai();
        } else {
            f391a = new ah();
        }
    }

    public static int m640a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m641a(MotionEvent motionEvent, int i) {
        return f391a.m648a(motionEvent, i);
    }

    public static int m642b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m643b(MotionEvent motionEvent, int i) {
        return f391a.m649b(motionEvent, i);
    }

    public static float m644c(MotionEvent motionEvent, int i) {
        return f391a.m650c(motionEvent, i);
    }

    public static int m645c(MotionEvent motionEvent) {
        return f391a.m647a(motionEvent);
    }

    public static float m646d(MotionEvent motionEvent, int i) {
        return f391a.m651d(motionEvent, i);
    }
}
