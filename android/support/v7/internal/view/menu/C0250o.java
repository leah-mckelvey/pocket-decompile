package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p000h.C0118a;
import android.support.v4.p005d.p006a.C0092b;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.internal.view.menu.o */
public class C0250o extends C0239e implements MenuItem {
    private Method f916c;

    C0250o(Context context, C0092b c0092b) {
        super(context, c0092b);
    }

    C0251p m1699a(ActionProvider actionProvider) {
        return new C0251p(this, this.a, actionProvider);
    }

    public void m1700a(boolean z) {
        try {
            if (this.f916c == null) {
                this.f916c = ((C0092b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f916c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0092b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0092b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0118a a = ((C0092b) this.b).m532a();
        return a instanceof C0251p ? ((C0251p) a).f917a : null;
    }

    public View getActionView() {
        View actionView = ((C0092b) this.b).getActionView();
        return actionView instanceof C0252q ? ((C0252q) actionView).m1707c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0092b) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0092b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0092b) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((C0092b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0092b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0092b) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0092b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0092b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m1546a(((C0092b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0092b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0092b) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0092b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0092b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0092b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0092b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0092b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0092b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0092b) this.b).m530a(actionProvider != null ? m1699a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0092b) this.b).setActionView(i);
        View actionView = ((C0092b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0092b) this.b).setActionView(new C0252q(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0252q(view);
        }
        ((C0092b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0092b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0092b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0092b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0092b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0092b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0092b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0092b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0092b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0092b) this.b).m531a(onActionExpandListener != null ? new C0253r(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0092b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0254s(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0092b) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0092b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0092b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0092b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0092b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0092b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0092b) this.b).setVisible(z);
    }
}
