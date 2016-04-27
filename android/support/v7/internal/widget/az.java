package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.widget.ab;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;

class az extends ab implements bd {
    final /* synthetic */ au f1187a;
    private CharSequence f1188c;
    private ListAdapter f1189d;

    public az(au auVar, Context context, AttributeSet attributeSet, int i) {
        this.f1187a = auVar;
        super(context, attributeSet, i);
        m1947a((View) auVar);
        m1951a(true);
        m1945a(0);
        m1948a(new ba(this, auVar));
    }

    public void m1963a(ListAdapter listAdapter) {
        super.m1949a(listAdapter);
        this.f1189d = listAdapter;
    }

    public void m1964a(CharSequence charSequence) {
        this.f1188c = charSequence;
    }
}
