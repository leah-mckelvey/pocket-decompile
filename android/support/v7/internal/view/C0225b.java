package android.support.v7.internal.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p013b.C0209k;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.internal.view.b */
public class C0225b extends ContextWrapper {
    private int f720a;
    private Theme f721b;
    private LayoutInflater f722c;

    public C0225b(Context context, int i) {
        super(context);
        this.f720a = i;
    }

    private void m1458b() {
        boolean z = this.f721b == null;
        if (z) {
            this.f721b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f721b.setTo(theme);
            }
        }
        m1460a(this.f721b, this.f720a, z);
    }

    public int m1459a() {
        return this.f720a;
    }

    protected void m1460a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f722c == null) {
            this.f722c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f722c;
    }

    public Theme getTheme() {
        if (this.f721b != null) {
            return this.f721b;
        }
        if (this.f720a == 0) {
            this.f720a = C0209k.Theme_AppCompat_Light;
        }
        m1458b();
        return this.f721b;
    }

    public void setTheme(int i) {
        this.f720a = i;
        m1458b();
    }
}
