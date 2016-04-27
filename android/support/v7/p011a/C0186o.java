package android.support.v7.p011a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.p013b.C0200b;
import android.util.TypedValue;
import android.view.KeyEvent;

/* renamed from: android.support.v7.a.o */
public class C0186o extends ai implements DialogInterface {
    private C0176e f623a;

    C0186o(Context context, int i, boolean z) {
        super(context, C0186o.m1228a(context, i));
        this.f623a = new C0176e(getContext(), this, getWindow());
    }

    static int m1228a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0200b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f623a.m1212a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f623a.m1218a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f623a.m1222b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f623a.m1217a(charSequence);
    }
}
