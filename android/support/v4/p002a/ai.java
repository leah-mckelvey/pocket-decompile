package android.support.v4.p002a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* renamed from: android.support.v4.a.ai */
final class ai extends EpicenterCallback {
    final /* synthetic */ ak f112a;
    private Rect f113b;

    ai(ak akVar) {
        this.f112a = akVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f113b == null && this.f112a.f125a != null) {
            this.f113b = af.m206c(this.f112a.f125a);
        }
        return this.f113b;
    }
}
