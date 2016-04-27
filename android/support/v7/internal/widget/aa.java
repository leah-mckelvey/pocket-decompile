package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

class aa extends DataSetObserver {
    final /* synthetic */ C0261y f1059a;
    private Parcelable f1060b;

    aa(C0261y c0261y) {
        this.f1059a = c0261y;
        this.f1060b = null;
    }

    public void onChanged() {
        this.f1059a.f1124u = true;
        this.f1059a.f1104A = this.f1059a.f1129z;
        this.f1059a.f1129z = this.f1059a.getAdapter().getCount();
        if (!this.f1059a.getAdapter().hasStableIds() || this.f1060b == null || this.f1059a.f1104A != 0 || this.f1059a.f1129z <= 0) {
            this.f1059a.m1908j();
        } else {
            this.f1059a.onRestoreInstanceState(this.f1060b);
            this.f1060b = null;
        }
        this.f1059a.m1903e();
        this.f1059a.requestLayout();
    }

    public void onInvalidated() {
        this.f1059a.f1124u = true;
        if (this.f1059a.getAdapter().hasStableIds()) {
            this.f1060b = this.f1059a.onSaveInstanceState();
        }
        this.f1059a.f1104A = this.f1059a.f1129z;
        this.f1059a.f1129z = 0;
        this.f1059a.f1127x = -1;
        this.f1059a.f1128y = Long.MIN_VALUE;
        this.f1059a.f1125v = -1;
        this.f1059a.f1126w = Long.MIN_VALUE;
        this.f1059a.f1118o = false;
        this.f1059a.m1903e();
        this.f1059a.requestLayout();
    }
}
