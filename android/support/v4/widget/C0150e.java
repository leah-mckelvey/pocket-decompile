package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.e */
public abstract class C0150e extends BaseAdapter implements C0149j, Filterable {
    protected boolean f481a;
    protected boolean f482b;
    protected Cursor f483c;
    protected Context f484d;
    protected int f485e;
    protected C0152g f486f;
    protected DataSetObserver f487g;
    protected C0154i f488h;
    protected FilterQueryProvider f489i;

    public C0150e(Context context, Cursor cursor, boolean z) {
        m1074a(context, cursor, z ? 1 : 2);
    }

    public Cursor m1071a() {
        return this.f483c;
    }

    public Cursor m1072a(CharSequence charSequence) {
        return this.f489i != null ? this.f489i.runQuery(charSequence) : this.f483c;
    }

    public abstract View m1073a(Context context, Cursor cursor, ViewGroup viewGroup);

    void m1074a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f482b = true;
        } else {
            this.f482b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f483c = cursor;
        this.f481a = z;
        this.f484d = context;
        this.f485e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f486f = new C0152g(this);
            this.f487g = new C0153h();
        } else {
            this.f486f = null;
            this.f487g = null;
        }
        if (z) {
            if (this.f486f != null) {
                cursor.registerContentObserver(this.f486f);
            }
            if (this.f487g != null) {
                cursor.registerDataSetObserver(this.f487g);
            }
        }
    }

    public void m1075a(Cursor cursor) {
        Cursor b = m1077b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void m1076a(View view, Context context, Cursor cursor);

    public Cursor m1077b(Cursor cursor) {
        if (cursor == this.f483c) {
            return null;
        }
        Cursor cursor2 = this.f483c;
        if (cursor2 != null) {
            if (this.f486f != null) {
                cursor2.unregisterContentObserver(this.f486f);
            }
            if (this.f487g != null) {
                cursor2.unregisterDataSetObserver(this.f487g);
            }
        }
        this.f483c = cursor;
        if (cursor != null) {
            if (this.f486f != null) {
                cursor.registerContentObserver(this.f486f);
            }
            if (this.f487g != null) {
                cursor.registerDataSetObserver(this.f487g);
            }
            this.f485e = cursor.getColumnIndexOrThrow("_id");
            this.f481a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f485e = -1;
        this.f481a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View m1078b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return m1073a(context, cursor, viewGroup);
    }

    protected void m1079b() {
        if (this.f482b && this.f483c != null && !this.f483c.isClosed()) {
            this.f481a = this.f483c.requery();
        }
    }

    public CharSequence m1080c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        return (!this.f481a || this.f483c == null) ? 0 : this.f483c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f481a) {
            return null;
        }
        this.f483c.moveToPosition(i);
        if (view == null) {
            view = m1078b(this.f484d, this.f483c, viewGroup);
        }
        m1076a(view, this.f484d, this.f483c);
        return view;
    }

    public Filter getFilter() {
        if (this.f488h == null) {
            this.f488h = new C0154i(this);
        }
        return this.f488h;
    }

    public Object getItem(int i) {
        if (!this.f481a || this.f483c == null) {
            return null;
        }
        this.f483c.moveToPosition(i);
        return this.f483c;
    }

    public long getItemId(int i) {
        return (this.f481a && this.f483c != null && this.f483c.moveToPosition(i)) ? this.f483c.getLong(this.f485e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f481a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f483c.moveToPosition(i)) {
            if (view == null) {
                view = m1073a(this.f484d, this.f483c, viewGroup);
            }
            m1076a(view, this.f484d, this.f483c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
