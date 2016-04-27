package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

/* renamed from: android.support.v7.internal.view.menu.s */
class C0254s extends C0238f implements OnMenuItemClickListener {
    final /* synthetic */ C0250o f921a;

    C0254s(C0250o c0250o, OnMenuItemClickListener onMenuItemClickListener) {
        this.f921a = c0250o;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f921a.m1545a(menuItem));
    }
}
