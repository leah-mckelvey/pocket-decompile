package android.support.v7.internal.p016a;

import android.content.Context;
import android.support.v7.internal.view.C0229f;
import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.internal.a.f */
public class C0220f extends C0212a implements C0193j {
    final /* synthetic */ C0216b f713a;
    private final Context f714b;
    private final C0240i f715c;
    private C0171b f716d;
    private WeakReference f717e;

    public C0220f(C0216b c0216b, Context context, C0171b c0171b) {
        this.f713a = c0216b;
        this.f714b = context;
        this.f716d = c0171b;
        this.f715c = new C0240i(context).m1560a(1);
        this.f715c.m1567a((C0193j) this);
    }

    public MenuInflater m1431a() {
        return new C0229f(this.f714b);
    }

    public void m1432a(int i) {
        m1440b(this.f713a.f693j.getResources().getString(i));
    }

    public void m1433a(C0240i c0240i) {
        if (this.f716d != null) {
            m1442d();
            this.f713a.f700q.m1752a();
        }
    }

    public void m1434a(View view) {
        this.f713a.f700q.setCustomView(view);
        this.f717e = new WeakReference(view);
    }

    public void m1435a(CharSequence charSequence) {
        this.f713a.f700q.setSubtitle(charSequence);
    }

    public void m1436a(boolean z) {
        super.m1359a(z);
        this.f713a.f700q.setTitleOptional(z);
    }

    public boolean m1437a(C0240i c0240i, MenuItem menuItem) {
        return this.f716d != null ? this.f716d.m1161a((C0212a) this, menuItem) : false;
    }

    public Menu m1438b() {
        return this.f715c;
    }

    public void m1439b(int i) {
        m1435a(this.f713a.f693j.getResources().getString(i));
    }

    public void m1440b(CharSequence charSequence) {
        this.f713a.f700q.setTitle(charSequence);
    }

    public void m1441c() {
        if (this.f713a.f686a == this) {
            if (C0216b.m1389b(this.f713a.f680D, this.f713a.f681E, false)) {
                this.f716d.m1159a(this);
            } else {
                this.f713a.f687b = this;
                this.f713a.f688c = this.f716d;
            }
            this.f716d = null;
            this.f713a.m1427j(false);
            this.f713a.f700q.m1753b();
            this.f713a.f699p.m1838a().sendAccessibilityEvent(32);
            this.f713a.f697n.setHideOnContentScrollEnabled(this.f713a.f689d);
            this.f713a.f686a = null;
        }
    }

    public void m1442d() {
        if (this.f713a.f686a == this) {
            this.f715c.m1591g();
            try {
                this.f716d.m1162b(this, this.f715c);
            } finally {
                this.f715c.m1592h();
            }
        }
    }

    public boolean m1443e() {
        this.f715c.m1591g();
        try {
            boolean a = this.f716d.m1160a((C0212a) this, this.f715c);
            return a;
        } finally {
            this.f715c.m1592h();
        }
    }

    public CharSequence m1444f() {
        return this.f713a.f700q.getTitle();
    }

    public CharSequence m1445g() {
        return this.f713a.f700q.getSubtitle();
    }

    public boolean m1446h() {
        return this.f713a.f700q.m1757d();
    }

    public View m1447i() {
        return this.f717e != null ? (View) this.f717e.get() : null;
    }
}
