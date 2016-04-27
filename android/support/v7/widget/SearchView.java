package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.C0150e;
import android.support.v7.p012d.C0213c;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0203e;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.pocket.doorway.C0339o;
import java.util.WeakHashMap;

public class SearchView extends C0260z implements C0213c {
    static final ao f1312a;
    private static final boolean f1313b;
    private boolean f1314A;
    private boolean f1315B;
    private int f1316C;
    private boolean f1317D;
    private CharSequence f1318E;
    private boolean f1319F;
    private int f1320G;
    private SearchableInfo f1321H;
    private Bundle f1322I;
    private Runnable f1323J;
    private final Runnable f1324K;
    private Runnable f1325L;
    private final WeakHashMap f1326M;
    private final SearchAutoComplete f1327c;
    private final View f1328d;
    private final View f1329e;
    private final ImageView f1330f;
    private final ImageView f1331g;
    private final ImageView f1332h;
    private final ImageView f1333i;
    private final ImageView f1334j;
    private final Drawable f1335k;
    private final int f1336l;
    private final int f1337m;
    private final Intent f1338n;
    private final Intent f1339o;
    private final CharSequence f1340p;
    private aq f1341q;
    private ap f1342r;
    private OnFocusChangeListener f1343s;
    private ar f1344t;
    private OnClickListener f1345u;
    private boolean f1346v;
    private boolean f1347w;
    private C0150e f1348x;
    private boolean f1349y;
    private CharSequence f1350z;

    public class SearchAutoComplete extends C0285p {
        private int f1310a;
        private SearchView f1311b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0200b.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1310a = getThreshold();
        }

        public boolean enoughToFilter() {
            return this.f1310a <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1311b.m2160d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1311b.clearFocus();
                        this.f1311b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1311b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m2139a(getContext())) {
                    SearchView.f1312a.m2245a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1311b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1310a = i;
        }
    }

    static {
        f1313b = VERSION.SDK_INT >= 8;
        f1312a = new ao();
    }

    private Intent m2135a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1318E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1322I != null) {
            intent.putExtra("app_data", this.f1322I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1313b) {
            intent.setComponent(this.f1321H.getSearchActivity());
        }
        return intent;
    }

    private void m2136a(int i, String str, String str2) {
        getContext().startActivity(m2135a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void m2138a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f1347w = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1327c.getText());
        this.f1330f.setVisibility(i2);
        m2141b(z3);
        this.f1328d.setVisibility(z ? 8 : 0);
        ImageView imageView = this.f1334j;
        if (!this.f1346v) {
            i = 0;
        }
        imageView.setVisibility(i);
        m2146h();
        if (z3) {
            z2 = false;
        }
        m2142c(z2);
        m2145g();
    }

    static boolean m2139a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m2140b(CharSequence charSequence) {
        if (!this.f1346v || this.f1335k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1327c.getTextSize()) * 1.25d);
        this.f1335k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1335k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m2141b(boolean z) {
        int i = 8;
        if (this.f1349y && m2144f() && hasFocus() && (z || !this.f1317D)) {
            i = 0;
        }
        this.f1331g.setVisibility(i);
    }

    private void m2142c(boolean z) {
        int i;
        if (this.f1317D && !m2159c() && z) {
            i = 0;
            this.f1331g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1333i.setVisibility(i);
    }

    @TargetApi(8)
    private boolean m2143e() {
        if (this.f1321H == null || !this.f1321H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1321H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1338n;
        } else if (this.f1321H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1339o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m2144f() {
        return (this.f1349y || this.f1317D) && !m2159c();
    }

    private void m2145g() {
        int i = 8;
        if (m2144f() && (this.f1331g.getVisibility() == 0 || this.f1333i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1329e.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0203e.abc_search_view_preferred_width);
    }

    private void m2146h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1327c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1346v || this.f1319F)) {
            i = 0;
        }
        ImageView imageView = this.f1332h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1332h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m2147i() {
        post(this.f1324K);
    }

    private void m2148k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1327c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m2140b(queryHint));
    }

    @TargetApi(8)
    private void m2149l() {
        int i = 1;
        this.f1327c.setThreshold(this.f1321H.getSuggestThreshold());
        this.f1327c.setImeOptions(this.f1321H.getImeOptions());
        int inputType = this.f1321H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1321H.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1327c.setInputType(inputType);
        if (this.f1348x != null) {
            this.f1348x.m1075a(null);
        }
        if (this.f1321H.getSuggestAuthority() != null) {
            this.f1348x = new as(getContext(), this, this.f1321H, this.f1326M);
            this.f1327c.setAdapter(this.f1348x);
            as asVar = (as) this.f1348x;
            if (this.f1314A) {
                i = 2;
            }
            asVar.m2268a(i);
        }
    }

    private void m2150m() {
        CharSequence text = this.f1327c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1341q == null || !this.f1341q.m2248a(text.toString())) {
                if (this.f1321H != null) {
                    m2136a(0, null, text.toString());
                }
                setImeVisibility(false);
                m2151n();
            }
        }
    }

    private void m2151n() {
        this.f1327c.dismissDropDown();
    }

    private void m2152o() {
        if (!TextUtils.isEmpty(this.f1327c.getText())) {
            this.f1327c.setText("");
            this.f1327c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1346v) {
        } else {
            if (this.f1342r == null || !this.f1342r.m2247a()) {
                clearFocus();
                m2138a(true);
            }
        }
    }

    private void m2153p() {
        m2138a(false);
        this.f1327c.requestFocus();
        setImeVisibility(true);
        if (this.f1345u != null) {
            this.f1345u.onClick(this);
        }
    }

    private void m2154q() {
        f1312a.m2244a(this.f1327c);
        f1312a.m2246b(this.f1327c);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1323J);
            return;
        }
        removeCallbacks(this.f1323J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1327c.setText(charSequence);
        this.f1327c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void m2155a() {
        if (!this.f1319F) {
            this.f1319F = true;
            this.f1320G = this.f1327c.getImeOptions();
            this.f1327c.setImeOptions(this.f1320G | 33554432);
            this.f1327c.setText("");
            setIconified(false);
        }
    }

    void m2156a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m2157a(CharSequence charSequence, boolean z) {
        this.f1327c.setText(charSequence);
        if (charSequence != null) {
            this.f1327c.setSelection(this.f1327c.length());
            this.f1318E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m2150m();
        }
    }

    public void m2158b() {
        m2157a((CharSequence) "", false);
        clearFocus();
        m2138a(true);
        this.f1327c.setImeOptions(this.f1320G);
        this.f1319F = false;
    }

    public boolean m2159c() {
        return this.f1347w;
    }

    public void clearFocus() {
        this.f1315B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1327c.clearFocus();
        this.f1315B = false;
    }

    void m2160d() {
        m2138a(m2159c());
        m2147i();
        if (this.f1327c.hasFocus()) {
            m2154q();
        }
    }

    public int getImeOptions() {
        return this.f1327c.getImeOptions();
    }

    public int getInputType() {
        return this.f1327c.getInputType();
    }

    public int getMaxWidth() {
        return this.f1316C;
    }

    public CharSequence getQuery() {
        return this.f1327c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1350z != null ? this.f1350z : (!f1313b || this.f1321H == null || this.f1321H.getHintId() == 0) ? this.f1340p : getContext().getText(this.f1321H.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f1337m;
    }

    int getSuggestionRowLayout() {
        return this.f1336l;
    }

    public C0150e getSuggestionsAdapter() {
        return this.f1348x;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1324K);
        post(this.f1325L);
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        if (m2159c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1316C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1316C, size);
                    break;
                }
            case C0339o.View_android_theme /*0*/:
                if (this.f1316C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1316C;
                    break;
                }
            case 1073741824:
                if (this.f1316C > 0) {
                    size = Math.min(this.f1316C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m2147i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1315B || !isFocusable()) {
            return false;
        }
        if (m2159c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1327c.requestFocus(i, rect);
        if (requestFocus) {
            m2138a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1322I = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m2152o();
        } else {
            m2153p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1346v != z) {
            this.f1346v = z;
            m2138a(z);
            m2148k();
        }
    }

    public void setImeOptions(int i) {
        this.f1327c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1327c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1316C = i;
        requestLayout();
    }

    public void setOnCloseListener(ap apVar) {
        this.f1342r = apVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1343s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(aq aqVar) {
        this.f1341q = aqVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1345u = onClickListener;
    }

    public void setOnSuggestionListener(ar arVar) {
        this.f1344t = arVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1350z = charSequence;
        m2148k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1314A = z;
        if (this.f1348x instanceof as) {
            ((as) this.f1348x).m2268a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1321H = searchableInfo;
        if (this.f1321H != null) {
            if (f1313b) {
                m2149l();
            }
            m2148k();
        }
        boolean z = f1313b && m2143e();
        this.f1317D = z;
        if (this.f1317D) {
            this.f1327c.setPrivateImeOptions("nm");
        }
        m2138a(m2159c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1349y = z;
        m2138a(m2159c());
    }

    public void setSuggestionsAdapter(C0150e c0150e) {
        this.f1348x = c0150e;
        this.f1327c.setAdapter(this.f1348x);
    }
}
