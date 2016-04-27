package android.support.v7.p011a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/* renamed from: android.support.v7.a.g */
public class C0178g {
    public int f571A;
    public boolean f572B;
    public boolean[] f573C;
    public boolean f574D;
    public boolean f575E;
    public int f576F;
    public OnMultiChoiceClickListener f577G;
    public Cursor f578H;
    public String f579I;
    public String f580J;
    public OnItemSelectedListener f581K;
    public C0183l f582L;
    public boolean f583M;
    public final Context f584a;
    public final LayoutInflater f585b;
    public int f586c;
    public Drawable f587d;
    public int f588e;
    public CharSequence f589f;
    public View f590g;
    public CharSequence f591h;
    public CharSequence f592i;
    public OnClickListener f593j;
    public CharSequence f594k;
    public OnClickListener f595l;
    public CharSequence f596m;
    public OnClickListener f597n;
    public boolean f598o;
    public OnCancelListener f599p;
    public OnDismissListener f600q;
    public OnKeyListener f601r;
    public CharSequence[] f602s;
    public ListAdapter f603t;
    public OnClickListener f604u;
    public int f605v;
    public View f606w;
    public int f607x;
    public int f608y;
    public int f609z;

    public C0178g(Context context) {
        this.f586c = 0;
        this.f588e = 0;
        this.f572B = false;
        this.f576F = -1;
        this.f583M = true;
        this.f584a = context;
        this.f598o = true;
        this.f585b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void m1225b(C0176e c0176e) {
        ListAdapter c0185n;
        ListView listView = (ListView) this.f585b.inflate(c0176e.f537H, null);
        if (!this.f574D) {
            int k = this.f575E ? c0176e.f539J : c0176e.f540K;
            c0185n = this.f578H == null ? this.f603t != null ? this.f603t : new C0185n(this.f584a, k, 16908308, this.f602s) : new SimpleCursorAdapter(this.f584a, k, this.f578H, new String[]{this.f579I}, new int[]{16908308});
        } else if (this.f578H == null) {
            c0185n = new C0179h(this, this.f584a, c0176e.f538I, 16908308, this.f602s, listView);
        } else {
            Object c0180i = new C0180i(this, this.f584a, this.f578H, false, listView, c0176e);
        }
        if (this.f582L != null) {
            this.f582L.m1227a(listView);
        }
        c0176e.f533D = c0185n;
        c0176e.f534E = this.f576F;
        if (this.f604u != null) {
            listView.setOnItemClickListener(new C0181j(this, c0176e));
        } else if (this.f577G != null) {
            listView.setOnItemClickListener(new C0182k(this, listView, c0176e));
        }
        if (this.f581K != null) {
            listView.setOnItemSelectedListener(this.f581K);
        }
        if (this.f575E) {
            listView.setChoiceMode(1);
        } else if (this.f574D) {
            listView.setChoiceMode(2);
        }
        c0176e.f549f = listView;
    }

    public void m1226a(C0176e c0176e) {
        if (this.f590g != null) {
            c0176e.m1220b(this.f590g);
        } else {
            if (this.f589f != null) {
                c0176e.m1217a(this.f589f);
            }
            if (this.f587d != null) {
                c0176e.m1215a(this.f587d);
            }
            if (this.f586c != 0) {
                c0176e.m1219b(this.f586c);
            }
            if (this.f588e != 0) {
                c0176e.m1219b(c0176e.m1223c(this.f588e));
            }
        }
        if (this.f591h != null) {
            c0176e.m1221b(this.f591h);
        }
        if (this.f592i != null) {
            c0176e.m1214a(-1, this.f592i, this.f593j, null);
        }
        if (this.f594k != null) {
            c0176e.m1214a(-2, this.f594k, this.f595l, null);
        }
        if (this.f596m != null) {
            c0176e.m1214a(-3, this.f596m, this.f597n, null);
        }
        if (!(this.f602s == null && this.f578H == null && this.f603t == null)) {
            m1225b(c0176e);
        }
        if (this.f606w != null) {
            if (this.f572B) {
                c0176e.m1216a(this.f606w, this.f607x, this.f608y, this.f609z, this.f571A);
                return;
            }
            c0176e.m1224c(this.f606w);
        } else if (this.f605v != 0) {
            c0176e.m1213a(this.f605v);
        }
    }
}
