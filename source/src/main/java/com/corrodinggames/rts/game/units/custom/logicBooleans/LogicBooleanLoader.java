package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicBooleanLoader {
    static Pattern patternSingleQuote;

    static Pattern patternDoubleQuote;

    static Pattern patternInteger;

    static Pattern patternFloat;

    public LogicBooleanLoader() {
        super();
    }

    public static LogicBoolean parseBooleanBlock(l p0, String p1) {
        return null;
    }

    public static Matcher match(Pattern p0, String p1) {
        return null;
    }

    public static void setArgumentsWithMapping(ParameterMapping p0, Object p1, String p2) {
    }

    public static void setArgumentWithMapping(ParameterMapping p0, Object p1, String p2,
            String p3) {
    }

    public static List getAllFieldsInherited(List p0, Class p1) {
        return null;
    }

    public static Object convertParameterData(String p0, Class p1) {
        return null;
    }

    public static String breakOuterLayerBrackets(String p0) {
        return null;
    }

    public static class ParameterMapping {
        public HashMap parameters;

        public Class type;

        public String allParametersString;

        public ParameterMapping(Class p0) {
            super();
        }

        public static class FieldOrMethod {
            Field field;

            Method method;

            Class type;

            public FieldOrMethod(Field p0) {
                super();
            }

            public FieldOrMethod(Method p0) {
                super();
            }
        }
    }
}
