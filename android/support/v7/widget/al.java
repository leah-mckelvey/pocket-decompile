package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class al implements OnScrollListener {
    final /* synthetic */ ab f1423a;

    private al(ab abVar) {
        this.f1423a = abVar;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f1423a.m1960f() && this.f1423a.f1164d.getContentView() != null) {
            this.f1423a.f1158A.removeCallbacks(this.f1423a.f1182v);
            this.f1423a.f1182v.run();
        }
    }
}
