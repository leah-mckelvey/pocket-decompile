package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.ad;
import android.support.v4.p001b.C0034a;
import android.support.v4.p005d.p006a.C0092b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.a */
public class C0237a implements C0092b {
    private final int f808a;
    private final int f809b;
    private final int f810c;
    private final int f811d;
    private CharSequence f812e;
    private CharSequence f813f;
    private Intent f814g;
    private char f815h;
    private char f816i;
    private Drawable f817j;
    private int f818k;
    private Context f819l;
    private OnMenuItemClickListener f820m;
    private int f821n;

    public C0237a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f818k = 0;
        this.f821n = 16;
        this.f819l = context;
        this.f808a = i2;
        this.f809b = i;
        this.f810c = i3;
        this.f811d = i4;
        this.f812e = charSequence;
    }

    public C0092b m1536a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0092b m1537a(C0118a c0118a) {
        throw new UnsupportedOperationException();
    }

    public C0092b m1538a(ad adVar) {
        return this;
    }

    public C0092b m1539a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0118a m1540a() {
        return null;
    }

    public C0092b m1541b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f816i;
    }

    public int getGroupId() {
        return this.f809b;
    }

    public Drawable getIcon() {
        return this.f817j;
    }

    public Intent getIntent() {
        return this.f814g;
    }

    public int getItemId() {
        return this.f808a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f815h;
    }

    public int getOrder() {
        return this.f811d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f812e;
    }

    public CharSequence getTitleCondensed() {
        return this.f813f != null ? this.f813f : this.f812e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f821n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f821n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f821n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f821n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1536a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1539a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f816i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f821n = (z ? 1 : 0) | (this.f821n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f821n = (z ? 2 : 0) | (this.f821n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f821n = (z ? 16 : 0) | (this.f821n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f818k = i;
        this.f817j = C0034a.m179a(this.f819l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f817j = drawable;
        this.f818k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f814g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f815h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f820m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f815h = c;
        this.f816i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1541b(i);
    }

    public MenuItem setTitle(int i) {
        this.f812e = this.f819l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f812e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f813f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f821n = (z ? 0 : 8) | (this.f821n & 8);
        return this;
    }
}
