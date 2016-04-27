package android.support.v7.p014c.p015a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p003c.p004a.C0073a;

/* renamed from: android.support.v7.c.a.a */
public class C0211a extends Drawable implements Callback {
    private Drawable f669a;

    public C0211a(Drawable drawable) {
        m1353a(drawable);
    }

    public void m1353a(Drawable drawable) {
        if (this.f669a != null) {
            this.f669a.setCallback(null);
        }
        this.f669a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f669a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f669a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f669a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f669a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f669a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f669a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f669a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f669a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f669a.getPadding(rect);
    }

    public int[] getState() {
        return this.f669a.getState();
    }

    public Region getTransparentRegion() {
        return this.f669a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0073a.m473b(this.f669a);
    }

    public boolean isStateful() {
        return this.f669a.isStateful();
    }

    public void jumpToCurrentState() {
        C0073a.m466a(this.f669a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f669a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f669a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f669a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0073a.m472a(this.f669a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f669a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f669a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f669a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f669a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0073a.m467a(this.f669a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0073a.m469a(this.f669a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f669a.setState(iArr);
    }

    public void setTint(int i) {
        C0073a.m468a(this.f669a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0073a.m470a(this.f669a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0073a.m471a(this.f669a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f669a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
