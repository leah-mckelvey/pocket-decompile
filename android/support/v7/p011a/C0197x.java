package android.support.v7.p011a;

import android.support.v7.internal.view.C0227d;
import android.support.v7.internal.view.C0228e;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.ActionMode;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.x */
class C0197x extends C0192u {
    final /* synthetic */ C0196w f667b;

    C0197x(C0196w c0196w, Callback callback) {
        this.f667b = c0196w;
        super(c0196w, callback);
    }

    final ActionMode m1352a(ActionMode.Callback callback) {
        Object c0228e = new C0228e(this.f667b.a, callback);
        C0212a b = this.f667b.m1333b((C0171b) c0228e);
        if (b == null) {
            return null;
        }
        C0227d c0227d = new C0227d(this.f667b.a, b);
        c0228e.m1480a(c0227d);
        return c0227d;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f667b.f666n ? m1352a(callback) : super.onWindowStartingActionMode(callback);
    }
}
