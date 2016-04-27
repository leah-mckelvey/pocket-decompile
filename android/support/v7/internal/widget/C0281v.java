package android.support.v7.internal.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.internal.widget.v */
final class C0281v extends AsyncTask {
    final /* synthetic */ C0275p f1285a;

    private C0281v(C0275p c0275p) {
        this.f1285a = c0275p;
    }

    public Void m2101a(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        String str = (String) objArr[1];
        try {
            OutputStream openFileOutput = this.f1285a.f1269g.openFileOutput(str, 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    C0279t c0279t = (C0279t) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", c0279t.f1282a.flattenToString());
                    newSerializer.attribute(null, "time", String.valueOf(c0279t.f1283b));
                    newSerializer.attribute(null, "weight", String.valueOf(c0279t.f1284c));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                this.f1285a.f1274l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                Log.e(C0275p.f1263a, "Error writing historical recrod file: " + this.f1285a.f1270h, e2);
                this.f1285a.f1274l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(C0275p.f1263a, "Error writing historical recrod file: " + this.f1285a.f1270h, e22);
                this.f1285a.f1274l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable e222) {
                Log.e(C0275p.f1263a, "Error writing historical recrod file: " + this.f1285a.f1270h, e222);
                this.f1285a.f1274l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                this.f1285a.f1274l = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (Throwable e2222) {
            Log.e(C0275p.f1263a, "Error writing historical recrod file: " + str, e2222);
        }
        return null;
    }

    public /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2101a(objArr);
    }
}
