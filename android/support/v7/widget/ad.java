package android.support.v7.widget;

import android.view.View;

class ad implements Runnable {
    final /* synthetic */ ab f1412a;

    ad(ab abVar) {
        this.f1412a = abVar;
    }

    public void run() {
        View d = this.f1412a.m1956d();
        if (d != null && d.getWindowToken() != null) {
            this.f1412a.m1954c();
        }
    }
}
