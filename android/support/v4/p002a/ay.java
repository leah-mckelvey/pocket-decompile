package android.support.v4.p002a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p001b.C0034a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.a.ay */
public class ay implements Iterable {
    private static final ba f150a;
    private final ArrayList f151b;
    private final Context f152c;

    static {
        if (VERSION.SDK_INT >= 11) {
            f150a = new bc();
        } else {
            f150a = new bb();
        }
    }

    private ay(Context context) {
        this.f151b = new ArrayList();
        this.f152c = context;
    }

    public static ay m257a(Context context) {
        return new ay(context);
    }

    public ay m258a(Activity activity) {
        Intent intent = null;
        if (activity instanceof az) {
            intent = ((az) activity).m263a();
        }
        Intent a = intent == null ? aq.m230a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f152c.getPackageManager());
            }
            m259a(component);
            m260a(a);
        }
        return this;
    }

    public ay m259a(ComponentName componentName) {
        int size = this.f151b.size();
        try {
            Intent a = aq.m231a(this.f152c, componentName);
            while (a != null) {
                this.f151b.add(size, a);
                a = aq.m231a(this.f152c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public ay m260a(Intent intent) {
        this.f151b.add(intent);
        return this;
    }

    public void m261a() {
        m262a(null);
    }

    public void m262a(Bundle bundle) {
        if (this.f151b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f151b.toArray(new Intent[this.f151b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0034a.m180a(this.f152c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f152c.startActivity(intent);
        }
    }

    public Iterator iterator() {
        return this.f151b.iterator();
    }
}
