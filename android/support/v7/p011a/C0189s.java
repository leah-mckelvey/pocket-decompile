package android.support.v7.p011a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.a.s */
public abstract class C0189s {
    C0189s() {
    }

    public static C0189s m1250a(Activity activity, C0172r c0172r) {
        return C0189s.m1252a(activity, activity.getWindow(), c0172r);
    }

    public static C0189s m1251a(Dialog dialog, C0172r c0172r) {
        return C0189s.m1252a(dialog.getContext(), dialog.getWindow(), c0172r);
    }

    private static C0189s m1252a(Context context, Window window, C0172r c0172r) {
        int i = VERSION.SDK_INT;
        return i >= 14 ? new C0196w(context, window, c0172r) : i >= 11 ? new C0195v(context, window, c0172r) : new C0194y(context, window, c0172r);
    }

    public abstract C0169a m1253a();

    public abstract void m1254a(int i);

    public abstract void m1255a(Configuration configuration);

    public abstract void m1256a(Bundle bundle);

    public abstract void m1257a(View view);

    public abstract void m1258a(View view, LayoutParams layoutParams);

    public abstract void m1259a(CharSequence charSequence);

    public abstract MenuInflater m1260b();

    public abstract void m1261b(Bundle bundle);

    public abstract void m1262b(View view, LayoutParams layoutParams);

    public abstract boolean m1263b(int i);

    public abstract void m1264c();

    public abstract void m1265d();

    public abstract void m1266e();

    public abstract void m1267f();

    public abstract void m1268g();
}
