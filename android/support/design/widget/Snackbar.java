package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.C0001b;
import android.support.design.C0003d;
import android.support.design.C0004e;
import android.support.design.C0005f;
import android.support.design.C0006g;
import android.support.v4.p000h.au;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar {
    private static final Handler f10a;
    private final ViewGroup f11b;
    private final SnackbarLayout f12c;
    private final C0031w f13d;

    public class SnackbarLayout extends LinearLayout {
        private TextView f5a;
        private TextView f6b;
        private int f7c;
        private int f8d;
        private C0021t f9e;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0006g.SnackbarLayout);
            this.f7c = obtainStyledAttributes.getDimensionPixelSize(C0006g.SnackbarLayout_android_maxWidth, -1);
            this.f8d = obtainStyledAttributes.getDimensionPixelSize(C0006g.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0006g.SnackbarLayout_elevation)) {
                au.m701e(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0006g.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0005f.layout_snackbar_include, this);
        }

        private static void m7a(View view, int i, int i2) {
            if (au.m708l(view)) {
                au.m686a(view, au.m696c(view), i, au.m698d(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean m8a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f5a.getPaddingTop() == i2 && this.f5a.getPaddingBottom() == i3) {
                return z;
            }
            m7a(this.f5a, i2, i3);
            return true;
        }

        void m9a(int i, int i2) {
            au.m697c(this.f5a, 0.0f);
            au.m703g(this.f5a).m860a(1.0f).m861a((long) i2).m867b((long) i).m868b();
            if (this.f6b.getVisibility() == 0) {
                au.m697c(this.f6b, 0.0f);
                au.m703g(this.f6b).m860a(1.0f).m861a((long) i2).m867b((long) i).m868b();
            }
        }

        void m10b(int i, int i2) {
            au.m697c(this.f5a, 1.0f);
            au.m703g(this.f5a).m860a(0.0f).m861a((long) i2).m867b((long) i).m868b();
            if (this.f6b.getVisibility() == 0) {
                au.m697c(this.f6b, 1.0f);
                au.m703g(this.f6b).m860a(0.0f).m861a((long) i2).m867b((long) i).m868b();
            }
        }

        TextView getActionView() {
            return this.f6b;
        }

        TextView getMessageView() {
            return this.f5a;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f5a = (TextView) findViewById(C0004e.snackbar_text);
            this.f6b = (TextView) findViewById(C0004e.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f9e != null) {
                this.f9e.m107a(this, i, i2, i3, i4);
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f7c > 0 && getMeasuredWidth() > this.f7c) {
                i = MeasureSpec.makeMeasureSpec(this.f7c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0003d.snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0003d.snackbar_padding_vertical);
            int i3 = this.f5a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f8d <= 0 || this.f6b.getMeasuredWidth() <= this.f8d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m8a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m8a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnLayoutChangeListener(C0021t c0021t) {
            this.f9e = c0021t;
        }
    }

    static {
        f10a = new Handler(Looper.getMainLooper(), new C0019l());
    }

    private void m14d() {
        if (VERSION.SDK_INT >= 14) {
            au.m694b(this.f12c, (float) this.f12c.getHeight());
            au.m703g(this.f12c).m869c(0.0f).m864a(C0008a.f15b).m861a(250).m862a(new C0023o(this)).m868b();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12c.getContext(), C0001b.snackbar_in);
        loadAnimation.setInterpolator(C0008a.f15b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C0024p(this));
        this.f12c.startAnimation(loadAnimation);
    }

    private void m16e() {
        if (VERSION.SDK_INT >= 14) {
            au.m703g(this.f12c).m869c((float) this.f12c.getHeight()).m864a(C0008a.f15b).m861a(250).m862a(new C0025q(this)).m868b();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12c.getContext(), C0001b.snackbar_out);
        loadAnimation.setInterpolator(C0008a.f15b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C0026r(this));
        this.f12c.startAnimation(loadAnimation);
    }

    private void m17f() {
        this.f11b.removeView(this.f12c);
        C0029u.m140a().m149b(this.f13d);
    }

    private boolean m18g() {
        LayoutParams layoutParams = this.f12c.getLayoutParams();
        if (layoutParams instanceof C0012e) {
            C0010c a = ((C0012e) layoutParams).m85a();
            if (a instanceof C0027y) {
                return ((C0027y) a).m131a() != 0;
            }
        }
        return false;
    }

    public void m19a() {
        C0029u.m140a().m148a(this.f13d);
    }

    final void m20b() {
        if (this.f12c.getParent() == null) {
            LayoutParams layoutParams = this.f12c.getLayoutParams();
            if (layoutParams instanceof C0012e) {
                C0010c c0028s = new C0028s(this);
                c0028s.m132a(0.1f);
                c0028s.m136b(0.6f);
                c0028s.m133a(0);
                c0028s.m134a(new C0020m(this));
                ((C0012e) layoutParams).m87a(c0028s);
            }
            this.f11b.addView(this.f12c);
        }
        if (au.m709m(this.f12c)) {
            m14d();
        } else {
            this.f12c.setOnLayoutChangeListener(new C0022n(this));
        }
    }

    final void m21c() {
        if (this.f12c.getVisibility() != 0 || m18g()) {
            m17f();
        } else {
            m16e();
        }
    }
}
