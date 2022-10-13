package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class Context {
    public static final int MODE_PRIVATE = 0;

    @Deprecated
    public static final int MODE_WORLD_READABLE = 0;

    @Deprecated
    public static final int MODE_WORLD_WRITEABLE = 0;

    public static final int MODE_APPEND = 0;

    public static final int MODE_MULTI_PROCESS = 0;

    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 0;

    public static final int BIND_AUTO_CREATE = 0;

    public static final int BIND_DEBUG_UNBIND = 0;

    public static final int BIND_NOT_FOREGROUND = 0;

    public static final int BIND_ABOVE_CLIENT = 0;

    public static final int BIND_ALLOW_OOM_MANAGEMENT = 0;

    public static final int BIND_WAIVE_PRIORITY = 0;

    public static final int BIND_IMPORTANT = 0;

    public static final int BIND_ADJUST_WITH_ACTIVITY = 0;

    public static final String POWER_SERVICE = null;

    public static final String WINDOW_SERVICE = null;

    public static final String LAYOUT_INFLATER_SERVICE = null;

    public static final String ACCOUNT_SERVICE = null;

    public static final String ACTIVITY_SERVICE = null;

    public static final String ALARM_SERVICE = null;

    public static final String NOTIFICATION_SERVICE = null;

    public static final String ACCESSIBILITY_SERVICE = null;

    public static final String KEYGUARD_SERVICE = null;

    public static final String LOCATION_SERVICE = null;

    public static final String SEARCH_SERVICE = null;

    public static final String SENSOR_SERVICE = null;

    public static final String STORAGE_SERVICE = null;

    public static final String WALLPAPER_SERVICE = null;

    public static final String VIBRATOR_SERVICE = null;

    public static final String CONNECTIVITY_SERVICE = null;

    public static final String WIFI_SERVICE = null;

    public static final String WIFI_P2P_SERVICE = null;

    public static final String NSD_SERVICE = null;

    public static final String AUDIO_SERVICE = null;

    public static final String MEDIA_ROUTER_SERVICE = null;

    public static final String TELEPHONY_SERVICE = null;

    public static final String CLIPBOARD_SERVICE = null;

    public static final String INPUT_METHOD_SERVICE = null;

    public static final String TEXT_SERVICES_MANAGER_SERVICE = null;

    public static final String DROPBOX_SERVICE = null;

    public static final String DEVICE_POLICY_SERVICE = null;

    public static final String UI_MODE_SERVICE = null;

    public static final String DOWNLOAD_SERVICE = null;

    public static final String NFC_SERVICE = null;

    public static final String BLUETOOTH_SERVICE = null;

    public static final String USB_SERVICE = null;

    public static final String INPUT_SERVICE = null;

    public static final String DISPLAY_SERVICE = null;

    public static final String USER_SERVICE = null;

    public static final int CONTEXT_INCLUDE_CODE = 0;

    public static final int CONTEXT_IGNORE_SECURITY = 0;

    public static final int CONTEXT_RESTRICTED = 0;

    public Context() {
        super();
    }

    public abstract AssetManager getAssets();

    public abstract Resources getResources();

    public abstract PackageManager getPackageManager();

    public abstract ContentResolver getContentResolver();

    public abstract Looper getMainLooper();

    public abstract Context getApplicationContext();

    public void registerComponentCallbacks(ComponentCallbacks p0) {
    }

    public void unregisterComponentCallbacks(ComponentCallbacks p0) {
    }

    public final CharSequence getText(int p0) {
        return null;
    }

    public final String getString(int p0) {
        return null;
    }

    public final String getString(int p0, Object[] p1) {
        return null;
    }

    public abstract void setTheme(int p0);

    public abstract android.content.res.Resources.Theme getTheme();

    public final TypedArray obtainStyledAttributes(int[] p0) {
        return null;
    }

    public final TypedArray obtainStyledAttributes(int p0, int[] p1) throws
            android.content.res.Resources.NotFoundException {
        return null;
    }

    public final TypedArray obtainStyledAttributes(AttributeSet p0, int[] p1) {
        return null;
    }

    public final TypedArray obtainStyledAttributes(AttributeSet p0, int[] p1, int p2, int p3) {
        return null;
    }

    public abstract ClassLoader getClassLoader();

    public abstract String getPackageName();

    public abstract ApplicationInfo getApplicationInfo();

    public abstract String getPackageResourcePath();

    public abstract String getPackageCodePath();

    public abstract SharedPreferences getSharedPreferences(String p0, int p1);

    public abstract FileInputStream openFileInput(String p0) throws FileNotFoundException;

    public abstract FileOutputStream openFileOutput(String p0, int p1) throws FileNotFoundException;

    public abstract boolean deleteFile(String p0);

    public abstract File getFileStreamPath(String p0);

    public abstract File getFilesDir();

    public abstract File getExternalFilesDir(String p0);

    public abstract File getObbDir();

    public abstract File getCacheDir();

    public abstract File getExternalCacheDir();

    public abstract String[] fileList();

    public abstract File getDir(String p0, int p1);

    public abstract SQLiteDatabase openOrCreateDatabase(String p0, int p1,
            android.database.sqlite.SQLiteDatabase.CursorFactory p2);

    public abstract SQLiteDatabase openOrCreateDatabase(String p0, int p1,
            android.database.sqlite.SQLiteDatabase.CursorFactory p2,
            DatabaseErrorHandler p3);

    public abstract boolean deleteDatabase(String p0);

    public abstract File getDatabasePath(String p0);

    public abstract String[] databaseList();

    @Deprecated
    public abstract Drawable getWallpaper();

    @Deprecated
    public abstract Drawable peekWallpaper();

    @Deprecated
    public abstract int getWallpaperDesiredMinimumWidth();

    @Deprecated
    public abstract int getWallpaperDesiredMinimumHeight();

    @Deprecated
    public abstract void setWallpaper(Bitmap p0) throws IOException;

    @Deprecated
    public abstract void setWallpaper(InputStream p0) throws IOException;

    @Deprecated
    public abstract void clearWallpaper() throws IOException;

    public abstract void startActivity(Intent p0);

    public abstract void startActivity(Intent p0, Bundle p1);

    public abstract void startActivities(Intent[] p0);

    public abstract void startActivities(Intent[] p0, Bundle p1);

    public abstract void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4)
            throws android.content.IntentSender.SendIntentException;

    public abstract void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4,
            Bundle p5) throws android.content.IntentSender.SendIntentException;

    public abstract void sendBroadcast(Intent p0);

    public abstract void sendBroadcast(Intent p0, String p1);

    public abstract void sendOrderedBroadcast(Intent p0, String p1);

    public abstract void sendOrderedBroadcast(Intent p0, String p1, BroadcastReceiver p2,
            Handler p3, int p4, String p5, Bundle p6);

    public abstract void sendBroadcastAsUser(Intent p0, UserHandle p1);

    public abstract void sendBroadcastAsUser(Intent p0, UserHandle p1, String p2);

    public abstract void sendOrderedBroadcastAsUser(Intent p0, UserHandle p1, String p2,
            BroadcastReceiver p3, Handler p4, int p5, String p6, Bundle p7);

    public abstract void sendStickyBroadcast(Intent p0);

    public abstract void sendStickyOrderedBroadcast(Intent p0, BroadcastReceiver p1, Handler p2,
            int p3, String p4, Bundle p5);

    public abstract void removeStickyBroadcast(Intent p0);

    public abstract void sendStickyBroadcastAsUser(Intent p0, UserHandle p1);

    public abstract void sendStickyOrderedBroadcastAsUser(Intent p0, UserHandle p1,
            BroadcastReceiver p2, Handler p3, int p4, String p5, Bundle p6);

    public abstract void removeStickyBroadcastAsUser(Intent p0, UserHandle p1);

    public abstract Intent registerReceiver(BroadcastReceiver p0, IntentFilter p1);

    public abstract Intent registerReceiver(BroadcastReceiver p0, IntentFilter p1, String p2,
            Handler p3);

    public abstract void unregisterReceiver(BroadcastReceiver p0);

    public abstract ComponentName startService(Intent p0);

    public abstract boolean stopService(Intent p0);

    public abstract boolean bindService(Intent p0, ServiceConnection p1, int p2);

    public abstract void unbindService(ServiceConnection p0);

    public abstract boolean startInstrumentation(ComponentName p0, String p1, Bundle p2);

    public abstract Object getSystemService(String p0);

    public abstract int checkPermission(String p0, int p1, int p2);

    public abstract int checkCallingPermission(String p0);

    public abstract int checkCallingOrSelfPermission(String p0);

    public abstract void enforcePermission(String p0, int p1, int p2, String p3);

    public abstract void enforceCallingPermission(String p0, String p1);

    public abstract void enforceCallingOrSelfPermission(String p0, String p1);

    public abstract void grantUriPermission(String p0, Uri p1, int p2);

    public abstract void revokeUriPermission(Uri p0, int p1);

    public abstract int checkUriPermission(Uri p0, int p1, int p2, int p3);

    public abstract int checkCallingUriPermission(Uri p0, int p1);

    public abstract int checkCallingOrSelfUriPermission(Uri p0, int p1);

    public abstract int checkUriPermission(Uri p0, String p1, String p2, int p3, int p4, int p5);

    public abstract void enforceUriPermission(Uri p0, int p1, int p2, int p3, String p4);

    public abstract void enforceCallingUriPermission(Uri p0, int p1, String p2);

    public abstract void enforceCallingOrSelfUriPermission(Uri p0, int p1, String p2);

    public abstract void enforceUriPermission(Uri p0, String p1, String p2, int p3, int p4, int p5,
            String p6);

    public abstract Context createPackageContext(String p0, int p1) throws
            android.content.pm.PackageManager.NameNotFoundException;

    public abstract Context createConfigurationContext(Configuration p0);

    public abstract Context createDisplayContext(Display p0);

    public boolean isRestricted() {
        return false;
    }
}
