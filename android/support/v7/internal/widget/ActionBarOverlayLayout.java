package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p000h.an;
import android.support.v4.p000h.au;
import android.support.v4.p000h.bt;
import android.support.v4.p000h.ck;
import android.support.v4.widget.C0162r;
import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0205g;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.pocket.doorway.C0339o;

public class ActionBarOverlayLayout extends ViewGroup implements ah {
    static final int[] f980a;
    private final ck f981A;
    private final ck f982B;
    private final Runnable f983C;
    private final Runnable f984D;
    private final an f985E;
    private int f986b;
    private int f987c;
    private ContentFrameLayout f988d;
    private ActionBarContainer f989e;
    private ActionBarContainer f990f;
    private ai f991g;
    private Drawable f992h;
    private boolean f993i;
    private boolean f994j;
    private boolean f995k;
    private boolean f996l;
    private boolean f997m;
    private int f998n;
    private int f999o;
    private final Rect f1000p;
    private final Rect f1001q;
    private final Rect f1002r;
    private final Rect f1003s;
    private final Rect f1004t;
    private final Rect f1005u;
    private C0215n f1006v;
    private final int f1007w;
    private C0162r f1008x;
    private bt f1009y;
    private bt f1010z;

    static {
        f980a = new int[]{C0200b.actionBarSize, 16842841};
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f987c = 0;
        this.f1000p = new Rect();
        this.f1001q = new Rect();
        this.f1002r = new Rect();
        this.f1003s = new Rect();
        this.f1004t = new Rect();
        this.f1005u = new Rect();
        this.f1007w = 600;
        this.f981A = new C0270j(this);
        this.f982B = new C0271k(this);
        this.f983C = new C0272l(this);
        this.f984D = new C0273m(this);
        m1769a(context);
        this.f985E = new an(this);
    }

    private ai m1768a(View view) {
        if (view instanceof ai) {
            return (ai) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m1769a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f980a);
        this.f986b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f992h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f992h == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f993i = z;
        this.f1008x = C0162r.m1091a(context);
    }

    private boolean m1771a(float f, float f2) {
        this.f1008x.m1095a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1008x.m1098d() > this.f990f.getHeight();
    }

    private boolean m1773a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0274o c0274o = (C0274o) view.getLayoutParams();
        if (z && c0274o.leftMargin != rect.left) {
            c0274o.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0274o.topMargin != rect.top) {
            c0274o.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0274o.rightMargin != rect.right) {
            c0274o.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0274o.bottomMargin == rect.bottom) {
            return z5;
        }
        c0274o.bottomMargin = rect.bottom;
        return true;
    }

    private void m1779k() {
        removeCallbacks(this.f983C);
        removeCallbacks(this.f984D);
        if (this.f1009y != null) {
            this.f1009y.m865a();
        }
        if (this.f1010z != null) {
            this.f1010z.m865a();
        }
    }

    private void m1780l() {
        m1779k();
        postDelayed(this.f983C, 600);
    }

    private void m1781m() {
        m1779k();
        postDelayed(this.f984D, 600);
    }

    private void m1782n() {
        m1779k();
        this.f983C.run();
    }

    private void m1783o() {
        m1779k();
        this.f984D.run();
    }

    public C0274o m1784a(AttributeSet attributeSet) {
        return new C0274o(getContext(), attributeSet);
    }

    public void m1785a(int i) {
        m1789c();
        switch (i) {
            case C0339o.View_paddingStart /*2*/:
                this.f991g.m1855g();
            case C0339o.View_backgroundTint /*5*/:
                this.f991g.m1856h();
            case C0339o.Toolbar_titleTextAppearance /*9*/:
                setOverlayMode(true);
            default:
        }
    }

    public void m1786a(Menu menu, C0170y c0170y) {
        m1789c();
        this.f991g.m1842a(menu, c0170y);
    }

    public boolean m1787a() {
        return this.f994j;
    }

    protected C0274o m1788b() {
        return new C0274o(-1, -1);
    }

    void m1789c() {
        if (this.f988d == null) {
            this.f988d = (ContentFrameLayout) findViewById(C0205g.action_bar_activity_content);
            this.f990f = (ActionBarContainer) findViewById(C0205g.action_bar_container);
            this.f991g = m1768a(findViewById(C0205g.action_bar));
            this.f989e = (ActionBarContainer) findViewById(C0205g.split_action_bar);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0274o;
    }

    public boolean m1790d() {
        m1789c();
        return this.f991g.m1857i();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f992h != null && !this.f993i) {
            int bottom = this.f990f.getVisibility() == 0 ? (int) ((((float) this.f990f.getBottom()) + au.m700e(this.f990f)) + 0.5f) : 0;
            this.f992h.setBounds(0, bottom, getWidth(), this.f992h.getIntrinsicHeight() + bottom);
            this.f992h.draw(canvas);
        }
    }

    public boolean m1791e() {
        m1789c();
        return this.f991g.m1858j();
    }

    public boolean m1792f() {
        m1789c();
        return this.f991g.m1859k();
    }

    protected boolean fitSystemWindows(Rect rect) {
        m1789c();
        boolean a = (au.m704h(this) & 256) != 0 ? m1773a(this.f990f, rect, true, true, false, true) : m1773a(this.f990f, rect, true, true, false, true);
        if (this.f989e != null) {
            a |= m1773a(this.f989e, rect, true, false, true, true);
        }
        this.f1003s.set(rect);
        bq.m2068a(this, this.f1003s, this.f1000p);
        if (!this.f1001q.equals(this.f1000p)) {
            this.f1001q.set(this.f1000p);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean m1793g() {
        m1789c();
        return this.f991g.m1860l();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1788b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1784a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0274o(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f990f != null ? -((int) au.m700e(this.f990f)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f985E.m667a();
    }

    public CharSequence getTitle() {
        m1789c();
        return this.f991g.m1854f();
    }

    public boolean m1794h() {
        m1789c();
        return this.f991g.m1861m();
    }

    public void m1795i() {
        m1789c();
        this.f991g.m1862n();
    }

    public void m1796j() {
        m1789c();
        this.f991g.m1863o();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m1769a(getContext());
        au.m705i(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1779k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0274o c0274o = (C0274o) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = c0274o.leftMargin + paddingLeft;
                paddingRight = childAt == this.f989e ? (paddingBottom - measuredHeight) - c0274o.bottomMargin : c0274o.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, measuredWidth + i6, measuredHeight + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int max2;
        int i3;
        int i4;
        m1789c();
        measureChildWithMargins(this.f990f, i, 0, i2, 0);
        C0274o c0274o = (C0274o) this.f990f.getLayoutParams();
        int max3 = Math.max(0, (this.f990f.getMeasuredWidth() + c0274o.leftMargin) + c0274o.rightMargin);
        int max4 = Math.max(0, c0274o.bottomMargin + (this.f990f.getMeasuredHeight() + c0274o.topMargin));
        int a = bq.m2067a(0, au.m692b(this.f990f));
        if (this.f989e != null) {
            measureChildWithMargins(this.f989e, i, 0, i2, 0);
            c0274o = (C0274o) this.f989e.getLayoutParams();
            max = Math.max(max3, (this.f989e.getMeasuredWidth() + c0274o.leftMargin) + c0274o.rightMargin);
            max2 = Math.max(max4, c0274o.bottomMargin + (this.f989e.getMeasuredHeight() + c0274o.topMargin));
            max3 = bq.m2067a(a, au.m692b(this.f989e));
            max4 = max;
            i3 = max2;
        } else {
            i3 = max4;
            max4 = max3;
            max3 = a;
        }
        Object obj = (au.m704h(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i4 = this.f986b;
            if (this.f995k && this.f990f.getTabContainer() != null) {
                i4 += this.f986b;
            }
        } else {
            i4 = this.f990f.getVisibility() != 8 ? this.f990f.getMeasuredHeight() : 0;
        }
        max = (!this.f991g.m1850c() || this.f989e == null) ? 0 : obj != null ? this.f986b : this.f989e.getMeasuredHeight();
        this.f1002r.set(this.f1000p);
        this.f1004t.set(this.f1003s);
        Rect rect;
        Rect rect2;
        if (this.f994j || obj != null) {
            rect = this.f1004t;
            rect.top = i4 + rect.top;
            rect2 = this.f1004t;
            rect2.bottom = max + rect2.bottom;
        } else {
            rect = this.f1002r;
            rect.top = i4 + rect.top;
            rect2 = this.f1002r;
            rect2.bottom = max + rect2.bottom;
        }
        m1773a(this.f988d, this.f1002r, true, true, true, true);
        if (!this.f1005u.equals(this.f1004t)) {
            this.f1005u.set(this.f1004t);
            this.f988d.m1832a(this.f1004t);
        }
        measureChildWithMargins(this.f988d, i, 0, i2, 0);
        c0274o = (C0274o) this.f988d.getLayoutParams();
        max = Math.max(max4, (this.f988d.getMeasuredWidth() + c0274o.leftMargin) + c0274o.rightMargin);
        i4 = Math.max(i3, c0274o.bottomMargin + (this.f988d.getMeasuredHeight() + c0274o.topMargin));
        max2 = bq.m2067a(max3, au.m692b(this.f988d));
        setMeasuredDimension(au.m682a(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, max2), au.m682a(Math.max(i4 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, max2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f996l || !z) {
            return false;
        }
        if (m1771a(f, f2)) {
            m1783o();
        } else {
            m1782n();
        }
        this.f997m = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f998n += i2;
        setActionBarHideOffset(this.f998n);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f985E.m669a(view, view2, i);
        this.f998n = getActionBarHideOffset();
        m1779k();
        if (this.f1006v != null) {
            this.f1006v.m1381i();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f990f.getVisibility() != 0) ? false : this.f996l;
    }

    public void onStopNestedScroll(View view) {
        if (this.f996l && !this.f997m) {
            if (this.f998n <= this.f990f.getHeight()) {
                m1780l();
            } else {
                m1781m();
            }
        }
        if (this.f1006v != null) {
            this.f1006v.m1382j();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m1789c();
        int i2 = this.f999o ^ i;
        this.f999o = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f1006v != null) {
            C0215n c0215n = this.f1006v;
            if (z3) {
                z = false;
            }
            c0215n.m1379g(z);
            if (z2 || !z3) {
                this.f1006v.m1378g();
            } else {
                this.f1006v.m1380h();
            }
        }
        if ((i2 & 256) != 0 && this.f1006v != null) {
            au.m705i(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f987c = i;
        if (this.f1006v != null) {
            this.f1006v.m1377a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m1779k();
        int height = this.f990f.getHeight();
        int max = Math.max(0, Math.min(i, height));
        au.m694b(this.f990f, (float) (-max));
        if (this.f989e != null && this.f989e.getVisibility() != 8) {
            au.m694b(this.f989e, (float) ((int) ((((float) max) / ((float) height)) * ((float) this.f989e.getHeight()))));
        }
    }

    public void setActionBarVisibilityCallback(C0215n c0215n) {
        this.f1006v = c0215n;
        if (getWindowToken() != null) {
            this.f1006v.m1377a(this.f987c);
            if (this.f999o != 0) {
                onWindowSystemUiVisibilityChanged(this.f999o);
                au.m705i(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f995k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f996l) {
            this.f996l = z;
            if (!z) {
                m1779k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m1789c();
        this.f991g.m1839a(i);
    }

    public void setIcon(Drawable drawable) {
        m1789c();
        this.f991g.m1840a(drawable);
    }

    public void setLogo(int i) {
        m1789c();
        this.f991g.m1847b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f994j = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f993i = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m1789c();
        this.f991g.m1843a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m1789c();
        this.f991g.m1844a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
