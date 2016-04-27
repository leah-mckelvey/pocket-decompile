package android.support.v7.internal.widget;

import android.support.v4.p000h.cl;
import android.view.View;

class bn extends cl {
    final /* synthetic */ bl f1250a;
    private boolean f1251b;

    bn(bl blVar) {
        this.f1250a = blVar;
        this.f1251b = false;
    }

    public void m2063b(View view) {
        if (!this.f1251b) {
            this.f1250a.f1230a.setVisibility(8);
        }
    }

    public void m2064c(View view) {
        this.f1251b = true;
    }
}
