package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

class ax implements OnClickListener, bd {
    final /* synthetic */ au f1151a;
    private AlertDialog f1152b;
    private ListAdapter f1153c;
    private CharSequence f1154d;

    private ax(au auVar) {
        this.f1151a = auVar;
    }

    public void m1932a() {
        if (this.f1152b != null) {
            this.f1152b.dismiss();
            this.f1152b = null;
        }
    }

    public void m1933a(ListAdapter listAdapter) {
        this.f1153c = listAdapter;
    }

    public void m1934a(CharSequence charSequence) {
        this.f1154d = charSequence;
    }

    public boolean m1935b() {
        return this.f1152b != null ? this.f1152b.isShowing() : false;
    }

    public void m1936c() {
        if (this.f1153c != null) {
            Builder builder = new Builder(this.f1151a.getContext());
            if (this.f1154d != null) {
                builder.setTitle(this.f1154d);
            }
            this.f1152b = builder.setSingleChoiceItems(this.f1153c, this.f1151a.getSelectedItemPosition(), this).create();
            this.f1152b.show();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1151a.setSelection(i);
        if (this.f1151a.s != null) {
            this.f1151a.m1900a(null, i, this.f1153c.getItemId(i));
        }
        m1932a();
    }
}
