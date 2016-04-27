package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p001b.C0034a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ad extends C0240i implements SubMenu {
    private C0240i f851d;
    private C0248m f852e;

    public ad(Context context, C0240i c0240i, C0248m c0248m) {
        super(context);
        this.f851d = c0240i;
        this.f852e = c0248m;
    }

    public String m1603a() {
        int itemId = this.f852e != null ? this.f852e.getItemId() : 0;
        return itemId == 0 ? null : super.m1565a() + ":" + itemId;
    }

    public void m1604a(C0193j c0193j) {
        this.f851d.m1567a(c0193j);
    }

    boolean m1605a(C0240i c0240i, MenuItem menuItem) {
        return super.m1574a(c0240i, menuItem) || this.f851d.m1574a(c0240i, menuItem);
    }

    public boolean m1606b() {
        return this.f851d.m1582b();
    }

    public boolean m1607c() {
        return this.f851d.m1585c();
    }

    public boolean m1608c(C0248m c0248m) {
        return this.f851d.m1586c(c0248m);
    }

    public boolean m1609d(C0248m c0248m) {
        return this.f851d.m1588d(c0248m);
    }

    public MenuItem getItem() {
        return this.f852e;
    }

    public C0240i m1610p() {
        return this.f851d;
    }

    public Menu m1611s() {
        return this.f851d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m1561a(C0034a.m179a(m1589e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m1561a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m1563a(m1589e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m1563a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m1562a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f852e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f852e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f851d.setQwertyMode(z);
    }
}
