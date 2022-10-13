package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Element {
    private long nativeHandle;

    boolean loadedChinese;

    HashSet charsetsLoaded;

    public Element() {
        super();
    }

    public native Element getElementById(String p0);

    public native String getTagName();

    public native boolean focus();

    public native void blur();

    public native void click();

    public native void addReference();

    public native void removeReference();

    public native String getAttribute(String p0, String p1);

    public native void setAttribute(String p0, String p1);

    public native String getAttributeKey(int p0);

    public native String getAttributeValue(int p0);

    public native int getNumAttributes();

    public native Element getChild(int p0);

    public native int getNumChildren();

    public native String getInnerRML();

    public native void setInnerRML(String p0);

    public native void setClassNames(String p0);

    public native String getClassNames();

    public native void appendChild(Element p0);

    public native void insertBefore(Element p0, Element p1);

    public native void removeChild(Element p0);

    public native String getProperty(String p0, String p1);

    public native void setProperty(String p0, String p1);

    public native boolean isPseudoClassSet(String p0);

    public native float getAbsoluteLeft();

    public native float getAbsoluteTop();

    public native float getOffsetLeft();

    public native float getOffsetTop();

    public native float getOffsetWidth();

    public native float getOffsetHeight();

    public native float getScrollTop();

    public native void setScrollTop(float p0);

    public native void scrollIntoView(boolean p0);

    public String getAttribute(String p0) {
        return null;
    }

    public boolean getAttributeBoolean(String p0, boolean p1) {
        return false;
    }

    public String getId() {
        return null;
    }

    public void addStyle(String p0) {
    }

    public void setStyle(String p0) {
    }

    public void setValue(String p0) {
    }

    public void setCheckbox(boolean p0) {
    }

    public boolean getCheckbox() {
        return false;
    }

    public String getValue() {
        return null;
    }

    public Integer getValueAsInt(Integer p0) {
        return null;
    }

    public Float getValueAsFloat(Float p0) {
        return null;
    }

    public Boolean getValueAsBoolean(Boolean p0) {
        return null;
    }

    public static String excapeHTML(String p0) {
        return null;
    }

    public void setTextNoCharset(String p0, boolean p1) {
    }

    public boolean loadCharsetIfNeededWithCurrentText() {
        return false;
    }

    public boolean loadCharsetIfNeeded(String p0) {
        return false;
    }

    public static final String keycodeToHex(int p0) {
        return null;
    }

    public void compareAndSetText(String p0) {
    }

    public void setText(String p0) {
    }

    public void setTextWithNewlines(String p0) {
    }

    public void addClass(String p0) {
    }

    public void compareAndAddClass(String p0) {
    }

    public void removeClass(String p0) {
    }

    public void compareAndSetClassNames(String p0) {
    }

    public Element cloneAndFix() {
        return null;
    }

    public boolean isFocused() {
        return false;
    }

    public boolean isHovering() {
        return false;
    }

    public void prependChild(Element p0) {
    }

    public void clearAllChildren() {
    }

    public ArrayList getChildren() {
        return null;
    }

    public Element getTopLevelFocusedElement() {
        return null;
    }

    public ArrayList getChainFromChildElement(Element p0) {
        return null;
    }

    public ArrayList getAllNestedChildren() {
        return null;
    }

    public void getAllNestedChildren(ArrayList p0) {
    }

    public boolean hasClassName(String p0) {
        return false;
    }

    public Element findByClassName(String p0) {
        return null;
    }

    public Element findByTagName(String p0) {
        return null;
    }

    public ArrayList findElementsByClassName(String p0) {
        return null;
    }

    public void findElementsByClassName(String p0, List p1) {
    }

    public void hide() {
    }

    public void show() {
    }

    public void show(boolean p0) {
    }
}
