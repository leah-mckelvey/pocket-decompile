package android.support.v7.p011a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0210l;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

/* renamed from: android.support.v7.a.e */
class C0176e {
    private TextView f530A;
    private TextView f531B;
    private View f532C;
    private ListAdapter f533D;
    private int f534E;
    private int f535F;
    private int f536G;
    private int f537H;
    private int f538I;
    private int f539J;
    private int f540K;
    private int f541L;
    private Handler f542M;
    private final OnClickListener f543N;
    private final Context f544a;
    private final ai f545b;
    private final Window f546c;
    private CharSequence f547d;
    private CharSequence f548e;
    private ListView f549f;
    private View f550g;
    private int f551h;
    private int f552i;
    private int f553j;
    private int f554k;
    private int f555l;
    private boolean f556m;
    private Button f557n;
    private CharSequence f558o;
    private Message f559p;
    private Button f560q;
    private CharSequence f561r;
    private Message f562s;
    private Button f563t;
    private CharSequence f564u;
    private Message f565v;
    private ScrollView f566w;
    private int f567x;
    private Drawable f568y;
    private ImageView f569z;

    public C0176e(Context context, ai aiVar, Window window) {
        this.f556m = false;
        this.f567x = 0;
        this.f534E = -1;
        this.f541L = 0;
        this.f543N = new C0177f(this);
        this.f544a = context;
        this.f545b = aiVar;
        this.f546c = window;
        this.f542M = new C0184m(aiVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0210l.AlertDialog, C0200b.alertDialogStyle, 0);
        this.f535F = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_android_layout, 0);
        this.f536G = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_buttonPanelSideLayout, 0);
        this.f537H = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_listLayout, 0);
        this.f538I = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_multiChoiceItemLayout, 0);
        this.f539J = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_singleChoiceItemLayout, 0);
        this.f540K = obtainStyledAttributes.getResourceId(C0210l.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    private void m1193a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean m1194a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0200b.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean m1195a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0176e.m1195a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private boolean m1196a(ViewGroup viewGroup) {
        if (this.f532C != null) {
            viewGroup.addView(this.f532C, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f546c.findViewById(C0205g.title_template).setVisibility(8);
            return true;
        }
        this.f569z = (ImageView) this.f546c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f547d) ? 1 : 0) != 0) {
            this.f530A = (TextView) this.f546c.findViewById(C0205g.alertTitle);
            this.f530A.setText(this.f547d);
            if (this.f567x != 0) {
                this.f569z.setImageResource(this.f567x);
                return true;
            } else if (this.f568y != null) {
                this.f569z.setImageDrawable(this.f568y);
                return true;
            } else {
                this.f530A.setPadding(this.f569z.getPaddingLeft(), this.f569z.getPaddingTop(), this.f569z.getPaddingRight(), this.f569z.getPaddingBottom());
                this.f569z.setVisibility(8);
                return true;
            }
        }
        this.f546c.findViewById(C0205g.title_template).setVisibility(8);
        this.f569z.setVisibility(8);
        viewGroup.setVisibility(8);
        return false;
    }

    private int m1197b() {
        return this.f536G == 0 ? this.f535F : this.f541L == 1 ? this.f536G : this.f535F;
    }

    private void m1199b(ViewGroup viewGroup) {
        this.f566w = (ScrollView) this.f546c.findViewById(C0205g.scrollView);
        this.f566w.setFocusable(false);
        this.f531B = (TextView) this.f546c.findViewById(16908299);
        if (this.f531B != null) {
            if (this.f548e != null) {
                this.f531B.setText(this.f548e);
                return;
            }
            this.f531B.setVisibility(8);
            this.f566w.removeView(this.f531B);
            if (this.f549f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f566w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f566w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f549f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m1201c() {
        boolean z = false;
        m1199b((ViewGroup) this.f546c.findViewById(C0205g.contentPanel));
        boolean d = m1203d();
        ViewGroup viewGroup = (ViewGroup) this.f546c.findViewById(C0205g.topPanel);
        bk a = bk.m2000a(this.f544a, null, C0210l.AlertDialog, C0200b.alertDialogStyle, 0);
        m1196a(viewGroup);
        View findViewById = this.f546c.findViewById(C0205g.buttonPanel);
        if (!d) {
            findViewById.setVisibility(8);
            findViewById = this.f546c.findViewById(C0205g.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        FrameLayout frameLayout = (FrameLayout) this.f546c.findViewById(C0205g.customPanel);
        View inflate = this.f550g != null ? this.f550g : this.f551h != 0 ? LayoutInflater.from(this.f544a).inflate(this.f551h, frameLayout, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0176e.m1195a(inflate))) {
            this.f546c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout2 = (FrameLayout) this.f546c.findViewById(C0205g.custom);
            frameLayout2.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f556m) {
                frameLayout2.setPadding(this.f552i, this.f553j, this.f554k, this.f555l);
            }
            if (this.f549f != null) {
                ((LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
        } else {
            frameLayout.setVisibility(8);
        }
        ListView listView = this.f549f;
        if (!(listView == null || this.f533D == null)) {
            listView.setAdapter(this.f533D);
            int i = this.f534E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
        a.m2008b();
    }

    private boolean m1203d() {
        int i;
        this.f557n = (Button) this.f546c.findViewById(16908313);
        this.f557n.setOnClickListener(this.f543N);
        if (TextUtils.isEmpty(this.f558o)) {
            this.f557n.setVisibility(8);
            i = 0;
        } else {
            this.f557n.setText(this.f558o);
            this.f557n.setVisibility(0);
            i = 1;
        }
        this.f560q = (Button) this.f546c.findViewById(16908314);
        this.f560q.setOnClickListener(this.f543N);
        if (TextUtils.isEmpty(this.f561r)) {
            this.f560q.setVisibility(8);
        } else {
            this.f560q.setText(this.f561r);
            this.f560q.setVisibility(0);
            i |= 2;
        }
        this.f563t = (Button) this.f546c.findViewById(16908315);
        this.f563t.setOnClickListener(this.f543N);
        if (TextUtils.isEmpty(this.f564u)) {
            this.f563t.setVisibility(8);
        } else {
            this.f563t.setText(this.f564u);
            this.f563t.setVisibility(0);
            i |= 4;
        }
        if (C0176e.m1194a(this.f544a)) {
            if (i == 1) {
                m1193a(this.f557n);
            } else if (i == 2) {
                m1193a(this.f560q);
            } else if (i == 4) {
                m1193a(this.f563t);
            }
        }
        return i != 0;
    }

    public void m1212a() {
        this.f545b.m1181a(1);
        this.f545b.setContentView(m1197b());
        m1201c();
    }

    public void m1213a(int i) {
        this.f550g = null;
        this.f551h = i;
        this.f556m = false;
    }

    public void m1214a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f542M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f564u = charSequence;
                this.f565v = message;
            case -2:
                this.f561r = charSequence;
                this.f562s = message;
            case -1:
                this.f558o = charSequence;
                this.f559p = message;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m1215a(Drawable drawable) {
        this.f568y = drawable;
        this.f567x = 0;
        if (this.f569z == null) {
            return;
        }
        if (drawable != null) {
            this.f569z.setImageDrawable(drawable);
        } else {
            this.f569z.setVisibility(8);
        }
    }

    public void m1216a(View view, int i, int i2, int i3, int i4) {
        this.f550g = view;
        this.f551h = 0;
        this.f556m = true;
        this.f552i = i;
        this.f553j = i2;
        this.f554k = i3;
        this.f555l = i4;
    }

    public void m1217a(CharSequence charSequence) {
        this.f547d = charSequence;
        if (this.f530A != null) {
            this.f530A.setText(charSequence);
        }
    }

    public boolean m1218a(int i, KeyEvent keyEvent) {
        return this.f566w != null && this.f566w.executeKeyEvent(keyEvent);
    }

    public void m1219b(int i) {
        this.f568y = null;
        this.f567x = i;
        if (this.f569z == null) {
            return;
        }
        if (i != 0) {
            this.f569z.setImageResource(this.f567x);
        } else {
            this.f569z.setVisibility(8);
        }
    }

    public void m1220b(View view) {
        this.f532C = view;
    }

    public void m1221b(CharSequence charSequence) {
        this.f548e = charSequence;
        if (this.f531B != null) {
            this.f531B.setText(charSequence);
        }
    }

    public boolean m1222b(int i, KeyEvent keyEvent) {
        return this.f566w != null && this.f566w.executeKeyEvent(keyEvent);
    }

    public int m1223c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f544a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m1224c(View view) {
        this.f550g = view;
        this.f551h = 0;
        this.f556m = false;
    }
}
