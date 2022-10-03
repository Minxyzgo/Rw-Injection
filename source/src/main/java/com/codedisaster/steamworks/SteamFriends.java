package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.util.Collection;

public class SteamFriends extends SteamInterface {
    public SteamFriends(SteamFriendsCallback p0) {
        super(0);
    }

    public String getPersonaName() {
        return null;
    }

    public SteamAPICall setPersonaName(String p0) {
        return null;
    }

    public PersonaState getPersonaState() {
        return null;
    }

    public int getFriendCount(FriendFlags p0) {
        return 0;
    }

    public int getFriendCount(Collection p0) {
        return 0;
    }

    public SteamID getFriendByIndex(int p0, FriendFlags p1) {
        return null;
    }

    public SteamID getFriendByIndex(int p0, Collection p1) {
        return null;
    }

    public FriendRelationship getFriendRelationship(SteamID p0) {
        return null;
    }

    public PersonaState getFriendPersonaState(SteamID p0) {
        return null;
    }

    public String getFriendPersonaName(SteamID p0) {
        return null;
    }

    public int getSmallFriendAvatar(SteamID p0) {
        return 0;
    }

    public int getMediumFriendAvatar(SteamID p0) {
        return 0;
    }

    public int getLargeFriendAvatar(SteamID p0) {
        return 0;
    }

    public boolean requestUserInformation(SteamID p0, boolean p1) {
        return false;
    }

    public void activateGameOverlay(OverlayDialog p0) {
    }

    public void activateGameOverlayToUser(OverlayToUserDialog p0, SteamID p1) {
    }

    public void activateGameOverlayToWebPage(String p0) {
    }

    public void activateGameOverlayToStore(int p0, OverlayToStoreFlag p1) {
    }

    public void activateGameOverlayInviteDialog(SteamID p0) {
    }

    public boolean setRichPresence(String p0, String p1) {
        return false;
    }

    public void clearRichPresence() {
    }

    public String getFriendRichPresence(SteamID p0, String p1) {
        return null;
    }

    public int getFriendRichPresenceKeyCount(SteamID p0) {
        return 0;
    }

    public String getFriendRichPresenceKeyByIndex(SteamID p0, int p1) {
        return null;
    }

    public void requestFriendRichPresence(SteamID p0) {
    }

    public boolean inviteUserToGame(SteamID p0, String p1) {
        return false;
    }

    private static native long createCallback(SteamFriendsCallbackAdapter p0);

    private static native String getPersonaName(long p0);

    private static native long setPersonaName(long p0, long p1, String p2);

    private static native int getPersonaState(long p0);

    private static native int getFriendCount(long p0, int p1);

    private static native long getFriendByIndex(long p0, int p1, int p2);

    private static native int getFriendRelationship(long p0, long p1);

    private static native int getFriendPersonaState(long p0, long p1);

    private static native String getFriendPersonaName(long p0, long p1);

    private static native int getSmallFriendAvatar(long p0, long p1);

    private static native int getMediumFriendAvatar(long p0, long p1);

    private static native int getLargeFriendAvatar(long p0, long p1);

    private static native boolean requestUserInformation(long p0, long p1, boolean p2);

    private static native void activateGameOverlay(long p0, String p1);

    private static native void activateGameOverlayToUser(long p0, String p1, long p2);

    private static native void activateGameOverlayToWebPage(long p0, String p1);

    private static native void activateGameOverlayToStore(long p0, int p1, int p2);

    private static native void activateGameOverlayInviteDialog(long p0, long p1);

    private static native boolean setRichPresence(long p0, String p1, String p2);

    private static native void clearRichPresence(long p0);

    private static native String getFriendRichPresence(long p0, long p1, String p2);

    private static native int getFriendRichPresenceKeyCount(long p0, long p1);

    private static native String getFriendRichPresenceKeyByIndex(long p0, long p1, int p2);

    private static native void requestFriendRichPresence(long p0, long p1);

    private static native boolean inviteUserToGame(long p0, long p1, String p2);

    @Override
    public void dispose() {
    }

    public enum FriendFlags {
        None,

        Blocked,

        FriendshipRequested,

        Immediate,

        ClanMember,

        OnGameServer,

        RequestingFriendship,

        RequestingInfo,

        Ignored,

        IgnoredFriend,

        ChatMember,

        All,

        bits,

        $VALUES;

        private FriendFlags(String p0, int p1, int p2) {
        }

        @Additional
        FriendFlags() {

        }

        static int asBits(Collection p0) {
            return 0;
        }

        static int access$000(FriendFlags p0) {
            return 0;
        }
    }

    public enum FriendRelationship {
        None,

        Blocked,

        Recipient,

        Friend,

        RequestInitiator,

        Ignored,

        IgnoredFriend,

        Suggested_DEPRECATED,

        Max,

        values,

        $VALUES;

        private FriendRelationship(String p0, int p1) {
        }

        @Additional
        FriendRelationship() {

        }

        static FriendRelationship byOrdinal(int p0) {
            return null;
        }
    }

    public enum OverlayDialog {
        Friends,

        Community,

        Players,

        Settings,

        OfficialGameGroup,

        Stats,

        Achievements,

        id,

        $VALUES;

        private OverlayDialog(String p0, int p1, String p2) {
        }

        @Additional
        OverlayDialog() {

        }

        static String access$100(OverlayDialog p0) {
            return null;
        }
    }

    public enum OverlayToStoreFlag {
        None,

        AddToCart,

        AddToCartAndShow,

        $VALUES;

        private OverlayToStoreFlag(String p0, int p1) {
        }

        @Additional
        OverlayToStoreFlag() {

        }
    }

    public enum OverlayToUserDialog {
        SteamID,

        Chat,

        JoinTrade,

        Stats,

        Achievements,

        FriendAdd,

        FriendRemove,

        FriendRequestAccept,

        FriendRequestIgnore,

        id,

        $VALUES;

        private OverlayToUserDialog(String p0, int p1, String p2) {
        }

        @Additional
        OverlayToUserDialog() {

        }

        static String access$200(OverlayToUserDialog p0) {
            return null;
        }
    }

    public enum PersonaChange {
        Name,

        Status,

        ComeOnline,

        GoneOffline,

        GamePlayed,

        GameServer,

        Avatar,

        JoinedSource,

        LeftSource,

        RelationshipChanged,

        NameFirstSet,

        FacebookInfo,

        Nickname,

        SteamLevel,

        bits,

        $VALUES;

        private PersonaChange(String p0, int p1, int p2) {
        }

        @Additional
        PersonaChange() {

        }

        static boolean isSet(PersonaChange p0, int p1) {
            return false;
        }
    }

    public enum PersonaState {
        Offline,

        Online,

        Busy,

        Away,

        Snooze,

        LookingToTrade,

        LookingToPlay,

        values,

        $VALUES;

        private PersonaState(String p0, int p1) {
        }

        @Additional
        PersonaState() {

        }

        static PersonaState byOrdinal(int p0) {
            return null;
        }
    }
}
