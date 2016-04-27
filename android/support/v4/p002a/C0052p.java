package android.support.v4.p002a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p009g.C0102m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.pocket.doorway.C0339o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.p */
public class C0052p extends Activity {
    final Handler f268a;
    final C0059w f269b;
    final C0049t f270c;
    boolean f271d;
    boolean f272e;
    boolean f273f;
    boolean f274g;
    boolean f275h;
    boolean f276i;
    boolean f277j;
    boolean f278k;
    C0102m f279l;
    ao f280m;

    public C0052p() {
        this.f268a = new C0053q(this);
        this.f269b = new C0059w();
        this.f270c = new C0054r(this);
    }

    private static String m374a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case C0339o.View_android_theme /*0*/:
                stringBuilder.append('V');
                break;
            case C0339o.View_theme /*4*/:
                stringBuilder.append('I');
                break;
            case C0339o.Toolbar_popupTheme /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m375a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0052p.m374a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m375a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    ao m376a(String str, boolean z, boolean z2) {
        if (this.f279l == null) {
            this.f279l = new C0102m();
        }
        ao aoVar = (ao) this.f279l.get(str);
        if (aoVar != null) {
            aoVar.m212a(this);
            return aoVar;
        } else if (!z2) {
            return aoVar;
        } else {
            aoVar = new ao(str, this, z);
            this.f279l.put(str, aoVar);
            return aoVar;
        }
    }

    public void m377a(C0048m c0048m) {
    }

    void m378a(String str) {
        if (this.f279l != null) {
            ao aoVar = (ao) this.f279l.get(str);
            if (aoVar != null && !aoVar.f132g) {
                aoVar.m221h();
                this.f279l.remove(str);
            }
        }
    }

    void m379a(boolean z) {
        if (!this.f274g) {
            this.f274g = true;
            this.f275h = z;
            this.f268a.removeMessages(1);
            m384e();
        }
    }

    protected boolean m380a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void a_() {
        C0035a.m182b(this);
    }

    protected void m381b() {
        this.f269b.m440l();
    }

    public Object m382c() {
        return null;
    }

    public void m383d() {
        if (VERSION.SDK_INT >= 11) {
            C0038c.m265a(this);
        } else {
            this.f276i = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f271d);
            printWriter.print("mResumed=");
            printWriter.print(this.f272e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f273f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f274g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f278k);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f271d);
            printWriter.print("mResumed=");
            printWriter.print(this.f272e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f273f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f274g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f278k);
        }
        if (this.f280m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f280m)));
            printWriter.println(":");
            this.f280m.m213a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f269b.m412a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m375a(str + "  ", printWriter, getWindow().getDecorView());
    }

    void m384e() {
        if (this.f278k) {
            this.f278k = false;
            if (this.f280m != null) {
                if (this.f275h) {
                    this.f280m.m217d();
                } else {
                    this.f280m.m216c();
                }
            }
        }
        this.f269b.m443o();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f269b.m436h();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f269b.f297f == null || i3 < 0 || i3 >= this.f269b.f297f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            C0048m c0048m = (C0048m) this.f269b.f297f.get(i3);
            if (c0048m == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                c0048m.m316a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f269b.m422b()) {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f269b.m403a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f269b.m411a(this, this.f270c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0055s c0055s = (C0055s) getLastNonConfigurationInstance();
        if (c0055s != null) {
            this.f279l = c0055s.f287e;
        }
        if (bundle != null) {
            this.f269b.m405a(bundle.getParcelable("android:support:fragments"), c0055s != null ? c0055s.f286d : null);
        }
        this.f269b.m437i();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f269b.m416a(menu, getMenuInflater()) : true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View a = this.f269b.m398a(null, str, context, attributeSet);
        return a == null ? super.onCreateView(str, context, attributeSet) : a;
    }

    protected void onDestroy() {
        super.onDestroy();
        m379a(false);
        this.f269b.m445q();
        if (this.f280m != null) {
            this.f280m.m221h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f269b.m446r();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case C0339o.View_android_theme /*0*/:
                return this.f269b.m417a(menuItem);
            case C0339o.View_backgroundTintMode /*6*/:
                return this.f269b.m423b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f269b.m436h();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case C0339o.View_android_theme /*0*/:
                this.f269b.m421b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f272e = false;
        if (this.f268a.hasMessages(2)) {
            this.f268a.removeMessages(2);
            m381b();
        }
        this.f269b.m441m();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f268a.removeMessages(2);
        m381b();
        this.f269b.m429d();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f276i) {
            this.f276i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m380a(view, menu) | this.f269b.m415a(menu);
    }

    protected void onResume() {
        super.onResume();
        this.f268a.sendEmptyMessage(2);
        this.f272e = true;
        this.f269b.m429d();
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f273f) {
            m379a(true);
        }
        Object c = m382c();
        ArrayList f = this.f269b.m434f();
        int i2;
        if (this.f279l != null) {
            int size = this.f279l.size();
            ao[] aoVarArr = new ao[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                aoVarArr[i3] = (ao) this.f279l.m556c(i3);
            }
            i2 = 0;
            while (i < size) {
                ao aoVar = aoVarArr[i];
                if (aoVar.f132g) {
                    i2 = true;
                } else {
                    aoVar.m221h();
                    this.f279l.remove(aoVar.f129d);
                }
                i++;
            }
        } else {
            i2 = 0;
        }
        if (f == null && r0 == 0 && c == null) {
            return null;
        }
        C0055s c0055s = new C0055s();
        c0055s.f283a = null;
        c0055s.f284b = c;
        c0055s.f285c = null;
        c0055s.f286d = f;
        c0055s.f287e = this.f279l;
        return c0055s;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable g = this.f269b.m435g();
        if (g != null) {
            bundle.putParcelable("android:support:fragments", g);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f273f = false;
        this.f274g = false;
        this.f268a.removeMessages(1);
        if (!this.f271d) {
            this.f271d = true;
            this.f269b.m438j();
        }
        this.f269b.m436h();
        this.f269b.m429d();
        if (!this.f278k) {
            this.f278k = true;
            if (this.f280m != null) {
                this.f280m.m215b();
            } else if (!this.f277j) {
                this.f280m = m376a("(root)", this.f278k, false);
                if (!(this.f280m == null || this.f280m.f131f)) {
                    this.f280m.m215b();
                }
            }
            this.f277j = true;
        }
        this.f269b.m439k();
        if (this.f279l != null) {
            int size = this.f279l.size();
            ao[] aoVarArr = new ao[size];
            for (int i = size - 1; i >= 0; i--) {
                aoVarArr[i] = (ao) this.f279l.m556c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ao aoVar = aoVarArr[i2];
                aoVar.m218e();
                aoVar.m220g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f273f = true;
        this.f268a.sendEmptyMessage(1);
        this.f269b.m442n();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
