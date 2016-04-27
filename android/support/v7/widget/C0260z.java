package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p000h.C0121d;
import android.support.v4.p000h.au;
import android.support.v7.internal.widget.bk;
import android.support.v7.internal.widget.bq;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v7.widget.z */
public class C0260z extends ViewGroup {
    private boolean f1011a;
    private int f1012b;
    private int f1013c;
    private int f1014d;
    private int f1015e;
    private int f1016f;
    private float f1017g;
    private boolean f1018h;
    private int[] f1019i;
    private int[] f1020j;
    private Drawable f1021k;
    private int f1022l;
    private int f1023m;
    private int f1024n;
    private int f1025o;

    public C0260z(Context context) {
        this(context, null);
    }

    public C0260z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0260z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1011a = true;
        this.f1012b = -1;
        this.f1013c = 0;
        this.f1015e = 8388659;
        bk a = bk.m2000a(context, attributeSet, C0210l.LinearLayoutCompat, i, 0);
        int a2 = a.m2003a(C0210l.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m2003a(C0210l.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m2005a(C0210l.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f1017g = a.m2001a(C0210l.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1012b = a.m2003a(C0210l.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1018h = a.m2005a(C0210l.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m2004a(C0210l.LinearLayoutCompat_divider));
        this.f1024n = a.m2003a(C0210l.LinearLayoutCompat_showDividers, 0);
        this.f1025o = a.m2012d(C0210l.LinearLayoutCompat_dividerPadding, 0);
        a.m2008b();
    }

    private void m1797a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void m1798c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1810b(i3);
            if (b.getVisibility() != 8) {
                aa aaVar = (aa) b.getLayoutParams();
                if (aaVar.width == -1) {
                    int i4 = aaVar.height;
                    aaVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aaVar.height = i4;
                }
            }
        }
    }

    private void m1799d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1810b(i3);
            if (b.getVisibility() != 8) {
                aa aaVar = (aa) b.getLayoutParams();
                if (aaVar.height == -1) {
                    int i4 = aaVar.width;
                    aaVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aaVar.width = i4;
                }
            }
        }
    }

    int m1800a(View view) {
        return 0;
    }

    int m1801a(View view, int i) {
        return 0;
    }

    void m1802a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        View b;
        this.f1016f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i10 = this.f1012b;
        boolean z = this.f1018h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj5;
            int i13;
            View b2 = m1810b(i12);
            if (b2 == null) {
                this.f1016f += m1816d(i12);
                i3 = i11;
                obj5 = obj4;
                obj = obj2;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += m1801a(b2, i12);
                i3 = i11;
                obj5 = obj4;
                obj = obj2;
                i4 = i7;
                i13 = i6;
            } else {
                if (m1815c(i12)) {
                    this.f1016f += this.f1023m;
                }
                aa aaVar = (aa) b2.getLayoutParams();
                float f2 = f + aaVar.f1409g;
                if (mode2 == 1073741824 && aaVar.height == 0 && aaVar.f1409g > 0.0f) {
                    i3 = this.f1016f;
                    this.f1016f = Math.max(i3, (aaVar.topMargin + i3) + aaVar.bottomMargin);
                    obj4 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aaVar.height == 0 && aaVar.f1409g > 0.0f) {
                        i3 = 0;
                        aaVar.height = -2;
                    }
                    int i14 = i3;
                    m1806a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f1016f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        aaVar.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f1016f;
                    this.f1016f = Math.max(i15, (((i15 + i3) + aaVar.topMargin) + aaVar.bottomMargin) + m1807b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.f1013c = this.f1016f;
                }
                if (i12 >= i10 || aaVar.f1409g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || aaVar.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = aaVar.rightMargin + aaVar.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int a = bq.m2067a(i7, au.m692b(b2));
                    obj = (obj2 == null || aaVar.width != -1) ? null : 1;
                    if (aaVar.f1409g > 0.0f) {
                        i3 = Math.max(i9, obj7 != null ? i4 : i13);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += m1801a(b2, i12);
                    obj5 = obj4;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = a;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj4 = obj5;
            obj2 = obj;
            i7 = i4;
            i6 = i13;
        }
        if (this.f1016f > 0 && m1815c(virtualChildCount)) {
            this.f1016f += this.f1023m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1016f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = m1810b(i5);
                if (b == null) {
                    this.f1016f += m1816d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = m1801a(b, i5) + i5;
                } else {
                    aa aaVar2 = (aa) b.getLayoutParams();
                    int i16 = this.f1016f;
                    this.f1016f = Math.max(i16, (aaVar2.bottomMargin + ((i16 + i11) + aaVar2.topMargin)) + m1807b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f1016f += getPaddingTop() + getPaddingBottom();
        int a2 = au.m682a(Math.max(this.f1016f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a2) - this.f1016f;
        int i17;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f1017g > 0.0f) {
                f = this.f1017g;
            }
            this.f1016f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = m1810b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    aaVar2 = (aa) b3.getLayoutParams();
                    float f6 = aaVar2.f1409g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = C0260z.getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + aaVar2.leftMargin) + aaVar2.rightMargin, aaVar2.width);
                        if (aaVar2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = bq.m2067a(i16, au.m692b(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = aaVar2.leftMargin + aaVar2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || aaVar2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj = (obj8 == null || aaVar2.width != -1) ? null : 1;
                    i13 = this.f1016f;
                    this.f1016f = Math.max(i13, (aaVar2.bottomMargin + ((b3.getMeasuredHeight() + i13) + aaVar2.topMargin)) + m1807b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj;
                i16 = i5;
            }
            this.f1016f += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = m1810b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((aa) b.getLayoutParams()).f1409g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(au.m682a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a2);
        if (obj3 != null) {
            m1798c(virtualChildCount, i2);
        }
    }

    void m1803a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f1015e & 8388615;
        switch (this.f1015e & 112) {
            case C0339o.Toolbar_maxButtonHeight /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.f1016f) / 2);
                break;
            case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f1016f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m1810b(i7);
            if (b == null) {
                i8 += m1816d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                aa aaVar = (aa) b.getLayoutParams();
                i5 = aaVar.f1410h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0121d.m939a(i5, au.m683a(this)) & 7) {
                    case C0339o.View_android_focusable /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aaVar.leftMargin) - aaVar.rightMargin;
                        break;
                    case C0339o.View_backgroundTint /*5*/:
                        i9 = (paddingRight - measuredWidth) - aaVar.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + aaVar.leftMargin;
                        break;
                }
                int i10 = (m1815c(i7) ? this.f1023m + i8 : i8) + aaVar.topMargin;
                m1797a(b, i9, i10 + m1800a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((aaVar.bottomMargin + measuredHeight) + m1807b(b));
                i5 = m1801a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m1804a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m1810b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1815c(i))) {
                m1805a(canvas, (b.getTop() - ((aa) b.getLayoutParams()).topMargin) - this.f1023m);
            }
            i++;
        }
        if (m1815c(virtualChildCount)) {
            int height;
            View b2 = m1810b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f1023m;
            } else {
                aa aaVar = (aa) b2.getLayoutParams();
                height = aaVar.bottomMargin + b2.getBottom();
            }
            m1805a(canvas, height);
        }
    }

    void m1805a(Canvas canvas, int i) {
        this.f1021k.setBounds(getPaddingLeft() + this.f1025o, i, (getWidth() - getPaddingRight()) - this.f1025o, this.f1023m + i);
        this.f1021k.draw(canvas);
    }

    void m1806a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m1807b(View view) {
        return 0;
    }

    public aa m1808b(AttributeSet attributeSet) {
        return new aa(getContext(), attributeSet);
    }

    protected aa m1809b(LayoutParams layoutParams) {
        return new aa(layoutParams);
    }

    View m1810b(int i) {
        return getChildAt(i);
    }

    void m1811b(int i, int i2) {
        int i3;
        int i4;
        aa aaVar;
        this.f1016f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.f1019i == null || this.f1020j == null) {
            this.f1019i = new int[4];
            this.f1020j = new int[4];
        }
        int[] iArr = this.f1019i;
        int[] iArr2 = this.f1020j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f1011a;
        boolean z2 = this.f1018h;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = m1810b(i10);
            if (b == null) {
                this.f1016f += m1816d(i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m1801a(b, i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m1815c(i10)) {
                    this.f1016f += this.f1022l;
                }
                aa aaVar2 = (aa) b.getLayoutParams();
                float f2 = f + aaVar2.f1409g;
                if (mode == 1073741824 && aaVar2.width == 0 && aaVar2.f1409g > 0.0f) {
                    if (obj4 != null) {
                        this.f1016f += aaVar2.leftMargin + aaVar2.rightMargin;
                    } else {
                        i3 = this.f1016f;
                        this.f1016f = Math.max(i3, (aaVar2.leftMargin + i3) + aaVar2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj3 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aaVar2.width == 0 && aaVar2.f1409g > 0.0f) {
                        i3 = 0;
                        aaVar2.width = -2;
                    }
                    int i13 = i3;
                    m1806a(b, i10, i, f2 == 0.0f ? this.f1016f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        aaVar2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj4 != null) {
                        this.f1016f += ((aaVar2.leftMargin + i3) + aaVar2.rightMargin) + m1807b(b);
                    } else {
                        int i14 = this.f1016f;
                        this.f1016f = Math.max(i14, (((i14 + i3) + aaVar2.leftMargin) + aaVar2.rightMargin) + m1807b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || aaVar2.height != -1) {
                    obj7 = obj2;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = aaVar2.bottomMargin + aaVar2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = bq.m2067a(i6, au.m692b(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((aaVar2.f1410h < 0 ? this.f1015e : aaVar2.f1410h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj == null || aaVar2.height != -1) ? null : 1;
                if (aaVar2.f1409g > 0.0f) {
                    i3 = Math.max(i8, obj8 != null ? i11 : i12);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m1801a(b, i10);
                obj5 = obj3;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj2 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj3 = obj5;
            obj = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f1016f > 0 && m1815c(virtualChildCount)) {
            this.f1016f += this.f1022l;
        }
        i10 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i5 : Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1016f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m1810b(i4);
                if (b2 == null) {
                    this.f1016f += m1816d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m1801a(b2, i4) + i4;
                } else {
                    aaVar = (aa) b2.getLayoutParams();
                    if (obj4 != null) {
                        this.f1016f = ((aaVar.rightMargin + (aaVar.leftMargin + i9)) + m1807b(b2)) + this.f1016f;
                        i3 = i4;
                    } else {
                        i11 = this.f1016f;
                        this.f1016f = Math.max(i11, (aaVar.rightMargin + ((i11 + i9) + aaVar.leftMargin)) + m1807b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f1016f += getPaddingLeft() + getPaddingRight();
        int a2 = au.m682a(Math.max(this.f1016f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f1016f;
        int i16;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1017g > 0.0f) {
                f = this.f1017g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1016f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m1810b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    aaVar = (aa) b3.getLayoutParams();
                    float f6 = aaVar.f1409g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = C0260z.getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + aaVar.topMargin) + aaVar.bottomMargin, aaVar.height);
                        if (aaVar.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = bq.m2067a(i15, au.m692b(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj4 != null) {
                        this.f1016f += ((b3.getMeasuredWidth() + aaVar.leftMargin) + aaVar.rightMargin) + m1807b(b3);
                    } else {
                        i4 = this.f1016f;
                        this.f1016f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + aaVar.leftMargin) + aaVar.rightMargin) + m1807b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || aaVar.height != -1) ? null : 1;
                    i10 = aaVar.topMargin + aaVar.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    i10 = Math.max(i16, obj5 != null ? i10 : i14);
                    obj5 = (obj9 == null || aaVar.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((aaVar.f1410h < 0 ? this.f1015e : aaVar.f1410h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f1016f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m1810b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((aa) b4.getLayoutParams()).f1409g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, au.m682a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj2 != null) {
            m1799d(virtualChildCount, i);
        }
    }

    void m1812b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bq.m2069a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f1015e & 8388615;
        int i8 = this.f1015e & 112;
        boolean z = this.f1011a;
        int[] iArr = this.f1019i;
        int[] iArr2 = this.f1020j;
        switch (C0121d.m939a(i7, au.m683a(this))) {
            case C0339o.View_android_focusable /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1016f) / 2);
                break;
            case C0339o.View_backgroundTint /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1016f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m1810b(i10);
            if (b == null) {
                paddingLeft += m1816d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                aa aaVar = (aa) b.getLayoutParams();
                i7 = (!z || aaVar.height == -1) ? -1 : b.getBaseline();
                int i12 = aaVar.f1410h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case C0339o.Toolbar_maxButtonHeight /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aaVar.topMargin) - aaVar.bottomMargin;
                        break;
                    case C0339o.Theme_homeAsUpIndicator /*48*/:
                        i11 = paddingTop + aaVar.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                        i11 = (paddingBottom - measuredHeight) - aaVar.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (m1815c(i10) ? this.f1022l + paddingLeft : paddingLeft) + aaVar.leftMargin;
                m1797a(b, paddingLeft + m1800a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (aaVar.rightMargin + measuredWidth) + m1807b(b);
                i7 = m1801a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void m1813b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bq.m2069a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m1810b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1815c(i))) {
                aa aaVar = (aa) b.getLayoutParams();
                m1814b(canvas, a ? aaVar.rightMargin + b.getRight() : (b.getLeft() - aaVar.leftMargin) - this.f1022l);
            }
            i++;
        }
        if (m1815c(virtualChildCount)) {
            int paddingLeft;
            View b2 = m1810b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f1022l;
            } else {
                aaVar = (aa) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - aaVar.leftMargin) - this.f1022l : aaVar.rightMargin + b2.getRight();
            }
            m1814b(canvas, paddingLeft);
        }
    }

    void m1814b(Canvas canvas, int i) {
        this.f1021k.setBounds(i, getPaddingTop() + this.f1025o, this.f1022l + i, (getHeight() - getPaddingBottom()) - this.f1025o);
        this.f1021k.draw(canvas);
    }

    protected boolean m1815c(int i) {
        if (i == 0) {
            return (this.f1024n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f1024n & 4) != 0;
            } else {
                if ((this.f1024n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof aa;
    }

    int m1816d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1817j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1808b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1809b(layoutParams);
    }

    public int getBaseline() {
        if (this.f1012b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1012b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1012b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f1013c;
            if (this.f1014d == 1) {
                i = this.f1015e & 112;
                if (i != 48) {
                    switch (i) {
                        case C0339o.Toolbar_maxButtonHeight /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1016f) / 2);
                            break;
                        case C0339o.Theme_listChoiceBackgroundIndicator /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1016f;
                            break;
                    }
                }
            }
            i = i2;
            return (((aa) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f1012b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1012b;
    }

    public Drawable getDividerDrawable() {
        return this.f1021k;
    }

    public int getDividerPadding() {
        return this.f1025o;
    }

    public int getDividerWidth() {
        return this.f1022l;
    }

    public int getOrientation() {
        return this.f1014d;
    }

    public int getShowDividers() {
        return this.f1024n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1017g;
    }

    protected aa m1817j() {
        return this.f1014d == 0 ? new aa(-2, -2) : this.f1014d == 1 ? new aa(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1021k != null) {
            if (this.f1014d == 1) {
                m1804a(canvas);
            } else {
                m1813b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0260z.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0260z.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1014d == 1) {
            m1803a(i, i2, i3, i4);
        } else {
            m1812b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1014d == 1) {
            m1802a(i, i2);
        } else {
            m1811b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f1011a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1012b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1021k) {
            this.f1021k = drawable;
            if (drawable != null) {
                this.f1022l = drawable.getIntrinsicWidth();
                this.f1023m = drawable.getIntrinsicHeight();
            } else {
                this.f1022l = 0;
                this.f1023m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1025o = i;
    }

    public void setGravity(int i) {
        if (this.f1015e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1015e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f1015e & 8388615) != i2) {
            this.f1015e = i2 | (this.f1015e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1018h = z;
    }

    public void setOrientation(int i) {
        if (this.f1014d != i) {
            this.f1014d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1024n) {
            requestLayout();
        }
        this.f1024n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1015e & 112) != i2) {
            this.f1015e = i2 | (this.f1015e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f1017g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
