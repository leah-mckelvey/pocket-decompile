package android.support.v7.p011a;

import android.content.Context;
import android.widget.ArrayAdapter;

/* renamed from: android.support.v7.a.n */
class C0185n extends ArrayAdapter {
    public C0185n(Context context, int i, int i2, CharSequence[] charSequenceArr) {
        super(context, i, i2, charSequenceArr);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }
}
