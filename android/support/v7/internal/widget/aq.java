package android.support.v7.internal.widget;

import android.view.View;

class aq implements Runnable {
    final /* synthetic */ View f1094a;
    final /* synthetic */ ap f1095b;

    aq(ap apVar, View view) {
        this.f1095b = apVar;
        this.f1094a = view;
    }

    public void run() {
        this.f1095b.smoothScrollTo(this.f1094a.getLeft() - ((this.f1095b.getWidth() - this.f1094a.getWidth()) / 2), 0);
        this.f1095b.f1085a = null;
    }
}
