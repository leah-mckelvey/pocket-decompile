package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.i */
class C0154i extends Filter {
    C0149j f492a;

    C0154i(C0149j c0149j) {
        this.f492a = c0149j;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f492a.m1070c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f492a.m1068a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f492a.m1067a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f492a.m1069a((Cursor) filterResults.values);
        }
    }
}
