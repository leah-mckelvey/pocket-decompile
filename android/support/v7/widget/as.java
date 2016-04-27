package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p001b.C0034a;
import android.support.v4.widget.C0161q;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0205g;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class as extends C0161q implements OnClickListener {
    private final SearchManager f1430j;
    private final SearchView f1431k;
    private final SearchableInfo f1432l;
    private final Context f1433m;
    private final WeakHashMap f1434n;
    private final int f1435o;
    private boolean f1436p;
    private int f1437q;
    private ColorStateList f1438r;
    private int f1439s;
    private int f1440t;
    private int f1441u;
    private int f1442v;
    private int f1443w;
    private int f1444x;

    public as(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1436p = false;
        this.f1437q = 1;
        this.f1439s = -1;
        this.f1440t = -1;
        this.f1441u = -1;
        this.f1442v = -1;
        this.f1443w = -1;
        this.f1444x = -1;
        this.f1430j = (SearchManager) this.d.getSystemService("search");
        this.f1431k = searchView;
        this.f1432l = searchableInfo;
        this.f1435o = searchView.getSuggestionCommitIconResId();
        this.f1433m = context;
        this.f1434n = weakHashMap;
    }

    private Drawable m2249a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1434n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f1434n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f1433m.getResources());
        } else {
            Drawable b = m2256b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f1434n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m2250a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1433m.getPackageName() + "/" + parseInt;
            b = m2258b(str2);
            if (b != null) {
                return b;
            }
            b = C0034a.m179a(this.f1433m, parseInt);
            m2255a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m2258b(str);
            if (b != null) {
                return b;
            }
            b = m2257b(Uri.parse(str));
            m2255a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String m2251a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m2252a(Cursor cursor, String str) {
        return m2251a(cursor, cursor.getColumnIndex(str));
    }

    private void m2253a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m2254a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m2255a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1434n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m2256b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m2257b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m2266a(uri);
            }
            openInputStream = this.f1433m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m2258b(String str) {
        ConstantState constantState = (ConstantState) this.f1434n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence m2259b(CharSequence charSequence) {
        if (this.f1438r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0200b.textColorSearchUrl, typedValue, true);
            this.f1438r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1438r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m2260d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private Drawable m2261e(Cursor cursor) {
        if (this.f1442v == -1) {
            return null;
        }
        Drawable a = m2250a(cursor.getString(this.f1442v));
        return a == null ? m2263g(cursor) : a;
    }

    private Drawable m2262f(Cursor cursor) {
        return this.f1443w == -1 ? null : m2250a(cursor.getString(this.f1443w));
    }

    private Drawable m2263g(Cursor cursor) {
        Drawable a = m2249a(this.f1432l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m2264a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public Cursor m2265a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1431k.getVisibility() != 0 || this.f1431k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m2264a(this.f1432l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable m2266a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public View m2267a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.m1089a(context, cursor, viewGroup);
        a.setTag(new at(a));
        ((ImageView) a.findViewById(C0205g.edit_query)).setImageResource(this.f1435o);
        return a;
    }

    public void m2268a(int i) {
        this.f1437q = i;
    }

    public void m2269a(Cursor cursor) {
        if (this.f1436p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.m1075a(cursor);
            if (cursor != null) {
                this.f1439s = cursor.getColumnIndex("suggest_text_1");
                this.f1440t = cursor.getColumnIndex("suggest_text_2");
                this.f1441u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1442v = cursor.getColumnIndex("suggest_icon_1");
                this.f1443w = cursor.getColumnIndex("suggest_icon_2");
                this.f1444x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void m2270a(View view, Context context, Cursor cursor) {
        at atVar = (at) view.getTag();
        int i = this.f1444x != -1 ? cursor.getInt(this.f1444x) : 0;
        if (atVar.f1445a != null) {
            m2254a(atVar.f1445a, m2251a(cursor, this.f1439s));
        }
        if (atVar.f1446b != null) {
            CharSequence a = m2251a(cursor, this.f1441u);
            a = a != null ? m2259b(a) : m2251a(cursor, this.f1440t);
            if (TextUtils.isEmpty(a)) {
                if (atVar.f1445a != null) {
                    atVar.f1445a.setSingleLine(false);
                    atVar.f1445a.setMaxLines(2);
                }
            } else if (atVar.f1445a != null) {
                atVar.f1445a.setSingleLine(true);
                atVar.f1445a.setMaxLines(1);
            }
            m2254a(atVar.f1446b, a);
        }
        if (atVar.f1447c != null) {
            m2253a(atVar.f1447c, m2261e(cursor), 4);
        }
        if (atVar.f1448d != null) {
            m2253a(atVar.f1448d, m2262f(cursor), 8);
        }
        if (this.f1437q == 2 || (this.f1437q == 1 && (i & 1) != 0)) {
            atVar.f1449e.setVisibility(0);
            atVar.f1449e.setTag(atVar.f1445a.getText());
            atVar.f1449e.setOnClickListener(this);
            return;
        }
        atVar.f1449e.setVisibility(8);
    }

    public CharSequence m2271c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m2252a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1432l.shouldRewriteQueryFromData()) {
            a = m2252a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f1432l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m2252a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = m2267a(this.d, this.c, viewGroup);
            if (a != null) {
                ((at) a.getTag()).f1445a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2260d(m1071a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2260d(m1071a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1431k.m2156a((CharSequence) tag);
        }
    }
}
