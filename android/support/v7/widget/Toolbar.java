package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.p000h.C0121d;
import android.support.v4.p000h.C0136t;
import android.support.v4.p000h.C0141y;
import android.support.v4.p000h.ag;
import android.support.v4.p000h.au;
import android.support.v7.internal.view.C0229f;
import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0243x;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.widget.ai;
import android.support.v7.internal.widget.ao;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.internal.widget.bl;
import android.support.v7.internal.widget.bq;
import android.support.v7.p011a.C0173b;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0210l;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.pocket.doorway.C0339o;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f1351A;
    private final ArrayList f1352B;
    private final int[] f1353C;
    private az f1354D;
    private final C0287o f1355E;
    private bl f1356F;
    private C0286a f1357G;
    private ax f1358H;
    private C0170y f1359I;
    private C0193j f1360J;
    private boolean f1361K;
    private final Runnable f1362L;
    private final bi f1363M;
    View f1364a;
    private ActionMenuView f1365b;
    private TextView f1366c;
    private TextView f1367d;
    private ImageButton f1368e;
    private ImageView f1369f;
    private Drawable f1370g;
    private CharSequence f1371h;
    private ImageButton f1372i;
    private Context f1373j;
    private int f1374k;
    private int f1375l;
    private int f1376m;
    private int f1377n;
    private int f1378o;
    private int f1379p;
    private int f1380q;
    private int f1381r;
    private int f1382s;
    private final ao f1383t;
    private int f1384u;
    private CharSequence f1385v;
    private CharSequence f1386w;
    private int f1387x;
    private int f1388y;
    private boolean f1389z;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1383t = new ao();
        this.f1384u = 8388627;
        this.f1352B = new ArrayList();
        this.f1353C = new int[2];
        this.f1355E = new au(this);
        this.f1362L = new av(this);
        bk a = bk.m2000a(getContext(), attributeSet, C0210l.Toolbar, i, 0);
        this.f1375l = a.m2016f(C0210l.Toolbar_titleTextAppearance, 0);
        this.f1376m = a.m2016f(C0210l.Toolbar_subtitleTextAppearance, 0);
        this.f1384u = a.m2006b(C0210l.Toolbar_android_gravity, this.f1384u);
        this.f1377n = 48;
        int c = a.m2009c(C0210l.Toolbar_titleMargins, 0);
        this.f1382s = c;
        this.f1381r = c;
        this.f1380q = c;
        this.f1379p = c;
        c = a.m2009c(C0210l.Toolbar_titleMarginStart, -1);
        if (c >= 0) {
            this.f1379p = c;
        }
        c = a.m2009c(C0210l.Toolbar_titleMarginEnd, -1);
        if (c >= 0) {
            this.f1380q = c;
        }
        c = a.m2009c(C0210l.Toolbar_titleMarginTop, -1);
        if (c >= 0) {
            this.f1381r = c;
        }
        c = a.m2009c(C0210l.Toolbar_titleMarginBottom, -1);
        if (c >= 0) {
            this.f1382s = c;
        }
        this.f1378o = a.m2012d(C0210l.Toolbar_maxButtonHeight, -1);
        c = a.m2009c(C0210l.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int c2 = a.m2009c(C0210l.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f1383t.m1879b(a.m2012d(C0210l.Toolbar_contentInsetLeft, 0), a.m2012d(C0210l.Toolbar_contentInsetRight, 0));
        if (!(c == Integer.MIN_VALUE && c2 == Integer.MIN_VALUE)) {
            this.f1383t.m1876a(c, c2);
        }
        this.f1370g = a.m2004a(C0210l.Toolbar_collapseIcon);
        this.f1371h = a.m2011c(C0210l.Toolbar_collapseContentDescription);
        CharSequence c3 = a.m2011c(C0210l.Toolbar_title);
        if (!TextUtils.isEmpty(c3)) {
            setTitle(c3);
        }
        c3 = a.m2011c(C0210l.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.f1373j = getContext();
        setPopupTheme(a.m2016f(C0210l.Toolbar_popupTheme, 0));
        Drawable a2 = a.m2004a(C0210l.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c3 = a.m2011c(C0210l.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c3)) {
            setNavigationContentDescription(c3);
        }
        a.m2008b();
        this.f1363M = a.m2010c();
    }

    private int m2161a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case C0339o.Toolbar_maxButtonHeight /*16*/:
            case C0339o.Theme_homeAsUpIndicator /*48*/:
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                return i2;
            default:
                return this.f1384u & 112;
        }
    }

    private int m2162a(View view, int i) {
        ay ayVar = (ay) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2161a(ayVar.a)) {
            case C0339o.Theme_homeAsUpIndicator /*48*/:
                return getPaddingTop() - i2;
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - ayVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < ayVar.topMargin) {
                    i3 = ayVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < ayVar.bottomMargin ? Math.max(0, i2 - (ayVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m2163a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m2164a(View view, int i, int[] iArr, int i2) {
        ay ayVar = (ay) view.getLayoutParams();
        int i3 = ayVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m2162a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (ayVar.rightMargin + measuredWidth) + max;
    }

    private int m2165a(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            ay ayVar = (ay) view.getLayoutParams();
            i6 = ayVar.leftMargin - i6;
            i = ayVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m2168a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m2201i();
        } else if (checkLayoutParams(layoutParams)) {
            ay ayVar = (ay) layoutParams;
        } else {
            layoutParams = m2188a(layoutParams);
        }
        layoutParams.f1456b = 1;
        addView(view, layoutParams);
    }

    private void m2169a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m2170a(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (au.m683a(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0121d.m939a(i, au.m683a(this));
        list.clear();
        ay ayVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                ayVar = (ay) childAt.getLayoutParams();
                if (ayVar.f1456b == 0 && m2174b(childAt) && m2171b(ayVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            ayVar = (ay) childAt2.getLayoutParams();
            if (ayVar.f1456b == 0 && m2174b(childAt2) && m2171b(ayVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m2171b(int i) {
        int a = au.m683a(this);
        int a2 = C0121d.m939a(i, a) & 7;
        switch (a2) {
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingEnd /*3*/:
            case C0339o.View_backgroundTint /*5*/:
                return a2;
            default:
                return a == 1 ? 5 : 3;
        }
    }

    private int m2172b(View view, int i, int[] iArr, int i2) {
        ay ayVar = (ay) view.getLayoutParams();
        int i3 = ayVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m2162a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (ayVar.leftMargin + measuredWidth);
    }

    private boolean m2174b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m2175c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0136t.m959b(marginLayoutParams) + C0136t.m958a(marginLayoutParams);
    }

    private int m2178d(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private void m2179e(View view) {
        if (((ay) view.getLayoutParams()).f1456b != 2 && view != this.f1365b) {
            view.setVisibility(this.f1364a != null ? 8 : 0);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0229f(getContext());
    }

    private void m2180j() {
        if (this.f1369f == null) {
            this.f1369f = new ImageView(getContext());
        }
    }

    private void m2181k() {
        m2182l();
        if (this.f1365b.m2127d() == null) {
            C0240i c0240i = (C0240i) this.f1365b.getMenu();
            if (this.f1358H == null) {
                this.f1358H = new ax();
            }
            this.f1365b.setExpandedActionViewsExclusive(true);
            c0240i.m1570a(this.f1358H, this.f1373j);
        }
    }

    private void m2182l() {
        if (this.f1365b == null) {
            this.f1365b = new ActionMenuView(getContext());
            this.f1365b.setPopupTheme(this.f1374k);
            this.f1365b.setOnMenuItemClickListener(this.f1355E);
            this.f1365b.m2119a(this.f1359I, this.f1360J);
            LayoutParams i = m2201i();
            i.a = 8388613 | (this.f1377n & 112);
            this.f1365b.setLayoutParams(i);
            m2168a(this.f1365b);
        }
    }

    private void m2183m() {
        if (this.f1368e == null) {
            this.f1368e = new ImageButton(getContext(), null, C0200b.toolbarNavigationButtonStyle);
            LayoutParams i = m2201i();
            i.a = 8388611 | (this.f1377n & 112);
            this.f1368e.setLayoutParams(i);
        }
    }

    private void m2184n() {
        if (this.f1372i == null) {
            this.f1372i = new ImageButton(getContext(), null, C0200b.toolbarNavigationButtonStyle);
            this.f1372i.setImageDrawable(this.f1370g);
            this.f1372i.setContentDescription(this.f1371h);
            LayoutParams i = m2201i();
            i.a = 8388611 | (this.f1377n & 112);
            i.f1456b = 2;
            this.f1372i.setLayoutParams(i);
            this.f1372i.setOnClickListener(new aw(this));
        }
    }

    private void m2185o() {
        removeCallbacks(this.f1362L);
        post(this.f1362L);
    }

    private boolean m2186p() {
        if (!this.f1361K) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2174b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void setChildVisibilityForExpandedActionView(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!(((ay) childAt.getLayoutParams()).f1456b == 2 || childAt == this.f1365b)) {
                childAt.setVisibility(z ? 8 : 0);
            }
        }
    }

    public ay m2187a(AttributeSet attributeSet) {
        return new ay(getContext(), attributeSet);
    }

    protected ay m2188a(LayoutParams layoutParams) {
        return layoutParams instanceof ay ? new ay((ay) layoutParams) : layoutParams instanceof C0173b ? new ay((C0173b) layoutParams) : layoutParams instanceof MarginLayoutParams ? new ay((MarginLayoutParams) layoutParams) : new ay(layoutParams);
    }

    public void m2189a(int i, int i2) {
        this.f1383t.m1876a(i, i2);
    }

    public void m2190a(Context context, int i) {
        this.f1375l = i;
        if (this.f1366c != null) {
            this.f1366c.setTextAppearance(context, i);
        }
    }

    public void m2191a(C0240i c0240i, C0286a c0286a) {
        if (c0240i != null || this.f1365b != null) {
            m2182l();
            C0240i d = this.f1365b.m2127d();
            if (d != c0240i) {
                if (d != null) {
                    d.m1580b(this.f1357G);
                    d.m1580b(this.f1358H);
                }
                if (this.f1358H == null) {
                    this.f1358H = new ax();
                }
                c0286a.m2231d(true);
                if (c0240i != null) {
                    c0240i.m1570a((C0243x) c0286a, this.f1373j);
                    c0240i.m1570a(this.f1358H, this.f1373j);
                } else {
                    c0286a.m2217a(this.f1373j, null);
                    this.f1358H.m2274a(this.f1373j, null);
                    c0286a.m2227b(true);
                    this.f1358H.m2278b(true);
                }
                this.f1365b.setPopupTheme(this.f1374k);
                this.f1365b.setPresenter(c0286a);
                this.f1357G = c0286a;
            }
        }
    }

    public boolean m2192a() {
        return getVisibility() == 0 && this.f1365b != null && this.f1365b.m2120a();
    }

    public void m2193b(Context context, int i) {
        this.f1376m = i;
        if (this.f1367d != null) {
            this.f1367d.setTextAppearance(context, i);
        }
    }

    public boolean m2194b() {
        return this.f1365b != null && this.f1365b.m2130g();
    }

    public boolean m2195c() {
        return this.f1365b != null && this.f1365b.m2131h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof ay);
    }

    public boolean m2196d() {
        return this.f1365b != null && this.f1365b.m2128e();
    }

    public boolean m2197e() {
        return this.f1365b != null && this.f1365b.m2129f();
    }

    public void m2198f() {
        if (this.f1365b != null) {
            this.f1365b.m2132i();
        }
    }

    public boolean m2199g() {
        return (this.f1358H == null || this.f1358H.f1454b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2201i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2187a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m2188a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f1383t.m1881d();
    }

    public int getContentInsetLeft() {
        return this.f1383t.m1875a();
    }

    public int getContentInsetRight() {
        return this.f1383t.m1878b();
    }

    public int getContentInsetStart() {
        return this.f1383t.m1880c();
    }

    public Drawable getLogo() {
        return this.f1369f != null ? this.f1369f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f1369f != null ? this.f1369f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m2181k();
        return this.f1365b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1368e != null ? this.f1368e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f1368e != null ? this.f1368e.getDrawable() : null;
    }

    public int getPopupTheme() {
        return this.f1374k;
    }

    public CharSequence getSubtitle() {
        return this.f1386w;
    }

    public CharSequence getTitle() {
        return this.f1385v;
    }

    public ai getWrapper() {
        if (this.f1356F == null) {
            this.f1356F = new bl(this, true);
        }
        return this.f1356F;
    }

    public void m2200h() {
        C0248m c0248m = this.f1358H == null ? null : this.f1358H.f1454b;
        if (c0248m != null) {
            c0248m.collapseActionView();
        }
    }

    protected ay m2201i() {
        return new ay(-2, -2);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1362L);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ag.m640a(motionEvent);
        if (a == 9) {
            this.f1351A = false;
        }
        if (!this.f1351A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1351A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1351A = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = au.m683a(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1353C;
        iArr[1] = 0;
        iArr[0] = 0;
        int f = au.m702f(this);
        if (!m2174b(this.f1368e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m2172b(this.f1368e, i8, iArr, f);
            i5 = paddingLeft;
        } else {
            i5 = m2164a(this.f1368e, paddingLeft, iArr, f);
        }
        if (m2174b(this.f1372i)) {
            if (obj != null) {
                i8 = m2172b(this.f1372i, i8, iArr, f);
            } else {
                i5 = m2164a(this.f1372i, i5, iArr, f);
            }
        }
        if (m2174b(this.f1365b)) {
            if (obj != null) {
                i5 = m2164a(this.f1365b, i5, iArr, f);
            } else {
                i8 = m2172b(this.f1365b, i8, iArr, f);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m2174b(this.f1364a)) {
            if (obj != null) {
                i8 = m2172b(this.f1364a, i8, iArr, f);
            } else {
                i5 = m2164a(this.f1364a, i5, iArr, f);
            }
        }
        if (!m2174b(this.f1369f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m2172b(this.f1369f, i8, iArr, f);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m2164a(this.f1369f, i5, iArr, f);
        }
        boolean b = m2174b(this.f1366c);
        boolean b2 = m2174b(this.f1367d);
        i5 = 0;
        if (b) {
            ay ayVar = (ay) this.f1366c.getLayoutParams();
            i5 = 0 + (ayVar.bottomMargin + (ayVar.topMargin + this.f1366c.getMeasuredHeight()));
        }
        if (b2) {
            ayVar = (ay) this.f1367d.getLayoutParams();
            measuredHeight = (ayVar.bottomMargin + (ayVar.topMargin + this.f1367d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (b || b2) {
            int paddingTop2;
            ayVar = (ay) (b ? this.f1366c : this.f1367d).getLayoutParams();
            ay ayVar2 = (ay) (b2 ? this.f1367d : this.f1366c).getLayoutParams();
            Object obj2 = ((!b || this.f1366c.getMeasuredWidth() <= 0) && (!b2 || this.f1367d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1384u & 112) {
                case C0339o.Theme_homeAsUpIndicator /*48*/:
                    paddingTop2 = (ayVar.topMargin + getPaddingTop()) + this.f1381r;
                    break;
                case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                    paddingTop2 = (((height - paddingBottom) - ayVar2.bottomMargin) - this.f1382s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < ayVar.topMargin + this.f1381r) {
                        i8 = ayVar.topMargin + this.f1381r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < ayVar.bottomMargin + this.f1382s ? Math.max(0, paddingTop2 - ((ayVar2.bottomMargin + this.f1382s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1379p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (b) {
                    ayVar = (ay) this.f1366c.getLayoutParams();
                    measuredWidth = i5 - this.f1366c.getMeasuredWidth();
                    i6 = this.f1366c.getMeasuredHeight() + paddingTop2;
                    this.f1366c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + ayVar.bottomMargin;
                    i6 = measuredWidth - this.f1380q;
                } else {
                    i6 = i5;
                }
                if (b2) {
                    ayVar = (ay) this.f1367d.getLayoutParams();
                    measuredWidth = ayVar.topMargin + paddingTop2;
                    measuredHeight = this.f1367d.getMeasuredHeight() + measuredWidth;
                    this.f1367d.layout(i5 - this.f1367d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = ayVar.bottomMargin + measuredHeight;
                    i8 = i5 - this.f1380q;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.f1379p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (b) {
                    ayVar = (ay) this.f1366c.getLayoutParams();
                    i5 = this.f1366c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1366c.getMeasuredHeight() + paddingTop2;
                    this.f1366c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = ayVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1380q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (b2) {
                    ayVar = (ay) this.f1367d.getLayoutParams();
                    i5 += ayVar.topMargin;
                    paddingTop2 = this.f1367d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1367d.getMeasuredHeight() + i5;
                    this.f1367d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = ayVar.bottomMargin + measuredHeight;
                    i8 = this.f1380q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m2170a(this.f1352B, 3);
        int size = this.f1352B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m2164a((View) this.f1352B.get(measuredWidth), i5, iArr, f);
        }
        m2170a(this.f1352B, 5);
        i7 = this.f1352B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m2172b((View) this.f1352B.get(measuredWidth), i6, iArr, f);
        }
        m2170a(this.f1352B, 1);
        measuredWidth = m2165a(this.f1352B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1352B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m2164a((View) this.f1352B.get(i5), measuredWidth, iArr, f);
        }
        this.f1352B.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1353C;
        if (bq.m2069a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m2174b(this.f1368e)) {
            m2169a(this.f1368e, i, 0, i2, 0, this.f1378o);
            i7 = this.f1368e.getMeasuredWidth() + m2175c(this.f1368e);
            max = Math.max(0, this.f1368e.getMeasuredHeight() + m2178d(this.f1368e));
            i6 = bq.m2067a(0, au.m692b(this.f1368e));
            i5 = max;
        }
        if (m2174b(this.f1372i)) {
            m2169a(this.f1372i, i, 0, i2, 0, this.f1378o);
            i7 = this.f1372i.getMeasuredWidth() + m2175c(this.f1372i);
            i5 = Math.max(i5, this.f1372i.getMeasuredHeight() + m2178d(this.f1372i));
            i6 = bq.m2067a(i6, au.m692b(this.f1372i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m2174b(this.f1365b)) {
            m2169a(this.f1365b, i, max2, i2, 0, this.f1378o);
            i7 = this.f1365b.getMeasuredWidth() + m2175c(this.f1365b);
            i5 = Math.max(i5, this.f1365b.getMeasuredHeight() + m2178d(this.f1365b));
            i6 = bq.m2067a(i6, au.m692b(this.f1365b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m2174b(this.f1364a)) {
            max2 += m2163a(this.f1364a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1364a.getMeasuredHeight() + m2178d(this.f1364a));
            i6 = bq.m2067a(i6, au.m692b(this.f1364a));
        }
        if (m2174b(this.f1369f)) {
            max2 += m2163a(this.f1369f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1369f.getMeasuredHeight() + m2178d(this.f1369f));
            i6 = bq.m2067a(i6, au.m692b(this.f1369f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((ay) childAt.getLayoutParams()).f1456b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m2174b(childAt)) {
                max2 += m2163a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m2178d(childAt));
                i7 = bq.m2067a(i5, au.m692b(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f1381r + this.f1382s;
        max = this.f1379p + this.f1380q;
        if (m2174b(this.f1366c)) {
            m2163a(this.f1366c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m2175c(this.f1366c) + this.f1366c.getMeasuredWidth();
            i7 = this.f1366c.getMeasuredHeight() + m2178d(this.f1366c);
            i5 = bq.m2067a(i5, au.m692b(this.f1366c));
        }
        if (m2174b(this.f1367d)) {
            contentInsetStart = Math.max(contentInsetStart, m2163a(this.f1367d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1367d.getMeasuredHeight() + m2178d(this.f1367d);
            i5 = bq.m2067a(i5, au.m692b(this.f1367d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = au.m682a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = au.m682a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m2186p()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        ba baVar = (ba) parcelable;
        super.onRestoreInstanceState(baVar.getSuperState());
        Menu d = this.f1365b != null ? this.f1365b.m2127d() : null;
        if (!(baVar.f1457a == 0 || this.f1358H == null || d == null)) {
            MenuItem findItem = d.findItem(baVar.f1457a);
            if (findItem != null) {
                C0141y.m973b(findItem);
            }
        }
        if (baVar.f1458b) {
            m2185o();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ao aoVar = this.f1383t;
        if (i != 1) {
            z = false;
        }
        aoVar.m1877a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable baVar = new ba(super.onSaveInstanceState());
        if (!(this.f1358H == null || this.f1358H.f1454b == null)) {
            baVar.f1457a = this.f1358H.f1454b.getItemId();
        }
        baVar.f1458b = m2194b();
        return baVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ag.m640a(motionEvent);
        if (a == 0) {
            this.f1389z = false;
        }
        if (!this.f1389z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1389z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1389z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f1361K = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.f1363M.m1991a(i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2180j();
            if (this.f1369f.getParent() == null) {
                m2168a(this.f1369f);
                m2179e(this.f1369f);
            }
        } else if (!(this.f1369f == null || this.f1369f.getParent() == null)) {
            removeView(this.f1369f);
        }
        if (this.f1369f != null) {
            this.f1369f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2180j();
        }
        if (this.f1369f != null) {
            this.f1369f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2183m();
        }
        if (this.f1368e != null) {
            this.f1368e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1363M.m1991a(i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2183m();
            if (this.f1368e.getParent() == null) {
                m2168a(this.f1368e);
                m2179e(this.f1368e);
            }
        } else if (!(this.f1368e == null || this.f1368e.getParent() == null)) {
            removeView(this.f1368e);
        }
        if (this.f1368e != null) {
            this.f1368e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m2183m();
        this.f1368e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(az azVar) {
        this.f1354D = azVar;
    }

    public void setPopupTheme(int i) {
        if (this.f1374k != i) {
            this.f1374k = i;
            if (i == 0) {
                this.f1373j = getContext();
            } else {
                this.f1373j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1367d == null) {
                Context context = getContext();
                this.f1367d = new TextView(context);
                this.f1367d.setSingleLine();
                this.f1367d.setEllipsize(TruncateAt.END);
                if (this.f1376m != 0) {
                    this.f1367d.setTextAppearance(context, this.f1376m);
                }
                if (this.f1388y != 0) {
                    this.f1367d.setTextColor(this.f1388y);
                }
            }
            if (this.f1367d.getParent() == null) {
                m2168a(this.f1367d);
                m2179e(this.f1367d);
            }
        } else if (!(this.f1367d == null || this.f1367d.getParent() == null)) {
            removeView(this.f1367d);
        }
        if (this.f1367d != null) {
            this.f1367d.setText(charSequence);
        }
        this.f1386w = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f1388y = i;
        if (this.f1367d != null) {
            this.f1367d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1366c == null) {
                Context context = getContext();
                this.f1366c = new TextView(context);
                this.f1366c.setSingleLine();
                this.f1366c.setEllipsize(TruncateAt.END);
                if (this.f1375l != 0) {
                    this.f1366c.setTextAppearance(context, this.f1375l);
                }
                if (this.f1387x != 0) {
                    this.f1366c.setTextColor(this.f1387x);
                }
            }
            if (this.f1366c.getParent() == null) {
                m2168a(this.f1366c);
                m2179e(this.f1366c);
            }
        } else if (!(this.f1366c == null || this.f1366c.getParent() == null)) {
            removeView(this.f1366c);
        }
        if (this.f1366c != null) {
            this.f1366c.setText(charSequence);
        }
        this.f1385v = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f1387x = i;
        if (this.f1366c != null) {
            this.f1366c.setTextColor(i);
        }
    }
}
