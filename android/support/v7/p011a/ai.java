package android.support.v7.p011a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.support.v7.p013b.C0200b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.ai */
public class ai extends Dialog implements C0172r {
    private C0189s f528a;

    public ai(Context context, int i) {
        super(context, ai.m1177a(context, i));
        m1178a().m1256a(null);
    }

    private static int m1177a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0200b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0189s m1178a() {
        if (this.f528a == null) {
            this.f528a = C0189s.m1251a((Dialog) this, (C0172r) this);
        }
        return this.f528a;
    }

    public C0212a m1179a(C0171b c0171b) {
        return null;
    }

    public void m1180a(C0212a c0212a) {
    }

    public boolean m1181a(int i) {
        return m1178a().m1263b(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m1178a().m1262b(view, layoutParams);
    }

    public void m1182b(C0212a c0212a) {
    }

    public void invalidateOptionsMenu() {
        m1178a().m1266e();
    }

    protected void onCreate(Bundle bundle) {
        m1178a().m1268g();
        super.onCreate(bundle);
        m1178a().m1256a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m1178a().m1264c();
    }

    public void setContentView(int i) {
        m1178a().m1254a(i);
    }

    public void setContentView(View view) {
        m1178a().m1257a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m1178a().m1258a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m1178a().m1259a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m1178a().m1259a(charSequence);
    }
}
