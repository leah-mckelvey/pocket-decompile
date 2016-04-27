package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.ad;
import android.support.v4.p005d.p006a.C0092b;
import android.support.v7.internal.widget.bi;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v7.internal.view.menu.m */
public final class C0248m implements C0092b {
    private static String f889w;
    private static String f890x;
    private static String f891y;
    private static String f892z;
    private final int f893a;
    private final int f894b;
    private final int f895c;
    private final int f896d;
    private CharSequence f897e;
    private CharSequence f898f;
    private Intent f899g;
    private char f900h;
    private char f901i;
    private Drawable f902j;
    private int f903k;
    private C0240i f904l;
    private ad f905m;
    private Runnable f906n;
    private OnMenuItemClickListener f907o;
    private int f908p;
    private int f909q;
    private View f910r;
    private C0118a f911s;
    private ad f912t;
    private boolean f913u;
    private ContextMenuInfo f914v;

    C0248m(C0240i c0240i, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f903k = 0;
        this.f908p = 16;
        this.f909q = 0;
        this.f913u = false;
        this.f904l = c0240i;
        this.f893a = i2;
        this.f894b = i;
        this.f895c = i3;
        this.f896d = i4;
        this.f897e = charSequence;
        this.f909q = i5;
    }

    public C0092b m1671a(int i) {
        Context e = this.f904l.m1589e();
        m1674a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0092b m1672a(C0118a c0118a) {
        if (this.f911s != null) {
            this.f911s.m611a(null);
        }
        this.f910r = null;
        this.f911s = c0118a;
        this.f904l.m1581b(true);
        if (this.f911s != null) {
            this.f911s.m611a(new C0249n(this));
        }
        return this;
    }

    public C0092b m1673a(ad adVar) {
        this.f912t = adVar;
        return this;
    }

    public C0092b m1674a(View view) {
        this.f910r = view;
        this.f911s = null;
        if (view != null && view.getId() == -1 && this.f893a > 0) {
            view.setId(this.f893a);
        }
        this.f904l.m1579b(this);
        return this;
    }

    public C0118a m1675a() {
        return this.f911s;
    }

    CharSequence m1676a(aa aaVar) {
        return (aaVar == null || !aaVar.m1a()) ? getTitle() : getTitleCondensed();
    }

    void m1677a(ad adVar) {
        this.f905m = adVar;
        adVar.setHeaderTitle(getTitle());
    }

    void m1678a(ContextMenuInfo contextMenuInfo) {
        this.f914v = contextMenuInfo;
    }

    public void m1679a(boolean z) {
        this.f908p = (z ? 4 : 0) | (this.f908p & -5);
    }

    public C0092b m1680b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m1681b(boolean z) {
        int i = this.f908p;
        this.f908p = (z ? 2 : 0) | (this.f908p & -3);
        if (i != this.f908p) {
            this.f904l.m1581b(false);
        }
    }

    public boolean m1682b() {
        if ((this.f907o != null && this.f907o.onMenuItemClick(this)) || this.f904l.m1574a(this.f904l.m1600p(), (MenuItem) this)) {
            return true;
        }
        if (this.f906n != null) {
            this.f906n.run();
            return true;
        }
        if (this.f899g != null) {
            try {
                this.f904l.m1589e().startActivity(this.f899g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f911s != null && this.f911s.m616d();
    }

    public int m1683c() {
        return this.f896d;
    }

    boolean m1684c(boolean z) {
        int i = this.f908p;
        this.f908p = (z ? 0 : 8) | (this.f908p & -9);
        return i != this.f908p;
    }

    public boolean collapseActionView() {
        return (this.f909q & 8) == 0 ? false : this.f910r == null ? true : (this.f912t == null || this.f912t.m633b(this)) ? this.f904l.m1588d(this) : false;
    }

    char m1685d() {
        return this.f904l.m1582b() ? this.f901i : this.f900h;
    }

    public void m1686d(boolean z) {
        if (z) {
            this.f908p |= 32;
        } else {
            this.f908p &= -33;
        }
    }

    String m1687e() {
        char d = m1685d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f889w);
        switch (d) {
            case C0339o.Toolbar_popupTheme /*8*/:
                stringBuilder.append(f891y);
                break;
            case C0339o.Toolbar_subtitleTextAppearance /*10*/:
                stringBuilder.append(f890x);
                break;
            case C0339o.Theme_actionModeCutDrawable /*32*/:
                stringBuilder.append(f892z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m1688e(boolean z) {
        this.f913u = z;
        this.f904l.m1581b(false);
    }

    public boolean expandActionView() {
        return !m1697n() ? false : (this.f912t == null || this.f912t.m632a(this)) ? this.f904l.m1586c(this) : false;
    }

    boolean m1689f() {
        return this.f904l.m1585c() && m1685d() != '\u0000';
    }

    public boolean m1690g() {
        return (this.f908p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f910r != null) {
            return this.f910r;
        }
        if (this.f911s == null) {
            return null;
        }
        this.f910r = this.f911s.m609a((MenuItem) this);
        return this.f910r;
    }

    public char getAlphabeticShortcut() {
        return this.f901i;
    }

    public int getGroupId() {
        return this.f894b;
    }

    public Drawable getIcon() {
        if (this.f902j != null) {
            return this.f902j;
        }
        if (this.f903k == 0) {
            return null;
        }
        Drawable a = bi.m1978a(this.f904l.m1589e(), this.f903k);
        this.f903k = 0;
        this.f902j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f899g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f893a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f914v;
    }

    public char getNumericShortcut() {
        return this.f900h;
    }

    public int getOrder() {
        return this.f895c;
    }

    public SubMenu getSubMenu() {
        return this.f905m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f897e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f898f != null ? this.f898f : this.f897e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void m1691h() {
        this.f904l.m1579b(this);
    }

    public boolean hasSubMenu() {
        return this.f905m != null;
    }

    public boolean m1692i() {
        return this.f904l.m1601q();
    }

    public boolean isActionViewExpanded() {
        return this.f913u;
    }

    public boolean isCheckable() {
        return (this.f908p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f908p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f908p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f911s == null || !this.f911s.m614b()) ? (this.f908p & 8) == 0 : (this.f908p & 8) == 0 && this.f911s.m615c();
    }

    public boolean m1693j() {
        return (this.f908p & 32) == 32;
    }

    public boolean m1694k() {
        return (this.f909q & 1) == 1;
    }

    public boolean m1695l() {
        return (this.f909q & 2) == 2;
    }

    public boolean m1696m() {
        return (this.f909q & 4) == 4;
    }

    public boolean m1697n() {
        if ((this.f909q & 8) == 0) {
            return false;
        }
        if (this.f910r == null && this.f911s != null) {
            this.f910r = this.f911s.m609a((MenuItem) this);
        }
        return this.f910r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1671a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1674a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f901i != c) {
            this.f901i = Character.toLowerCase(c);
            this.f904l.m1581b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f908p;
        this.f908p = (z ? 1 : 0) | (this.f908p & -2);
        if (i != this.f908p) {
            this.f904l.m1581b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f908p & 4) != 0) {
            this.f904l.m1571a((MenuItem) this);
        } else {
            m1681b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f908p |= 16;
        } else {
            this.f908p &= -17;
        }
        this.f904l.m1581b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f902j = null;
        this.f903k = i;
        this.f904l.m1581b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f903k = 0;
        this.f902j = drawable;
        this.f904l.m1581b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f899g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f900h != c) {
            this.f900h = c;
            this.f904l.m1581b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f907o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f900h = c;
        this.f901i = Character.toLowerCase(c2);
        this.f904l.m1581b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case C0339o.View_android_theme /*0*/:
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingStart /*2*/:
                this.f909q = i;
                this.f904l.m1579b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1680b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f904l.m1589e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f897e = charSequence;
        this.f904l.m1581b(false);
        if (this.f905m != null) {
            this.f905m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f898f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f897e;
        }
        this.f904l.m1581b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m1684c(z)) {
            this.f904l.m1568a(this);
        }
        return this;
    }

    public String toString() {
        return this.f897e.toString();
    }
}
