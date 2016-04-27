package android.support.v7.p011a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.a.p */
public class C0187p {
    private final C0178g f624a;
    private int f625b;

    public C0187p(Context context) {
        this(context, C0186o.m1228a(context, 0));
    }

    public C0187p(Context context, int i) {
        this.f624a = new C0178g(new ContextThemeWrapper(context, C0186o.m1228a(context, i)));
        this.f625b = i;
    }

    public Context m1230a() {
        return this.f624a.f584a;
    }

    public C0187p m1231a(OnKeyListener onKeyListener) {
        this.f624a.f601r = onKeyListener;
        return this;
    }

    public C0187p m1232a(Drawable drawable) {
        this.f624a.f587d = drawable;
        return this;
    }

    public C0187p m1233a(View view) {
        this.f624a.f590g = view;
        return this;
    }

    public C0187p m1234a(ListAdapter listAdapter, OnClickListener onClickListener) {
        this.f624a.f603t = listAdapter;
        this.f624a.f604u = onClickListener;
        return this;
    }

    public C0187p m1235a(CharSequence charSequence) {
        this.f624a.f589f = charSequence;
        return this;
    }

    public C0186o m1236b() {
        C0186o c0186o = new C0186o(this.f624a.f584a, this.f625b, false);
        this.f624a.m1226a(c0186o.f623a);
        c0186o.setCancelable(this.f624a.f598o);
        if (this.f624a.f598o) {
            c0186o.setCanceledOnTouchOutside(true);
        }
        c0186o.setOnCancelListener(this.f624a.f599p);
        c0186o.setOnDismissListener(this.f624a.f600q);
        if (this.f624a.f601r != null) {
            c0186o.setOnKeyListener(this.f624a.f601r);
        }
        return c0186o;
    }
}
