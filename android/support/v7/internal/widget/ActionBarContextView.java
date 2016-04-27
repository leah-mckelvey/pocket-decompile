package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p000h.au;
import android.support.v4.p000h.bt;
import android.support.v4.p000h.ck;
import android.support.v7.internal.view.C0232i;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.p012d.C0212a;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0207i;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.C0286a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0259a implements ck {
    private CharSequence f965j;
    private CharSequence f966k;
    private View f967l;
    private View f968m;
    private LinearLayout f969n;
    private TextView f970o;
    private TextView f971p;
    private int f972q;
    private int f973r;
    private Drawable f974s;
    private boolean f975t;
    private int f976u;
    private C0232i f977v;
    private boolean f978w;
    private int f979x;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.m2000a(context, attributeSet, C0210l.ActionMode, i, 0);
        setBackgroundDrawable(a.m2004a(C0210l.ActionMode_background));
        this.f972q = a.m2016f(C0210l.ActionMode_titleTextStyle, 0);
        this.f973r = a.m2016f(C0210l.ActionMode_subtitleTextStyle, 0);
        this.h = a.m2014e(C0210l.ActionMode_height, 0);
        this.f974s = a.m2004a(C0210l.ActionMode_backgroundSplit);
        this.f976u = a.m2016f(C0210l.ActionMode_closeItemLayout, C0207i.abc_action_mode_close_item_material);
        a.m2008b();
    }

    private void m1745e() {
        int i = 8;
        Object obj = 1;
        if (this.f969n == null) {
            LayoutInflater.from(getContext()).inflate(C0207i.abc_action_bar_title_item, this);
            this.f969n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f970o = (TextView) this.f969n.findViewById(C0205g.action_bar_title);
            this.f971p = (TextView) this.f969n.findViewById(C0205g.action_bar_subtitle);
            if (this.f972q != 0) {
                this.f970o.setTextAppearance(getContext(), this.f972q);
            }
            if (this.f973r != 0) {
                this.f971p.setTextAppearance(getContext(), this.f973r);
            }
        }
        this.f970o.setText(this.f965j);
        this.f971p.setText(this.f966k);
        Object obj2 = !TextUtils.isEmpty(this.f965j) ? 1 : null;
        if (TextUtils.isEmpty(this.f966k)) {
            obj = null;
        }
        this.f971p.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f969n;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f969n.getParent() == null) {
            addView(this.f969n);
        }
    }

    private void m1746f() {
        C0232i c0232i = this.f977v;
        if (c0232i != null) {
            this.f977v = null;
            c0232i.m1512b();
        }
    }

    private C0232i m1747g() {
        au.m685a(this.f967l, (float) ((-this.f967l.getWidth()) - ((MarginLayoutParams) this.f967l.getLayoutParams()).leftMargin));
        bt b = au.m703g(this.f967l).m866b(0.0f);
        b.m861a(200);
        b.m862a((ck) this);
        b.m864a(new DecelerateInterpolator());
        C0232i c0232i = new C0232i();
        c0232i.m1508a(b);
        if (this.c != null) {
            int childCount = this.c.getChildCount();
            if (childCount > 0) {
                int i = childCount - 1;
                childCount = 0;
                while (i >= 0) {
                    View childAt = this.c.getChildAt(i);
                    au.m699d(childAt, 0.0f);
                    bt d = au.m703g(childAt).m870d(1.0f);
                    d.m861a(300);
                    c0232i.m1508a(d);
                    i--;
                    childCount++;
                }
            }
        }
        return c0232i;
    }

    private C0232i m1748h() {
        bt b = au.m703g(this.f967l).m866b((float) ((-this.f967l.getWidth()) - ((MarginLayoutParams) this.f967l.getLayoutParams()).leftMargin));
        b.m861a(200);
        b.m862a((ck) this);
        b.m864a(new DecelerateInterpolator());
        C0232i c0232i = new C0232i();
        c0232i.m1508a(b);
        return (this.c == null || this.c.getChildCount() > 0) ? c0232i : c0232i;
    }

    public void m1750a(C0212a c0212a) {
        if (this.f967l == null) {
            this.f967l = LayoutInflater.from(getContext()).inflate(this.f976u, this, false);
            addView(this.f967l);
        } else if (this.f967l.getParent() == null) {
            addView(this.f967l);
        }
        this.f967l.findViewById(C0205g.action_mode_close_button).setOnClickListener(new C0269i(this, c0212a));
        C0240i c0240i = (C0240i) c0212a.m1360b();
        if (this.d != null) {
            this.d.m2233e();
        }
        this.d = new C0286a(getContext());
        this.d.m2229c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.f) {
            this.d.m2216a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.d.m2226b(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.h;
            c0240i.m1570a(this.d, this.b);
            this.c = (ActionMenuView) this.d.m2214a((ViewGroup) this);
            this.c.setBackgroundDrawable(this.f974s);
            this.e.addView(this.c, layoutParams);
        } else {
            c0240i.m1570a(this.d, this.b);
            this.c = (ActionMenuView) this.d.m2214a((ViewGroup) this);
            this.c.setBackgroundDrawable(null);
            addView(this.c, layoutParams);
        }
        this.f978w = true;
    }

    public void m1751a(View view) {
    }

    public boolean m1752a() {
        return this.d != null ? this.d.m2230c() : false;
    }

    public void m1753b() {
        if (this.f979x != 2) {
            if (this.f967l == null) {
                m1755c();
                return;
            }
            m1746f();
            this.f979x = 2;
            this.f977v = m1748h();
            this.f977v.m1511a();
        }
    }

    public void m1754b(View view) {
        if (this.f979x == 2) {
            m1755c();
        }
        this.f979x = 0;
    }

    public void m1755c() {
        m1746f();
        removeAllViews();
        if (this.e != null) {
            this.e.removeView(this.c);
        }
        this.f968m = null;
        this.c = null;
        this.f978w = false;
    }

    public void m1756c(View view) {
    }

    public boolean m1757d() {
        return this.f975t;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f966k;
    }

    public CharSequence getTitle() {
        return this.f965j;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m2232d();
            this.d.m2234f();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f965j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bq.m2069a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.f967l == null || this.f967l.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f967l.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0259a.m1740a(paddingRight, i5, a);
            paddingRight = C0259a.m1740a(m1742a(this.f967l, i5, paddingTop, paddingTop2, a) + i5, i6, a);
            if (this.f978w) {
                this.f979x = 1;
                this.f977v = m1747g();
                this.f977v.m1511a();
                this.f978w = false;
            }
        }
        i5 = paddingRight;
        if (!(this.f969n == null || this.f968m != null || this.f969n.getVisibility() == 8)) {
            i5 += m1742a(this.f969n, i5, paddingTop, paddingTop2, a);
        }
        if (this.f968m != null) {
            int a2 = m1742a(this.f968m, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m1742a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.h > 0 ? this.h : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f967l != null) {
                a = m1741a(this.f967l, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f967l.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m1741a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f969n != null && this.f968m == null) {
                if (this.f975t) {
                    this.f969n.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f969n.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f969n.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m1741a(this.f969n, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f968m != null) {
                LayoutParams layoutParams = this.f968m.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f968m.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.h <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        if (this.f968m != null) {
            removeView(this.f968m);
        }
        this.f968m = view;
        if (this.f969n != null) {
            removeView(this.f969n);
            this.f969n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        if (this.f != z) {
            if (this.d != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.d.m2216a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.d.m2226b(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.h;
                    this.c = (ActionMenuView) this.d.m2214a((ViewGroup) this);
                    this.c.setBackgroundDrawable(this.f974s);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    this.e.addView(this.c, layoutParams);
                } else {
                    this.c = (ActionMenuView) this.d.m2214a((ViewGroup) this);
                    this.c.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    addView(this.c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f966k = charSequence;
        m1745e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f965j = charSequence;
        m1745e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f975t) {
            requestLayout();
        }
        this.f975t = z;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
