package com.corrodinggames.librocket.scripts;

import com.Element;
import java.util.ArrayList;

public class Multiplayer extends ScriptContext {
    Root root;

    String[] currentDropdownRawArray;

    Root.TableData lastPlayerTable;

    boolean useMapDropdown;

    Multiplayer(Root p0) {
        super();
    }

    void updateMapDropdown(Element p0, String p1, String p2) {
    }

    String generateOption(String p0, String p1, boolean p2) {
        return null;
    }

    Element getMapDropdown() {
        return null;
    }

    String getMapDropdownSelected() {
        return null;
    }

    void readInterfaceIntoNetworkSettings() {
    }

    public void multiplayerStart() {
    }

    public void battleroomSetup() {
    }

    public void refreshUI() {
    }

    public void refreshPlayerTable() {
    }

    public Root.TableData getPlayerTable() {
        return null;
    }

    public void showSetTeamsDialog() {
    }

    public void showPlayerConfigForSelf() {
    }

    public void showPlayerConfig(String p0) {
    }

    public void teamsSet_apply() {
    }

    public void playerConfig_kick() {
    }

    public void playerConfig_apply() {
    }

    public void disconnect(String p0) {
    }

    public void multiplayerBackPrompt() {
    }

    public void surrenderPrompt() {
    }

    public void surrender() {
    }

    public void multiplayerExitPrompt() {
    }

    public void addAI() {
    }

    public String _getRandomDefaultPlayerName() {
        return null;
    }

    public void loadUsername() {
    }

    public void getUsernameFromInterface() {
    }

    public void gameOptionsGet() {
    }

    public void gameOptionsPush() {
    }

    public void gameOptionsRefreshTypes() {
    }

    public void gameOptionsGetOrPush(boolean p0) {
    }

    public void closeBattleroomIfOpen() {
    }

    public void reinviteAsk() {
    }

    public void showSteamInviteDialog() {
    }

    public void setMapFromPopup(String p0) {
    }

    public void showMapSelect() {
    }

    public boolean isInControlOfServer() {
        return false;
    }

    public void askPassword() {
    }

    public void askPasswordEntered(String p0) {
    }

    public void cancelPaswordAsk() {
    }

    public void setupStartingUnitDropDown(Element p0) {
    }

    public ArrayList getStartingUnitOptions() {
        return null;
    }

    public static class DropdownOption {
        String key;

        String value;

        public DropdownOption(String p0, String p1) {
            super();
        }
    }
}
