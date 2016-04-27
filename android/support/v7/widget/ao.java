package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class ao {
    private Method f1426a;
    private Method f1427b;
    private Method f1428c;
    private Method f1429d;

    ao() {
        try {
            this.f1426a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f1426a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.f1427b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f1427b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.f1428c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f1428c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.f1429d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.f1429d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    void m2244a(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1426a != null) {
            try {
                this.f1426a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m2245a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.f1428c != null) {
            try {
                this.f1428c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }

    void m2246b(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1427b != null) {
            try {
                this.f1427b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }
}
