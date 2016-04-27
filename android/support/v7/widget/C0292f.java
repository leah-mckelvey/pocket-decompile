package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p003c.p004a.C0073a;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.p013b.C0200b;

/* renamed from: android.support.v7.widget.f */
class C0292f extends TintImageView implements C0235k {
    final /* synthetic */ C0286a f1464a;
    private final float[] f1465b;

    public C0292f(C0286a c0286a, Context context) {
        this.f1464a = c0286a;
        super(context, null, C0200b.actionOverflowButtonStyle);
        this.f1465b = new float[2];
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new C0293g(this, this, c0286a));
    }

    public boolean m2286c() {
        return false;
    }

    public boolean m2287d() {
        return false;
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.f1464a.m2230c();
        }
        return true;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            C0073a.m469a(background, width - max, height - max, width + max, height + max);
        }
        return frame;
    }
}
