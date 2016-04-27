package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p005d.p006a.C0091a;
import android.support.v7.internal.view.menu.ab;
import android.support.v7.p012d.C0212a;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v7.internal.view.d */
public class C0227d extends ActionMode {
    final Context f730a;
    final C0212a f731b;

    public C0227d(Context context, C0212a c0212a) {
        this.f730a = context;
        this.f731b = c0212a;
    }

    public void finish() {
        this.f731b.m1363c();
    }

    public View getCustomView() {
        return this.f731b.m1368i();
    }

    public Menu getMenu() {
        return ab.m1542a(this.f730a, (C0091a) this.f731b.m1360b());
    }

    public MenuInflater getMenuInflater() {
        return this.f731b.m1354a();
    }

    public CharSequence getSubtitle() {
        return this.f731b.m1366g();
    }

    public Object getTag() {
        return this.f731b.m1369j();
    }

    public CharSequence getTitle() {
        return this.f731b.m1365f();
    }

    public boolean getTitleOptionalHint() {
        return this.f731b.m1370k();
    }

    public void invalidate() {
        this.f731b.m1364d();
    }

    public boolean isTitleOptional() {
        return this.f731b.m1367h();
    }

    public void setCustomView(View view) {
        this.f731b.m1356a(view);
    }

    public void setSubtitle(int i) {
        this.f731b.m1361b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f731b.m1357a(charSequence);
    }

    public void setTag(Object obj) {
        this.f731b.m1358a(obj);
    }

    public void setTitle(int i) {
        this.f731b.m1355a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f731b.m1362b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f731b.m1359a(z);
    }
}
