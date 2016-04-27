package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.C0237a;
import android.view.View;
import android.view.View.OnClickListener;

class bm implements OnClickListener {
    final C0237a f1248a;
    final /* synthetic */ bl f1249b;

    bm(bl blVar) {
        this.f1249b = blVar;
        this.f1248a = new C0237a(this.f1249b.f1230a.getContext(), 0, 16908332, 0, 0, this.f1249b.f1238i);
    }

    public void onClick(View view) {
        if (this.f1249b.f1241l != null && this.f1249b.f1242m) {
            this.f1249b.f1241l.onMenuItemSelected(0, this.f1248a);
        }
    }
}
