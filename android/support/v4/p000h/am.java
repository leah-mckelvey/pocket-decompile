package android.support.v4.p000h;

import android.view.MotionEvent;

/* renamed from: android.support.v4.h.am */
class am {
    public static int m662a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m663a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m664b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m665c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m666d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
