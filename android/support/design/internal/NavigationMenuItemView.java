package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0002c;
import android.support.design.C0003d;
import android.support.v4.p003c.p004a.C0073a;
import android.support.v4.widget.C0168x;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.view.menu.aa;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class NavigationMenuItemView extends TextView implements aa {
    private static final int[] f1a;
    private int f2b;
    private C0248m f3c;
    private ColorStateList f4d;

    static {
        f1a = new int[]{16842912};
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2b = context.getResources().getDimensionPixelSize(C0003d.navigation_icon_size);
    }

    private StateListDrawable m2b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0002c.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f1a, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public void m3a(C0248m c0248m, int i) {
        this.f3c = c0248m;
        setVisibility(c0248m.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m2b());
        }
        setCheckable(c0248m.isCheckable());
        setChecked(c0248m.isChecked());
        setEnabled(c0248m.isEnabled());
        setTitle(c0248m.getTitle());
        setIcon(c0248m.getIcon());
    }

    public boolean m4a() {
        return false;
    }

    public C0248m getItemData() {
        return this.f3c;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f3c != null && this.f3c.isCheckable() && this.f3c.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f1a);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            drawable = C0073a.m474c(drawable).mutate();
            drawable.setBounds(0, 0, this.f2b, this.f2b);
            C0073a.m470a(drawable, this.f4d);
        }
        C0168x.m1137a(this, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f4d = colorStateList;
        if (this.f3c != null) {
            setIcon(this.f3c.getIcon());
        }
    }

    public void setTitle(CharSequence charSequence) {
        setText(charSequence);
    }
}
