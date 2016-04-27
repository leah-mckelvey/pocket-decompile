package android.support.v4.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.widget.h */
class C0153h extends DataSetObserver {
    final /* synthetic */ C0150e f491a;

    private C0153h(C0150e c0150e) {
        this.f491a = c0150e;
    }

    public void onChanged() {
        this.f491a.f481a = true;
        this.f491a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f491a.f481a = false;
        this.f491a.notifyDataSetInvalidated();
    }
}
