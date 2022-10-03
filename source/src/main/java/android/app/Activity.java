package android.app;

import android.content.*;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import rwij.annotations.Fixed;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/** 实际继承： android.view.ContextThemeWrapper. 不知为何无法过编译 */
@Fixed
public class Activity extends ContextWrapper
        implements android.view.LayoutInflater.Factory2, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener, ComponentCallbacks2 {
    public static final int RESULT_CANCELED = 0;

    public static final int RESULT_OK = 0;

    public static final int RESULT_FIRST_USER = 0;

    protected static final int[] FOCUSED_STATE_SET = null;

    public static final int DEFAULT_KEYS_DISABLE = 0;

    public static final int DEFAULT_KEYS_DIALER = 0;

    public static final int DEFAULT_KEYS_SHORTCUT = 0;

    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 0;

    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 0;

    public Activity() {
        super(null);
    }

    public Intent getIntent() {
        return null;
    }

    public void setIntent(Intent p0) {
    }

    public final Application getApplication() {
        return null;
    }

    public final boolean isChild() {
        return false;
    }

    public final Activity getParent() {
        return null;
    }

    public WindowManager getWindowManager() {
        return null;
    }

    public Window getWindow() {
        return null;
    }

    public LoaderManager getLoaderManager() {
        return null;
    }

    public View getCurrentFocus() {
        return null;
    }

    protected void onCreate(Bundle p0) {
    }

    protected void onRestoreInstanceState(Bundle p0) {
    }

    protected void onPostCreate(Bundle p0) {
    }

    protected void onStart() {
    }

    protected void onRestart() {
    }

    protected void onResume() {
    }

    protected void onPostResume() {
    }

    protected void onNewIntent(Intent p0) {
    }

    protected void onSaveInstanceState(Bundle p0) {
    }

    protected void onPause() {
    }

    protected void onUserLeaveHint() {
    }

    public boolean onCreateThumbnail(Bitmap p0, Canvas p1) {
        return false;
    }

    public CharSequence onCreateDescription() {
        return null;
    }

    public void onProvideAssistData(Bundle p0) {
    }

    protected void onStop() {
    }

    protected void onDestroy() {
    }

    @Override
    public void onConfigurationChanged(Configuration p0) {
    }

    public int getChangingConfigurations() {
        return 0;
    }

    @Deprecated
    public Object getLastNonConfigurationInstance() {
        return null;
    }

    @Deprecated
    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    @Override
    public void onLowMemory() {
    }

    @Override
    public void onTrimMemory(int p0) {
    }

    public FragmentManager getFragmentManager() {
        return null;
    }

    public void onAttachFragment(Fragment p0) {
    }

    @Deprecated
    public final Cursor managedQuery(Uri p0, String[] p1, String p2, String[] p3, String p4) {
        return null;
    }

    @Deprecated
    public void startManagingCursor(Cursor p0) {
    }

    @Deprecated
    public void stopManagingCursor(Cursor p0) {
    }

    public View findViewById(int p0) {
        return null;
    }

    public ActionBar getActionBar() {
        return null;
    }

    public void setContentView(int p0) {
    }

    public void setContentView(View p0) {
    }

    public void setContentView(View p0, android.view.ViewGroup.LayoutParams p1) {
    }

    public void addContentView(View p0, android.view.ViewGroup.LayoutParams p1) {
    }

    public void setFinishOnTouchOutside(boolean p0) {
    }

    public final void setDefaultKeyMode(int p0) {
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        return false;
    }

    public boolean onKeyLongPress(int p0, KeyEvent p1) {
        return false;
    }

    public boolean onKeyUp(int p0, KeyEvent p1) {
        return false;
    }

    public boolean onKeyMultiple(int p0, int p1, KeyEvent p2) {
        return false;
    }

    public void onBackPressed() {
    }

    public boolean onKeyShortcut(int p0, KeyEvent p1) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent p0) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent p0) {
        return false;
    }

    public boolean onGenericMotionEvent(MotionEvent p0) {
        return false;
    }

    public void onUserInteraction() {
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams p0) {
    }

    public void onContentChanged() {
    }

    public void onWindowFocusChanged(boolean p0) {
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public boolean hasWindowFocus() {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent p0) {
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent p0) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent p0) {
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent p0) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent p0) {
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent p0) {
        return false;
    }

    public View onCreatePanelView(int p0) {
        return null;
    }

    public boolean onCreatePanelMenu(int p0, Menu p1) {
        return false;
    }

    public boolean onPreparePanel(int p0, View p1, Menu p2) {
        return false;
    }

    public boolean onMenuOpened(int p0, Menu p1) {
        return false;
    }

    public boolean onMenuItemSelected(int p0, MenuItem p1) {
        return false;
    }

    public void onPanelClosed(int p0, Menu p1) {
    }

    public void invalidateOptionsMenu() {
    }

    public boolean onCreateOptionsMenu(Menu p0) {
        return false;
    }

    public boolean onPrepareOptionsMenu(Menu p0) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem p0) {
        return false;
    }

    public boolean onNavigateUp() {
        return false;
    }

    public boolean onNavigateUpFromChild(Activity p0) {
        return false;
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder p0) {
    }

    public void onPrepareNavigateUpTaskStack(TaskStackBuilder p0) {
    }

    public void onOptionsMenuClosed(Menu p0) {
    }

    public void openOptionsMenu() {
    }

    public void closeOptionsMenu() {
    }

    @Override
    public void onCreateContextMenu(ContextMenu p0, View p1,
            android.view.ContextMenu.ContextMenuInfo p2) {
    }

    public void registerForContextMenu(View p0) {
    }

    public void unregisterForContextMenu(View p0) {
    }

    public void openContextMenu(View p0) {
    }

    public void closeContextMenu() {
    }

    public boolean onContextItemSelected(MenuItem p0) {
        return false;
    }

    public void onContextMenuClosed(Menu p0) {
    }

    @Deprecated
    protected Dialog onCreateDialog(int p0) {
        return null;
    }

    @Deprecated
    protected Dialog onCreateDialog(int p0, Bundle p1) {
        return null;
    }

    @Deprecated
    protected void onPrepareDialog(int p0, Dialog p1) {
    }

    @Deprecated
    protected void onPrepareDialog(int p0, Dialog p1, Bundle p2) {
    }

    @Deprecated
    public final void showDialog(int p0) {
    }

    @Deprecated
    public final boolean showDialog(int p0, Bundle p1) {
        return false;
    }

    @Deprecated
    public final void dismissDialog(int p0) {
    }

    @Deprecated
    public final void removeDialog(int p0) {
    }

    public boolean onSearchRequested() {
        return false;
    }

    public void startSearch(String p0, boolean p1, Bundle p2, boolean p3) {
    }

    public void triggerSearch(String p0, Bundle p1) {
    }

    public void takeKeyEvents(boolean p0) {
    }

    public final boolean requestWindowFeature(int p0) {
        return false;
    }

    public final void setFeatureDrawableResource(int p0, int p1) {
    }

    public final void setFeatureDrawableUri(int p0, Uri p1) {
    }

    public final void setFeatureDrawable(int p0, Drawable p1) {
    }

    public final void setFeatureDrawableAlpha(int p0, int p1) {
    }

    public LayoutInflater getLayoutInflater() {
        return null;
    }

    public MenuInflater getMenuInflater() {
        return null;
    }

    /** @Override from super class */
    protected void onApplyThemeResource(android.content.res.Resources.Theme p0,
            int p1, boolean p2) {
    }

    public void startActivityForResult(Intent p0, int p1) {
    }

    public void startActivityForResult(Intent p0, int p1, Bundle p2) {
    }

    /** throws SendIntentException */
    public void startIntentSenderForResult(IntentSender p0, int p1, Intent p2, int p3, int p4,
            int p5) {
    }

    /** throws SendIntentException */
    public void startIntentSenderForResult(IntentSender p0, int p1, Intent p2, int p3, int p4,
            int p5, Bundle p6) {
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
    /** throws SendIntentException */
    public void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4) {
    }

    @Override
    /** throws SendIntentException */
    public void startIntentSender(IntentSender p0, Intent p1, int p2, int p3, int p4, Bundle p5) {
    }

    public boolean startActivityIfNeeded(Intent p0, int p1) {
        return false;
    }

    public boolean startActivityIfNeeded(Intent p0, int p1, Bundle p2) {
        return false;
    }

    public boolean startNextMatchingActivity(Intent p0) {
        return false;
    }

    public boolean startNextMatchingActivity(Intent p0, Bundle p1) {
        return false;
    }

    public void startActivityFromChild(Activity p0, Intent p1, int p2) {
    }

    public void startActivityFromChild(Activity p0, Intent p1, int p2, Bundle p3) {
    }

    public void startActivityFromFragment(Fragment p0, Intent p1, int p2) {
    }

    public void startActivityFromFragment(Fragment p0, Intent p1, int p2, Bundle p3) {
    }

    /** throws SendIntentException */
    public void startIntentSenderFromChild(Activity p0, IntentSender p1, int p2, Intent p3, int p4,
            int p5, int p6) {
    }

    /** throws SendIntentException */
    public void startIntentSenderFromChild(Activity p0, IntentSender p1, int p2, Intent p3, int p4,
            int p5, int p6, Bundle p7) {
    }

    public void overridePendingTransition(int p0, int p1) {
    }

    public final void setResult(int p0) {
    }

    public final void setResult(int p0, Intent p1) {
    }

    public String getCallingPackage() {
        return null;
    }

    public ComponentName getCallingActivity() {
        return null;
    }

    public void setVisible(boolean p0) {
    }

    public boolean isFinishing() {
        return false;
    }

    public boolean isDestroyed() {
        return false;
    }

    public boolean isChangingConfigurations() {
        return false;
    }

    public void recreate() {
    }

    public void finish() {
    }

    public void finishAffinity() {
    }

    public void finishFromChild(Activity p0) {
    }

    public void finishActivity(int p0) {
    }

    public void finishActivityFromChild(Activity p0, int p1) {
    }

    protected void onActivityResult(int p0, int p1, Intent p2) {
    }

    public PendingIntent createPendingResult(int p0, Intent p1, int p2) {
        return null;
    }

    public void setRequestedOrientation(int p0) {
    }

    public int getRequestedOrientation() {
        return 0;
    }

    public int getTaskId() {
        return 0;
    }

    public boolean isTaskRoot() {
        return false;
    }

    public boolean moveTaskToBack(boolean p0) {
        return false;
    }

    public String getLocalClassName() {
        return null;
    }

    public ComponentName getComponentName() {
        return null;
    }

    public SharedPreferences getPreferences(int p0) {
        return null;
    }

    @Override
    public Object getSystemService(String p0) {
        return null;
    }

    public void setTitle(CharSequence p0) {
    }

    public void setTitle(int p0) {
    }

    public void setTitleColor(int p0) {
    }

    public final CharSequence getTitle() {
        return null;
    }

    public final int getTitleColor() {
        return 0;
    }

    protected void onTitleChanged(CharSequence p0, int p1) {
    }

    protected void onChildTitleChanged(Activity p0, CharSequence p1) {
    }

    public final void setProgressBarVisibility(boolean p0) {
    }

    public final void setProgressBarIndeterminateVisibility(boolean p0) {
    }

    public final void setProgressBarIndeterminate(boolean p0) {
    }

    public final void setProgress(int p0) {
    }

    public final void setSecondaryProgress(int p0) {
    }

    public final void setVolumeControlStream(int p0) {
    }

    public final int getVolumeControlStream() {
        return 0;
    }

    public final void runOnUiThread(Runnable p0) {
    }

    public View onCreateView(String p0, Context p1, AttributeSet p2) {
        return null;
    }

    public View onCreateView(View p0, String p1, Context p2, AttributeSet p3) {
        return null;
    }

    public void dump(String p0, FileDescriptor p1, PrintWriter p2, String[] p3) {
    }

    public boolean isImmersive() {
        return false;
    }

    public void setImmersive(boolean p0) {
    }

    public ActionMode startActionMode(android.view.ActionMode.Callback p0) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback p0) {
        return null;
    }

    public void onActionModeStarted(ActionMode p0) {
    }

    public void onActionModeFinished(ActionMode p0) {
    }

    public boolean shouldUpRecreateTask(Intent p0) {
        return false;
    }

    public boolean navigateUpTo(Intent p0) {
        return false;
    }

    public boolean navigateUpToFromChild(Activity p0, Intent p1) {
        return false;
    }

    public Intent getParentActivityIntent() {
        return null;
    }
}
