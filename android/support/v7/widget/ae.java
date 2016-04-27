package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class ae implements OnItemSelectedListener {
    final /* synthetic */ ab f1413a;

    ae(ab abVar) {
        this.f1413a = abVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            af a = this.f1413a.f1166f;
            if (a != null) {
                a.f1414f = false;
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
