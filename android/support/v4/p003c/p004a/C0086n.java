package android.support.v4.p003c.p004a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: android.support.v4.c.a.n */
class C0086n extends Drawable implements Callback, C0085m {
    static final Mode f330a;
    Drawable f331b;
    private ColorStateList f332c;
    private Mode f333d;
    private int f334e;
    private Mode f335f;
    private boolean f336g;

    static {
        f330a = Mode.SRC_IN;
    }

    C0086n(Drawable drawable) {
        this.f333d = f330a;
        m525a(drawable);
    }

    private boolean m523a(int[] iArr) {
        if (!(this.f332c == null || this.f333d == null)) {
            int colorForState = this.f332c.getColorForState(iArr, this.f332c.getDefaultColor());
            Mode mode = this.f333d;
            if (!(this.f336g && colorForState == this.f334e && mode == this.f335f)) {
                setColorFilter(colorForState, mode);
                this.f334e = colorForState;
                this.f335f = mode;
                this.f336g = true;
                return true;
            }
        }
        return false;
    }

    public Drawable m524a() {
        return this.f331b;
    }

    public void m525a(Drawable drawable) {
        if (this.f331b != null) {
            this.f331b.setCallback(null);
        }
        this.f331b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.f331b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f331b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f331b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f331b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f331b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f331b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f331b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f331b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f331b.getPadding(rect);
    }

    public int[] getState() {
        return this.f331b.getState();
    }

    public Region getTransparentRegion() {
        return this.f331b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        return (this.f332c != null && this.f332c.isStateful()) || this.f331b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f331b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            m525a(mutate);
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.f331b.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f331b.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f331b.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f331b.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f331b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f331b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f331b.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m523a(iArr) || this.f331b.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f332c = colorStateList;
        m523a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f333d = mode;
        m523a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f331b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
