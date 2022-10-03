package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ContextWrapper extends Context {
    public ContextWrapper(Context p0) {
        super();
    }

    protected void attachBaseContext(Context p0) {
    }

    public Context getBaseContext() {
        return null;
    }

    @Override
    public AssetManager getAssets() {
        return null;
    }

    @Override
    public Resources getResources() {
        return null;
    }

    @Override
    public PackageManager getPackageManager() {
        return null;
    }

    @Override
    public ContentResolver getContentResolver() {
        return null;
    }

    @Override
    public Looper getMainLooper() {
        return null;
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    @Override
    public void setTheme(int p0) {
    }

    @Override
    public android.content.res.Resources.Theme getTheme() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public String getPackageName() {
        return null;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return null;
    }

    @Override
    public String getPackageResourcePath() {
        return null;
    }

    @Override
    public String getPackageCodePath() {
        return null;
    }

    @Override
    public SharedPreferences getSharedPreferences(String p0, int p1) {
        return null;
    }

    @Override
    public FileInputStream openFileInput(String p0) throws FileNotFoundException {
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(String p0, int p1) throws FileNotFoundException {
        return null;
    }

    @Override
    public boolean deleteFile(String p0) {
        return false;
    }

    @Override
    public File getFileStreamPath(String p0) {
        return null;
    }

    @Override
    public String[] fileList() {
        return null;
    }

    @Override
    public File getFilesDir() {
        return null;
    }

    @Override
    public File getExternalFilesDir(String p0) {
        return null;
    }

    @Override
    public File getObbDir() {
        return null;
    }

    @Override
    public File getCacheDir() {
        return null;
    }

    @Override
    public File getExternalCacheDir() {
        return null;
    }

    @Override
    public File getDir(String p0, int p1) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String p0, int p1,
            android.database.sqlite.SQLiteDatabase.CursorFactory p2) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String p0, int p1,
            android.database.sqlite.SQLiteDatabase.CursorFactory p2,
            DatabaseErrorHandler p3) {
        return null;
    }

    @Override
    public boolean deleteDatabase(String p0) {
        return false;
    }

    @Override
    public File getDatabasePath(String p0) {
        return null;
    }

    @Override
    public String[] databaseList() {
        return null;
    }

    @Override
    public Drawable getWallpaper() {
        return null;
    }

    @Override
    public Drawable peekWallpaper() {
        return null;
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        return 0;
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        return 0;
    }

    @Override
    public void setWallpaper(Bitmap p0) throws IOException {
    }

    @Override
    public void setWallpaper(InputStream p0) throws IOException {
    }

    @Override
    public void clearWallpaper() throws IOException {
    }

    @Override
    public void startActivity(Intent p0) {
    }

    @Override
    public void startActivity(Intent p0, Bundle p1) {
    }

    @Override
    public void startActivities(Intent[] p0) {
    }

    @Override
    public void startActivities(Intent[] p0, Bundle p1) {
    }

    @Override
    public void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4) throws
            android.content.IntentSender.SendIntentException {
    }

    @Override
    public void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4, Bundle p5)
            throws android.content.IntentSender.SendIntentException {
    }

    @Override
    public void sendBroadcast(Intent p0) {
    }

    @Override
    public void sendBroadcast(Intent p0, String p1) {
    }

    @Override
    public void sendOrderedBroadcast(Intent p0, String p1) {
    }

    @Override
    public void sendOrderedBroadcast(Intent p0, String p1, BroadcastReceiver p2, Handler p3, int p4,
            String p5, Bundle p6) {
    }

    @Override
    public void sendBroadcastAsUser(Intent p0, UserHandle p1) {
    }

    @Override
    public void sendBroadcastAsUser(Intent p0, UserHandle p1, String p2) {
    }

    @Override
    public void sendOrderedBroadcastAsUser(Intent p0, UserHandle p1, String p2,
            BroadcastReceiver p3, Handler p4, int p5, String p6, Bundle p7) {
    }

    @Override
    public void sendStickyBroadcast(Intent p0) {
    }

    @Override
    public void sendStickyOrderedBroadcast(Intent p0, BroadcastReceiver p1, Handler p2, int p3,
            String p4, Bundle p5) {
    }

    @Override
    public void removeStickyBroadcast(Intent p0) {
    }

    @Override
    public void sendStickyBroadcastAsUser(Intent p0, UserHandle p1) {
    }

    @Override
    public void sendStickyOrderedBroadcastAsUser(Intent p0, UserHandle p1, BroadcastReceiver p2,
            Handler p3, int p4, String p5, Bundle p6) {
    }

    @Override
    public void removeStickyBroadcastAsUser(Intent p0, UserHandle p1) {
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver p0, IntentFilter p1) {
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver p0, IntentFilter p1, String p2, Handler p3) {
        return null;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver p0) {
    }

    @Override
    public ComponentName startService(Intent p0) {
        return null;
    }

    @Override
    public boolean stopService(Intent p0) {
        return false;
    }

    @Override
    public boolean bindService(Intent p0, ServiceConnection p1, int p2) {
        return false;
    }

    @Override
    public void unbindService(ServiceConnection p0) {
    }

    @Override
    public boolean startInstrumentation(ComponentName p0, String p1, Bundle p2) {
        return false;
    }

    @Override
    public Object getSystemService(String p0) {
        return null;
    }

    @Override
    public int checkPermission(String p0, int p1, int p2) {
        return 0;
    }

    @Override
    public int checkCallingPermission(String p0) {
        return 0;
    }

    @Override
    public int checkCallingOrSelfPermission(String p0) {
        return 0;
    }

    @Override
    public void enforcePermission(String p0, int p1, int p2, String p3) {
    }

    @Override
    public void enforceCallingPermission(String p0, String p1) {
    }

    @Override
    public void enforceCallingOrSelfPermission(String p0, String p1) {
    }

    @Override
    public void grantUriPermission(String p0, Uri p1, int p2) {
    }

    @Override
    public void revokeUriPermission(Uri p0, int p1) {
    }

    @Override
    public int checkUriPermission(Uri p0, int p1, int p2, int p3) {
        return 0;
    }

    @Override
    public int checkCallingUriPermission(Uri p0, int p1) {
        return 0;
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri p0, int p1) {
        return 0;
    }

    @Override
    public int checkUriPermission(Uri p0, String p1, String p2, int p3, int p4, int p5) {
        return 0;
    }

    @Override
    public void enforceUriPermission(Uri p0, int p1, int p2, int p3, String p4) {
    }

    @Override
    public void enforceCallingUriPermission(Uri p0, int p1, String p2) {
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri p0, int p1, String p2) {
    }

    @Override
    public void enforceUriPermission(Uri p0, String p1, String p2, int p3, int p4, int p5,
            String p6) {
    }

    @Override
    public Context createPackageContext(String p0, int p1) throws
            android.content.pm.PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public Context createConfigurationContext(Configuration p0) {
        return null;
    }

    @Override
    public Context createDisplayContext(Display p0) {
        return null;
    }

    @Override
    public boolean isRestricted() {
        return false;
    }
}
