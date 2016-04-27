package android.support.v7.internal.p016a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.p009g.C0103a;
import android.support.v7.internal.view.C0225b;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.C0234y;
import android.support.v7.widget.C0285p;
import android.support.v7.widget.C0300q;
import android.support.v7.widget.C0301r;
import android.support.v7.widget.C0302s;
import android.support.v7.widget.C0303t;
import android.support.v7.widget.C0304u;
import android.support.v7.widget.C0305v;
import android.support.v7.widget.C0306w;
import android.support.v7.widget.C0307x;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.pocket.doorway.C0339o;
import java.lang.reflect.Constructor;
import java.util.Map;

/* renamed from: android.support.v7.internal.a.a */
public class C0214a {
    static final Class[] f672a;
    private static final Map f673b;
    private final Object[] f674c;

    static {
        f672a = new Class[]{Context.class, AttributeSet.class};
        f673b = new C0103a();
    }

    public C0214a() {
        this.f674c = new Object[2];
    }

    private static Context m1373a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0210l.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0210l.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0225b) && ((C0225b) context).m1459a() == i) ? context : new C0225b(context, i) : context;
    }

    private View m1374a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f674c[0] = context;
            this.f674c[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                a = m1375a(context, str, "android.widget.");
                return a;
            }
            a = m1375a(context, str, null);
            this.f674c[0] = null;
            this.f674c[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f674c[0] = null;
            this.f674c[1] = null;
        }
    }

    private View m1375a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f673b.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f672a);
                f673b.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f674c);
    }

    public final View m1376a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = C0214a.m1373a(context2, attributeSet, z2, z3);
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 7;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 4;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 6;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = 9;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 1;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 3;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 5;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 2;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = null;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 8;
                    break;
                }
                break;
        }
        switch (obj) {
            case C0339o.View_android_theme /*0*/:
                return new C0303t(context2, attributeSet);
            case C0339o.View_android_focusable /*1*/:
                return new C0307x(context2, attributeSet);
            case C0339o.View_paddingStart /*2*/:
                return new C0301r(context2, attributeSet);
            case C0339o.View_paddingEnd /*3*/:
                return new C0305v(context2, attributeSet);
            case C0339o.View_theme /*4*/:
                return new C0302s(context2, attributeSet);
            case C0339o.View_backgroundTint /*5*/:
                return new C0285p(context2, attributeSet);
            case C0339o.View_backgroundTintMode /*6*/:
                return new C0304u(context2, attributeSet);
            case C0339o.Toolbar_contentInsetRight /*7*/:
                return new C0306w(context2, attributeSet);
            case C0339o.Toolbar_popupTheme /*8*/:
                return new C0300q(context2, attributeSet);
            case C0339o.Toolbar_titleTextAppearance /*9*/:
                return new C0234y(context2, attributeSet);
            default:
                return context != context2 ? m1374a(context2, str, attributeSet) : null;
        }
    }
}
