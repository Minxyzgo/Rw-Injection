package com.codedisaster.steamworks;

import rwij.annotations.Additional;

public class SteamController extends SteamInterface {
    public static final int STEAM_CONTROLLER_MAX_COUNT = 0;

    public static final int STEAM_CONTROLLER_MAX_ANALOG_ACTIONS = 0;

    public static final int STEAM_CONTROLLER_MAX_DIGITAL_ACTIONS = 0;

    public static final int STEAM_CONTROLLER_MAX_ORIGINS = 0;

    public static final long STEAM_CONTROLLER_HANDLE_ALL_CONTROLLERS = 0;

    public static final float STEAM_CONTROLLER_MIN_ANALOG_ACTION_DATA = 0f;

    public static final float STEAM_CONTROLLER_MAX_ANALOG_ACTION_DATA = 0f;

    private long[] controllerHandles;

    private int[] actionOrigins;

    public SteamController() {
        super(0);
    }

    public boolean init() {
        return false;
    }

    public boolean shutdown() {
        return false;
    }

    public void runFrame() {
    }

    public int getConnectedControllers(SteamControllerHandle[] p0) {
        return 0;
    }

    public boolean showBindingPanel(SteamControllerHandle p0) {
        return false;
    }

    public SteamControllerActionSetHandle getActionSetHandle(String p0) {
        return null;
    }

    public void activateActionSet(SteamControllerHandle p0, SteamControllerActionSetHandle p1) {
    }

    public SteamControllerActionSetHandle getCurrentActionSet(SteamControllerHandle p0) {
        return null;
    }

    public SteamControllerDigitalActionHandle getDigitalActionHandle(String p0) {
        return null;
    }

    public void getDigitalActionData(SteamControllerHandle p0,
            SteamControllerDigitalActionHandle p1, SteamControllerDigitalActionData p2) {
    }

    public int getDigitalActionOrigins(SteamControllerHandle p0, SteamControllerActionSetHandle p1,
            SteamControllerDigitalActionHandle p2, ActionOrigin[] p3) {
        return 0;
    }

    public SteamControllerAnalogActionHandle getAnalogActionHandle(String p0) {
        return null;
    }

    public void getAnalogActionData(SteamControllerHandle p0, SteamControllerAnalogActionHandle p1,
            SteamControllerAnalogActionData p2) {
    }

    public int getAnalogActionOrigins(SteamControllerHandle p0, SteamControllerActionSetHandle p1,
            SteamControllerAnalogActionHandle p2, ActionOrigin[] p3) {
        return 0;
    }

    public void stopAnalogActionMomentum(SteamControllerHandle p0,
            SteamControllerAnalogActionHandle p1) {
    }

    public void triggerHapticPulse(SteamControllerHandle p0, Pad p1, int p2) {
    }

    public void triggerRepeatedHapticPulse(SteamControllerHandle p0, Pad p1, int p2, int p3, int p4,
            int p5) {
    }

    public void triggerVibration(SteamControllerHandle p0, short p1, short p2) {
    }

    public void setLEDColor(SteamControllerHandle p0, int p1, int p2, int p3, LEDFlag p4) {
    }

    public int getGamepadIndexForController(SteamControllerHandle p0) {
        return 0;
    }

    public SteamControllerHandle getControllerForGamepadIndex(int p0) {
        return null;
    }

    public void getMotionData(SteamControllerHandle p0, SteamControllerMotionData p1) {
    }

    public boolean showDigitalActionOrigins(SteamControllerHandle p0,
            SteamControllerDigitalActionHandle p1, float p2, float p3, float p4) {
        return false;
    }

    public boolean showAnalogActionOrigins(SteamControllerHandle p0,
            SteamControllerAnalogActionHandle p1, float p2, float p3, float p4) {
        return false;
    }

    public String getStringForActionOrigin(ActionOrigin p0) {
        return null;
    }

    public String getGlyphForActionOrigin(ActionOrigin p0) {
        return null;
    }

    private static native boolean init(long p0);

    private static native boolean shutdown(long p0);

    private static native void runFrame(long p0);

    private static native int getConnectedControllers(long p0, long[] p1);

    private static native boolean showBindingPanel(long p0, long p1);

    private static native long getActionSetHandle(long p0, String p1);

    private static native void activateActionSet(long p0, long p1, long p2);

    private static native long getCurrentActionSet(long p0, long p1);

    private static native long getDigitalActionHandle(long p0, String p1);

    private static native void getDigitalActionData(long p0, long p1, long p2,
            SteamControllerDigitalActionData p3);

    private static native int getDigitalActionOrigins(long p0, long p1, long p2, long p3, int[] p4);

    private static native long getAnalogActionHandle(long p0, String p1);

    private static native void getAnalogActionData(long p0, long p1, long p2,
            SteamControllerAnalogActionData p3);

    private static native int getAnalogActionOrigins(long p0, long p1, long p2, long p3, int[] p4);

    private static native void stopAnalogActionMomentum(long p0, long p1, long p2);

    private static native void triggerHapticPulse(long p0, long p1, int p2, int p3);

    private static native void triggerRepeatedHapticPulse(long p0, long p1, int p2, int p3, int p4,
            int p5, int p6);

    private static native void triggerVibration(long p0, long p1, short p2, short p3);

    private static native void setLEDColor(long p0, long p1, byte p2, byte p3, byte p4, int p5);

    private static native int getGamepadIndexForController(long p0, long p1);

    private static native long getControllerForGamepadIndex(long p0, int p1);

    private static native void getMotionData(long p0, long p1, float[] p2);

    private static native boolean showDigitalActionOrigins(long p0, long p1, long p2, float p3,
            float p4, float p5);

    private static native boolean showAnalogActionOrigins(long p0, long p1, long p2, float p3,
            float p4, float p5);

    private static native String getStringForActionOrigin(long p0, int p1);

    private static native String getGlyphForActionOrigin(long p0, int p1);

    @Override
    public void dispose() {
    }

    public enum ActionOrigin {
        None,

        A,

        B,

        X,

        Y,

        LeftBumper,

        RightBumper,

        LeftGrip,

        RightGrip,

        Start,

        Back,

        LeftPad_Touch,

        LeftPad_Swipe,

        LeftPad_Click,

        LeftPad_DPadNorth,

        LeftPad_DPadSouth,

        LeftPad_DPadWest,

        LeftPad_DPadEast,

        RightPad_Touch,

        RightPad_Swipe,

        RightPad_Click,

        RightPad_DPadNorth,

        RightPad_DPadSouth,

        RightPad_DPadWest,

        RightPad_DPadEast,

        LeftTrigger_Pull,

        LeftTrigger_Click,

        RightTrigger_Pull,

        RightTrigger_Click,

        LeftStick_Move,

        LeftStick_Click,

        LeftStick_DPadNorth,

        LeftStick_DPadSouth,

        LeftStick_DPadWest,

        LeftStick_DPadEast,

        Gyro_Move,

        Gyro_Pitch,

        Gyro_Yaw,

        Gyro_Roll,

        PS4_X,

        PS4_Circle,

        PS4_Triangle,

        PS4_Square,

        PS4_LeftBumper,

        PS4_RightBumper,

        PS4_Options,

        PS4_Share,

        PS4_LeftPad_Touch,

        PS4_LeftPad_Swipe,

        PS4_LeftPad_Click,

        PS4_LeftPad_DPadNorth,

        PS4_LeftPad_DPadSouth,

        PS4_LeftPad_DPadWest,

        PS4_LeftPad_DPadEast,

        PS4_RightPad_Touch,

        PS4_RightPad_Swipe,

        PS4_RightPad_Click,

        PS4_RightPad_DPadNorth,

        PS4_RightPad_DPadSouth,

        PS4_RightPad_DPadWest,

        PS4_RightPad_DPadEast,

        PS4_CenterPad_Touch,

        PS4_CenterPad_Swipe,

        PS4_CenterPad_Click,

        PS4_CenterPad_DPadNorth,

        PS4_CenterPad_DPadSouth,

        PS4_CenterPad_DPadWest,

        PS4_CenterPad_DPadEast,

        PS4_LeftTrigger_Pull,

        PS4_LeftTrigger_Click,

        PS4_RightTrigger_Pull,

        PS4_RightTrigger_Click,

        PS4_LeftStick_Move,

        PS4_LeftStick_Click,

        PS4_LeftStick_DPadNorth,

        PS4_LeftStick_DPadSouth,

        PS4_LeftStick_DPadWest,

        PS4_LeftStick_DPadEast,

        PS4_RightStick_Move,

        PS4_RightStick_Click,

        PS4_RightStick_DPadNorth,

        PS4_RightStick_DPadSouth,

        PS4_RightStick_DPadWest,

        PS4_RightStick_DPadEast,

        PS4_DPad_North,

        PS4_DPad_South,

        PS4_DPad_West,

        PS4_DPad_East,

        PS4_Gyro_Move,

        PS4_Gyro_Pitch,

        PS4_Gyro_Yaw,

        PS4_Gyro_Roll,

        XBoxOne_A,

        XBoxOne_B,

        XBoxOne_X,

        XBoxOne_Y,

        XBoxOne_LeftBumper,

        XBoxOne_RightBumper,

        XBoxOne_Menu,

        XBoxOne_View,

        XBoxOne_LeftTrigger_Pull,

        XBoxOne_LeftTrigger_Click,

        XBoxOne_RightTrigger_Pull,

        XBoxOne_RightTrigger_Click,

        XBoxOne_LeftStick_Move,

        XBoxOne_LeftStick_Click,

        XBoxOne_LeftStick_DPadNorth,

        XBoxOne_LeftStick_DPadSouth,

        XBoxOne_LeftStick_DPadWest,

        XBoxOne_LeftStick_DPadEast,

        XBoxOne_RightStick_Move,

        XBoxOne_RightStick_Click,

        XBoxOne_RightStick_DPadNorth,

        XBoxOne_RightStick_DPadSouth,

        XBoxOne_RightStick_DPadWest,

        XBoxOne_RightStick_DPadEast,

        XBoxOne_DPad_North,

        XBoxOne_DPad_South,

        XBoxOne_DPad_West,

        XBoxOne_DPad_East,

        XBox360_A,

        XBox360_B,

        XBox360_X,

        XBox360_Y,

        XBox360_LeftBumper,

        XBox360_RightBumper,

        XBox360_Start,

        XBox360_Back,

        XBox360_LeftTrigger_Pull,

        XBox360_LeftTrigger_Click,

        XBox360_RightTrigger_Pull,

        XBox360_RightTrigger_Click,

        XBox360_LeftStick_Move,

        XBox360_LeftStick_Click,

        XBox360_LeftStick_DPadNorth,

        XBox360_LeftStick_DPadSouth,

        XBox360_LeftStick_DPadWest,

        XBox360_LeftStick_DPadEast,

        XBox360_RightStick_Move,

        XBox360_RightStick_Click,

        XBox360_RightStick_DPadNorth,

        XBox360_RightStick_DPadSouth,

        XBox360_RightStick_DPadWest,

        XBox360_RightStick_DPadEast,

        XBox360_DPad_North,

        XBox360_DPad_South,

        XBox360_DPad_West,

        XBox360_DPad_East,

        SteamV2_A,

        SteamV2_B,

        SteamV2_X,

        SteamV2_Y,

        SteamV2_LeftBumper,

        SteamV2_RightBumper,

        SteamV2_LeftGrip,

        SteamV2_RightGrip,

        SteamV2_Start,

        SteamV2_Back,

        SteamV2_LeftPad_Touch,

        SteamV2_LeftPad_Swipe,

        SteamV2_LeftPad_Click,

        SteamV2_LeftPad_DPadNorth,

        SteamV2_LeftPad_DPadSouth,

        SteamV2_LeftPad_DPadWest,

        SteamV2_LeftPad_DPadEast,

        SteamV2_RightPad_Touch,

        SteamV2_RightPad_Swipe,

        SteamV2_RightPad_Click,

        SteamV2_RightPad_DPadNorth,

        SteamV2_RightPad_DPadSouth,

        SteamV2_RightPad_DPadWest,

        SteamV2_RightPad_DPadEast,

        SteamV2_LeftTrigger_Pull,

        SteamV2_LeftTrigger_Click,

        SteamV2_RightTrigger_Pull,

        SteamV2_RightTrigger_Click,

        SteamV2_LeftStick_Move,

        SteamV2_LeftStick_Click,

        SteamV2_LeftStick_DPadNorth,

        SteamV2_LeftStick_DPadSouth,

        SteamV2_LeftStick_DPadWest,

        SteamV2_LeftStick_DPadEast,

        SteamV2_Gyro_Move,

        SteamV2_Gyro_Pitch,

        SteamV2_Gyro_Yaw,

        SteamV2_Gyro_Roll,

        values,

        $VALUES;

        private ActionOrigin(String p0, int p1) {
        }

        @Additional
        ActionOrigin() {

        }

        static ActionOrigin byOrdinal(int p0) {
            return null;
        }
    }

    public enum LEDFlag {
        SetColor,

        RestoreUserDefault,

        $VALUES;

        private LEDFlag(String p0, int p1) {
        }

        @Additional
        LEDFlag() {

        }
    }

    public enum Pad {
        Left,

        Right,

        $VALUES;

        private Pad(String p0, int p1) {
        }

        @Additional
        Pad() {

        }
    }

    public enum Source {
        None,

        LeftTrackpad,

        RightTrackpad,

        Joystick,

        ABXY,

        Switch,

        LeftTrigger,

        RightTrigger,

        Gyro,

        CenterTrackpad,

        RightJoystick,

        DPad,

        $VALUES;

        private Source(String p0, int p1) {
        }

        @Additional
        Source() {

        }
    }

    public enum SourceMode {
        None,

        Dpad,

        Buttons,

        FourButtons,

        AbsoluteMouse,

        RelativeMouse,

        JoystickMove,

        JoystickMouse,

        JoystickCamera,

        ScrollWheel,

        Trigger,

        TouchMenu,

        MouseJoystick,

        MouseRegion,

        RadialMenu,

        Switches,

        values,

        $VALUES;

        private SourceMode(String p0, int p1) {
        }

        @Additional
        SourceMode() {

        }

        static SourceMode byOrdinal(int p0) {
            return null;
        }
    }
}
