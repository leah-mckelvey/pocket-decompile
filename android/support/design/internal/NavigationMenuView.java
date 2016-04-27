package android.support.design.internal;

import android.content.Context;
import android.support.v7.internal.view.menu.C0007z;
import android.support.v7.internal.view.menu.C0240i;
import android.util.AttributeSet;
import android.widget.ListView;

public class NavigationMenuView extends ListView implements C0007z {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m6a(C0240i c0240i) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
