package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.q */
public abstract class C0161q extends C0150e {
    private int f495j;
    private int f496k;
    private LayoutInflater f497l;

    public C0161q(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f496k = i;
        this.f495j = i;
        this.f497l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View m1089a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f497l.inflate(this.f495j, viewGroup, false);
    }

    public View m1090b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f497l.inflate(this.f496k, viewGroup, false);
    }
}
