package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class ScriptEngine {
    static ScriptEngine scriptEngine;

    static boolean mainScriptThreadMarked;

    static ThreadLocal isMainScriptThread;

    static Throwable scriptError;

    static String scriptErrorMessage;

    b slickLibRocket;

    private Root root;

    ArrayList queuedScripts;

    ArrayList runningScripts;

    HashMap globals;

    private ScriptEngine(b p0) {
        super();
    }

    public static boolean isStrict() {
        return false;
    }

    public static void checkThreadAccess() {
    }

    public Root getRoot() {
        return null;
    }

    public Root getRootNoCheck() {
        return null;
    }

    public static ScriptEngine getInstance() {
        return null;
    }

    public static ScriptEngine createScriptEngine(b p0) {
        return null;
    }

    public void setupScriptContext(ScriptContext p0) {
    }

    public void update(float p0) {
    }

    public Action addScriptToQueue(String p0, boolean p1) {
        return null;
    }

    public Action addScriptToQueueIfNotAlreadyQueued(String p0) {
        return null;
    }

    public Action addScriptToQueue(String p0) {
        return null;
    }

    public Action addRunnableToQueue(Runnable p0) {
        return null;
    }

    public void processScript(String p0) {
    }

    public static void throwDelayedException(String p0, Throwable p1) {
    }

    public void checkForErrors() {
    }

    public Matcher match(String p0, String p1) {
        return null;
    }

    public Object processArg(String p0) {
        return null;
    }

    public void printMetadata(HashMap p0) {
    }

    public Object getScriptVariable(String p0, boolean p1) {
        return null;
    }

    public void setLocalVariable(String p0, Object p1) {
    }

    public void setGlobalVariable(String p0, Object p1) {
    }

    public Object processFunction(String p0, Matcher p1) {
        return null;
    }

    public Object runFunction(String p0, Object[] p1) {
        return null;
    }

    public static void logError(String p0) {
    }

    public static void logCritical(String p0) {
    }

    /**
     * Rename from: com.corrodinggames.librocket.scripts.ScriptEngine#1
     */
    static final class ScriptEngine61 extends ThreadLocal {
        ScriptEngine61() {
            super();
        }

        @Override
        protected Boolean initialValue() {
            return null;
        }

    }

    public static class Action {
        public String script;

        public boolean tryToCatchCrash;

        public String caughtCrash;

        public boolean completed;

        public int framesDelay;

        public Action() {
            super();
        }

        public void run(ScriptEngine p0) {
        }

        public String waitForCompletionOrCrash(boolean p0) {
            return null;
        }
    }

    public static class RunnableAction extends Action {
        Runnable runnable;

        RunnableAction(Runnable p0) {
            super();
        }

        @Override
        public void run(ScriptEngine p0) {
        }
    }
}
