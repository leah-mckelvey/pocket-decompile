package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0207i;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements aa {
    private C0248m f794a;
    private ImageView f795b;
    private RadioButton f796c;
    private TextView f797d;
    private CheckBox f798e;
    private TextView f799f;
    private Drawable f800g;
    private int f801h;
    private Context f802i;
    private boolean f803j;
    private int f804k;
    private Context f805l;
    private LayoutInflater f806m;
    private boolean f807n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f805l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.MenuView, i, 0);
        this.f800g = obtainStyledAttributes.getDrawable(C0210l.MenuView_android_itemBackground);
        this.f801h = obtainStyledAttributes.getResourceId(C0210l.MenuView_android_itemTextAppearance, -1);
        this.f803j = obtainStyledAttributes.getBoolean(C0210l.MenuView_preserveIconSpacing, false);
        this.f802i = context;
        obtainStyledAttributes.recycle();
    }

    private void m1530b() {
        this.f795b = (ImageView) getInflater().inflate(C0207i.abc_list_menu_item_icon, this, false);
        addView(this.f795b, 0);
    }

    private void m1531c() {
        this.f796c = (RadioButton) getInflater().inflate(C0207i.abc_list_menu_item_radio, this, false);
        addView(this.f796c);
    }

    private void m1532d() {
        this.f798e = (CheckBox) getInflater().inflate(C0207i.abc_list_menu_item_checkbox, this, false);
        addView(this.f798e);
    }

    private LayoutInflater getInflater() {
        if (this.f806m == null) {
            this.f806m = LayoutInflater.from(this.f805l);
        }
        return this.f806m;
    }

    public void m1533a(C0248m c0248m, int i) {
        this.f794a = c0248m;
        this.f804k = i;
        setVisibility(c0248m.isVisible() ? 0 : 8);
        setTitle(c0248m.m1676a((aa) this));
        setCheckable(c0248m.isCheckable());
        m1534a(c0248m.m1689f(), c0248m.m1685d());
        setIcon(c0248m.getIcon());
        setEnabled(c0248m.isEnabled());
    }

    public void m1534a(boolean z, char c) {
        int i = (z && this.f794a.m1689f()) ? 0 : 8;
        if (i == 0) {
            this.f799f.setText(this.f794a.m1687e());
        }
        if (this.f799f.getVisibility() != i) {
            this.f799f.setVisibility(i);
        }
    }

    public boolean m1535a() {
        return false;
    }

    public C0248m getItemData() {
        return this.f794a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f800g);
        this.f797d = (TextView) findViewById(C0205g.title);
        if (this.f801h != -1) {
            this.f797d.setTextAppearance(this.f802i, this.f801h);
        }
        this.f799f = (TextView) findViewById(C0205g.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f795b != null && this.f803j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f795b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f796c != null || this.f798e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f794a.m1690g()) {
                if (this.f796c == null) {
                    m1531c();
                }
                compoundButton = this.f796c;
                compoundButton2 = this.f798e;
            } else {
                if (this.f798e == null) {
                    m1532d();
                }
                compoundButton = this.f798e;
                compoundButton2 = this.f796c;
            }
            if (z) {
                compoundButton.setChecked(this.f794a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f798e != null) {
                this.f798e.setVisibility(8);
            }
            if (this.f796c != null) {
                this.f796c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f794a.m1690g()) {
            if (this.f796c == null) {
                m1531c();
            }
            compoundButton = this.f796c;
        } else {
            if (this.f798e == null) {
                m1532d();
            }
            compoundButton = this.f798e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f807n = z;
        this.f803j = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f794a.m1692i() || this.f807n) ? 1 : 0;
        if (i == 0 && !this.f803j) {
            return;
        }
        if (this.f795b != null || drawable != null || this.f803j) {
            if (this.f795b == null) {
                m1530b();
            }
            if (drawable != null || this.f803j) {
                ImageView imageView = this.f795b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f795b.getVisibility() != 0) {
                    this.f795b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f795b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f797d.setText(charSequence);
            if (this.f797d.getVisibility() != 0) {
                this.f797d.setVisibility(0);
            }
        } else if (this.f797d.getVisibility() != 8) {
            this.f797d.setVisibility(8);
        }
    }
}
