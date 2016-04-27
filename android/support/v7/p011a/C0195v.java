package android.support.v7.p011a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.Window;

/* renamed from: android.support.v7.a.v */
class C0195v extends C0194y {
    C0195v(Context context, Window window, C0172r c0172r) {
        super(context, window, c0172r);
    }

    View m1349b(View view, String str, Context context, AttributeSet attributeSet) {
        View b = super.m1334b(view, str, context, attributeSet);
        return b != null ? b : this.c instanceof Factory2 ? ((Factory2) this.c).onCreateView(view, str, context, attributeSet) : null;
    }
}
