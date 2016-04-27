package android.support.v4.p000h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* renamed from: android.support.v4.h.o */
class C0132o implements Factory {
    final C0058s f422a;

    C0132o(C0058s c0058s) {
        this.f422a = c0058s;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f422a.m388a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f422a + "}";
    }
}
