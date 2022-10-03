package com.corrodinggames.rts.gameFramework;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

public class SettingsEngine {
    static SettingsEngine settingsEngine;

    public boolean enableSounds;

    public boolean enableMouseCapture;

    public boolean resizeFontWithUIScale;

    public String slick2dResolution;

    public String slick2dFullScreenResolution;

    public boolean slick2dFullScreen;

    public boolean slick2dBorderless;

    public float masterVolume;

    public float gameVolume;

    public float interfaceVolume;

    public float musicVolume;

    public float scrollSpeed;

    public float edgeScrollSpeed;

    public boolean hasPlayedGameOrSeenHelp;

    public boolean onscreenControls;

    public boolean trackpad;

    public boolean dpad;

    public boolean batterySaving;

    public boolean highRefreshRate;

    public boolean renderBackground;

    public boolean renderExtraLayers;

    public boolean immersiveFullScreen;

    public boolean unlockedScreenRotation;

    public boolean renderDoubleScale;

    public float renderDensity;

    public float uiRenderScale;

    public boolean renderExtraShadows;

    public boolean renderFancyWater;

    public boolean renderClouds;

    public boolean softFogFading;

    public boolean showActionInfoHoverNearMouse;

    public boolean disableModLazyLoad;

    public boolean showUnitGroups;

    public boolean allowGameRecording;

    public boolean renderAntiAlias;

    public boolean renderControls;

    public boolean showHp;

    public boolean showUnitIcons;

    public boolean gestureZoom;

    public boolean showSelectedUnitsList;

    public boolean useCircleSelect;

    public boolean showZoomButton;

    public boolean showFps;

    public boolean showUnitWaypoints;

    public boolean useMinimapAllyColors;

    public boolean showWarLogOnScreen;

    public boolean classicInterface;

    public boolean quickRally;

    public boolean doubleClickToAttackMove;

    public boolean showMapPingsOnBattlefield;

    public boolean showMapPingsOnMinimap;

    public boolean showPlayerChatInGame;

    public boolean sendReports;

    public boolean shownAudioWarning;

    public boolean mouseSupport;

    public boolean keyboardSupport;

    public boolean forceEnglish;

    public String overrideLanguageCode;

    public boolean saveMultiplayerReplays;

    public boolean replaysShowRecordedChat;

    public int nextBackgroundMap;

    public String lastNetworkPlayerName;

    public String lastNetworkIP;

    public String teamColors;

    public String teamColorsNames;

    public boolean landscapeOrientation;

    public int aiDifficulty;

    public int locationAction;

    public int locationDpad;

    public int keyAction;

    public int keyJump;

    public int keyLeft;

    public int keyRight;

    public int keyDown;

    public String uuid;

    public String networkClientId;

    public String networkClientIdMachineKey;

    public String networkServerId;

    public int lastSeenMessageId;

    public String lastSeenMessageIds;

    public int networkPort;

    public boolean udpInMultiplayer;

    public int numberOfWins;

    public boolean rateGameShown;

    public boolean highGraphics;

    public int mouseOrders;

    public int mousePlacement;

    public boolean liveReloading;

    public boolean renderVsync;

    public boolean renderSmoothDelta;

    public int teamUnitCapSinglePlayer;

    public int teamUnitCapHostedGame;

    public boolean showChatAndPingShortcuts;

    public String modSettings;

    public boolean loadDisabledModData;

    public int lastModCount;

    public boolean smartSelection_v2;

    SharedPreferences prefs;

    HashMap settingFields;

    private SettingsEngine(Context p0) {
        super();
    }

    public static SettingsEngine getInstance(Context p0) {
        return null;
    }

    public boolean getBooleanPref(String p0, boolean p1) {
        return false;
    }

    public int getIntPref(String p0, int p1) {
        return 0;
    }

    public float getFloatPref(String p0, float p1) {
        return 0f;
    }

    public String getStringPref(String p0, String p1) {
        return null;
    }

    public String getValueDynamic(String p0) {
        return null;
    }

    public boolean setValueDynamic(String p0, String p1) {
        return false;
    }

    public String getPreferencesPath() {
        return null;
    }

    public void saveToFileSystem() {
    }

    public void loadFromFileSystem() {
    }

    public void save() {
    }
}
