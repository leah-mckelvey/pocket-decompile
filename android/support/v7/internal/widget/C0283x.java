package android.support.v7.internal.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v7.internal.widget.x */
class C0283x implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView f1292a;

    private void m2111a() {
        if (this.f1292a.f1038l != null) {
            this.f1292a.f1038l.onDismiss();
        }
    }

    public void onClick(View view) {
        if (view == this.f1292a.f1033g) {
            this.f1292a.m1829b();
            Intent b = this.f1292a.f1028b.m2109d().m2095b(this.f1292a.f1028b.m2109d().m2093a(this.f1292a.f1028b.m2107b()));
            if (b != null) {
                b.addFlags(524288);
                this.f1292a.getContext().startActivity(b);
            }
        } else if (view == this.f1292a.f1031e) {
            this.f1292a.f1039m = false;
            this.f1292a.m1819a(this.f1292a.f1040n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onDismiss() {
        m2111a();
        if (this.f1292a.f1027a != null) {
            this.f1292a.f1027a.m613a(false);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (((C0282w) adapterView.getAdapter()).getItemViewType(i)) {
            case C0339o.View_android_theme /*0*/:
                this.f1292a.m1829b();
                if (!this.f1292a.f1039m) {
                    if (!this.f1292a.f1028b.m2110e()) {
                        i++;
                    }
                    Intent b = this.f1292a.f1028b.m2109d().m2095b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.f1292a.getContext().startActivity(b);
                    }
                } else if (i > 0) {
                    this.f1292a.f1028b.m2109d().m2097c(i);
                }
            case C0339o.View_android_focusable /*1*/:
                this.f1292a.m1819a(Integer.MAX_VALUE);
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.f1292a.f1033g) {
            if (this.f1292a.f1028b.getCount() > 0) {
                this.f1292a.f1039m = true;
                this.f1292a.m1819a(this.f1292a.f1040n);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
