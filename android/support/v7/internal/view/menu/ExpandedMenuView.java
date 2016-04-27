package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0236k, C0007z, OnItemClickListener {
    private static final int[] f791a;
    private C0240i f792b;
    private int f793c;

    static {
        f791a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bk a = bk.m2000a(context, attributeSet, f791a, i, 0);
        if (a.m2015e(0)) {
            setBackgroundDrawable(a.m2004a(0));
        }
        if (a.m2015e(1)) {
            setDivider(a.m2004a(1));
        }
        a.m2008b();
    }

    public void m1528a(C0240i c0240i) {
        this.f792b = c0240i;
    }

    public boolean m1529a(C0248m c0248m) {
        return this.f792b.m1575a((MenuItem) c0248m, 0);
    }

    public int getWindowAnimations() {
        return this.f793c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m1529a((C0248m) getAdapter().getItem(i));
    }
}
