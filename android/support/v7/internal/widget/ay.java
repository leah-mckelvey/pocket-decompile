package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class ay implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter f1155a;
    private ListAdapter f1156b;

    public ay(SpinnerAdapter spinnerAdapter) {
        this.f1155a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f1156b = (ListAdapter) spinnerAdapter;
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f1156b;
        return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
    }

    public int getCount() {
        return this.f1155a == null ? 0 : this.f1155a.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.f1155a == null ? null : this.f1155a.getDropDownView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.f1155a == null ? null : this.f1155a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f1155a == null ? -1 : this.f1155a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.f1155a != null && this.f1155a.hasStableIds();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f1156b;
        return listAdapter != null ? listAdapter.isEnabled(i) : true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1155a != null) {
            this.f1155a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1155a != null) {
            this.f1155a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
