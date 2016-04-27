package android.support.v4.p002a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* renamed from: android.support.v4.a.ag */
final class ag extends EpicenterCallback {
    final /* synthetic */ Rect f104a;

    ag(Rect rect) {
        this.f104a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f104a;
    }
}
