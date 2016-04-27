package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class af extends PopupWindow {
    private final boolean f1062a;

    public af(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.m2000a(context, attributeSet, C0210l.PopupWindow, i, 0);
        this.f1062a = a.m2005a(C0210l.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(a.m2004a(C0210l.PopupWindow_android_popupBackground));
        a.m2008b();
        if (VERSION.SDK_INT < 14) {
            m1837a(this);
        }
    }

    private static void m1837a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new ag(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (VERSION.SDK_INT < 21 && this.f1062a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (VERSION.SDK_INT < 21 && this.f1062a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (VERSION.SDK_INT >= 21 || !this.f1062a) ? i2 : i2 - view.getHeight();
        super.update(view, i, height, i3, i4);
    }
}
