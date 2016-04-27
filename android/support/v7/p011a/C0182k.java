package android.support.v7.p011a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/* renamed from: android.support.v7.a.k */
class C0182k implements OnItemClickListener {
    final /* synthetic */ ListView f619a;
    final /* synthetic */ C0176e f620b;
    final /* synthetic */ C0178g f621c;

    C0182k(C0178g c0178g, ListView listView, C0176e c0176e) {
        this.f621c = c0178g;
        this.f619a = listView;
        this.f620b = c0176e;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f621c.f573C != null) {
            this.f621c.f573C[i] = this.f619a.isItemChecked(i);
        }
        this.f621c.f577G.onClick(this.f620b.f545b, i, this.f619a.isItemChecked(i));
    }
}
