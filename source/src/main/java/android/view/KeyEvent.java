package android.view;

import android.os.Parcel;
import android.os.Parcelable;

public class KeyEvent extends InputEvent implements Parcelable {
    public static final int KEYCODE_UNKNOWN = 0;

    public static final int KEYCODE_SOFT_LEFT = 0;

    public static final int KEYCODE_SOFT_RIGHT = 0;

    public static final int KEYCODE_HOME = 0;

    public static final int KEYCODE_BACK = 0;

    public static final int KEYCODE_CALL = 0;

    public static final int KEYCODE_ENDCALL = 0;

    public static final int KEYCODE_0 = 0;

    public static final int KEYCODE_1 = 0;

    public static final int KEYCODE_2 = 0;

    public static final int KEYCODE_3 = 0;

    public static final int KEYCODE_4 = 0;

    public static final int KEYCODE_5 = 0;

    public static final int KEYCODE_6 = 0;

    public static final int KEYCODE_7 = 0;

    public static final int KEYCODE_8 = 0;

    public static final int KEYCODE_9 = 0;

    public static final int KEYCODE_STAR = 0;

    public static final int KEYCODE_POUND = 0;

    public static final int KEYCODE_DPAD_UP = 0;

    public static final int KEYCODE_DPAD_DOWN = 0;

    public static final int KEYCODE_DPAD_LEFT = 0;

    public static final int KEYCODE_DPAD_RIGHT = 0;

    public static final int KEYCODE_DPAD_CENTER = 0;

    public static final int KEYCODE_VOLUME_UP = 0;

    public static final int KEYCODE_VOLUME_DOWN = 0;

    public static final int KEYCODE_POWER = 0;

    public static final int KEYCODE_CAMERA = 0;

    public static final int KEYCODE_CLEAR = 0;

    public static final int KEYCODE_A = 0;

    public static final int KEYCODE_B = 0;

    public static final int KEYCODE_C = 0;

    public static final int KEYCODE_D = 0;

    public static final int KEYCODE_E = 0;

    public static final int KEYCODE_F = 0;

    public static final int KEYCODE_G = 0;

    public static final int KEYCODE_H = 0;

    public static final int KEYCODE_I = 0;

    public static final int KEYCODE_J = 0;

    public static final int KEYCODE_K = 0;

    public static final int KEYCODE_L = 0;

    public static final int KEYCODE_M = 0;

    public static final int KEYCODE_N = 0;

    public static final int KEYCODE_O = 0;

    public static final int KEYCODE_P = 0;

    public static final int KEYCODE_Q = 0;

    public static final int KEYCODE_R = 0;

    public static final int KEYCODE_S = 0;

    public static final int KEYCODE_T = 0;

    public static final int KEYCODE_U = 0;

    public static final int KEYCODE_V = 0;

    public static final int KEYCODE_W = 0;

    public static final int KEYCODE_X = 0;

    public static final int KEYCODE_Y = 0;

    public static final int KEYCODE_Z = 0;

    public static final int KEYCODE_COMMA = 0;

    public static final int KEYCODE_PERIOD = 0;

    public static final int KEYCODE_ALT_LEFT = 0;

    public static final int KEYCODE_ALT_RIGHT = 0;

    public static final int KEYCODE_SHIFT_LEFT = 0;

    public static final int KEYCODE_SHIFT_RIGHT = 0;

    public static final int KEYCODE_TAB = 0;

    public static final int KEYCODE_SPACE = 0;

    public static final int KEYCODE_SYM = 0;

    public static final int KEYCODE_EXPLORER = 0;

    public static final int KEYCODE_ENVELOPE = 0;

    public static final int KEYCODE_ENTER = 0;

    public static final int KEYCODE_DEL = 0;

    public static final int KEYCODE_GRAVE = 0;

    public static final int KEYCODE_MINUS = 0;

    public static final int KEYCODE_EQUALS = 0;

    public static final int KEYCODE_LEFT_BRACKET = 0;

    public static final int KEYCODE_RIGHT_BRACKET = 0;

    public static final int KEYCODE_BACKSLASH = 0;

    public static final int KEYCODE_SEMICOLON = 0;

    public static final int KEYCODE_APOSTROPHE = 0;

    public static final int KEYCODE_SLASH = 0;

    public static final int KEYCODE_AT = 0;

    public static final int KEYCODE_NUM = 0;

    public static final int KEYCODE_HEADSETHOOK = 0;

    public static final int KEYCODE_FOCUS = 0;

    public static final int KEYCODE_PLUS = 0;

    public static final int KEYCODE_MENU = 0;

    public static final int KEYCODE_NOTIFICATION = 0;

    public static final int KEYCODE_SEARCH = 0;

    public static final int KEYCODE_MEDIA_PLAY_PAUSE = 0;

    public static final int KEYCODE_MEDIA_STOP = 0;

    public static final int KEYCODE_MEDIA_NEXT = 0;

    public static final int KEYCODE_MEDIA_PREVIOUS = 0;

    public static final int KEYCODE_MEDIA_REWIND = 0;

    public static final int KEYCODE_MEDIA_FAST_FORWARD = 0;

    public static final int KEYCODE_MUTE = 0;

    public static final int KEYCODE_PAGE_UP = 0;

    public static final int KEYCODE_PAGE_DOWN = 0;

    public static final int KEYCODE_PICTSYMBOLS = 0;

    public static final int KEYCODE_SWITCH_CHARSET = 0;

    public static final int KEYCODE_BUTTON_A = 0;

    public static final int KEYCODE_BUTTON_B = 0;

    public static final int KEYCODE_BUTTON_C = 0;

    public static final int KEYCODE_BUTTON_X = 0;

    public static final int KEYCODE_BUTTON_Y = 0;

    public static final int KEYCODE_BUTTON_Z = 0;

    public static final int KEYCODE_BUTTON_L1 = 0;

    public static final int KEYCODE_BUTTON_R1 = 0;

    public static final int KEYCODE_BUTTON_L2 = 0;

    public static final int KEYCODE_BUTTON_R2 = 0;

    public static final int KEYCODE_BUTTON_THUMBL = 0;

    public static final int KEYCODE_BUTTON_THUMBR = 0;

    public static final int KEYCODE_BUTTON_START = 0;

    public static final int KEYCODE_BUTTON_SELECT = 0;

    public static final int KEYCODE_BUTTON_MODE = 0;

    public static final int KEYCODE_ESCAPE = 0;

    public static final int KEYCODE_FORWARD_DEL = 0;

    public static final int KEYCODE_CTRL_LEFT = 0;

    public static final int KEYCODE_CTRL_RIGHT = 0;

    public static final int KEYCODE_CAPS_LOCK = 0;

    public static final int KEYCODE_SCROLL_LOCK = 0;

    public static final int KEYCODE_META_LEFT = 0;

    public static final int KEYCODE_META_RIGHT = 0;

    public static final int KEYCODE_FUNCTION = 0;

    public static final int KEYCODE_SYSRQ = 0;

    public static final int KEYCODE_BREAK = 0;

    public static final int KEYCODE_MOVE_HOME = 0;

    public static final int KEYCODE_MOVE_END = 0;

    public static final int KEYCODE_INSERT = 0;

    public static final int KEYCODE_FORWARD = 0;

    public static final int KEYCODE_MEDIA_PLAY = 0;

    public static final int KEYCODE_MEDIA_PAUSE = 0;

    public static final int KEYCODE_MEDIA_CLOSE = 0;

    public static final int KEYCODE_MEDIA_EJECT = 0;

    public static final int KEYCODE_MEDIA_RECORD = 0;

    public static final int KEYCODE_F1 = 0;

    public static final int KEYCODE_F2 = 0;

    public static final int KEYCODE_F3 = 0;

    public static final int KEYCODE_F4 = 0;

    public static final int KEYCODE_F5 = 0;

    public static final int KEYCODE_F6 = 0;

    public static final int KEYCODE_F7 = 0;

    public static final int KEYCODE_F8 = 0;

    public static final int KEYCODE_F9 = 0;

    public static final int KEYCODE_F10 = 0;

    public static final int KEYCODE_F11 = 0;

    public static final int KEYCODE_F12 = 0;

    public static final int KEYCODE_NUM_LOCK = 0;

    public static final int KEYCODE_NUMPAD_0 = 0;

    public static final int KEYCODE_NUMPAD_1 = 0;

    public static final int KEYCODE_NUMPAD_2 = 0;

    public static final int KEYCODE_NUMPAD_3 = 0;

    public static final int KEYCODE_NUMPAD_4 = 0;

    public static final int KEYCODE_NUMPAD_5 = 0;

    public static final int KEYCODE_NUMPAD_6 = 0;

    public static final int KEYCODE_NUMPAD_7 = 0;

    public static final int KEYCODE_NUMPAD_8 = 0;

    public static final int KEYCODE_NUMPAD_9 = 0;

    public static final int KEYCODE_NUMPAD_DIVIDE = 0;

    public static final int KEYCODE_NUMPAD_MULTIPLY = 0;

    public static final int KEYCODE_NUMPAD_SUBTRACT = 0;

    public static final int KEYCODE_NUMPAD_ADD = 0;

    public static final int KEYCODE_NUMPAD_DOT = 0;

    public static final int KEYCODE_NUMPAD_COMMA = 0;

    public static final int KEYCODE_NUMPAD_ENTER = 0;

    public static final int KEYCODE_NUMPAD_EQUALS = 0;

    public static final int KEYCODE_NUMPAD_LEFT_PAREN = 0;

    public static final int KEYCODE_NUMPAD_RIGHT_PAREN = 0;

    public static final int KEYCODE_VOLUME_MUTE = 0;

    public static final int KEYCODE_INFO = 0;

    public static final int KEYCODE_CHANNEL_UP = 0;

    public static final int KEYCODE_CHANNEL_DOWN = 0;

    public static final int KEYCODE_ZOOM_IN = 0;

    public static final int KEYCODE_ZOOM_OUT = 0;

    public static final int KEYCODE_TV = 0;

    public static final int KEYCODE_WINDOW = 0;

    public static final int KEYCODE_GUIDE = 0;

    public static final int KEYCODE_DVR = 0;

    public static final int KEYCODE_BOOKMARK = 0;

    public static final int KEYCODE_CAPTIONS = 0;

    public static final int KEYCODE_SETTINGS = 0;

    public static final int KEYCODE_TV_POWER = 0;

    public static final int KEYCODE_TV_INPUT = 0;

    public static final int KEYCODE_STB_POWER = 0;

    public static final int KEYCODE_STB_INPUT = 0;

    public static final int KEYCODE_AVR_POWER = 0;

    public static final int KEYCODE_AVR_INPUT = 0;

    public static final int KEYCODE_PROG_RED = 0;

    public static final int KEYCODE_PROG_GREEN = 0;

    public static final int KEYCODE_PROG_YELLOW = 0;

    public static final int KEYCODE_PROG_BLUE = 0;

    public static final int KEYCODE_APP_SWITCH = 0;

    public static final int KEYCODE_BUTTON_1 = 0;

    public static final int KEYCODE_BUTTON_2 = 0;

    public static final int KEYCODE_BUTTON_3 = 0;

    public static final int KEYCODE_BUTTON_4 = 0;

    public static final int KEYCODE_BUTTON_5 = 0;

    public static final int KEYCODE_BUTTON_6 = 0;

    public static final int KEYCODE_BUTTON_7 = 0;

    public static final int KEYCODE_BUTTON_8 = 0;

    public static final int KEYCODE_BUTTON_9 = 0;

    public static final int KEYCODE_BUTTON_10 = 0;

    public static final int KEYCODE_BUTTON_11 = 0;

    public static final int KEYCODE_BUTTON_12 = 0;

    public static final int KEYCODE_BUTTON_13 = 0;

    public static final int KEYCODE_BUTTON_14 = 0;

    public static final int KEYCODE_BUTTON_15 = 0;

    public static final int KEYCODE_BUTTON_16 = 0;

    public static final int KEYCODE_LANGUAGE_SWITCH = 0;

    public static final int KEYCODE_MANNER_MODE = 0;

    public static final int KEYCODE_3D_MODE = 0;

    public static final int KEYCODE_CONTACTS = 0;

    public static final int KEYCODE_CALENDAR = 0;

    public static final int KEYCODE_MUSIC = 0;

    public static final int KEYCODE_CALCULATOR = 0;

    public static final int KEYCODE_ZENKAKU_HANKAKU = 0;

    public static final int KEYCODE_EISU = 0;

    public static final int KEYCODE_MUHENKAN = 0;

    public static final int KEYCODE_HENKAN = 0;

    public static final int KEYCODE_KATAKANA_HIRAGANA = 0;

    public static final int KEYCODE_YEN = 0;

    public static final int KEYCODE_RO = 0;

    public static final int KEYCODE_KANA = 0;

    public static final int KEYCODE_ASSIST = 0;

    public static final int KEYCODE_BRIGHTNESS_DOWN = 0;

    public static final int KEYCODE_BRIGHTNESS_UP = 0;

    @Deprecated
    public static final int MAX_KEYCODE = 0;

    public static final int ACTION_DOWN = 0;

    public static final int ACTION_UP = 0;

    public static final int ACTION_MULTIPLE = 0;

    public static final int META_ALT_ON = 0;

    public static final int META_ALT_LEFT_ON = 0;

    public static final int META_ALT_RIGHT_ON = 0;

    public static final int META_SHIFT_ON = 0;

    public static final int META_SHIFT_LEFT_ON = 0;

    public static final int META_SHIFT_RIGHT_ON = 0;

    public static final int META_SYM_ON = 0;

    public static final int META_FUNCTION_ON = 0;

    public static final int META_CTRL_ON = 0;

    public static final int META_CTRL_LEFT_ON = 0;

    public static final int META_CTRL_RIGHT_ON = 0;

    public static final int META_META_ON = 0;

    public static final int META_META_LEFT_ON = 0;

    public static final int META_META_RIGHT_ON = 0;

    public static final int META_CAPS_LOCK_ON = 0;

    public static final int META_NUM_LOCK_ON = 0;

    public static final int META_SCROLL_LOCK_ON = 0;

    public static final int META_SHIFT_MASK = 0;

    public static final int META_ALT_MASK = 0;

    public static final int META_CTRL_MASK = 0;

    public static final int META_META_MASK = 0;

    public static final int FLAG_WOKE_HERE = 0;

    public static final int FLAG_SOFT_KEYBOARD = 0;

    public static final int FLAG_KEEP_TOUCH_MODE = 0;

    public static final int FLAG_FROM_SYSTEM = 0;

    public static final int FLAG_EDITOR_ACTION = 0;

    public static final int FLAG_CANCELED = 0;

    public static final int FLAG_VIRTUAL_HARD_KEY = 0;

    public static final int FLAG_LONG_PRESS = 0;

    public static final int FLAG_CANCELED_LONG_PRESS = 0;

    public static final int FLAG_TRACKING = 0;

    public static final int FLAG_FALLBACK = 0;

    public static final android.os.Parcelable.Creator CREATOR = null;

    public KeyEvent(int p0, int p1) {
        super();
    }

    public KeyEvent(long p0, long p1, int p2, int p3, int p4) {
        super();
    }

    public KeyEvent(long p0, long p1, int p2, int p3, int p4, int p5) {
        super();
    }

    public KeyEvent(long p0, long p1, int p2, int p3, int p4, int p5, int p6, int p7) {
        super();
    }

    public KeyEvent(long p0, long p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        super();
    }

    public KeyEvent(long p0, long p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
            int p9) {
        super();
    }

    public KeyEvent(long p0, String p1, int p2, int p3) {
        super();
    }

    public KeyEvent(KeyEvent p0) {
        super();
    }

    @Deprecated
    public KeyEvent(KeyEvent p0, long p1, int p2) {
        super();
    }

    public static int getMaxKeyCode() {
        return 0;
    }

    public static int getDeadChar(int p0, int p1) {
        return 0;
    }

    public static KeyEvent changeTimeRepeat(KeyEvent p0, long p1, int p2) {
        return null;
    }

    public static KeyEvent changeTimeRepeat(KeyEvent p0, long p1, int p2, int p3) {
        return null;
    }

    public static KeyEvent changeAction(KeyEvent p0, int p1) {
        return null;
    }

    public static KeyEvent changeFlags(KeyEvent p0, int p1) {
        return null;
    }

    public final boolean isSystem() {
        return false;
    }

    public static final boolean isGamepadButton(int p0) {
        return false;
    }

    @Override
    public final int getDeviceId() {
        return 0;
    }

    @Override
    public final int getSource() {
        return 0;
    }

    public final void setSource(int p0) {
    }

    public final int getMetaState() {
        return 0;
    }

    public final int getModifiers() {
        return 0;
    }

    public final int getFlags() {
        return 0;
    }

    public static int getModifierMetaStateMask() {
        return 0;
    }

    public static boolean isModifierKey(int p0) {
        return false;
    }

    public static int normalizeMetaState(int p0) {
        return 0;
    }

    public static boolean metaStateHasNoModifiers(int p0) {
        return false;
    }

    public static boolean metaStateHasModifiers(int p0, int p1) {
        return false;
    }

    public final boolean hasNoModifiers() {
        return false;
    }

    public final boolean hasModifiers(int p0) {
        return false;
    }

    public final boolean isAltPressed() {
        return false;
    }

    public final boolean isShiftPressed() {
        return false;
    }

    public final boolean isSymPressed() {
        return false;
    }

    public final boolean isCtrlPressed() {
        return false;
    }

    public final boolean isMetaPressed() {
        return false;
    }

    public final boolean isFunctionPressed() {
        return false;
    }

    public final boolean isCapsLockOn() {
        return false;
    }

    public final boolean isNumLockOn() {
        return false;
    }

    public final boolean isScrollLockOn() {
        return false;
    }

    public final int getAction() {
        return 0;
    }

    public final boolean isCanceled() {
        return false;
    }

    public final void startTracking() {
    }

    public final boolean isTracking() {
        return false;
    }

    public final boolean isLongPress() {
        return false;
    }

    public final int getKeyCode() {
        return 0;
    }

    public final String getCharacters() {
        return null;
    }

    public final int getScanCode() {
        return 0;
    }

    public final int getRepeatCount() {
        return 0;
    }

    public final long getDownTime() {
        return 0;
    }

    @Override
    public final long getEventTime() {
        return 0;
    }

    public final KeyCharacterMap getKeyCharacterMap() {
        return null;
    }

    public char getDisplayLabel() {
        return ' ';
    }

    public int getUnicodeChar() {
        return 0;
    }

    public int getUnicodeChar(int p0) {
        return 0;
    }

    @Deprecated
    public boolean getKeyData(android.view.KeyCharacterMap.KeyData p0) {
        return false;
    }

    public char getMatch(char[] p0) {
        return ' ';
    }

    public char getMatch(char[] p0, int p1) {
        return ' ';
    }

    public char getNumber() {
        return ' ';
    }

    public boolean isPrintingKey() {
        return false;
    }

    @Deprecated
    public final boolean dispatch(android.view.KeyEvent.Callback p0) {
        return false;
    }

    public final boolean dispatch(android.view.KeyEvent.Callback p0,
            android.view.KeyEvent.DispatcherState p1, Object p2) {
        return false;
    }

    public static String keyCodeToString(int p0) {
        return null;
    }

    public static int keyCodeFromString(String p0) {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p0, int p1) {
    }

    /**
     * Rename from: android.view.KeyEvent#1
     */
    static final class KeyEvent48 implements android.os.Parcelable.Creator {
        KeyEvent48() {
            super();
        }

        public KeyEvent a(Parcel p0) {
            return null;
        }

        public KeyEvent[] a(int p0) {
            return null;
        }

        @Override
        public Object[] newArray(int p0) {
            return null;
        }

        @Override
        public Object createFromParcel(Parcel p0) {
            return null;
        }
    }

    public strictfp interface Callback {
        boolean onKeyDown(int p0, KeyEvent p1);

        boolean onKeyLongPress(int p0, KeyEvent p1);

        boolean onKeyUp(int p0, KeyEvent p1);

        boolean onKeyMultiple(int p0, int p1, KeyEvent p2);
    }

    public static class DispatcherState {
        public DispatcherState() {
            super();
        }

        public void reset() {
        }

        public void reset(Object p0) {
        }

        public void startTracking(KeyEvent p0, Object p1) {
        }

        public boolean isTracking(KeyEvent p0) {
            return false;
        }

        public void performedLongPress(KeyEvent p0) {
        }

        public void handleUpEvent(KeyEvent p0) {
        }
    }
}
