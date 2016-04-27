package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class am implements OnTouchListener {
    final /* synthetic */ ab f1424a;

    private am(ab abVar) {
        this.f1424a = abVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f1424a.f1164d != null && this.f1424a.f1164d.isShowing() && x >= 0 && x < this.f1424a.f1164d.getWidth() && y >= 0 && y < this.f1424a.f1164d.getHeight()) {
            this.f1424a.f1158A.postDelayed(this.f1424a.f1182v, 250);
        } else if (action == 1) {
            this.f1424a.f1158A.removeCallbacks(this.f1424a.f1182v);
        }
        return false;
    }
}
