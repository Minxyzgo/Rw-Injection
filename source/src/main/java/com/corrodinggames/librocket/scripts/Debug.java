package com.corrodinggames.librocket.scripts;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Debug extends ScriptContext {
    Root root;

    ConcurrentLinkedQueue backgroundClientConnections;

    Thread backgroundConnectionThread;

    Runnable backgroundConnectionRunnable;

    boolean forceNonThreaded;

    Debug(Root p0) {
        super();
    }

    public void setLocalPlayerName(String p0) {
    }

    public void setDdosProtection(boolean p0) {
    }

    public void lookAt(float p0, float p1) {
    }

    public void createManyUnits(String p0, float p1, float p2, int p3, boolean p4, int p5) {
    }

    public Long createUnit(String p0, float p1, float p2, int p3, boolean p4) {
        return null;
    }

    public int getMaxCustomUnitTypeId() {
        return 0;
    }

    public Long createCustomUnitFromTypeId(int p0, float p1, float p2, int p3, boolean p4) {
        return null;
    }

    public void selectNextUnit() {
    }

    public void removeAllUnits() {
    }

    public void killAllUnits() {
    }

    public boolean backgroundCurrentClientConnection() {
        return false;
    }

    public boolean setTeamCredits(int p0, int p1) {
        return false;
    }

    public boolean setTeamAllyGroup(int p0, int p1) {
        return false;
    }

    public void giveUpgradeToAllUnits() {
    }

    public void giveAllActionsToAllUnits() {
    }

    public void completeAllUnitsQueues() {
    }

    public boolean moveAllUnitsOnTeam(int p0, float p1, float p2) {
        return false;
    }

    public void showMessage(String p0) {
    }

    public String unicodeTest1() {
        return null;
    }

    public void setZoom(float p0) {
    }

    public boolean isNetworkGameActive() {
        return false;
    }

    public int getLocalPlayerId() {
        return 0;
    }

    public int numberOfHumanPlayers() {
        return 0;
    }

    public int numberOfPlayersPlusAI() {
        return 0;
    }

    public boolean enableFastSync() {
        return false;
    }

    public boolean enablePauseOnDesync() {
        return false;
    }

    public boolean networkPause() {
        return false;
    }

    public boolean plainTextDebugSave(boolean p0) {
        return false;
    }

    public boolean checkDesync(int p0) {
        return false;
    }

    public int getNumberOfDesyncErrors() {
        return 0;
    }

    public int getNumberOfDesyncPasses() {
        return 0;
    }

    public boolean setMultiplayerMap(int p0, String p1) {
        return false;
    }

    public boolean setMultiplayerSave(String p0) {
        return false;
    }

    public void generateNewClientId() {
    }

    public void disableFog() {
    }

    public void overrideDeltaSpeed(float p0) {
    }

    public void setGameSetting(String p0, String p1) {
    }

    public void setNetworkaiDifficulty(int p0) {
    }

    public void setNetworkStartingUnits(int p0) {
    }

    public void startRandomUnitDesyncTest() {
    }

    public void startRandomUnitStressTest() {
    }

    public void runAllUnitTests() {
    }

    public void runAllLeakTests() {
    }

    public boolean loadSaveFromSystemPath(String p0) {
        return false;
    }

    public void checkTeamCaches() {
    }

    public void setPathSpeedConf(boolean p0) {
    }

    public float getPathSpeed(int p0, float p1, float p2, float p3, float p4) {
        return 0f;
    }

    public void muteSounds() {
    }

    public void pong() {
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.Debug#1
     */
    class Debug51 implements Runnable {
        Debug51(Debug p0) {
            super();
        }

        @Override
        public void run() {
        }
    }
}
