package android.support.v7.p012d;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* renamed from: android.support.v7.d.a */
public abstract class C0212a {
    private Object f670a;
    private boolean f671b;

    public abstract MenuInflater m1354a();

    public abstract void m1355a(int i);

    public abstract void m1356a(View view);

    public abstract void m1357a(CharSequence charSequence);

    public void m1358a(Object obj) {
        this.f670a = obj;
    }

    public void m1359a(boolean z) {
        this.f671b = z;
    }

    public abstract Menu m1360b();

    public abstract void m1361b(int i);

    public abstract void m1362b(CharSequence charSequence);

    public abstract void m1363c();

    public abstract void m1364d();

    public abstract CharSequence m1365f();

    public abstract CharSequence m1366g();

    public boolean m1367h() {
        return false;
    }

    public abstract View m1368i();

    public Object m1369j() {
        return this.f670a;
    }

    public boolean m1370k() {
        return this.f671b;
    }
}
