package android.app;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;

public class Application extends ContextWrapper implements ComponentCallbacks2 {
    public Application() {
        super(null);
    }

    public void onCreate() {
    }

    public void onTerminate() {
    }

    @Override
    public void onConfigurationChanged(Configuration p0) {
    }

    @Override
    public void onLowMemory() {
    }

    @Override
    public void onTrimMemory(int p0) {
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks p0) {
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks p0) {
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks p0) {
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks p0) {
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener p0) {
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener p0) {
    }

    public strictfp interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity p0, Bundle p1);

        void onActivityStarted(Activity p0);

        void onActivityResumed(Activity p0);

        void onActivityPaused(Activity p0);

        void onActivityStopped(Activity p0);

        void onActivitySaveInstanceState(Activity p0, Bundle p1);

        void onActivityDestroyed(Activity p0);
    }

    public strictfp interface OnProvideAssistDataListener {
        void onProvideAssistData(Activity p0, Bundle p1);
    }
}
