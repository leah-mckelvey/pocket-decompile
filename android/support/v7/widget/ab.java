package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.p008f.C0101f;
import android.support.v4.widget.C0156l;
import android.support.v7.internal.widget.af;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.pocket.doorway.C0339o;
import java.lang.reflect.Method;

public class ab {
    private static Method f1157a;
    private Handler f1158A;
    private Rect f1159B;
    private boolean f1160C;
    private int f1161D;
    int f1162b;
    private Context f1163c;
    private PopupWindow f1164d;
    private ListAdapter f1165e;
    private af f1166f;
    private int f1167g;
    private int f1168h;
    private int f1169i;
    private int f1170j;
    private boolean f1171k;
    private int f1172l;
    private boolean f1173m;
    private boolean f1174n;
    private View f1175o;
    private int f1176p;
    private DataSetObserver f1177q;
    private View f1178r;
    private Drawable f1179s;
    private OnItemClickListener f1180t;
    private OnItemSelectedListener f1181u;
    private final an f1182v;
    private final am f1183w;
    private final al f1184x;
    private final aj f1185y;
    private Runnable f1186z;

    static {
        try {
            f1157a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ab(Context context) {
        this(context, null, C0200b.listPopupWindowStyle);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ab(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1167g = -2;
        this.f1168h = -2;
        this.f1172l = 0;
        this.f1173m = false;
        this.f1174n = false;
        this.f1162b = Integer.MAX_VALUE;
        this.f1176p = 0;
        this.f1182v = new an();
        this.f1183w = new am();
        this.f1184x = new al();
        this.f1185y = new aj();
        this.f1158A = new Handler();
        this.f1159B = new Rect();
        this.f1163c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.ListPopupWindow, i, i2);
        this.f1169i = obtainStyledAttributes.getDimensionPixelOffset(C0210l.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1170j = obtainStyledAttributes.getDimensionPixelOffset(C0210l.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1170j != 0) {
            this.f1171k = true;
        }
        obtainStyledAttributes.recycle();
        this.f1164d = new af(context, attributeSet, i);
        this.f1164d.setInputMethodMode(1);
        this.f1161D = C0101f.m545a(this.f1163c.getResources().getConfiguration().locale);
    }

    private void m1939b(boolean z) {
        if (f1157a != null) {
            try {
                f1157a.invoke(this.f1164d, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private void m1942h() {
        if (this.f1175o != null) {
            ViewParent parent = this.f1175o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1175o);
            }
        }
    }

    private int m1943i() {
        int measuredHeight;
        int i;
        int i2;
        int maxAvailableHeight;
        LayoutParams layoutParams;
        View view;
        if (this.f1166f == null) {
            Context context = this.f1163c;
            this.f1186z = new ad(this);
            this.f1166f = new af(context, !this.f1160C);
            if (this.f1179s != null) {
                this.f1166f.setSelector(this.f1179s);
            }
            this.f1166f.setAdapter(this.f1165e);
            this.f1166f.setOnItemClickListener(this.f1180t);
            this.f1166f.setFocusable(true);
            this.f1166f.setFocusableInTouchMode(true);
            this.f1166f.setOnItemSelectedListener(new ae(this));
            this.f1166f.setOnScrollListener(this.f1184x);
            if (this.f1181u != null) {
                this.f1166f.setOnItemSelectedListener(this.f1181u);
            }
            View view2 = this.f1166f;
            View view3 = this.f1175o;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1176p) {
                    case C0339o.View_android_theme /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case C0339o.View_android_focusable /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1176p);
                        break;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(this.f1168h, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                measuredHeight = 0;
            }
            this.f1164d.setContentView(view);
            i = measuredHeight;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1164d.getContentView();
            view = this.f1175o;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i = 0;
            }
        }
        Drawable background = this.f1164d.getBackground();
        if (background != null) {
            background.getPadding(this.f1159B);
            measuredHeight = this.f1159B.top + this.f1159B.bottom;
            if (this.f1171k) {
                i2 = measuredHeight;
            } else {
                this.f1170j = -this.f1159B.top;
                i2 = measuredHeight;
            }
        } else {
            this.f1159B.setEmpty();
            i2 = 0;
        }
        if (this.f1164d.getInputMethodMode() == 2) {
            maxAvailableHeight = this.f1164d.getMaxAvailableHeight(m1956d(), this.f1170j);
        } else {
            maxAvailableHeight = this.f1164d.getMaxAvailableHeight(m1956d(), this.f1170j);
        }
        if (this.f1173m || this.f1167g == -1) {
            return maxAvailableHeight + i2;
        }
        int makeMeasureSpec;
        switch (this.f1168h) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1163c.getResources().getDisplayMetrics().widthPixels - (this.f1159B.left + this.f1159B.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1163c.getResources().getDisplayMetrics().widthPixels - (this.f1159B.left + this.f1159B.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1168h, 1073741824);
                break;
        }
        measuredHeight = this.f1166f.m1866a(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measuredHeight > 0) {
            i += i2;
        }
        return measuredHeight + i;
    }

    public void m1944a() {
        this.f1164d.dismiss();
        m1942h();
        this.f1164d.setContentView(null);
        this.f1166f = null;
        this.f1158A.removeCallbacks(this.f1182v);
    }

    public void m1945a(int i) {
        this.f1176p = i;
    }

    public void m1946a(Drawable drawable) {
        this.f1164d.setBackgroundDrawable(drawable);
    }

    public void m1947a(View view) {
        this.f1178r = view;
    }

    public void m1948a(OnItemClickListener onItemClickListener) {
        this.f1180t = onItemClickListener;
    }

    public void m1949a(ListAdapter listAdapter) {
        if (this.f1177q == null) {
            this.f1177q = new ak();
        } else if (this.f1165e != null) {
            this.f1165e.unregisterDataSetObserver(this.f1177q);
        }
        this.f1165e = listAdapter;
        if (this.f1165e != null) {
            listAdapter.registerDataSetObserver(this.f1177q);
        }
        if (this.f1166f != null) {
            this.f1166f.setAdapter(this.f1165e);
        }
    }

    public void m1950a(OnDismissListener onDismissListener) {
        this.f1164d.setOnDismissListener(onDismissListener);
    }

    public void m1951a(boolean z) {
        this.f1160C = z;
        this.f1164d.setFocusable(z);
    }

    public void m1952b(int i) {
        this.f1172l = i;
    }

    public boolean m1953b() {
        return this.f1164d.isShowing();
    }

    public void m1954c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int i2 = m1943i();
        boolean f = m1960f();
        if (this.f1164d.isShowing()) {
            int width = this.f1168h == -1 ? -1 : this.f1168h == -2 ? m1956d().getWidth() : this.f1168h;
            if (this.f1167g == -1) {
                if (!f) {
                    i2 = -1;
                }
                if (f) {
                    PopupWindow popupWindow = this.f1164d;
                    if (this.f1168h != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.f1164d.setWindowLayoutMode(this.f1168h == -1 ? -1 : 0, -1);
                }
            } else if (this.f1167g != -2) {
                i2 = this.f1167g;
            }
            PopupWindow popupWindow2 = this.f1164d;
            if (!(this.f1174n || this.f1173m)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.f1164d.update(m1956d(), this.f1169i, this.f1170j, width, i2);
            return;
        }
        int i3;
        if (this.f1168h == -1) {
            i3 = -1;
        } else if (this.f1168h == -2) {
            this.f1164d.setWidth(m1956d().getWidth());
            i3 = 0;
        } else {
            this.f1164d.setWidth(this.f1168h);
            i3 = 0;
        }
        if (this.f1167g == -1) {
            width = -1;
        } else if (this.f1167g == -2) {
            this.f1164d.setHeight(i2);
            width = 0;
        } else {
            this.f1164d.setHeight(this.f1167g);
            width = 0;
        }
        this.f1164d.setWindowLayoutMode(i3, width);
        m1939b(true);
        popupWindow = this.f1164d;
        if (this.f1174n || this.f1173m) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f1164d.setTouchInterceptor(this.f1183w);
        C0156l.m1084a(this.f1164d, m1956d(), this.f1169i, this.f1170j, this.f1172l);
        this.f1166f.setSelection(-1);
        if (!this.f1160C || this.f1166f.isInTouchMode()) {
            m1958e();
        }
        if (!this.f1160C) {
            this.f1158A.post(this.f1185y);
        }
    }

    public void m1955c(int i) {
        this.f1168h = i;
    }

    public View m1956d() {
        return this.f1178r;
    }

    public void m1957d(int i) {
        Drawable background = this.f1164d.getBackground();
        if (background != null) {
            background.getPadding(this.f1159B);
            this.f1168h = (this.f1159B.left + this.f1159B.right) + i;
            return;
        }
        m1955c(i);
    }

    public void m1958e() {
        af afVar = this.f1166f;
        if (afVar != null) {
            afVar.f1414f = true;
            afVar.requestLayout();
        }
    }

    public void m1959e(int i) {
        this.f1164d.setInputMethodMode(i);
    }

    public boolean m1960f() {
        return this.f1164d.getInputMethodMode() == 2;
    }

    public ListView m1961g() {
        return this.f1166f;
    }
}
