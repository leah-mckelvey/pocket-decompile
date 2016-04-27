package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.C0141y;
import android.support.v4.p001b.C0034a;
import android.support.v4.p005d.p006a.C0091a;
import android.support.v7.p013b.C0201c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.internal.view.menu.i */
public class C0240i implements C0091a {
    private static final int[] f826d;
    CharSequence f827a;
    Drawable f828b;
    View f829c;
    private final Context f830e;
    private final Resources f831f;
    private boolean f832g;
    private boolean f833h;
    private C0193j f834i;
    private ArrayList f835j;
    private ArrayList f836k;
    private boolean f837l;
    private ArrayList f838m;
    private ArrayList f839n;
    private boolean f840o;
    private int f841p;
    private ContextMenuInfo f842q;
    private boolean f843r;
    private boolean f844s;
    private boolean f845t;
    private boolean f846u;
    private ArrayList f847v;
    private CopyOnWriteArrayList f848w;
    private C0248m f849x;
    private boolean f850y;

    static {
        f826d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0240i(Context context) {
        this.f841p = 0;
        this.f843r = false;
        this.f844s = false;
        this.f845t = false;
        this.f846u = false;
        this.f847v = new ArrayList();
        this.f848w = new CopyOnWriteArrayList();
        this.f830e = context;
        this.f831f = context.getResources();
        this.f835j = new ArrayList();
        this.f836k = new ArrayList();
        this.f837l = true;
        this.f838m = new ArrayList();
        this.f839n = new ArrayList();
        this.f840o = true;
        m1558e(true);
    }

    private static int m1550a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0248m) arrayList.get(size)).m1683c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0248m m1551a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0248m(this, i, i2, i3, i4, charSequence, i5);
    }

    private MenuItem m1552a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0240i.m1556d(i3);
        MenuItem a = m1551a(i, i2, i3, d, charSequence, this.f841p);
        if (this.f842q != null) {
            a.m1678a(this.f842q);
        }
        this.f835j.add(C0240i.m1550a(this.f835j, d), a);
        m1581b(true);
        return a;
    }

    private void m1553a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m1587d();
        if (view != null) {
            this.f829c = view;
            this.f827a = null;
            this.f828b = null;
        } else {
            if (i > 0) {
                this.f827a = d.getText(i);
            } else if (charSequence != null) {
                this.f827a = charSequence;
            }
            if (i2 > 0) {
                this.f828b = C0034a.m179a(m1589e(), i2);
            } else if (drawable != null) {
                this.f828b = drawable;
            }
            this.f829c = null;
        }
        m1581b(false);
    }

    private void m1554a(int i, boolean z) {
        if (i >= 0 && i < this.f835j.size()) {
            this.f835j.remove(i);
            if (z) {
                m1581b(true);
            }
        }
    }

    private boolean m1555a(ad adVar, C0243x c0243x) {
        boolean z = false;
        if (this.f848w.isEmpty()) {
            return false;
        }
        if (c0243x != null) {
            z = c0243x.m1631a(adVar);
        }
        Iterator it = this.f848w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0243x c0243x2 = (C0243x) weakReference.get();
            if (c0243x2 == null) {
                this.f848w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0243x2.m1631a(adVar) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private static int m1556d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f826d.length) {
            return (f826d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void m1557d(boolean z) {
        if (!this.f848w.isEmpty()) {
            m1591g();
            Iterator it = this.f848w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0243x c0243x = (C0243x) weakReference.get();
                if (c0243x == null) {
                    this.f848w.remove(weakReference);
                } else {
                    c0243x.m1633b(z);
                }
            }
            m1592h();
        }
    }

    private void m1558e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f831f.getConfiguration().keyboard != 1 && this.f831f.getBoolean(C0201c.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f833h = z2;
    }

    public int m1559a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0248m) this.f835j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0240i m1560a(int i) {
        this.f841p = i;
        return this;
    }

    protected C0240i m1561a(Drawable drawable) {
        m1553a(0, null, 0, drawable, null);
        return this;
    }

    protected C0240i m1562a(View view) {
        m1553a(0, null, 0, null, view);
        return this;
    }

    protected C0240i m1563a(CharSequence charSequence) {
        m1553a(0, charSequence, 0, null, null);
        return this;
    }

    C0248m m1564a(int i, KeyEvent keyEvent) {
        List list = this.f847v;
        list.clear();
        m1572a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0248m) list.get(0);
        }
        boolean b = m1582b();
        for (int i2 = 0; i2 < size; i2++) {
            C0248m c0248m = (C0248m) list.get(i2);
            char alphabeticShortcut = b ? c0248m.getAlphabeticShortcut() : c0248m.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0248m;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0248m;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0248m;
            }
        }
        return null;
    }

    protected String m1565a() {
        return "android:menu:actionviewstates";
    }

    public void m1566a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0141y.m970a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0141y.m974c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ad) item.getSubMenu()).m1566a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m1565a(), sparseArray);
        }
    }

    public void m1567a(C0193j c0193j) {
        this.f834i = c0193j;
    }

    void m1568a(C0248m c0248m) {
        this.f837l = true;
        m1581b(true);
    }

    public void m1569a(C0243x c0243x) {
        m1570a(c0243x, this.f830e);
    }

    public void m1570a(C0243x c0243x, Context context) {
        this.f848w.add(new WeakReference(c0243x));
        c0243x.m1629a(context, this);
        this.f840o = true;
    }

    void m1571a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f835j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0248m) this.f835j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m1690g() && menuItem2.isCheckable()) {
                menuItem2.m1681b(menuItem2 == menuItem);
            }
        }
    }

    void m1572a(List list, int i, KeyEvent keyEvent) {
        boolean b = m1582b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f835j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0248m c0248m = (C0248m) this.f835j.get(i2);
                if (c0248m.hasSubMenu()) {
                    ((C0240i) c0248m.getSubMenu()).m1572a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0248m.getAlphabeticShortcut() : c0248m.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0248m.isEnabled())) {
                    list.add(c0248m);
                }
            }
        }
    }

    public final void m1573a(boolean z) {
        if (!this.f846u) {
            this.f846u = true;
            Iterator it = this.f848w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0243x c0243x = (C0243x) weakReference.get();
                if (c0243x == null) {
                    this.f848w.remove(weakReference);
                } else {
                    c0243x.m1630a(this, z);
                }
            }
            this.f846u = false;
        }
    }

    boolean m1574a(C0240i c0240i, MenuItem menuItem) {
        return this.f834i != null && this.f834i.m1288a(c0240i, menuItem);
    }

    public boolean m1575a(MenuItem menuItem, int i) {
        return m1576a(menuItem, null, i);
    }

    public boolean m1576a(MenuItem menuItem, C0243x c0243x, int i) {
        C0248m c0248m = (C0248m) menuItem;
        if (c0248m == null || !c0248m.isEnabled()) {
            return false;
        }
        boolean b = c0248m.m1682b();
        C0118a a = c0248m.m1675a();
        boolean z = a != null && a.m617e();
        boolean expandActionView;
        if (c0248m.m1697n()) {
            expandActionView = c0248m.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m1573a(true);
            return expandActionView;
        } else if (c0248m.hasSubMenu() || z) {
            m1573a(false);
            if (!c0248m.hasSubMenu()) {
                c0248m.m1677a(new ad(m1589e(), this, c0248m));
            }
            ad adVar = (ad) c0248m.getSubMenu();
            if (z) {
                a.m612a((SubMenu) adVar);
            }
            expandActionView = m1555a(adVar, c0243x) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m1573a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m1573a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m1552a(0, 0, 0, this.f831f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1552a(i, i2, i3, this.f831f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1552a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m1552a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f830e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f831f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f831f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0248m c0248m = (C0248m) m1552a(i, i2, i3, charSequence);
        ad adVar = new ad(this.f830e, this, c0248m);
        c0248m.m1677a(adVar);
        return adVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m1577b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0248m) this.f835j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m1578b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m1565a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0141y.m970a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ad) item.getSubMenu()).m1578b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0141y.m973b(item);
                }
            }
        }
    }

    void m1579b(C0248m c0248m) {
        this.f840o = true;
        m1581b(true);
    }

    public void m1580b(C0243x c0243x) {
        Iterator it = this.f848w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0243x c0243x2 = (C0243x) weakReference.get();
            if (c0243x2 == null || c0243x2 == c0243x) {
                this.f848w.remove(weakReference);
            }
        }
    }

    public void m1581b(boolean z) {
        if (this.f843r) {
            this.f844s = true;
            return;
        }
        if (z) {
            this.f837l = true;
            this.f840o = true;
        }
        m1557d(z);
    }

    boolean m1582b() {
        return this.f832g;
    }

    public int m1583c(int i) {
        return m1559a(i, 0);
    }

    public void m1584c(boolean z) {
        this.f850y = z;
    }

    public boolean m1585c() {
        return this.f833h;
    }

    public boolean m1586c(C0248m c0248m) {
        boolean z = false;
        if (!this.f848w.isEmpty()) {
            m1591g();
            Iterator it = this.f848w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0243x c0243x = (C0243x) weakReference.get();
                if (c0243x == null) {
                    this.f848w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0243x.m1632a(this, c0248m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1592h();
            if (z) {
                this.f849x = c0248m;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f849x != null) {
            m1588d(this.f849x);
        }
        this.f835j.clear();
        m1581b(true);
    }

    public void clearHeader() {
        this.f828b = null;
        this.f827a = null;
        this.f829c = null;
        m1581b(false);
    }

    public void close() {
        m1573a(true);
    }

    Resources m1587d() {
        return this.f831f;
    }

    public boolean m1588d(C0248m c0248m) {
        boolean z = false;
        if (!this.f848w.isEmpty() && this.f849x == c0248m) {
            m1591g();
            Iterator it = this.f848w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0243x c0243x = (C0243x) weakReference.get();
                if (c0243x == null) {
                    this.f848w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0243x.m1635b(this, c0248m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1592h();
            if (z) {
                this.f849x = null;
            }
        }
        return z;
    }

    public Context m1589e() {
        return this.f830e;
    }

    public void m1590f() {
        if (this.f834i != null) {
            this.f834i.m1287a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0248m c0248m = (C0248m) this.f835j.get(i2);
            if (c0248m.getItemId() == i) {
                return c0248m;
            }
            if (c0248m.hasSubMenu()) {
                MenuItem findItem = c0248m.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m1591g() {
        if (!this.f843r) {
            this.f843r = true;
            this.f844s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f835j.get(i);
    }

    public void m1592h() {
        this.f843r = false;
        if (this.f844s) {
            this.f844s = false;
            m1581b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f850y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0248m) this.f835j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList m1593i() {
        if (!this.f837l) {
            return this.f836k;
        }
        this.f836k.clear();
        int size = this.f835j.size();
        for (int i = 0; i < size; i++) {
            C0248m c0248m = (C0248m) this.f835j.get(i);
            if (c0248m.isVisible()) {
                this.f836k.add(c0248m);
            }
        }
        this.f837l = false;
        this.f840o = true;
        return this.f836k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1564a(i, keyEvent) != null;
    }

    public void m1594j() {
        ArrayList i = m1593i();
        if (this.f840o) {
            Iterator it = this.f848w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0243x c0243x = (C0243x) weakReference.get();
                if (c0243x == null) {
                    this.f848w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0243x.m1634b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f838m.clear();
                this.f839n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0248m c0248m = (C0248m) i.get(i4);
                    if (c0248m.m1693j()) {
                        this.f838m.add(c0248m);
                    } else {
                        this.f839n.add(c0248m);
                    }
                }
            } else {
                this.f838m.clear();
                this.f839n.clear();
                this.f839n.addAll(m1593i());
            }
            this.f840o = false;
        }
    }

    public ArrayList m1595k() {
        m1594j();
        return this.f838m;
    }

    public ArrayList m1596l() {
        m1594j();
        return this.f839n;
    }

    public CharSequence m1597m() {
        return this.f827a;
    }

    public Drawable m1598n() {
        return this.f828b;
    }

    public View m1599o() {
        return this.f829c;
    }

    public C0240i m1600p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m1575a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m1564a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m1575a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m1573a(true);
        }
        return z;
    }

    boolean m1601q() {
        return this.f845t;
    }

    public C0248m m1602r() {
        return this.f849x;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m1583c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f835j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f835j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.internal.view.menu.C0248m) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m1554a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m1581b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.menu.i.removeGroup(int):void");
    }

    public void removeItem(int i) {
        m1554a(m1577b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f835j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0248m c0248m = (C0248m) this.f835j.get(i2);
            if (c0248m.getGroupId() == i) {
                c0248m.m1679a(z2);
                c0248m.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f835j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0248m c0248m = (C0248m) this.f835j.get(i2);
            if (c0248m.getGroupId() == i) {
                c0248m.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f835j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0248m c0248m = (C0248m) this.f835j.get(i2);
            boolean z3 = (c0248m.getGroupId() == i && c0248m.m1684c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m1581b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f832g = z;
        m1581b(false);
    }

    public int size() {
        return this.f835j.size();
    }
}
