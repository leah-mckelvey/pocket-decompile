package android.support.v4.p000h;

import android.view.MotionEvent;

/* renamed from: android.support.v4.h.ah */
class ah implements al {
    ah() {
    }

    public int m652a(MotionEvent motionEvent) {
        return 1;
    }

    public int m653a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int m654b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m655c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m656d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
