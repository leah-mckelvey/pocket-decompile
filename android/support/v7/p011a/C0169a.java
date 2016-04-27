package android.support.v7.p011a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.KeyEvent;

/* renamed from: android.support.v7.a.a */
public abstract class C0169a {
    public abstract int m1138a();

    public C0212a m1139a(C0171b c0171b) {
        return null;
    }

    public void m1140a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void m1141a(Configuration configuration) {
    }

    public void m1142a(CharSequence charSequence) {
    }

    public void m1143a(boolean z) {
    }

    public boolean m1144a(int i, KeyEvent keyEvent) {
        return false;
    }

    public Context m1145b() {
        return null;
    }

    public void m1146b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void m1147c(boolean z) {
    }

    public boolean m1148c() {
        return false;
    }

    public void m1149d(boolean z) {
    }

    public boolean m1150d() {
        return false;
    }

    public void m1151e(boolean z) {
    }
}
