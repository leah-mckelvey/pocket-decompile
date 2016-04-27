package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.p000h.au;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.d */
public abstract class C0244d implements C0243x {
    protected Context f864a;
    protected Context f865b;
    protected C0240i f866c;
    protected LayoutInflater f867d;
    protected LayoutInflater f868e;
    protected C0007z f869f;
    private C0170y f870g;
    private int f871h;
    private int f872i;
    private int f873j;

    public C0244d(Context context, int i, int i2) {
        this.f864a = context;
        this.f867d = LayoutInflater.from(context);
        this.f871h = i;
        this.f872i = i2;
    }

    public C0170y m1636a() {
        return this.f870g;
    }

    public C0007z m1637a(ViewGroup viewGroup) {
        if (this.f869f == null) {
            this.f869f = (C0007z) this.f867d.inflate(this.f871h, viewGroup, false);
            this.f869f.m5a(this.f866c);
            m1650b(true);
        }
        return this.f869f;
    }

    public View m1638a(C0248m c0248m, View view, ViewGroup viewGroup) {
        aa b = view instanceof aa ? (aa) view : m1649b(viewGroup);
        m1642a(c0248m, b);
        return (View) b;
    }

    public void m1639a(int i) {
        this.f873j = i;
    }

    public void m1640a(Context context, C0240i c0240i) {
        this.f865b = context;
        this.f868e = LayoutInflater.from(this.f865b);
        this.f866c = c0240i;
    }

    public void m1641a(C0240i c0240i, boolean z) {
        if (this.f870g != null) {
            this.f870g.m1155a(c0240i, z);
        }
    }

    public abstract void m1642a(C0248m c0248m, aa aaVar);

    public void m1643a(C0170y c0170y) {
        this.f870g = c0170y;
    }

    protected void m1644a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f869f).addView(view, i);
    }

    public boolean m1645a(int i, C0248m c0248m) {
        return true;
    }

    public boolean m1646a(ad adVar) {
        return this.f870g != null ? this.f870g.m1156a(adVar) : false;
    }

    public boolean m1647a(C0240i c0240i, C0248m c0248m) {
        return false;
    }

    protected boolean m1648a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public aa m1649b(ViewGroup viewGroup) {
        return (aa) this.f867d.inflate(this.f872i, viewGroup, false);
    }

    public void m1650b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f869f;
        if (viewGroup != null) {
            int i;
            if (this.f866c != null) {
                this.f866c.m1594j();
                ArrayList i2 = this.f866c.m1593i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0248m c0248m = (C0248m) i2.get(i3);
                    if (m1645a(i, c0248m)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0248m itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View a = m1638a(c0248m, childAt, viewGroup);
                        if (c0248m != itemData) {
                            a.setPressed(false);
                            au.m707k(a);
                        }
                        if (a != childAt) {
                            m1644a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!m1648a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean m1651b() {
        return false;
    }

    public boolean m1652b(C0240i c0240i, C0248m c0248m) {
        return false;
    }
}
