package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.C0006g;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.design.widget.e */
public class C0012e extends MarginLayoutParams {
    C0010c f48a;
    boolean f49b;
    public int f50c;
    public int f51d;
    public int f52e;
    int f53f;
    View f54g;
    View f55h;
    final Rect f56i;
    Object f57j;
    private boolean f58k;
    private boolean f59l;
    private boolean f60m;

    public C0012e(int i, int i2) {
        super(i, i2);
        this.f49b = false;
        this.f50c = 0;
        this.f51d = 0;
        this.f52e = -1;
        this.f53f = -1;
        this.f56i = new Rect();
    }

    C0012e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49b = false;
        this.f50c = 0;
        this.f51d = 0;
        this.f52e = -1;
        this.f53f = -1;
        this.f56i = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0006g.CoordinatorLayout_LayoutParams);
        this.f50c = obtainStyledAttributes.getInteger(C0006g.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f53f = obtainStyledAttributes.getResourceId(C0006g.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.f51d = obtainStyledAttributes.getInteger(C0006g.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.f52e = obtainStyledAttributes.getInteger(C0006g.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.f49b = obtainStyledAttributes.hasValue(C0006g.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.f49b) {
            this.f48a = C0009b.m32a(context, attributeSet, obtainStyledAttributes.getString(C0006g.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }

    public C0012e(C0012e c0012e) {
        super(c0012e);
        this.f49b = false;
        this.f50c = 0;
        this.f51d = 0;
        this.f52e = -1;
        this.f53f = -1;
        this.f56i = new Rect();
    }

    public C0012e(LayoutParams layoutParams) {
        super(layoutParams);
        this.f49b = false;
        this.f50c = 0;
        this.f51d = 0;
        this.f52e = -1;
        this.f53f = -1;
        this.f56i = new Rect();
    }

    public C0012e(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f49b = false;
        this.f50c = 0;
        this.f51d = 0;
        this.f52e = -1;
        this.f53f = -1;
        this.f56i = new Rect();
    }

    private void m83a(View view, C0009b c0009b) {
        this.f54g = c0009b.findViewById(this.f53f);
        if (this.f54g != null) {
            View view2 = this.f54g;
            View parent = this.f54g.getParent();
            while (parent != c0009b && parent != null) {
                if (parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                    parent = parent.getParent();
                } else if (c0009b.isInEditMode()) {
                    this.f55h = null;
                    this.f54g = null;
                    return;
                } else {
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
            }
            this.f55h = view2;
        } else if (c0009b.isInEditMode()) {
            this.f55h = null;
            this.f54g = null;
        } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + c0009b.getResources().getResourceName(this.f53f) + " to anchor view " + view);
        }
    }

    private boolean m84b(View view, C0009b c0009b) {
        if (this.f54g.getId() != this.f53f) {
            return false;
        }
        View view2 = this.f54g;
        View parent = this.f54g.getParent();
        while (parent != c0009b) {
            if (parent == null || parent == view) {
                this.f55h = null;
                this.f54g = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        this.f55h = view2;
        return true;
    }

    public C0010c m85a() {
        return this.f48a;
    }

    void m86a(Rect rect) {
        this.f56i.set(rect);
    }

    public void m87a(C0010c c0010c) {
        if (this.f48a != c0010c) {
            this.f48a = c0010c;
            this.f57j = null;
            this.f49b = true;
        }
    }

    void m88a(boolean z) {
        this.f59l = z;
    }

    boolean m89a(C0009b c0009b, View view) {
        if (this.f58k) {
            return true;
        }
        boolean c = (this.f48a != null ? this.f48a.m79c(c0009b, view) : 0) | this.f58k;
        this.f58k = c;
        return c;
    }

    boolean m90a(C0009b c0009b, View view, View view2) {
        return view2 == this.f55h || (this.f48a != null && this.f48a.m70a(c0009b, view, view2));
    }

    Rect m91b() {
        return this.f56i;
    }

    View m92b(C0009b c0009b, View view) {
        if (this.f53f == -1) {
            this.f55h = null;
            this.f54g = null;
            return null;
        }
        if (this.f54g == null || !m84b(view, c0009b)) {
            m83a(view, c0009b);
        }
        return this.f54g;
    }

    void m93b(boolean z) {
        this.f60m = z;
    }

    boolean m94c() {
        return this.f54g == null && this.f53f != -1;
    }

    boolean m95c(C0009b c0009b, View view) {
        return this.f48a != null && this.f48a.m80d(c0009b, view);
    }

    boolean m96d() {
        if (this.f48a == null) {
            this.f58k = false;
        }
        return this.f58k;
    }

    void m97e() {
        this.f58k = false;
    }

    void m98f() {
        this.f59l = false;
    }

    boolean m99g() {
        return this.f59l;
    }

    boolean m100h() {
        return this.f60m;
    }

    void m101i() {
        this.f60m = false;
    }
}
