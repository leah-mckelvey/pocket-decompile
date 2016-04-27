package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p011a.C0175d;
import android.support.v7.p013b.C0200b;
import android.support.v7.widget.C0234y;
import android.support.v7.widget.C0260z;
import android.support.v7.widget.aa;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class at extends C0260z implements OnLongClickListener {
    final /* synthetic */ ap f1098a;
    private final int[] f1099b;
    private C0175d f1100c;
    private TextView f1101d;
    private ImageView f1102e;
    private View f1103f;

    public at(ap apVar, Context context, C0175d c0175d, boolean z) {
        this.f1098a = apVar;
        super(context, null, C0200b.actionBarTabStyle);
        this.f1099b = new int[]{16842964};
        this.f1100c = c0175d;
        bk a = bk.m2000a(context, null, this.f1099b, C0200b.actionBarTabStyle, 0);
        if (a.m2015e(0)) {
            setBackgroundDrawable(a.m2004a(0));
        }
        a.m2008b();
        if (z) {
            setGravity(8388627);
        }
        m1891a();
    }

    public void m1891a() {
        C0175d c0175d = this.f1100c;
        View c = c0175d.m1186c();
        if (c != null) {
            at parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f1103f = c;
            if (this.f1101d != null) {
                this.f1101d.setVisibility(8);
            }
            if (this.f1102e != null) {
                this.f1102e.setVisibility(8);
                this.f1102e.setImageDrawable(null);
                return;
            }
            return;
        }
        if (this.f1103f != null) {
            removeView(this.f1103f);
            this.f1103f = null;
        }
        Drawable a = c0175d.m1184a();
        CharSequence b = c0175d.m1185b();
        if (a != null) {
            if (this.f1102e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams aaVar = new aa(-2, -2);
                aaVar.f1410h = 16;
                imageView.setLayoutParams(aaVar);
                addView(imageView, 0);
                this.f1102e = imageView;
            }
            this.f1102e.setImageDrawable(a);
            this.f1102e.setVisibility(0);
        } else if (this.f1102e != null) {
            this.f1102e.setVisibility(8);
            this.f1102e.setImageDrawable(null);
        }
        boolean z = !TextUtils.isEmpty(b);
        if (z) {
            if (this.f1101d == null) {
                imageView = new C0234y(getContext(), null, C0200b.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                aaVar = new aa(-2, -2);
                aaVar.f1410h = 16;
                imageView.setLayoutParams(aaVar);
                addView(imageView);
                this.f1101d = imageView;
            }
            this.f1101d.setText(b);
            this.f1101d.setVisibility(0);
        } else if (this.f1101d != null) {
            this.f1101d.setVisibility(8);
            this.f1101d.setText(null);
        }
        if (this.f1102e != null) {
            this.f1102e.setContentDescription(c0175d.m1188e());
        }
        if (z || TextUtils.isEmpty(c0175d.m1188e())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public void m1892a(C0175d c0175d) {
        this.f1100c = c0175d;
        m1891a();
    }

    public C0175d m1893b() {
        return this.f1100c;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0175d.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(C0175d.class.getName());
        }
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f1100c.m1188e(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1098a.f1086b > 0 && getMeasuredWidth() > this.f1098a.f1086b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.f1098a.f1086b, 1073741824), i2);
        }
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }
}
