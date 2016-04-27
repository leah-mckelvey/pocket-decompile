package android.support.v7.p011a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.a.h */
class C0179h extends ArrayAdapter {
    final /* synthetic */ ListView f610a;
    final /* synthetic */ C0178g f611b;

    C0179h(C0178g c0178g, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.f611b = c0178g;
        this.f610a = listView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f611b.f573C != null && this.f611b.f573C[i]) {
            this.f610a.setItemChecked(i, true);
        }
        return view2;
    }
}
