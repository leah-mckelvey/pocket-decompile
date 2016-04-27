package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class aw implements OnGlobalLayoutListener {
    final /* synthetic */ au f1150a;

    aw(au auVar) {
        this.f1150a = auVar;
    }

    public void onGlobalLayout() {
        if (!this.f1150a.f1142G.m1930b()) {
            this.f1150a.f1142G.m1931c();
        }
        ViewTreeObserver viewTreeObserver = this.f1150a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }
}
