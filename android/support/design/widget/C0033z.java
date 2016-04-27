package android.support.design.widget;

import android.support.v4.p000h.au;
import android.support.v4.widget.ah;
import android.view.View;

/* renamed from: android.support.design.widget.z */
class C0033z extends ah {
    final /* synthetic */ C0027y f88a;
    private int f89b;

    C0033z(C0027y c0027y) {
        this.f88a = c0027y;
    }

    private boolean m171a(View view, float f) {
        if (f != 0.0f) {
            boolean z = au.m683a(view) == 1;
            return this.f88a.f74f == 2 ? true : this.f88a.f74f == 0 ? z ? f < 0.0f : f > 0.0f : this.f88a.f74f == 1 ? z ? f > 0.0f : f < 0.0f : false;
        } else {
            return Math.abs(view.getLeft() - this.f89b) >= Math.round(((float) view.getWidth()) * this.f88a.f75g);
        }
    }

    public int m172a(View view) {
        return view.getWidth();
    }

    public int m173a(View view, int i, int i2) {
        int width;
        int i3;
        Object obj = au.m683a(view) == 1 ? 1 : null;
        if (this.f88a.f74f == 0) {
            if (obj != null) {
                width = this.f89b - view.getWidth();
                i3 = this.f89b;
            } else {
                width = this.f89b;
                i3 = this.f89b + view.getWidth();
            }
        } else if (this.f88a.f74f != 1) {
            width = this.f89b - view.getWidth();
            i3 = this.f89b + view.getWidth();
        } else if (obj != null) {
            width = this.f89b;
            i3 = this.f89b + view.getWidth();
        } else {
            width = this.f89b - view.getWidth();
            i3 = this.f89b;
        }
        return C0027y.m124b(width, i, i3);
    }

    public void m174a(int i) {
        if (this.f88a.f70b != null) {
            this.f88a.f70b.m22a(i);
        }
    }

    public void m175a(View view, float f, float f2) {
        int width = view.getWidth();
        boolean z = false;
        if (m171a(view, f)) {
            width = view.getLeft() < this.f89b ? this.f89b - width : this.f89b + width;
            z = true;
        } else {
            width = this.f89b;
        }
        if (this.f88a.f69a.m1045a(width, view.getTop())) {
            au.m689a(view, new ab(this.f88a, view, z));
        } else if (z && this.f88a.f70b != null) {
            this.f88a.f70b.m23a(view);
        }
    }

    public void m176a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) view.getWidth()) * this.f88a.f76h;
        float width2 = ((float) view.getWidth()) * this.f88a.f77i;
        if (((float) i) <= width) {
            au.m697c(view, 1.0f);
        } else if (((float) i) >= width2) {
            au.m697c(view, 0.0f);
        } else {
            au.m697c(view, C0027y.m126c(0.0f, 1.0f - C0027y.m119a(width, width2, (float) i), 1.0f));
        }
    }

    public boolean m177a(View view, int i) {
        this.f89b = view.getLeft();
        return true;
    }

    public int m178b(View view, int i, int i2) {
        return view.getTop();
    }
}
