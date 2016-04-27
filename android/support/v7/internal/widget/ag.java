package android.support.v7.internal.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class ag implements OnScrollChangedListener {
    final /* synthetic */ Field f1063a;
    final /* synthetic */ PopupWindow f1064b;
    final /* synthetic */ OnScrollChangedListener f1065c;

    ag(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
        this.f1063a = field;
        this.f1064b = popupWindow;
        this.f1065c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f1063a.get(this.f1064b);
            if (weakReference != null && weakReference.get() != null) {
                this.f1065c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
