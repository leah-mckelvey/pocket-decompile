package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.p007e.C0094a;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v7.internal.widget.p */
public class C0275p extends DataSetObservable {
    private static final String f1263a;
    private static final Object f1264b;
    private static final Map f1265c;
    private final Object f1266d;
    private final List f1267e;
    private final List f1268f;
    private final Context f1269g;
    private final String f1270h;
    private Intent f1271i;
    private C0278s f1272j;
    private int f1273k;
    private boolean f1274l;
    private boolean f1275m;
    private boolean f1276n;
    private boolean f1277o;
    private C0280u f1278p;

    static {
        f1263a = C0275p.class.getSimpleName();
        f1264b = new Object();
        f1265c = new HashMap();
    }

    private boolean m2082a(C0279t c0279t) {
        boolean add = this.f1268f.add(c0279t);
        if (add) {
            this.f1276n = true;
            m2090i();
            m2085d();
            m2087f();
            notifyChanged();
        }
        return add;
    }

    private void m2085d() {
        if (!this.f1275m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1276n) {
            this.f1276n = false;
            if (!TextUtils.isEmpty(this.f1270h)) {
                C0094a.m533a(new C0281v(), this.f1268f, this.f1270h);
            }
        }
    }

    private void m2086e() {
        int g = m2088g() | m2089h();
        m2090i();
        if (g != 0) {
            m2087f();
            notifyChanged();
        }
    }

    private boolean m2087f() {
        if (this.f1272j == null || this.f1271i == null || this.f1267e.isEmpty() || this.f1268f.isEmpty()) {
            return false;
        }
        this.f1272j.m2099a(this.f1271i, this.f1267e, Collections.unmodifiableList(this.f1268f));
        return true;
    }

    private boolean m2088g() {
        if (!this.f1277o || this.f1271i == null) {
            return false;
        }
        this.f1277o = false;
        this.f1267e.clear();
        List queryIntentActivities = this.f1269g.getPackageManager().queryIntentActivities(this.f1271i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1267e.add(new C0277r(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m2089h() {
        if (!this.f1274l || !this.f1276n || TextUtils.isEmpty(this.f1270h)) {
            return false;
        }
        this.f1274l = false;
        this.f1275m = true;
        m2091j();
        return true;
    }

    private void m2090i() {
        int size = this.f1268f.size() - this.f1273k;
        if (size > 0) {
            this.f1276n = true;
            for (int i = 0; i < size; i++) {
                C0279t c0279t = (C0279t) this.f1268f.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2091j() {
        /*
        r9 = this;
        r8 = 1;
        r0 = r9.f1269g;	 Catch:{ FileNotFoundException -> 0x00d2 }
        r1 = r9.f1270h;	 Catch:{ FileNotFoundException -> 0x00d2 }
        r1 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00d2 }
        r2 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r0 = 0;
        r2.setInput(r1, r0);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r0 = 0;
    L_0x0012:
        if (r0 == r8) goto L_0x001c;
    L_0x0014:
        r3 = 2;
        if (r0 == r3) goto L_0x001c;
    L_0x0017:
        r0 = r2.next();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        goto L_0x0012;
    L_0x001c:
        r0 = "historical-records";
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r0 = r0.equals(r3);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        if (r0 != 0) goto L_0x0051;
    L_0x0028:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r2 = "Share records file does not start with historical-records tag.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
    L_0x0030:
        r0 = move-exception;
        r2 = f1263a;	 Catch:{ all -> 0x00c7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r3.<init>();	 Catch:{ all -> 0x00c7 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c7 }
        r4 = r9.f1270h;	 Catch:{ all -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c7 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c7 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c7 }
        if (r1 == 0) goto L_0x0050;
    L_0x004d:
        r1.close();	 Catch:{ IOException -> 0x00ce }
    L_0x0050:
        return;
    L_0x0051:
        r0 = r9.f1268f;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r0.clear();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
    L_0x0056:
        r3 = r2.next();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        if (r3 != r8) goto L_0x0064;
    L_0x005c:
        if (r1 == 0) goto L_0x0050;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x0062 }
        goto L_0x0050;
    L_0x0062:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0064:
        r4 = 3;
        if (r3 == r4) goto L_0x0056;
    L_0x0067:
        r4 = 4;
        if (r3 == r4) goto L_0x0056;
    L_0x006a:
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r4 = "historical-record";
        r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        if (r3 != 0) goto L_0x00a1;
    L_0x0076:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r2 = "Share records file not well-formed.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
    L_0x007e:
        r0 = move-exception;
        r2 = f1263a;	 Catch:{ all -> 0x00c7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r3.<init>();	 Catch:{ all -> 0x00c7 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c7 }
        r4 = r9.f1270h;	 Catch:{ all -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c7 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c7 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c7 }
        if (r1 == 0) goto L_0x0050;
    L_0x009b:
        r1.close();	 Catch:{ IOException -> 0x009f }
        goto L_0x0050;
    L_0x009f:
        r0 = move-exception;
        goto L_0x0050;
    L_0x00a1:
        r3 = 0;
        r4 = "activity";
        r3 = r2.getAttributeValue(r3, r4);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r4 = 0;
        r5 = "time";
        r4 = r2.getAttributeValue(r4, r5);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r6 = 0;
        r7 = "weight";
        r6 = r2.getAttributeValue(r6, r7);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r6 = java.lang.Float.parseFloat(r6);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r7 = new android.support.v7.internal.widget.t;	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r7.<init>(r3, r4, r6);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        r0.add(r7);	 Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x007e }
        goto L_0x0056;
    L_0x00c7:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00cd;
    L_0x00ca:
        r1.close();	 Catch:{ IOException -> 0x00d0 }
    L_0x00cd:
        throw r0;
    L_0x00ce:
        r0 = move-exception;
        goto L_0x0050;
    L_0x00d0:
        r1 = move-exception;
        goto L_0x00cd;
    L_0x00d2:
        r0 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.p.j():void");
    }

    public int m2092a() {
        int size;
        synchronized (this.f1266d) {
            m2086e();
            size = this.f1267e.size();
        }
        return size;
    }

    public int m2093a(ResolveInfo resolveInfo) {
        synchronized (this.f1266d) {
            m2086e();
            List list = this.f1267e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0277r) list.get(i)).f1279a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m2094a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1266d) {
            m2086e();
            resolveInfo = ((C0277r) this.f1267e.get(i)).f1279a;
        }
        return resolveInfo;
    }

    public Intent m2095b(int i) {
        synchronized (this.f1266d) {
            if (this.f1271i == null) {
                return null;
            }
            m2086e();
            C0277r c0277r = (C0277r) this.f1267e.get(i);
            ComponentName componentName = new ComponentName(c0277r.f1279a.activityInfo.packageName, c0277r.f1279a.activityInfo.name);
            Intent intent = new Intent(this.f1271i);
            intent.setComponent(componentName);
            if (this.f1278p != null) {
                if (this.f1278p.m2100a(this, new Intent(intent))) {
                    return null;
                }
            }
            m2082a(new C0279t(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m2096b() {
        synchronized (this.f1266d) {
            m2086e();
            if (this.f1267e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0277r) this.f1267e.get(0)).f1279a;
            return resolveInfo;
        }
    }

    public void m2097c(int i) {
        synchronized (this.f1266d) {
            m2086e();
            C0277r c0277r = (C0277r) this.f1267e.get(i);
            C0277r c0277r2 = (C0277r) this.f1267e.get(0);
            m2082a(new C0279t(new ComponentName(c0277r.f1279a.activityInfo.packageName, c0277r.f1279a.activityInfo.name), System.currentTimeMillis(), c0277r2 != null ? (c0277r2.f1280b - c0277r.f1280b) + 5.0f : 1.0f));
        }
    }
}
