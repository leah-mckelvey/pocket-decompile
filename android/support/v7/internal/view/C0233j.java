package android.support.v7.internal.view;

import android.support.v4.p000h.cl;
import android.view.View;

/* renamed from: android.support.v7.internal.view.j */
class C0233j extends cl {
    final /* synthetic */ C0232i f777a;
    private boolean f778b;
    private int f779c;

    C0233j(C0232i c0232i) {
        this.f777a = c0232i;
        this.f778b = false;
        this.f779c = 0;
    }

    void m1513a() {
        this.f779c = 0;
        this.f778b = false;
        this.f777a.m1506c();
    }

    public void m1514a(View view) {
        if (!this.f778b) {
            this.f778b = true;
            if (this.f777a.f774d != null) {
                this.f777a.f774d.m109a(null);
            }
        }
    }

    public void m1515b(View view) {
        int i = this.f779c + 1;
        this.f779c = i;
        if (i == this.f777a.f771a.size()) {
            if (this.f777a.f774d != null) {
                this.f777a.f774d.m110b(null);
            }
            m1513a();
        }
    }
}
