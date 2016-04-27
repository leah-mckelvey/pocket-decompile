package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p000h.au;
import android.support.v4.p003c.p004a.C0085m;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* renamed from: android.support.v7.widget.w */
public class C0306w extends RatingBar {
    private static final int[] f1498a;
    private Bitmap f1499b;

    static {
        f1498a = new int[]{16843067, 16843068};
    }

    public C0306w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.ratingBarStyle);
    }

    public C0306w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1498a, i, 0);
            Drawable b = a.m2007b(0);
            if (b != null) {
                setIndeterminateDrawable(m2300a(b));
            }
            b = a.m2007b(1);
            if (b != null) {
                setProgressDrawable(m2301a(b, false));
            }
            a.m2008b();
        }
    }

    private Drawable m2300a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m2301a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private Drawable m2301a(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof C0085m) {
            a = ((C0085m) drawable).m521a();
            if (a != null) {
                ((C0085m) drawable).m522a(m2301a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                boolean z2 = id == 16908301 || id == 16908303;
                drawableArr[i2] = m2301a(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.f1499b == null) {
                this.f1499b = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1499b != null) {
            setMeasuredDimension(au.m682a(this.f1499b.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
