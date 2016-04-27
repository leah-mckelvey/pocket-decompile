package android.support.v7.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.pocket.doorway.C0339o;

public abstract class ag implements OnTouchListener {
    private final float f853a;
    private final int f854b;
    private final int f855c;
    private final View f856d;
    private Runnable f857e;
    private Runnable f858f;
    private boolean f859g;
    private boolean f860h;
    private int f861i;
    private final int[] f862j;

    public ag(View view) {
        this.f862j = new int[2];
        this.f856d = view;
        this.f853a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f854b = ViewConfiguration.getTapTimeout();
        this.f855c = (this.f854b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean m1614a(MotionEvent motionEvent) {
        View view = this.f856d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (android.support.v4.p000h.ag.m640a(motionEvent)) {
            case C0339o.View_android_theme /*0*/:
                this.f861i = motionEvent.getPointerId(0);
                this.f860h = false;
                if (this.f857e == null) {
                    this.f857e = new ah();
                }
                view.postDelayed(this.f857e, (long) this.f854b);
                if (this.f858f == null) {
                    this.f858f = new ai();
                }
                view.postDelayed(this.f858f, (long) this.f855c);
                return false;
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingEnd /*3*/:
                m1620d();
                return false;
            case C0339o.View_paddingStart /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.f861i);
                if (findPointerIndex < 0 || m1615a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f853a)) {
                    return false;
                }
                m1620d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean m1615a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m1616a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f862j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m1618b(MotionEvent motionEvent) {
        boolean z = true;
        View view = this.f856d;
        ab a = m1622a();
        if (a == null || !a.m1953b()) {
            return false;
        }
        View a2 = a.f1166f;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1619b(view, obtainNoHistory);
        m1616a(a2, obtainNoHistory);
        boolean a3 = a2.m2242a(obtainNoHistory, this.f861i);
        obtainNoHistory.recycle();
        int a4 = android.support.v4.p000h.ag.m640a(motionEvent);
        boolean z2 = (a4 == 1 || a4 == 3) ? false : true;
        if (!(a3 && z2)) {
            z = false;
        }
        return z;
    }

    private boolean m1619b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f862j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void m1620d() {
        if (this.f858f != null) {
            this.f856d.removeCallbacks(this.f858f);
        }
        if (this.f857e != null) {
            this.f856d.removeCallbacks(this.f857e);
        }
    }

    private void m1621e() {
        m1620d();
        View view = this.f856d;
        if (view.isEnabled() && !view.isLongClickable() && m1623b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f859g = true;
            this.f860h = true;
        }
    }

    public abstract ab m1622a();

    protected boolean m1623b() {
        ab a = m1622a();
        if (!(a == null || a.m1953b())) {
            a.m1954c();
        }
        return true;
    }

    protected boolean m1624c() {
        ab a = m1622a();
        if (a != null && a.m1953b()) {
            a.m1944a();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean b;
        boolean z = this.f859g;
        if (z) {
            b = this.f860h ? m1618b(motionEvent) : m1618b(motionEvent) || !m1624c();
        } else {
            boolean z2 = m1614a(motionEvent) && m1623b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f856d.onTouchEvent(obtain);
                obtain.recycle();
            }
            b = z2;
        }
        this.f859g = b;
        return b || z;
    }
}
