package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.corrodinggames.librocket.e;
import com.corrodinggames.rts.gameFramework.ad;
import com.corrodinggames.rts.gameFramework.bl;
import com.corrodinggames.rts.gameFramework.g.al;
import com.corrodinggames.rts.gameFramework.g.Connection;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;

public class Root extends ScriptContext {
    public static final boolean DEBUG_TIMING = false;

    static bl convertTextStopwatch;

    static bl loadSettingsStopwatch;

    public Multiplayer multiplayer;

    bl openDocumentTimer;

    al threadedGameConnector;

    ElementDocument lastConnectingPopup;

    ArrayList lastSortedDiscoveredServers;

    public Root() {
        super();
    }

    public void logDebug(String p0) {
    }

    public void logWarn(String p0) {
    }

    public void back() {
    }

    public void backOrClose() {
    }

    public String fullVersionOnlyStyle() {
        return null;
    }

    public void openIfNotDemo(String p0, Object p1, String p2) {
    }

    public String getVersionName() {
        return null;
    }

    public void delayedOpenNoHistory(String p0, Object p1) {
    }

    public void open(String p0, Object p1) {
    }

    public void onShowNewScreen() {
    }

    public void resume() {
    }

    public void resumeNonMenu() {
    }

    public void startNew(String p0) {
    }

    public void showRangeValue(String p0, String p1, boolean p2) {
    }

    public String getValueById(String p0) {
        return null;
    }

    public void setValueById(String p0, String p1) {
    }

    public Element getElementById(String p0) {
        return null;
    }

    public boolean clickElement(Element p0) {
        return false;
    }

    public void directJoinPopup() {
    }

    public void joinServerFromPopup(String p0) {
    }

    public void joinServerWithId(String p0, String p1) {
    }

    public void joinServer(String p0) {
    }

    public void joinServerCallback() {
    }

    public void cancelJoinServer() {
    }

    public void alert(String p0) {
    }

    public void showAlert(String p0) {
    }

    public void showPopupWithButtons(String p0, String p1, boolean p2, e p3, e p4) {
    }

    public void showPopupWithButtonsAndInput(String p0, String p1, boolean p2, String p3, e p4,
            e p5) {
    }

    public void showPopup(String p0, String p1, boolean p2, String p3, String p4) {
    }

    public void showInputPopup(String p0, String p1, String p2, String p3, String p4) {
    }

    public void showInputPopupNonClose(String p0, String p1, String p2, String p3, String p4) {
    }

    public ElementDocument getPopup() {
        return null;
    }

    public ElementDocument getAlertOrPopup() {
        return null;
    }

    public boolean closePopup() {
        return false;
    }

    public boolean closePopupOnly() {
        return false;
    }

    public boolean closeAlertOnly() {
        return false;
    }

    public String getPopupText() {
        return null;
    }

    public void showHostOptions() {
    }

    public void hostStartFromPopup(boolean p0) {
    }

    public void hostStart(boolean p0) {
    }

    public void hostStartWithPassword(boolean p0, String p1) {
    }

    public void hostStartWithPasswordAndMods(boolean p0, String p1, boolean p2) {
    }

    public void exit() {
    }

    public String getMapDetails(String p0) {
        return null;
    }

    public String getHTMLMapNameFromPath(String p0) {
        return null;
    }

    public String getMapNameFromPath(String p0) {
        return null;
    }

    public String convertMapName(String p0) {
        return null;
    }

    public String convertMapNameWithoutTranslation(String p0) {
        return null;
    }

    public String getHTMLMapThumbnail(String p0) {
        return null;
    }

    public String getMapThumbnail(String p0) {
        return null;
    }

    public boolean isMapSkirmish(String p0) {
        return false;
    }

    public void showLevelOptions() {
    }

    public void loadConfigAndStartSwitchToAdvanced(String p0) {
    }

    private void _startAdvancedMode(boolean p0) {
    }

    public void loadConfigAndStartNewSandbox(String p0) {
    }

    public void loadConfigAndStartNewSandboxInAdvanced(String p0) {
    }

    private void _loadConfigAndStartNewSandboxCommon(String p0, boolean p1) {
    }

    public void loadConfigAndStartNew(String p0) {
    }

    public void loadConfigCommon(String p0, boolean p1) {
    }

    public void showMapPopup(String p0, String p1) {
    }

    public boolean showMaps() {
        return false;
    }

    public boolean showMapsWithDoc(ElementDocument p0) {
        return false;
    }

    public void convertTextOnPage() {
    }

    public void keyBindingPopup_apply(boolean p0) {
    }

    public void keyBindingPopup_onKeydown(int p0) {
    }

    public void showKeyBindingPopup() {
    }

    public String getKeyBindingAction(int p0, ad p1, int p2) {
        return null;
    }

    public void showKeyBinding() {
    }

    public void loadSettings() {
    }

    public void applyResolution() {
    }

    public void saveSettings() {
    }

    public String hideStyle(boolean p0) {
        return null;
    }

    public String hideIf(boolean p0) {
        return null;
    }

    public String hideUnless(boolean p0) {
        return null;
    }

    public String hideClass(boolean p0) {
        return null;
    }

    public String hideIfMobile() {
        return null;
    }

    public boolean canResume() {
        return false;
    }

    public boolean isMobile() {
        return false;
    }

    public boolean isIOS() {
        return false;
    }

    public boolean isDesktop() {
        return false;
    }

    public boolean isMac() {
        return false;
    }

    public boolean hasModSupport() {
        return false;
    }

    public boolean hasReloadSupport() {
        return false;
    }

    String restrictedString(String p0) {
        return null;
    }

    String escapedString(String p0) {
        return null;
    }

    String htmlString(String p0) {
        return null;
    }

    public void refreshServerList(String p0, String p1, String p2) {
    }

    public void displayServerList(String p0, String p1, String p2) {
    }

    public void clickedServerRow(int p0) {
    }

    public void clickedServer(String p0) {
    }

    public void hideKeyboard() {
    }

    public void saveGame(String p0) {
    }

    public void exportMap(String p0) {
    }

    public void loadGame(String p0) {
    }

    public void loadGameEdit(String p0) {
    }

    public void loadReplay(String p0) {
    }

    public void loadReplayEdit(String p0) {
    }

    public void makeSaveGamePopup(String p0) {
    }

    public void makeExportMapGamePopup(String p0) {
    }

    public void makeSendMessagePopup() {
    }

    public void makeSendTeamMessagePopup() {
    }

    public void makeSendTeamMessagePopupWithDefaultText(String p0) {
    }

    public void sendChatMessage(String p0) {
    }

    public void sendTeamChatMessageAndPing(String p0) {
    }

    public void sendTeamChatMessage(String p0) {
    }

    public void receiveChatMessage(int p0, String p1, String p2, Connection p3) {
    }

    public void refreshChat() {
    }

    public void trace(String p0) {
    }

    public void updateTableTextOnly(String p0, TableData p1, TableData p2) {
    }

    public void refreshTable(String p0, TableData p1) {
    }

    public ElementDocument createAndShowPopup(String p0, Object p1, String p2) {
        return null;
    }

    public void showMainMenu() {
    }

    public void onEnter() {
    }

    public void scrollFromFocusedElement(float p0) {
    }

    public boolean isSliderOrUIElementSelected() {
        return false;
    }

    public void onTouch() {
    }

    public void onEscape() {
    }

    public void askQuitGame() {
    }

    public String getCurrentDocumentPath() {
        return null;
    }

    public String getCurrentPopupPath() {
        return null;
    }

    public String getCreditsText() {
        return null;
    }

    public void runRunnable(Runnable p0) {
    }

    public boolean isLinux() {
        return false;
    }

    public boolean not(boolean p0) {
        return false;
    }

    public boolean and(boolean p0, boolean p1) {
        return false;
    }

    public boolean or(boolean p0, boolean p1) {
        return false;
    }

    public void showBattleroom() {
    }

    public void setDocument(String p0) {
    }

    public void playNextMusicTrack() {
    }

    public void toggleMusic() {
    }

    public void updateMusicButton(String p0) {
    }

    public void setSandboxMapFromPopup(String p0) {
    }

    public void showSandboxMapSelectOnChange() {
    }

    public void showSandboxMapSelect() {
    }

    public String getModeMapPath(Element p0, String p1) {
        return null;
    }

    public void event_unicodeEntered() {
    }

    public boolean isVersionBeta() {
        return false;
    }

    public Object ifCondition(boolean p0, Object p1, Object p2) {
        return null;
    }

    public String i(String p0) {
        return null;
    }

    public void openLinkToCG(String p0) {
    }

    public void openWhitelistedLink(String p0) {
    }

    public void writeGameLog(String p0) {
    }

    public void setPageMinWidthAndHeight(float p0, float p1) {
    }

    public void importFilePopup() {
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#1
     */
    class Root52 implements Runnable {
        final String val$level = null;

        Root52(Root p0, String p1) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#2
     */
    class Root53 implements Runnable {
        Root53(Root p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#3
     */
    class Root54 implements Runnable {
        Root54(Root p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#4
     */
    class Root55 implements Runnable {
        final String val$serverListDataId = null;

        final String val$serverRowTemplateId = null;

        final String val$refreshButton = null;

        Root55(Root p0, String p1, String p2, String p3) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#5
     */
    class Root56 implements Runnable {
        final GameEngine val$game = null;

        final String val$saveName = null;

        Root56(Root p0, GameEngine p1, String p2) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#6
     */
    class Root57 implements Runnable {
        final GameEngine val$game = null;

        final String val$saveName = null;

        Root57(Root p0, GameEngine p1, String p2) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#7
     */
    class Root58 implements Runnable {
        final GameEngine val$game = null;

        final String val$replayName = null;

        Root58(Root p0, GameEngine p1, String p2) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#8
     */
    class Root59 implements Runnable {
        final GameEngine val$game = null;

        final String val$replayName = null;

        Root59(Root p0, GameEngine p1, String p2) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Root#9
     */
    class Root60 extends b {
        Root60(Root p0) {
            super();
        }

        @Override
        public void onFileSelected() {
        }

        @Override
        public void onCancelled() {
        }
    }

    public static class TableCell {
        public String text;

        public String classes;

        public String librocketOnClick;

        public Integer color;

        public TableCell(String p0) {
            super();
        }

        public void setLibrocketOnClick(String p0) {
        }

        public void addClass(String p0) {
        }

        public boolean same(TableCell p0, boolean p1) {
            return false;
        }
    }

    public static class TableData {
        public ArrayList rows;

        public TableData() {
            super();
        }

        public boolean same(TableData p0, boolean p1) {
            return false;
        }
    }

    public static class TableRow {
        public ArrayList tableCells;

        public Runnable androidOnclick;

        public String librocketOnClick;

        public String extraClasses;

        public TableRow() {
            super();
        }

        public void addClass(String p0) {
        }

        public TableCell addCell(String p0) {
            return null;
        }

        public void setLibrocketOnClick(String p0) {
        }

        public void setAndroidOnClick(Runnable p0) {
        }

        public boolean same(TableRow p0, boolean p1) {
            return false;
        }
    }
}
