package android.support.v4.widget;

import android.content.Context;
import android.support.v4.p000h.ag;
import android.support.v4.p000h.ap;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.pocket.doorway.C0339o;
import java.util.Arrays;

public class ae {
    private static final Interpolator f445v;
    private int f446a;
    private int f447b;
    private int f448c;
    private float[] f449d;
    private float[] f450e;
    private float[] f451f;
    private float[] f452g;
    private int[] f453h;
    private int[] f454i;
    private int[] f455j;
    private int f456k;
    private VelocityTracker f457l;
    private float f458m;
    private float f459n;
    private int f460o;
    private int f461p;
    private C0162r f462q;
    private final ah f463r;
    private View f464s;
    private boolean f465t;
    private final ViewGroup f466u;
    private final Runnable f467w;

    static {
        f445v = new af();
    }

    private ae(Context context, ViewGroup viewGroup, ah ahVar) {
        this.f448c = -1;
        this.f467w = new ag(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (ahVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f466u = viewGroup;
            this.f463r = ahVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f460o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f447b = viewConfiguration.getScaledTouchSlop();
            this.f458m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f459n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f462q = C0162r.m1092a(context, f445v);
        }
    }

    private float m1022a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m1023a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m1024a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f466u.getWidth();
        int i4 = width / 2;
        float a = (m1022a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m1025a(View view, int i, int i2, int i3, int i4) {
        int b = m1033b(i3, (int) this.f459n, (int) this.f458m);
        int b2 = m1033b(i4, (int) this.f459n, (int) this.f458m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m1024a(i2, b2, this.f463r.m165b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m1024a(i, b, this.f463r.m158a(view)))));
    }

    public static ae m1026a(ViewGroup viewGroup, float f, ah ahVar) {
        ae a = m1027a(viewGroup, ahVar);
        a.f447b = (int) (((float) a.f447b) * (1.0f / f));
        return a;
    }

    public static ae m1027a(ViewGroup viewGroup, ah ahVar) {
        return new ae(viewGroup.getContext(), viewGroup, ahVar);
    }

    private void m1028a(float f, float f2) {
        this.f465t = true;
        this.f463r.m162a(this.f464s, f, f2);
        this.f465t = false;
        if (this.f446a == 1) {
            m1043a(0);
        }
    }

    private void m1029a(float f, float f2, int i) {
        m1038c(i);
        float[] fArr = this.f449d;
        this.f451f[i] = f;
        fArr[i] = f;
        fArr = this.f450e;
        this.f452g[i] = f2;
        fArr[i] = f2;
        this.f453h[i] = m1040d((int) f, (int) f2);
        this.f456k |= 1 << i;
    }

    private boolean m1030a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f453h[i] & i2) != i2 || (this.f461p & i2) == 0 || (this.f455j[i] & i2) == i2 || (this.f454i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f447b) && abs2 <= ((float) this.f447b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f463r.m169b(i2)) {
            return (this.f454i[i] & i2) == 0 && abs > ((float) this.f447b);
        } else {
            int[] iArr = this.f455j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m1031a(int i, int i2, int i3, int i4) {
        int left = this.f464s.getLeft();
        int top = this.f464s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f462q.m1100f();
            m1043a(0);
            return false;
        }
        this.f462q.m1094a(left, top, i5, i6, m1025a(this.f464s, i5, i6, i3, i4));
        m1043a(2);
        return true;
    }

    private boolean m1032a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f463r.m158a(view) > 0;
        boolean z2 = this.f463r.m165b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f447b * this.f447b)) : z ? Math.abs(f) > ((float) this.f447b) : z2 ? Math.abs(f2) > ((float) this.f447b) : false;
    }

    private int m1033b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m1034b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1030a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1030a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1030a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1030a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f454i;
            iArr[i] = iArr[i] | i2;
            this.f463r.m167b(i2, i);
        }
    }

    private void m1035b(int i) {
        if (this.f449d != null) {
            this.f449d[i] = 0.0f;
            this.f450e[i] = 0.0f;
            this.f451f[i] = 0.0f;
            this.f452g[i] = 0.0f;
            this.f453h[i] = 0;
            this.f454i[i] = 0;
            this.f455j[i] = 0;
            this.f456k &= (1 << i) ^ -1;
        }
    }

    private void m1036b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f464s.getLeft();
        int top = this.f464s.getTop();
        if (i3 != 0) {
            a = this.f463r.m159a(this.f464s, i, i3);
            this.f464s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f463r.m166b(this.f464s, i2, i4);
            this.f464s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f463r.m163a(this.f464s, a, b, a - left, b - top);
        }
    }

    private void m1037c() {
        if (this.f449d != null) {
            Arrays.fill(this.f449d, 0.0f);
            Arrays.fill(this.f450e, 0.0f);
            Arrays.fill(this.f451f, 0.0f);
            Arrays.fill(this.f452g, 0.0f);
            Arrays.fill(this.f453h, 0);
            Arrays.fill(this.f454i, 0);
            Arrays.fill(this.f455j, 0);
            this.f456k = 0;
        }
    }

    private void m1038c(int i) {
        if (this.f449d == null || this.f449d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f449d != null) {
                System.arraycopy(this.f449d, 0, obj, 0, this.f449d.length);
                System.arraycopy(this.f450e, 0, obj2, 0, this.f450e.length);
                System.arraycopy(this.f451f, 0, obj3, 0, this.f451f.length);
                System.arraycopy(this.f452g, 0, obj4, 0, this.f452g.length);
                System.arraycopy(this.f453h, 0, obj5, 0, this.f453h.length);
                System.arraycopy(this.f454i, 0, obj6, 0, this.f454i.length);
                System.arraycopy(this.f455j, 0, obj7, 0, this.f455j.length);
            }
            this.f449d = obj;
            this.f450e = obj2;
            this.f451f = obj3;
            this.f452g = obj4;
            this.f453h = obj5;
            this.f454i = obj6;
            this.f455j = obj7;
        }
    }

    private void m1039c(MotionEvent motionEvent) {
        int c = ag.m645c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = ag.m643b(motionEvent, i);
            float c2 = ag.m644c(motionEvent, i);
            float d = ag.m646d(motionEvent, i);
            this.f451f[b] = c2;
            this.f452g[b] = d;
        }
    }

    private int m1040d(int i, int i2) {
        int i3 = 0;
        if (i < this.f466u.getLeft() + this.f460o) {
            i3 = 1;
        }
        if (i2 < this.f466u.getTop() + this.f460o) {
            i3 |= 4;
        }
        if (i > this.f466u.getRight() - this.f460o) {
            i3 |= 2;
        }
        return i2 > this.f466u.getBottom() - this.f460o ? i3 | 8 : i3;
    }

    private void m1041d() {
        this.f457l.computeCurrentVelocity(1000, this.f458m);
        m1028a(m1023a(ap.m671a(this.f457l, this.f448c), this.f459n, this.f458m), m1023a(ap.m672b(this.f457l, this.f448c), this.f459n, this.f458m));
    }

    public int m1042a() {
        return this.f446a;
    }

    void m1043a(int i) {
        this.f466u.removeCallbacks(this.f467w);
        if (this.f446a != i) {
            this.f446a = i;
            this.f463r.m160a(i);
            if (this.f446a == 0) {
                this.f464s = null;
            }
        }
    }

    public void m1044a(View view, int i) {
        if (view.getParent() != this.f466u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f466u + ")");
        }
        this.f464s = view;
        this.f448c = i;
        this.f463r.m168b(view, i);
        m1043a(1);
    }

    public boolean m1045a(int i, int i2) {
        if (this.f465t) {
            return m1031a(i, i2, (int) ap.m671a(this.f457l, this.f448c), (int) ap.m672b(this.f457l, this.f448c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1046a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.p000h.ag.m640a(r14);
        r1 = android.support.v4.p000h.ag.m642b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m1049b();
    L_0x000d:
        r2 = r13.f457l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f457l = r2;
    L_0x0017:
        r2 = r13.f457l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0121;
            case 2: goto L_0x0092;
            case 3: goto L_0x0121;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0118;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f446a;
        r1 = 1;
        if (r0 != r1) goto L_0x0126;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.p000h.ag.m643b(r14, r2);
        r13.m1029a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m1053c(r0, r1);
        r1 = r13.f464s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f446a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m1052b(r0, r2);
    L_0x0048:
        r0 = r13.f453h;
        r0 = r0[r2];
        r1 = r13.f461p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f463r;
        r3 = r13.f461p;
        r0 = r0 & r3;
        r1.m161a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.p000h.ag.m643b(r14, r1);
        r2 = android.support.v4.p000h.ag.m644c(r14, r1);
        r1 = android.support.v4.p000h.ag.m646d(r14, r1);
        r13.m1029a(r2, r1, r0);
        r3 = r13.f446a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f453h;
        r1 = r1[r0];
        r2 = r13.f461p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f463r;
        r3 = r13.f461p;
        r1 = r1 & r3;
        r2.m161a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f446a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m1053c(r2, r1);
        r2 = r13.f464s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m1052b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f449d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f450e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.p000h.ag.m645c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x00fd;
    L_0x00a2:
        r3 = android.support.v4.p000h.ag.m643b(r14, r1);
        r0 = android.support.v4.p000h.ag.m644c(r14, r1);
        r4 = android.support.v4.p000h.ag.m646d(r14, r1);
        r5 = r13.f449d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f450e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m1053c(r0, r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00c2:
        r0 = r13.m1032a(r4, r5, r6);
        if (r0 == 0) goto L_0x0102;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x0104;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f463r;
        r10 = (int) r5;
        r8 = r9.m159a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f463r;
        r12 = (int) r6;
        r10 = r11.m166b(r4, r10, r12);
        r11 = r13.f463r;
        r11 = r11.m158a(r4);
        r12 = r13.f463r;
        r12 = r12.m165b(r4);
        if (r11 == 0) goto L_0x00f7;
    L_0x00f3:
        if (r11 <= 0) goto L_0x0104;
    L_0x00f5:
        if (r8 != r7) goto L_0x0104;
    L_0x00f7:
        if (r12 == 0) goto L_0x00fd;
    L_0x00f9:
        if (r12 <= 0) goto L_0x0104;
    L_0x00fb:
        if (r10 != r9) goto L_0x0104;
    L_0x00fd:
        r13.m1039c(r14);
        goto L_0x001f;
    L_0x0102:
        r0 = 0;
        goto L_0x00c9;
    L_0x0104:
        r13.m1034b(r5, r6, r3);
        r5 = r13.f446a;
        r6 = 1;
        if (r5 == r6) goto L_0x00fd;
    L_0x010c:
        if (r0 == 0) goto L_0x0114;
    L_0x010e:
        r0 = r13.m1052b(r4, r3);
        if (r0 != 0) goto L_0x00fd;
    L_0x0114:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x0118:
        r0 = android.support.v4.p000h.ag.m643b(r14, r1);
        r13.m1035b(r0);
        goto L_0x001f;
    L_0x0121:
        r13.m1049b();
        goto L_0x001f;
    L_0x0126:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ae.a(android.view.MotionEvent):boolean");
    }

    public boolean m1047a(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public boolean m1048a(boolean z) {
        if (this.f446a == 2) {
            int i;
            boolean e = this.f462q.m1099e();
            int a = this.f462q.m1093a();
            int b = this.f462q.m1096b();
            int left = a - this.f464s.getLeft();
            int top = b - this.f464s.getTop();
            if (left != 0) {
                this.f464s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f464s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f463r.m163a(this.f464s, a, b, left, top);
            }
            if (e && a == this.f462q.m1097c() && b == this.f462q.m1098d()) {
                this.f462q.m1100f();
                i = 0;
            } else {
                boolean z2 = e;
            }
            if (i == 0) {
                if (z) {
                    this.f466u.post(this.f467w);
                } else {
                    m1043a(0);
                }
            }
        }
        return this.f446a == 2;
    }

    public void m1049b() {
        this.f448c = -1;
        m1037c();
        if (this.f457l != null) {
            this.f457l.recycle();
            this.f457l = null;
        }
    }

    public void m1050b(MotionEvent motionEvent) {
        int i = 0;
        int a = ag.m640a(motionEvent);
        int b = ag.m642b(motionEvent);
        if (a == 0) {
            m1049b();
        }
        if (this.f457l == null) {
            this.f457l = VelocityTracker.obtain();
        }
        this.f457l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (a) {
            case C0339o.View_android_theme /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = ag.m643b(motionEvent, 0);
                c = m1053c((int) x, (int) y);
                m1029a(x, y, i);
                m1052b(c, i);
                i2 = this.f453h[i];
                if ((this.f461p & i2) != 0) {
                    this.f463r.m161a(i2 & this.f461p, i);
                }
            case C0339o.View_android_focusable /*1*/:
                if (this.f446a == 1) {
                    m1041d();
                }
                m1049b();
            case C0339o.View_paddingStart /*2*/:
                if (this.f446a == 1) {
                    i = ag.m641a(motionEvent, this.f448c);
                    x = ag.m644c(motionEvent, i);
                    i2 = (int) (x - this.f451f[this.f448c]);
                    i = (int) (ag.m646d(motionEvent, i) - this.f452g[this.f448c]);
                    m1036b(this.f464s.getLeft() + i2, this.f464s.getTop() + i, i2, i);
                    m1039c(motionEvent);
                    return;
                }
                i2 = ag.m645c(motionEvent);
                while (i < i2) {
                    a = ag.m643b(motionEvent, i);
                    float c2 = ag.m644c(motionEvent, i);
                    float d = ag.m646d(motionEvent, i);
                    float f = c2 - this.f449d[a];
                    float f2 = d - this.f450e[a];
                    m1034b(f, f2, a);
                    if (this.f446a != 1) {
                        c = m1053c((int) c2, (int) d);
                        if (!m1032a(c, f, f2) || !m1052b(c, a)) {
                            i++;
                        }
                    }
                    m1039c(motionEvent);
                }
                m1039c(motionEvent);
            case C0339o.View_paddingEnd /*3*/:
                if (this.f446a == 1) {
                    m1028a(0.0f, 0.0f);
                }
                m1049b();
            case C0339o.View_backgroundTint /*5*/:
                i = ag.m643b(motionEvent, b);
                x = ag.m644c(motionEvent, b);
                y = ag.m646d(motionEvent, b);
                m1029a(x, y, i);
                if (this.f446a == 0) {
                    m1052b(m1053c((int) x, (int) y), i);
                    i2 = this.f453h[i];
                    if ((this.f461p & i2) != 0) {
                        this.f463r.m161a(i2 & this.f461p, i);
                    }
                } else if (m1051b((int) x, (int) y)) {
                    m1052b(this.f464s, i);
                }
            case C0339o.View_backgroundTintMode /*6*/:
                a = ag.m643b(motionEvent, b);
                if (this.f446a == 1 && a == this.f448c) {
                    b = ag.m645c(motionEvent);
                    while (i < b) {
                        int b2 = ag.m643b(motionEvent, i);
                        if (b2 != this.f448c) {
                            if (m1053c((int) ag.m644c(motionEvent, i), (int) ag.m646d(motionEvent, i)) == this.f464s && m1052b(this.f464s, b2)) {
                                i = this.f448c;
                                if (i == -1) {
                                    m1041d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m1041d();
                    }
                }
                m1035b(a);
            default:
        }
    }

    public boolean m1051b(int i, int i2) {
        return m1047a(this.f464s, i, i2);
    }

    boolean m1052b(View view, int i) {
        if (view == this.f464s && this.f448c == i) {
            return true;
        }
        if (view == null || !this.f463r.m164a(view, i)) {
            return false;
        }
        this.f448c = i;
        m1044a(view, i);
        return true;
    }

    public View m1053c(int i, int i2) {
        for (int childCount = this.f466u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f466u.getChildAt(this.f463r.m170c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
