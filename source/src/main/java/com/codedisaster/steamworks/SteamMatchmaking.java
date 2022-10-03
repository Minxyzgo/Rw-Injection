package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.ByteBuffer;

public class SteamMatchmaking extends SteamInterface {
    public SteamMatchmaking(SteamMatchmakingCallback p0) {
        super(0);
    }

    public SteamAPICall requestLobbyList() {
        return null;
    }

    public void addRequestLobbyListStringFilter(String p0, String p1, LobbyComparison p2) {
    }

    public void addRequestLobbyListNumericalFilter(String p0, int p1, LobbyComparison p2) {
    }

    public void addRequestLobbyListNearValueFilter(String p0, int p1) {
    }

    public void addRequestLobbyListFilterSlotsAvailable(int p0) {
    }

    public void addRequestLobbyListDistanceFilter(LobbyDistanceFilter p0) {
    }

    public void addRequestLobbyListResultCountFilter(int p0) {
    }

    public void addRequestLobbyListCompatibleMembersFilter(SteamID p0) {
    }

    public SteamID getLobbyByIndex(int p0) {
        return null;
    }

    public SteamAPICall createLobby(LobbyType p0, int p1) {
        return null;
    }

    public SteamAPICall joinLobby(SteamID p0) {
        return null;
    }

    public void leaveLobby(SteamID p0) {
    }

    public boolean inviteUserToLobby(SteamID p0, SteamID p1) {
        return false;
    }

    public int getNumLobbyMembers(SteamID p0) {
        return 0;
    }

    public SteamID getLobbyMemberByIndex(SteamID p0, int p1) {
        return null;
    }

    public String getLobbyData(SteamID p0, String p1) {
        return null;
    }

    public boolean setLobbyData(SteamID p0, String p1, String p2) {
        return false;
    }

    public boolean setLobbyData(SteamID p0, SteamMatchMakingKeyValuePair p1) {
        return false;
    }

    public int getLobbyDataCount(SteamID p0) {
        return 0;
    }

    public boolean getLobbyDataByIndex(SteamID p0, int p1, SteamMatchMakingKeyValuePair p2) {
        return false;
    }

    public boolean deleteLobbyData(SteamID p0, String p1) {
        return false;
    }

    public boolean sendLobbyChatMsg(SteamID p0, ByteBuffer p1) {
        return false;
    }

    public boolean sendLobbyChatMsg(SteamID p0, ByteBuffer p1, int p2, int p3) {
        return false;
    }

    public boolean sendLobbyChatMsg(SteamID p0, String p1) {
        return false;
    }

    public int getLobbyChatEntry(SteamID p0, int p1, ChatEntry p2, ByteBuffer p3) {
        return 0;
    }

    public int getLobbyChatEntry(SteamID p0, int p1, ChatEntry p2, ByteBuffer p3, int p4, int p5) {
        return 0;
    }

    public boolean requestLobbyData(SteamID p0) {
        return false;
    }

    public boolean setLobbyMemberLimit(SteamID p0, int p1) {
        return false;
    }

    public boolean getLobbyMemberLimit(SteamID p0) {
        return false;
    }

    public boolean setLobbyType(SteamID p0, LobbyType p1) {
        return false;
    }

    public boolean setLobbyJoinable(SteamID p0, boolean p1) {
        return false;
    }

    public SteamID getLobbyOwner(SteamID p0) {
        return null;
    }

    public boolean setLobbyOwner(SteamID p0, SteamID p1) {
        return false;
    }

    public boolean setLinkedLobby(SteamID p0, SteamID p1) {
        return false;
    }

    private static native long createCallback(SteamMatchmakingCallbackAdapter p0);

    private static native long requestLobbyList(long p0, long p1);

    private static native void addRequestLobbyListStringFilter(long p0, String p1, String p2,
            int p3);

    private static native void addRequestLobbyListNumericalFilter(long p0, String p1, int p2,
            int p3);

    private static native void addRequestLobbyListNearValueFilter(long p0, String p1, int p2);

    private static native void addRequestLobbyListFilterSlotsAvailable(long p0, int p1);

    private static native void addRequestLobbyListDistanceFilter(long p0, int p1);

    private static native void addRequestLobbyListResultCountFilter(long p0, int p1);

    private static native void addRequestLobbyListCompatibleMembersFilter(long p0, long p1);

    private static native long getLobbyByIndex(long p0, int p1);

    private static native long createLobby(long p0, long p1, int p2, int p3);

    private static native long joinLobby(long p0, long p1, long p2);

    private static native void leaveLobby(long p0, long p1);

    private static native boolean inviteUserToLobby(long p0, long p1, long p2);

    private static native int getNumLobbyMembers(long p0, long p1);

    private static native long getLobbyMemberByIndex(long p0, long p1, int p2);

    private static native String getLobbyData(long p0, long p1, String p2);

    private static native boolean setLobbyData(long p0, long p1, String p2, String p3);

    private static native int getLobbyDataCount(long p0, long p1);

    private static native boolean getLobbyDataByIndex(long p0, long p1, int p2,
            SteamMatchMakingKeyValuePair p3);

    private static native boolean deleteLobbyData(long p0, long p1, String p2);

    private static native boolean sendLobbyChatMsg(long p0, long p1, ByteBuffer p2, int p3, int p4);

    private static native boolean sendLobbyChatMsg(long p0, long p1, String p2);

    private static native int getLobbyChatEntry(long p0, long p1, int p2, ChatEntry p3,
            ByteBuffer p4, int p5, int p6);

    private static native boolean requestLobbyData(long p0, long p1);

    private static native boolean setLobbyMemberLimit(long p0, long p1, int p2);

    private static native boolean getLobbyMemberLimit(long p0, long p1);

    private static native boolean setLobbyType(long p0, long p1, int p2);

    private static native boolean setLobbyJoinable(long p0, long p1, boolean p2);

    private static native long getLobbyOwner(long p0, long p1);

    private static native boolean setLobbyOwner(long p0, long p1, long p2);

    private static native boolean setLinkedLobby(long p0, long p1, long p2);

    @Override
    public void dispose() {
    }

    public static class ChatEntry {
        private long steamIDUser;

        private int chatEntryType;

        public ChatEntry() {
            super();
        }

        public SteamID getSteamIDUser() {
            return null;
        }

        public ChatEntryType getChatEntryType() {
            return null;
        }
    }

    public enum ChatEntryType {
        Invalid,

        ChatMsg,

        Typing,

        InviteGame,

        Emote,

        LeftConversation,

        Entered,

        WasKicked,

        WasBanned,

        Disconnected,

        HistoricalChat,

        Reserved1,

        Reserved2,

        LinkBlocked,

        code,

        values,

        $VALUES;

        private ChatEntryType(String p0, int p1, int p2) {
        }

        @Additional
        ChatEntryType() {

        }

        static ChatEntryType byCode(int p0) {
            return null;
        }
    }

    public enum ChatMemberStateChange {
        Entered,

        Left,

        Disconnected,

        Kicked,

        Banned,

        bits,

        $VALUES;

        private ChatMemberStateChange(String p0, int p1, int p2) {
        }

        @Additional
        ChatMemberStateChange() {

        }

        static boolean isSet(ChatMemberStateChange p0, int p1) {
            return false;
        }
    }

    public enum ChatRoomEnterResponse {
        Success,

        DoesntExist,

        NotAllowed,

        Full,

        Error,

        Banned,

        Limited,

        ClanDisabled,

        CommunityBan,

        MemberBlockedYou,

        YouBlockedMember,

        code,

        values,

        $VALUES;

        private ChatRoomEnterResponse(String p0, int p1, int p2) {
        }

        @Additional
        ChatRoomEnterResponse() {

        }

        static ChatRoomEnterResponse byCode(int p0) {
            return null;
        }
    }

    public enum LobbyComparison {
        EqualToOrLessThan,

        LessThan,

        Equal,

        GreaterThan,

        EqualToOrGreaterThan,

        NotEqual,

        value,

        $VALUES;

        private LobbyComparison(String p0, int p1, int p2) {
        }

        @Additional
        LobbyComparison() {

        }

        static int access$000(LobbyComparison p0) {
            return 0;
        }
    }

    public enum LobbyDistanceFilter {
        Close,

        Default,

        Far,

        Worldwide,

        $VALUES;

        private LobbyDistanceFilter(String p0, int p1) {
        }

        @Additional
        LobbyDistanceFilter() {

        }
    }

    public enum LobbyType {
        Private,

        FriendsOnly,

        Public,

        Invisible,

        $VALUES;

        private LobbyType(String p0, int p1) {
        }

        @Additional
        LobbyType() {

        }
    }
}
