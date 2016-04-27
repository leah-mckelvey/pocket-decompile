package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ah {
    private static final ThreadLocal f21a;
    private static final ThreadLocal f22b;
    private static final Matrix f23c;

    static {
        f21a = new ThreadLocal();
        f22b = new ThreadLocal();
        f23c = new Matrix();
    }

    public static void m29a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) f21a.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f21a.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.set(f23c);
            matrix = matrix2;
        }
        m30a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f22b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void m30a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m30a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
