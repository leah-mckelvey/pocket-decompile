package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.p000h.C0121d;
import android.support.v4.p000h.an;
import android.support.v4.p000h.au;
import android.support.v4.p000h.cn;
import android.support.v4.p001b.C0034a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.pocket.doorway.C0339o;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.design.widget.b */
public class C0009b extends ViewGroup {
    static final String f24a;
    static final Class[] f25b;
    static final ThreadLocal f26c;
    static final Comparator f27e;
    static final C0017j f28f;
    final Comparator f29d;
    private final List f30g;
    private final List f31h;
    private final Rect f32i;
    private final Rect f33j;
    private final Rect f34k;
    private final int[] f35l;
    private Paint f36m;
    private boolean f37n;
    private int[] f38o;
    private View f39p;
    private View f40q;
    private View f41r;
    private C0013f f42s;
    private boolean f43t;
    private cn f44u;
    private boolean f45v;
    private Drawable f46w;
    private final an f47x;

    static {
        f24a = C0009b.class.getPackage().getName();
        if (VERSION.SDK_INT >= 21) {
            f27e = new C0016i();
            f28f = new C0018k();
        } else {
            f27e = null;
            f28f = null;
        }
        f25b = new Class[]{Context.class, AttributeSet.class};
        f26c = new ThreadLocal();
    }

    private int m31a(int i) {
        if (this.f38o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f38o.length) {
            return this.f38o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static C0010c m32a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            str = f24a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f26c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f26c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f25b);
                map.put(str, constructor);
            }
            return (C0010c) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private void m33a(cn cnVar) {
        if (!cnVar.m931e()) {
            int childCount = getChildCount();
            cn cnVar2 = cnVar;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (au.m706j(childAt)) {
                    cn a;
                    C0010c a2 = ((C0012e) childAt.getLayoutParams()).m85a();
                    if (a2 != null) {
                        a = a2.m63a(this, childAt, cnVar2);
                        if (a.m931e()) {
                            return;
                        }
                    }
                    a = cnVar2;
                    cnVar2 = au.m693b(childAt, a);
                    if (cnVar2.m931e()) {
                        return;
                    }
                }
            }
        }
    }

    private void m34a(View view, View view2, int i) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        Rect rect = this.f32i;
        Rect rect2 = this.f33j;
        m51a(view2, rect);
        m50a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m35a(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f27e != null) {
            Collections.sort(list, f27e);
        }
    }

    private boolean m36a(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f31h;
        m35a(list);
        int size = list.size();
        int i = 0;
        while (i < size) {
            Object obj2;
            View view = (View) list.get(i);
            C0012e c0012e = (C0012e) view.getLayoutParams();
            C0010c a = c0012e.m85a();
            if ((!z2 && obj == null) || actionMasked == 0) {
                if (z2 || a == null) {
                    z = z2;
                } else {
                    z2 = a.m69a(this, view, motionEvent);
                    if (z2) {
                        this.f39p = view;
                    }
                    z = z2;
                }
                boolean d = c0012e.m96d();
                boolean a2 = c0012e.m89a(this, view);
                obj2 = (!a2 || d) ? null : 1;
                if (a2 && obj2 == null) {
                    break;
                }
            } else if (a != null) {
                MotionEvent obtain;
                if (motionEvent2 != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    obtain = motionEvent2;
                }
                a.m69a(this, view, obtain);
                motionEvent2 = obtain;
                z = z2;
                obj2 = obj;
            } else {
                obj2 = obj;
                z = z2;
            }
            i++;
            obj = obj2;
            z2 = z;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int m37b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private void m38b(View view, int i, int i2) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        int a = C0121d.m939a(C0009b.m39c(c0012e.f50c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m31a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case C0339o.View_android_focusable /*1*/:
                a2 += measuredWidth / 2;
                break;
            case C0339o.View_backgroundTint /*5*/:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case C0339o.Toolbar_maxButtonHeight /*16*/:
                a = 0 + (measuredHeight / 2);
                break;
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + c0012e.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - c0012e.rightMargin));
        int max = Math.max(getPaddingTop() + c0012e.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0012e.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private static int m39c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m40c(View view, int i) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        Rect rect = this.f32i;
        rect.set(getPaddingLeft() + c0012e.leftMargin, getPaddingTop() + c0012e.topMargin, (getWidth() - getPaddingRight()) - c0012e.rightMargin, (getHeight() - getPaddingBottom()) - c0012e.bottomMargin);
        if (!(this.f44u == null || !au.m706j(this) || au.m706j(view))) {
            rect.left += this.f44u.m926a();
            rect.top += this.f44u.m928b();
            rect.right -= this.f44u.m929c();
            rect.bottom -= this.f44u.m930d();
        }
        Rect rect2 = this.f33j;
        C0121d.m940a(C0009b.m37b(c0012e.f50c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m41d(int i) {
        return i == 0 ? 17 : i;
    }

    private void m42e() {
        int i = 0;
        if (this.f39p != null) {
            C0010c a = ((C0012e) this.f39p.getLayoutParams()).m85a();
            if (a != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                a.m76b(this, this.f39p, obtain);
                obtain.recycle();
            }
            this.f39p = null;
        }
        int childCount = getChildCount();
        while (i < childCount) {
            ((C0012e) getChildAt(i).getLayoutParams()).m97e();
            i++;
        }
    }

    private void m43f() {
        int i = 0;
        int childCount = getChildCount();
        int i2 = this.f30g.size() != childCount ? 1 : 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0012e a = m45a(childAt);
            if (i2 == 0 && a.m95c(this, childAt)) {
                i2 = 1;
            }
            a.m92b(this, childAt);
        }
        if (i2 != 0) {
            this.f30g.clear();
            while (i < childCount) {
                this.f30g.add(getChildAt(i));
                i++;
            }
            Collections.sort(this.f30g, this.f29d);
        }
    }

    private void setWindowInsets(cn cnVar) {
        boolean z = true;
        if (this.f44u != cnVar) {
            this.f44u = cnVar;
            boolean z2 = cnVar != null && cnVar.m928b() > 0;
            this.f45v = z2;
            if (this.f45v || getBackground() != null) {
                z = false;
            }
            setWillNotDraw(z);
            m33a(cnVar);
            requestLayout();
        }
    }

    public C0012e m44a(AttributeSet attributeSet) {
        return new C0012e(getContext(), attributeSet);
    }

    C0012e m45a(View view) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        if (!c0012e.f49b) {
            C0011d c0011d = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0011d = (C0011d) cls.getAnnotation(C0011d.class);
                if (c0011d != null) {
                    break;
                }
            }
            C0011d c0011d2 = c0011d;
            if (c0011d2 != null) {
                try {
                    c0012e.m87a((C0010c) c0011d2.m82a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0011d2.m82a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0012e.f49b = true;
        }
        return c0012e;
    }

    protected C0012e m46a(LayoutParams layoutParams) {
        return layoutParams instanceof C0012e ? new C0012e((C0012e) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0012e((MarginLayoutParams) layoutParams) : new C0012e(layoutParams);
    }

    void m47a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m58b(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f43t) {
            return;
        }
        if (z) {
            m55b();
        } else {
            m59c();
        }
    }

    public void m48a(View view, int i) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        if (c0012e.m94c()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0012e.f54g != null) {
            m34a(view, c0012e.f54g, i);
        } else if (c0012e.f52e >= 0) {
            m38b(view, c0012e.f52e, i);
        } else {
            m40c(view, i);
        }
    }

    public void m49a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m50a(View view, int i, Rect rect, Rect rect2) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        int a = C0121d.m939a(C0009b.m41d(c0012e.f50c), i);
        int a2 = C0121d.m939a(C0009b.m37b(c0012e.f51d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case C0339o.View_android_focusable /*1*/:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case C0339o.View_backgroundTint /*5*/:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case C0339o.Toolbar_maxButtonHeight /*16*/:
                a = rect.top + (rect.height() / 2);
                break;
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case C0339o.View_android_focusable /*1*/:
                a2 -= measuredWidth / 2;
                break;
            case C0339o.View_backgroundTint /*5*/:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case C0339o.Toolbar_maxButtonHeight /*16*/:
                a -= measuredHeight / 2;
                break;
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + c0012e.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - c0012e.rightMargin));
        int max = Math.max(getPaddingTop() + c0012e.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - c0012e.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    void m51a(View view, Rect rect) {
        ac.m25b(this, view, rect);
    }

    void m52a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m51a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m53a(boolean z) {
        int a = au.m683a(this);
        int size = this.f30g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f30g.get(i);
            C0012e c0012e = (C0012e) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (c0012e.f55h == ((View) this.f30g.get(i2))) {
                    m56b(view, a);
                }
            }
            Rect rect = this.f32i;
            Rect rect2 = this.f33j;
            m60c(view, rect);
            m52a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m57b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f30g.get(i2);
                    C0012e c0012e2 = (C0012e) view2.getLayoutParams();
                    C0010c a2 = c0012e2.m85a();
                    if (a2 != null && a2.m70a(this, view2, view)) {
                        if (z || !c0012e2.m100h()) {
                            boolean b = a2.m77b(this, view2, view);
                            if (z) {
                                c0012e2.m93b(b);
                            }
                        } else {
                            c0012e2.m101i();
                        }
                    }
                }
            }
        }
    }

    public boolean m54a(View view, int i, int i2) {
        Rect rect = this.f32i;
        m51a(view, rect);
        return rect.contains(i, i2);
    }

    void m55b() {
        if (this.f37n) {
            if (this.f42s == null) {
                this.f42s = new C0013f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f42s);
        }
        this.f43t = true;
    }

    void m56b(View view, int i) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        if (c0012e.f54g != null) {
            Rect rect = this.f32i;
            Rect rect2 = this.f33j;
            Rect rect3 = this.f34k;
            m51a(c0012e.f54g, rect);
            m52a(view, false, rect2);
            m50a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                C0010c a = c0012e.m85a();
                if (a != null) {
                    a.m77b(this, view, c0012e.f54g);
                }
            }
        }
    }

    void m57b(View view, Rect rect) {
        ((C0012e) view.getLayoutParams()).m86a(rect);
    }

    boolean m58b(View view) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        if (c0012e.f54g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0012e.m90a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    void m59c() {
        if (this.f37n && this.f42s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f42s);
        }
        this.f43t = false;
    }

    void m60c(View view, Rect rect) {
        rect.set(((C0012e) view.getLayoutParams()).m91b());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0012e) && super.checkLayoutParams(layoutParams);
    }

    protected C0012e m61d() {
        return new C0012e(-2, -2);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0012e c0012e = (C0012e) view.getLayoutParams();
        if (c0012e.f48a != null && c0012e.f48a.m74b(this, view) > 0.0f) {
            if (this.f36m == null) {
                this.f36m = new Paint();
            }
            this.f36m.setColor(c0012e.f48a.m62a(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f36m);
        }
        return super.drawChild(canvas, view, j);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m61d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m44a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m46a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.f47x.m667a();
    }

    public Drawable getStatusBarBackground() {
        return this.f46w;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m42e();
        if (this.f43t) {
            if (this.f42s == null) {
                this.f42s = new C0013f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f42s);
        }
        this.f37n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m42e();
        if (this.f43t && this.f42s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f42s);
        }
        if (this.f41r != null) {
            onStopNestedScroll(this.f41r);
        }
        this.f37n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f45v && this.f46w != null) {
            int b = this.f44u != null ? this.f44u.m928b() : 0;
            if (b > 0) {
                this.f46w.setBounds(0, 0, getWidth(), b);
                this.f46w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m42e();
        }
        boolean a = m36a(motionEvent);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            m42e();
        }
        return a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int a = au.m683a(this);
        int size = this.f30g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f30g.get(i5);
            C0010c a2 = ((C0012e) view.getLayoutParams()).m85a();
            if (a2 == null || !a2.m67a(this, view, a)) {
                m48a(view, a);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m43f();
        m47a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int a = au.m683a(this);
        Object obj = a == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (this.f44u == null || !au.m706j(this)) ? null : 1;
        int size3 = this.f30g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f30g.get(i5);
            C0012e c0012e = (C0012e) view.getLayoutParams();
            int i10 = 0;
            if (c0012e.f52e >= 0 && mode != 0) {
                int a2 = m31a(c0012e.f52e);
                paddingTop = C0121d.m939a(C0009b.m39c(c0012e.f50c), a) & 7;
                if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a2);
                } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                    i10 = Math.max(0, a2 - paddingLeft);
                }
            }
            if (obj2 == null || au.m706j(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f44u.m928b() + this.f44u.m930d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f44u.m926a() + this.f44u.m929c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            C0010c a3 = c0012e.m85a();
            if (a3 == null || !a3.m68a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m49a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + c0012e.leftMargin) + c0012e.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + c0012e.topMargin) + c0012e.bottomMargin);
            i5++;
            i6 = au.m681a(i6, au.m692b(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(au.m682a(i8, i, -16777216 & i6), au.m682a(i7, i2, i6 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a2 = c0012e.m85a();
                a = a2 != null ? a2.m72a(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m53a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a2 = c0012e.m85a();
                a = a2 != null ? a2.m71a(this, childAt, view, f, f2) | z : z;
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a = c0012e.m85a();
                if (a != null) {
                    int[] iArr2 = this.f35l;
                    this.f35l[1] = 0;
                    iArr2[0] = 0;
                    a.m66a(this, childAt, view, i, i2, this.f35l);
                    max = i > 0 ? Math.max(i3, this.f35l[0]) : Math.min(i3, this.f35l[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f35l[1]) : Math.min(i4, this.f35l[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m53a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a = c0012e.m85a();
                if (a != null) {
                    a.m65a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m53a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f47x.m669a(view, view2, i);
        this.f40q = view;
        this.f41r = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a = c0012e.m85a();
                if (a != null) {
                    a.m75b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        C0014g c0014g = (C0014g) parcelable;
        super.onRestoreInstanceState(c0014g.getSuperState());
        SparseArray sparseArray = c0014g.f62a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0010c a = m45a(childAt).m85a();
            if (!(id == -1 || a == null)) {
                Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                if (parcelable2 != null) {
                    a.m64a(this, childAt, parcelable2);
                }
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0014g = new C0014g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0010c a = ((C0012e) childAt.getLayoutParams()).m85a();
            if (!(id == -1 || a == null)) {
                Parcelable e = a.m81e(this, childAt);
                if (e != null) {
                    sparseArray.append(id, e);
                }
            }
        }
        c0014g.f62a = sparseArray;
        return c0014g;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            C0010c a = c0012e.m85a();
            if (a != null) {
                boolean a2 = a.m73a(this, childAt, view, view2, i);
                z2 = z | a2;
                c0012e.m88a(a2);
            } else {
                c0012e.m88a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f47x.m668a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0012e c0012e = (C0012e) childAt.getLayoutParams();
            if (c0012e.m99g()) {
                C0010c a = c0012e.m85a();
                if (a != null) {
                    a.m78c(this, childAt, view);
                }
                c0012e.m98f();
                c0012e.m101i();
            }
        }
        this.f40q = null;
        this.f41r = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        MotionEvent obtain;
        if (this.f39p == null) {
            boolean a = m36a(motionEvent);
            if (a) {
                z = a;
            } else {
                z = a;
                if (this.f39p == null) {
                    z2 = false | super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (null == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z2 || actionMasked == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (actionMasked == 1 || actionMasked == 3) {
                        m42e();
                    }
                    return z2;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m42e();
                return z2;
            }
        }
        z = false;
        C0010c a2 = ((C0012e) this.f39p.getLayoutParams()).m85a();
        if (a2 != null) {
            a2.m76b(this, this.f39p, motionEvent);
        }
        if (this.f39p == null) {
            z2 = false | super.onTouchEvent(motionEvent);
        } else if (z) {
            if (null == null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z2) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m42e();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m42e();
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f46w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0034a.m179a(getContext(), i) : null);
    }
}
