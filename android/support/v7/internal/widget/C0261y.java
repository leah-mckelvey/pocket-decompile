package android.support.v7.internal.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* renamed from: android.support.v7.internal.widget.y */
public abstract class C0261y extends ViewGroup {
    int f1104A;
    int f1105B;
    long f1106C;
    boolean f1107D;
    private int f1108a;
    private View f1109b;
    private boolean f1110c;
    private boolean f1111d;
    private ae f1112e;
    @ExportedProperty(category = "scrolling")
    int f1113j;
    int f1114k;
    int f1115l;
    long f1116m;
    long f1117n;
    boolean f1118o;
    int f1119p;
    boolean f1120q;
    ad f1121r;
    ab f1122s;
    ac f1123t;
    boolean f1124u;
    @ExportedProperty(category = "list")
    int f1125v;
    long f1126w;
    @ExportedProperty(category = "list")
    int f1127x;
    long f1128y;
    @ExportedProperty(category = "list")
    int f1129z;

    C0261y(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1113j = 0;
        this.f1116m = Long.MIN_VALUE;
        this.f1118o = false;
        this.f1120q = false;
        this.f1125v = -1;
        this.f1126w = Long.MIN_VALUE;
        this.f1127x = -1;
        this.f1128y = Long.MIN_VALUE;
        this.f1105B = -1;
        this.f1106C = Long.MIN_VALUE;
        this.f1107D = false;
    }

    private void m1895a() {
        if (this.f1121r != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                View selectedView = getSelectedView();
                this.f1121r.m1836a(this, selectedView, selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.f1121r.m1835a(this);
        }
    }

    private void m1897a(boolean z) {
        if (m1902d()) {
            z = false;
        }
        if (z) {
            if (this.f1109b != null) {
                this.f1109b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f1124u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f1109b != null) {
            this.f1109b.setVisibility(8);
        }
        setVisibility(0);
    }

    public long m1899a(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    public boolean m1900a(View view, int i, long j) {
        if (this.f1122s == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f1122s.m1834a(this, view, i, j);
        return true;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    int m1901b(int i, boolean z) {
        return i;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.f1129z > 0;
    }

    boolean m1902d() {
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    void m1903e() {
        boolean z = false;
        Adapter adapter = getAdapter();
        boolean z2 = adapter == null || adapter.getCount() == 0;
        boolean z3 = !z2 || m1902d();
        z2 = z3 && this.f1111d;
        super.setFocusableInTouchMode(z2);
        z2 = z3 && this.f1110c;
        super.setFocusable(z2);
        if (this.f1109b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            m1897a(z);
        }
    }

    void m1904f() {
        if (this.f1121r != null) {
            if (this.f1120q || this.f1107D) {
                if (this.f1112e == null) {
                    this.f1112e = new ae();
                }
                post(this.f1112e);
            } else {
                m1895a();
            }
        }
        if (this.f1127x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    void m1905g() {
        boolean z;
        int i = this.f1129z;
        if (i > 0) {
            int i2;
            boolean z2;
            if (this.f1118o) {
                this.f1118o = false;
                i2 = m1907i();
                if (i2 >= 0 && m1901b(i2, true) == i2) {
                    setNextSelectedPositionInt(i2);
                    z2 = true;
                    if (!z2) {
                        i2 = getSelectedItemPosition();
                        if (i2 >= i) {
                            i2 = i - 1;
                        }
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        i = m1901b(i2, true);
                        i2 = i >= 0 ? m1901b(i2, false) : i;
                        if (i2 >= 0) {
                            setNextSelectedPositionInt(i2);
                            m1906h();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                i2 = getSelectedItemPosition();
                if (i2 >= i) {
                    i2 = i - 1;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                i = m1901b(i2, true);
                if (i >= 0) {
                }
                if (i2 >= 0) {
                    setNextSelectedPositionInt(i2);
                    m1906h();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.f1127x = -1;
            this.f1128y = Long.MIN_VALUE;
            this.f1125v = -1;
            this.f1126w = Long.MIN_VALUE;
            this.f1118o = false;
            m1906h();
        }
    }

    public abstract Adapter getAdapter();

    @CapturedViewProperty
    public int getCount() {
        return this.f1129z;
    }

    public View getEmptyView() {
        return this.f1109b;
    }

    public int getFirstVisiblePosition() {
        return this.f1113j;
    }

    public int getLastVisiblePosition() {
        return (this.f1113j + getChildCount()) - 1;
    }

    public final ab getOnItemClickListener() {
        return this.f1122s;
    }

    public final ac getOnItemLongClickListener() {
        return this.f1123t;
    }

    public final ad getOnItemSelectedListener() {
        return this.f1121r;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        return (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) ? null : adapter.getItem(selectedItemPosition);
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.f1126w;
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f1125v;
    }

    public abstract View getSelectedView();

    void m1906h() {
        if (this.f1127x != this.f1105B || this.f1128y != this.f1106C) {
            m1904f();
            this.f1105B = this.f1127x;
            this.f1106C = this.f1128y;
        }
    }

    int m1907i() {
        int i = this.f1129z;
        if (i == 0) {
            return -1;
        }
        long j = this.f1116m;
        int i2 = this.f1115l;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        i2 = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = i2;
        int i4 = i2;
        int i5 = i2;
        i2 = 0;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i5) != j) {
                int i6 = i3 == i + -1 ? 1 : 0;
                int i7 = i4 == 0 ? 1 : 0;
                if (i6 != 0 && i7 != 0) {
                    break;
                } else if (i7 != 0 || (r0 != 0 && i6 == 0)) {
                    i2 = i3 + 1;
                    i3 = i2;
                    i5 = i2;
                    i2 = 0;
                } else if (i6 != 0 || (r0 == 0 && i7 == 0)) {
                    i2 = i4 - 1;
                    i4 = i2;
                    i5 = i2;
                    i2 = 1;
                }
            } else {
                return i5;
            }
        }
        return -1;
    }

    void m1908j() {
        if (getChildCount() > 0) {
            this.f1118o = true;
            this.f1117n = (long) this.f1108a;
            View childAt;
            if (this.f1127x >= 0) {
                childAt = getChildAt(this.f1127x - this.f1113j);
                this.f1116m = this.f1126w;
                this.f1115l = this.f1125v;
                if (childAt != null) {
                    this.f1114k = childAt.getTop();
                }
                this.f1119p = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.f1113j < 0 || this.f1113j >= adapter.getCount()) {
                this.f1116m = -1;
            } else {
                this.f1116m = adapter.getItemId(this.f1113j);
            }
            this.f1115l = this.f1113j;
            if (childAt != null) {
                this.f1114k = childAt.getTop();
            }
            this.f1119p = 1;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1112e);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1108a = getHeight();
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view) {
        this.f1109b = view;
        Adapter adapter = getAdapter();
        boolean z = adapter == null || adapter.isEmpty();
        m1897a(z);
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f1110c = z;
        if (!z) {
            this.f1111d = false;
        }
        if (!z || (z3 && !m1902d())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f1111d = z;
        if (z) {
            this.f1110c = true;
        }
        if (!z || (z3 && !m1902d())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    void setNextSelectedPositionInt(int i) {
        this.f1125v = i;
        this.f1126w = m1899a(i);
        if (this.f1118o && this.f1119p == 0 && i >= 0) {
            this.f1115l = i;
            this.f1116m = this.f1126w;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(ab abVar) {
        this.f1122s = abVar;
    }

    public void setOnItemLongClickListener(ac acVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f1123t = acVar;
    }

    public void setOnItemSelectedListener(ad adVar) {
        this.f1121r = adVar;
    }

    void setSelectedPositionInt(int i) {
        this.f1127x = i;
        this.f1128y = m1899a(i);
    }

    public abstract void setSelection(int i);
}
