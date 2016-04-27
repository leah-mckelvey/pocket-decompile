package android.support.v7.p011a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.a.j */
class C0181j implements OnItemClickListener {
    final /* synthetic */ C0176e f617a;
    final /* synthetic */ C0178g f618b;

    C0181j(C0178g c0178g, C0176e c0176e) {
        this.f618b = c0178g;
        this.f617a = c0176e;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f618b.f604u.onClick(this.f617a.f545b, i);
        if (!this.f618b.f575E) {
            this.f617a.f545b.dismiss();
        }
    }
}
