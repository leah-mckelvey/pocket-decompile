package android.support.design.widget;

import android.support.v4.widget.ae;
import android.support.v4.widget.ah;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.design.widget.y */
public class C0027y extends C0010c {
    private ae f69a;
    private aa f70b;
    private boolean f71c;
    private float f72d;
    private boolean f73e;
    private int f74f;
    private float f75g;
    private float f76h;
    private float f77i;
    private final ah f78j;

    public C0027y() {
        this.f72d = 0.0f;
        this.f74f = 2;
        this.f75g = 0.5f;
        this.f76h = 0.0f;
        this.f77i = 0.5f;
        this.f78j = new C0033z(this);
    }

    static float m119a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void m122a(ViewGroup viewGroup) {
        if (this.f69a == null) {
            this.f69a = this.f73e ? ae.m1026a(viewGroup, this.f72d, this.f78j) : ae.m1027a(viewGroup, this.f78j);
        }
    }

    private static int m124b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float m126c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public int m131a() {
        return this.f69a != null ? this.f69a.m1042a() : 0;
    }

    public void m132a(float f) {
        this.f76h = C0027y.m126c(0.0f, f, 1.0f);
    }

    public void m133a(int i) {
        this.f74f = i;
    }

    public void m134a(aa aaVar) {
        this.f70b = aaVar;
    }

    public boolean m135a(C0009b c0009b, View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case C0339o.View_android_theme /*0*/:
                this.f71c = !c0009b.m54a(view, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingEnd /*3*/:
                if (this.f71c) {
                    this.f71c = false;
                    return false;
                }
                break;
        }
        if (this.f71c) {
            return false;
        }
        m122a((ViewGroup) c0009b);
        return this.f69a.m1046a(motionEvent);
    }

    public void m136b(float f) {
        this.f77i = C0027y.m126c(0.0f, f, 1.0f);
    }

    public boolean m137b(C0009b c0009b, View view, MotionEvent motionEvent) {
        if (this.f69a == null) {
            return false;
        }
        this.f69a.m1050b(motionEvent);
        return true;
    }
}
