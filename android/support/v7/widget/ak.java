package android.support.v7.widget;

import android.database.DataSetObserver;

class ak extends DataSetObserver {
    final /* synthetic */ ab f1422a;

    private ak(ab abVar) {
        this.f1422a = abVar;
    }

    public void onChanged() {
        if (this.f1422a.m1953b()) {
            this.f1422a.m1954c();
        }
    }

    public void onInvalidated() {
        this.f1422a.m1944a();
    }
}
