package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ba implements OnItemClickListener {
    final /* synthetic */ au f1193a;
    final /* synthetic */ az f1194b;

    ba(az azVar, au auVar) {
        this.f1194b = azVar;
        this.f1193a = auVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1194b.f1187a.setSelection(i);
        if (this.f1194b.f1187a.s != null) {
            this.f1194b.f1187a.m1900a(view, i, this.f1194b.f1189d.getItemId(i));
        }
        this.f1194b.m1944a();
    }
}
