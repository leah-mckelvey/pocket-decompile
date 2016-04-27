package android.support.v7.widget;

import android.content.Context;
import android.support.v4.p000h.ag;
import android.support.v4.p000h.bt;
import android.support.v4.widget.C0155k;
import android.support.v7.internal.widget.al;
import android.support.v7.p013b.C0200b;
import android.view.MotionEvent;
import android.view.View;
import com.pocket.doorway.C0339o;

class af extends al {
    private boolean f1414f;
    private boolean f1415g;
    private boolean f1416h;
    private bt f1417i;
    private C0155k f1418j;

    public af(Context context, boolean z) {
        super(context, null, C0200b.dropDownListViewStyle);
        this.f1415g = z;
        setCacheColorHint(0);
    }

    private void m2238a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void m2239a(View view, int i, float f, float f2) {
        this.f1416h = true;
        setPressed(true);
        layoutChildren();
        setSelection(i);
        m1869a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void m2241d() {
        this.f1416h = false;
        setPressed(false);
        drawableStateChanged();
        if (this.f1417i != null) {
            this.f1417i.m865a();
            this.f1417i = null;
        }
    }

    public boolean m2242a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = ag.m640a(motionEvent);
        switch (a) {
            case C0339o.View_android_focusable /*1*/:
                z = false;
                break;
            case C0339o.View_paddingStart /*2*/:
                z = true;
                break;
            case C0339o.View_paddingEnd /*3*/:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m2239a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m2238a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m2241d();
        }
        if (z2) {
            if (this.f1418j == null) {
                this.f1418j = new C0155k(this);
            }
            this.f1418j.m1005a(true);
            this.f1418j.onTouch(this, motionEvent);
        } else if (this.f1418j != null) {
            this.f1418j.m1005a(false);
        }
        return z2;
    }

    protected boolean m2243c() {
        return this.f1416h || super.m1873c();
    }

    public boolean hasFocus() {
        return this.f1415g || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1415g || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1415g || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1415g && this.f1414f) || super.isInTouchMode();
    }
}
