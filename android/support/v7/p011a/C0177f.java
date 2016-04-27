package android.support.v7.p011a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.a.f */
class C0177f implements OnClickListener {
    final /* synthetic */ C0176e f570a;

    C0177f(C0176e c0176e) {
        this.f570a = c0176e;
    }

    public void onClick(View view) {
        Message obtain = (view != this.f570a.f557n || this.f570a.f559p == null) ? (view != this.f570a.f560q || this.f570a.f562s == null) ? (view != this.f570a.f563t || this.f570a.f565v == null) ? null : Message.obtain(this.f570a.f565v) : Message.obtain(this.f570a.f562s) : Message.obtain(this.f570a.f559p);
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.f570a.f542M.obtainMessage(1, this.f570a.f545b).sendToTarget();
    }
}
