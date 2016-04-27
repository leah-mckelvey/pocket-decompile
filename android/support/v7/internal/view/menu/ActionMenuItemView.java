package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p000h.au;
import android.support.v7.p013b.C0201c;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.C0234y;
import android.support.v7.widget.C0235k;
import android.support.v7.widget.ag;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends C0234y implements aa, C0235k, OnClickListener, OnLongClickListener {
    private C0248m f780a;
    private CharSequence f781b;
    private Drawable f782c;
    private C0236k f783d;
    private ag f784e;
    private C0242c f785f;
    private boolean f786g;
    private boolean f787h;
    private int f788i;
    private int f789j;
    private int f790k;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f786g = resources.getBoolean(C0201c.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.ActionMenuItemView, i, 0);
        this.f788i = obtainStyledAttributes.getDimensionPixelSize(C0210l.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f790k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f789j = -1;
    }

    private void m1521e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f781b) ? 1 : 0;
        if (this.f782c == null || (this.f780a.m1696m() && (this.f786g || this.f787h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f781b : null);
    }

    public void m1522a(C0248m c0248m, int i) {
        this.f780a = c0248m;
        setIcon(c0248m.getIcon());
        setTitle(c0248m.m1676a((aa) this));
        setId(c0248m.getItemId());
        setVisibility(c0248m.isVisible() ? 0 : 8);
        setEnabled(c0248m.isEnabled());
        if (c0248m.hasSubMenu() && this.f784e == null) {
            this.f784e = new C0241b(this);
        }
    }

    public boolean m1523a() {
        return true;
    }

    public boolean m1524b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean m1525c() {
        return m1524b() && this.f780a.getIcon() == null;
    }

    public boolean m1526d() {
        return m1524b();
    }

    public C0248m getItemData() {
        return this.f780a;
    }

    public void onClick(View view) {
        if (this.f783d != null) {
            this.f783d.m1527a(this.f780a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f786g = getContext().getResources().getBoolean(C0201c.abc_config_allowActionMenuItemTextWithIcon);
        m1521e();
    }

    public boolean onLongClick(View view) {
        if (m1524b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (au.m683a(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f780a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m1524b();
        if (b && this.f789j >= 0) {
            super.setPadding(this.f789j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f788i) : this.f788i;
        if (mode != 1073741824 && this.f788i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f782c != null) {
            super.setPadding((getMeasuredWidth() - this.f782c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f780a.hasSubMenu() && this.f784e != null && this.f784e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f787h != z) {
            this.f787h = z;
            if (this.f780a != null) {
                this.f780a.m1691h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f782c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f790k) {
                f = ((float) this.f790k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f790k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f790k) {
                f = ((float) this.f790k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f790k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1521e();
    }

    public void setItemInvoker(C0236k c0236k) {
        this.f783d = c0236k;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f789j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0242c c0242c) {
        this.f785f = c0242c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f781b = charSequence;
        setContentDescription(this.f781b);
        m1521e();
    }
}
