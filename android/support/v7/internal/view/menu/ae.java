package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p005d.p006a.C0093c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class ae extends ac implements SubMenu {
    ae(Context context, C0093c c0093c) {
        super(context, c0093c);
    }

    public C0093c m1612b() {
        return (C0093c) this.b;
    }

    public void clearHeader() {
        m1612b().clearHeader();
    }

    public MenuItem getItem() {
        return m1545a(m1612b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m1612b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m1612b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m1612b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m1612b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m1612b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m1612b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m1612b().setIcon(drawable);
        return this;
    }
}
