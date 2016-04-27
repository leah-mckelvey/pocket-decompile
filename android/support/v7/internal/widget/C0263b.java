package android.support.v7.internal.widget;

import android.support.v4.p000h.bt;
import android.support.v4.p000h.ck;
import android.view.View;

/* renamed from: android.support.v7.internal.widget.b */
public class C0263b implements ck {
    int f1190a;
    final /* synthetic */ C0259a f1191b;
    private boolean f1192c;

    protected C0263b(C0259a c0259a) {
        this.f1191b = c0259a;
        this.f1192c = false;
    }

    public C0263b m1965a(bt btVar, int i) {
        this.f1191b.f964i = btVar;
        this.f1190a = i;
        return this;
    }

    public void m1966a(View view) {
        this.f1191b.setVisibility(0);
        this.f1192c = false;
    }

    public void m1967b(View view) {
        if (!this.f1192c) {
            this.f1191b.f964i = null;
            this.f1191b.setVisibility(this.f1190a);
            if (this.f1191b.f960e != null && this.f1191b.f958c != null) {
                this.f1191b.f958c.setVisibility(this.f1190a);
            }
        }
    }

    public void m1968c(View view) {
        this.f1192c = true;
    }
}
