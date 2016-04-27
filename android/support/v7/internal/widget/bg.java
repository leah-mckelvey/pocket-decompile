package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class bg extends an {
    private final bi f1209a;

    public bg(Resources resources, bi biVar) {
        super(resources);
        this.f1209a = biVar;
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null) {
            this.f1209a.m1993a(i, drawable);
        }
        return drawable;
    }
}
