package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p003c.p004a.C0073a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class al extends ListView {
    private static final int[] f1066f;
    final Rect f1067a;
    int f1068b;
    int f1069c;
    int f1070d;
    int f1071e;
    private Field f1072g;
    private am f1073h;

    static {
        f1066f = new int[]{0};
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1067a = new Rect();
        this.f1068b = 0;
        this.f1069c = 0;
        this.f1070d = 0;
        this.f1071e = 0;
        try {
            this.f1072g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1072g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m1866a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            listPaddingTop = (layoutParams == null || layoutParams.height <= 0) ? MeasureSpec.makeMeasureSpec(0, 0) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            view.measure(i, listPaddingTop);
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m1867a() {
        Drawable selector = getSelector();
        if (selector != null && m1872b()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m1868a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m1871b(i, view);
        if (z2) {
            Rect rect = this.f1067a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0073a.m467a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m1869a(int i, View view, float f, float f2) {
        m1868a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0073a.m467a(selector, f, f2);
        }
    }

    protected void m1870a(Canvas canvas) {
        if (!this.f1067a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1067a);
                selector.draw(canvas);
            }
        }
    }

    protected void m1871b(int i, View view) {
        Rect rect = this.f1067a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1068b;
        rect.top -= this.f1069c;
        rect.right += this.f1070d;
        rect.bottom += this.f1071e;
        try {
            boolean z = this.f1072g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1072g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m1872b() {
        return m1873c() && isPressed();
    }

    protected boolean m1873c() {
        return false;
    }

    protected void dispatchDraw(Canvas canvas) {
        m1870a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m1867a();
    }

    public void setSelector(Drawable drawable) {
        this.f1073h = drawable != null ? new am(drawable) : null;
        super.setSelector(this.f1073h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1068b = rect.left;
        this.f1069c = rect.top;
        this.f1070d = rect.right;
        this.f1071e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f1073h != null) {
            this.f1073h.m1874a(z);
        }
    }
}
