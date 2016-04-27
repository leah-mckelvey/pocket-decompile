package android.support.v7.p011a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.p002a.C0035a;
import android.support.v4.p002a.C0052p;
import android.support.v4.p002a.aq;
import android.support.v4.p002a.ay;
import android.support.v4.p002a.az;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.q */
public class C0188q extends C0052p implements az, C0172r {
    private C0189s f626n;

    public Intent m1237a() {
        return aq.m230a(this);
    }

    public C0212a m1238a(C0171b c0171b) {
        return null;
    }

    public void m1239a(ay ayVar) {
        ayVar.m258a((Activity) this);
    }

    public void m1240a(C0212a c0212a) {
    }

    public boolean m1241a(Intent intent) {
        return aq.m232a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m1249i().m1262b(view, layoutParams);
    }

    public void m1242b(Intent intent) {
        aq.m235b((Activity) this, intent);
    }

    public void m1243b(ay ayVar) {
    }

    public void m1244b(C0212a c0212a) {
    }

    public void m1245d() {
        m1249i().m1266e();
    }

    public C0169a m1246f() {
        return m1249i().m1253a();
    }

    public boolean m1247g() {
        Intent a = m1237a();
        if (a == null) {
            return false;
        }
        if (m1241a(a)) {
            ay a2 = ay.m257a((Context) this);
            m1239a(a2);
            m1243b(a2);
            a2.m261a();
            try {
                C0035a.m181a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m1242b(a);
        }
        return true;
    }

    public MenuInflater getMenuInflater() {
        return m1249i().m1260b();
    }

    @Deprecated
    public void m1248h() {
    }

    public C0189s m1249i() {
        if (this.f626n == null) {
            this.f626n = C0189s.m1250a((Activity) this, (C0172r) this);
        }
        return this.f626n;
    }

    public void invalidateOptionsMenu() {
        m1249i().m1266e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1249i().m1255a(configuration);
    }

    public void onContentChanged() {
        m1248h();
    }

    protected void onCreate(Bundle bundle) {
        m1249i().m1268g();
        super.onCreate(bundle);
        m1249i().m1256a(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        m1249i().m1267f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0169a f = m1246f();
        return (menuItem.getItemId() != 16908332 || f == null || (f.m1138a() & 4) == 0) ? false : m1247g();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m1249i().m1261b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        m1249i().m1265d();
    }

    protected void onStop() {
        super.onStop();
        m1249i().m1264c();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m1249i().m1259a(charSequence);
    }

    public void setContentView(int i) {
        m1249i().m1254a(i);
    }

    public void setContentView(View view) {
        m1249i().m1257a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m1249i().m1258a(view, layoutParams);
    }
}
