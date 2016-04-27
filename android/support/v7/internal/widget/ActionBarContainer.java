package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.C0221a;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f945a;
    Drawable f946b;
    Drawable f947c;
    boolean f948d;
    boolean f949e;
    private boolean f950f;
    private View f951g;
    private View f952h;
    private View f953i;
    private int f954j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(C0221a.m1448a() ? new C0268h(this) : new C0267g(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.ActionBar);
        this.f945a = obtainStyledAttributes.getDrawable(C0210l.ActionBar_background);
        this.f946b = obtainStyledAttributes.getDrawable(C0210l.ActionBar_backgroundStacked);
        this.f954j = obtainStyledAttributes.getDimensionPixelSize(C0210l.ActionBar_height, -1);
        if (getId() == C0205g.split_action_bar) {
            this.f948d = true;
            this.f947c = obtainStyledAttributes.getDrawable(C0210l.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f948d ? this.f947c == null : this.f945a == null && this.f946b == null;
        setWillNotDraw(z);
    }

    private boolean m1738a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m1739b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f945a != null && this.f945a.isStateful()) {
            this.f945a.setState(getDrawableState());
        }
        if (this.f946b != null && this.f946b.isStateful()) {
            this.f946b.setState(getDrawableState());
        }
        if (this.f947c != null && this.f947c.isStateful()) {
            this.f947c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f951g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f945a != null) {
                this.f945a.jumpToCurrentState();
            }
            if (this.f946b != null) {
                this.f946b.jumpToCurrentState();
            }
            if (this.f947c != null) {
                this.f947c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f952h = findViewById(C0205g.action_bar);
        this.f953i = findViewById(C0205g.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f950f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f951g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f948d) {
            int i6;
            if (this.f945a != null) {
                if (this.f952h.getVisibility() == 0) {
                    this.f945a.setBounds(this.f952h.getLeft(), this.f952h.getTop(), this.f952h.getRight(), this.f952h.getBottom());
                } else if (this.f953i == null || this.f953i.getVisibility() != 0) {
                    this.f945a.setBounds(0, 0, 0, 0);
                } else {
                    this.f945a.setBounds(this.f953i.getLeft(), this.f953i.getTop(), this.f953i.getRight(), this.f953i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f949e = z2;
            if (!z2 || this.f946b == null) {
                i5 = i6;
            } else {
                this.f946b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f947c != null) {
            this.f947c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f952h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f954j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f954j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f952h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f951g != null && this.f951g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m1738a(this.f952h) ? m1739b(this.f952h) : !m1738a(this.f953i) ? m1739b(this.f953i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m1739b(this.f951g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f945a != null) {
            this.f945a.setCallback(null);
            unscheduleDrawable(this.f945a);
        }
        this.f945a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f952h != null) {
                this.f945a.setBounds(this.f952h.getLeft(), this.f952h.getTop(), this.f952h.getRight(), this.f952h.getBottom());
            }
        }
        if (this.f948d) {
            if (this.f947c != null) {
                z = false;
            }
        } else if (!(this.f945a == null && this.f946b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f947c != null) {
            this.f947c.setCallback(null);
            unscheduleDrawable(this.f947c);
        }
        this.f947c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f948d && this.f947c != null) {
                this.f947c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f948d) {
            if (this.f947c != null) {
                z = false;
            }
        } else if (!(this.f945a == null && this.f946b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f946b != null) {
            this.f946b.setCallback(null);
            unscheduleDrawable(this.f946b);
        }
        this.f946b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f949e && this.f946b != null) {
                this.f946b.setBounds(this.f951g.getLeft(), this.f951g.getTop(), this.f951g.getRight(), this.f951g.getBottom());
            }
        }
        if (this.f948d) {
            if (this.f947c != null) {
                z = false;
            }
        } else if (!(this.f945a == null && this.f946b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ap apVar) {
        if (this.f951g != null) {
            removeView(this.f951g);
        }
        this.f951g = apVar;
        if (apVar != null) {
            addView(apVar);
            ViewGroup.LayoutParams layoutParams = apVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            apVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f950f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f945a != null) {
            this.f945a.setVisible(z, false);
        }
        if (this.f946b != null) {
            this.f946b.setVisible(z, false);
        }
        if (this.f947c != null) {
            this.f947c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f945a && !this.f948d) || ((drawable == this.f946b && this.f949e) || ((drawable == this.f947c && this.f948d) || super.verifyDrawable(drawable)));
    }
}
