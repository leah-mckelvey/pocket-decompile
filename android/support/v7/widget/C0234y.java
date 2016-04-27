package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.internal.p017b.C0222a;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.y */
public class C0234y extends TextView {
    public C0234y(Context context) {
        this(context, null);
    }

    public C0234y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0234y(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0210l.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, C0210l.TextAppearance);
            if (obtainStyledAttributes.hasValue(C0210l.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes.getBoolean(C0210l.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0210l.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0210l.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new C0222a(getContext()) : null);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0210l.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0210l.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0210l.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
