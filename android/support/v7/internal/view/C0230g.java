package android.support.v7.internal.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.internal.view.g */
class C0230g implements OnMenuItemClickListener {
    private static final Class[] f742a;
    private Object f743b;
    private Method f744c;

    static {
        f742a = new Class[]{MenuItem.class};
    }

    public C0230g(Object obj, String str) {
        this.f743b = obj;
        Class cls = obj.getClass();
        try {
            this.f744c = cls.getMethod(str, f742a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f744c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f744c.invoke(this.f743b, new Object[]{menuItem})).booleanValue();
            }
            this.f744c.invoke(this.f743b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
