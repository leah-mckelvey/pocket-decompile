package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: android.support.design.widget.u */
class C0029u {
    private static C0029u f80a;
    private final Object f81b;
    private final Handler f82c;
    private C0032x f83d;
    private C0032x f84e;

    private C0029u() {
        this.f81b = new Object();
        this.f82c = new Handler(Looper.getMainLooper(), new C0030v(this));
    }

    static C0029u m140a() {
        if (f80a == null) {
            f80a = new C0029u();
        }
        return f80a;
    }

    private boolean m142a(C0032x c0032x) {
        C0031w c0031w = (C0031w) c0032x.f86a.get();
        if (c0031w == null) {
            return false;
        }
        c0031w.m154b();
        return true;
    }

    private void m143b() {
        if (this.f84e != null) {
            this.f83d = this.f84e;
            this.f84e = null;
            C0031w c0031w = (C0031w) this.f83d.f86a.get();
            if (c0031w != null) {
                c0031w.m153a();
            } else {
                this.f83d = null;
            }
        }
    }

    private void m144b(C0032x c0032x) {
        this.f82c.removeCallbacksAndMessages(c0032x);
        this.f82c.sendMessageDelayed(Message.obtain(this.f82c, 0, c0032x), c0032x.f87b == 0 ? 2750 : 1500);
    }

    private void m145c(C0032x c0032x) {
        synchronized (this.f81b) {
            if (this.f83d == c0032x || this.f84e == c0032x) {
                m142a(c0032x);
            }
        }
    }

    private boolean m146f(C0031w c0031w) {
        return this.f83d != null && this.f83d.m157a(c0031w);
    }

    private boolean m147g(C0031w c0031w) {
        return this.f84e != null && this.f84e.m157a(c0031w);
    }

    public void m148a(C0031w c0031w) {
        synchronized (this.f81b) {
            if (m146f(c0031w)) {
                m142a(this.f83d);
            }
            if (m147g(c0031w)) {
                m142a(this.f84e);
            }
        }
    }

    public void m149b(C0031w c0031w) {
        synchronized (this.f81b) {
            if (m146f(c0031w)) {
                this.f83d = null;
                if (this.f84e != null) {
                    m143b();
                }
            }
        }
    }

    public void m150c(C0031w c0031w) {
        synchronized (this.f81b) {
            if (m146f(c0031w)) {
                m144b(this.f83d);
            }
        }
    }

    public void m151d(C0031w c0031w) {
        synchronized (this.f81b) {
            if (m146f(c0031w)) {
                this.f82c.removeCallbacksAndMessages(this.f83d);
            }
        }
    }

    public void m152e(C0031w c0031w) {
        synchronized (this.f81b) {
            if (m146f(c0031w)) {
                m144b(this.f83d);
            }
        }
    }
}
