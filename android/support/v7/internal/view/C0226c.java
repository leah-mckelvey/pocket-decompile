package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.internal.view.c */
public class C0226c extends C0212a implements C0193j {
    private Context f723a;
    private ActionBarContextView f724b;
    private C0171b f725c;
    private WeakReference f726d;
    private boolean f727e;
    private boolean f728f;
    private C0240i f729g;

    public C0226c(Context context, ActionBarContextView actionBarContextView, C0171b c0171b, boolean z) {
        this.f723a = context;
        this.f724b = actionBarContextView;
        this.f725c = c0171b;
        this.f729g = new C0240i(actionBarContextView.getContext()).m1560a(1);
        this.f729g.m1567a((C0193j) this);
        this.f728f = z;
    }

    public MenuInflater m1461a() {
        return new MenuInflater(this.f724b.getContext());
    }

    public void m1462a(int i) {
        m1470b(this.f723a.getString(i));
    }

    public void m1463a(C0240i c0240i) {
        m1472d();
        this.f724b.m1752a();
    }

    public void m1464a(View view) {
        this.f724b.setCustomView(view);
        this.f726d = view != null ? new WeakReference(view) : null;
    }

    public void m1465a(CharSequence charSequence) {
        this.f724b.setSubtitle(charSequence);
    }

    public void m1466a(boolean z) {
        super.m1359a(z);
        this.f724b.setTitleOptional(z);
    }

    public boolean m1467a(C0240i c0240i, MenuItem menuItem) {
        return this.f725c.m1161a((C0212a) this, menuItem);
    }

    public Menu m1468b() {
        return this.f729g;
    }

    public void m1469b(int i) {
        m1465a(this.f723a.getString(i));
    }

    public void m1470b(CharSequence charSequence) {
        this.f724b.setTitle(charSequence);
    }

    public void m1471c() {
        if (!this.f727e) {
            this.f727e = true;
            this.f724b.sendAccessibilityEvent(32);
            this.f725c.m1159a(this);
        }
    }

    public void m1472d() {
        this.f725c.m1162b(this, this.f729g);
    }

    public CharSequence m1473f() {
        return this.f724b.getTitle();
    }

    public CharSequence m1474g() {
        return this.f724b.getSubtitle();
    }

    public boolean m1475h() {
        return this.f724b.m1757d();
    }

    public View m1476i() {
        return this.f726d != null ? (View) this.f726d.get() : null;
    }
}
