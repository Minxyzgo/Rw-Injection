package android.graphics;

import android.content.res.AssetManager;
import java.io.File;

public class Typeface {
    public static final Typeface DEFAULT = null;

    public static final Typeface DEFAULT_BOLD = null;

    public static final Typeface SANS_SERIF = null;

    public static final Typeface SERIF = null;

    public static final Typeface MONOSPACE = null;

    public static final int NORMAL = 0;

    public static final int BOLD = 0;

    public static final int ITALIC = 0;

    public static final int BOLD_ITALIC = 0;

    Typeface() {
        super();
    }

    public int getStyle() {
        return 0;
    }

    public final boolean isBold() {
        return false;
    }

    public final boolean isItalic() {
        return false;
    }

    public static Typeface create(String p0, int p1) {
        return null;
    }

    public static Typeface create(Typeface p0, int p1) {
        return null;
    }

    public static Typeface defaultFromStyle(int p0) {
        return null;
    }

    public static Typeface createFromAsset(AssetManager p0, String p1) {
        return null;
    }

    public static Typeface createFromFile(File p0) {
        return null;
    }

    public static Typeface createFromFile(String p0) {
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
    }
}
