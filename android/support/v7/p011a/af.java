package android.support.v7.p011a;

import android.content.Context;
import android.support.v7.internal.widget.bi;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.a.af */
class af extends FrameLayout {
    final /* synthetic */ C0194y f507a;

    public af(C0194y c0194y, Context context) {
        this.f507a = c0194y;
        super(context);
    }

    private boolean m1167a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f507a.m1332a(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m1167a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f507a.m1310c(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(bi.m1978a(getContext(), i));
    }
}
