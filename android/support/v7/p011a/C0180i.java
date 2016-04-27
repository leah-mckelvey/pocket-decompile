package android.support.v7.p011a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.a.i */
class C0180i extends CursorAdapter {
    final /* synthetic */ ListView f612a;
    final /* synthetic */ C0176e f613b;
    final /* synthetic */ C0178g f614c;
    private final int f615d;
    private final int f616e;

    C0180i(C0178g c0178g, Context context, Cursor cursor, boolean z, ListView listView, C0176e c0176e) {
        this.f614c = c0178g;
        this.f612a = listView;
        this.f613b = c0176e;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f615d = cursor2.getColumnIndexOrThrow(this.f614c.f579I);
        this.f616e = cursor2.getColumnIndexOrThrow(this.f614c.f580J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f615d));
        this.f612a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f616e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f614c.f585b.inflate(this.f613b.f538I, viewGroup, false);
    }
}
