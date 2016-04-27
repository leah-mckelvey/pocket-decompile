package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

public class bf extends ContextWrapper {
    private Resources f1208a;

    private bf(Context context) {
        super(context);
    }

    public static Context m1977a(Context context) {
        return !(context instanceof bf) ? new bf(context) : context;
    }

    public Resources getResources() {
        if (this.f1208a == null) {
            this.f1208a = new bg(super.getResources(), bi.m1979a((Context) this));
        }
        return this.f1208a;
    }
}
