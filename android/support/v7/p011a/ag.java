package android.support.v7.p011a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.internal.view.C0225b;
import android.support.v7.internal.view.menu.C0007z;
import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0245g;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0207i;
import android.support.v7.p013b.C0209k;
import android.support.v7.p013b.C0210l;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.a.ag */
final class ag {
    int f508a;
    int f509b;
    int f510c;
    int f511d;
    int f512e;
    int f513f;
    ViewGroup f514g;
    View f515h;
    View f516i;
    C0240i f517j;
    C0245g f518k;
    Context f519l;
    boolean f520m;
    boolean f521n;
    boolean f522o;
    public boolean f523p;
    boolean f524q;
    boolean f525r;
    Bundle f526s;

    ag(int i) {
        this.f508a = i;
        this.f524q = false;
    }

    C0007z m1168a(C0170y c0170y) {
        if (this.f517j == null) {
            return null;
        }
        if (this.f518k == null) {
            this.f518k = new C0245g(this.f519l, C0207i.abc_list_menu_item_layout);
            this.f518k.m1658a(c0170y);
            this.f517j.m1569a(this.f518k);
        }
        return this.f518k.m1654a(this.f514g);
    }

    void m1169a(Context context) {
        TypedValue typedValue = new TypedValue();
        Theme newTheme = context.getResources().newTheme();
        newTheme.setTo(context.getTheme());
        newTheme.resolveAttribute(C0200b.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        }
        newTheme.resolveAttribute(C0200b.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        } else {
            newTheme.applyStyle(C0209k.Theme_AppCompat_CompactMenu, true);
        }
        Context c0225b = new C0225b(context, 0);
        c0225b.getTheme().setTo(newTheme);
        this.f519l = c0225b;
        TypedArray obtainStyledAttributes = c0225b.obtainStyledAttributes(C0210l.Theme);
        this.f509b = obtainStyledAttributes.getResourceId(C0210l.Theme_panelBackground, 0);
        this.f513f = obtainStyledAttributes.getResourceId(C0210l.Theme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }

    void m1170a(C0240i c0240i) {
        if (c0240i != this.f517j) {
            if (this.f517j != null) {
                this.f517j.m1580b(this.f518k);
            }
            this.f517j = c0240i;
            if (c0240i != null && this.f518k != null) {
                c0240i.m1569a(this.f518k);
            }
        }
    }

    public boolean m1171a() {
        return this.f515h == null ? false : this.f516i != null || this.f518k.m1655a().getCount() > 0;
    }
}
