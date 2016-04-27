package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p000h.bm;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0201c;
import android.support.v7.p013b.C0203e;
import android.support.v7.p013b.C0206h;
import android.support.v7.p013b.C0210l;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.internal.view.a */
public class C0224a {
    private Context f719a;

    private C0224a(Context context) {
        this.f719a = context;
    }

    public static C0224a m1450a(Context context) {
        return new C0224a(context);
    }

    public int m1451a() {
        return this.f719a.getResources().getInteger(C0206h.abc_max_action_buttons);
    }

    public boolean m1452b() {
        return VERSION.SDK_INT >= 19 || !bm.m850a(ViewConfiguration.get(this.f719a));
    }

    public int m1453c() {
        return this.f719a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m1454d() {
        return this.f719a.getApplicationInfo().targetSdkVersion >= 16 ? this.f719a.getResources().getBoolean(C0201c.abc_action_bar_embed_tabs) : this.f719a.getResources().getBoolean(C0201c.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m1455e() {
        TypedArray obtainStyledAttributes = this.f719a.obtainStyledAttributes(null, C0210l.ActionBar, C0200b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0210l.ActionBar_height, 0);
        Resources resources = this.f719a.getResources();
        if (!m1454d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0203e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m1456f() {
        return this.f719a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m1457g() {
        return this.f719a.getResources().getDimensionPixelSize(C0203e.abc_action_bar_stacked_tab_max_width);
    }
}
