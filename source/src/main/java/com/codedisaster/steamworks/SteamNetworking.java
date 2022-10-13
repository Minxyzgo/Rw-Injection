package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.ByteBuffer;

public class SteamNetworking extends SteamInterface {
    private final int[] tmpIntResult = null;

    private final long[] tmpLongResult = null;

    public SteamNetworking(SteamNetworkingCallback p0, API p1) {
        super(0);
    }

    public boolean sendP2PPacket(SteamID p0, ByteBuffer p1, P2PSend p2, int p3) {
        return false;
    }

    public boolean sendP2PPacket(SteamID p0, ByteBuffer p1, int p2, int p3, P2PSend p4, int p5) {
        return false;
    }

    public int isP2PPacketAvailable(int p0) {
        return 0;
    }

    public int readP2PPacket(SteamID p0, ByteBuffer p1, int p2) {
        return 0;
    }

    public int readP2PPacket(SteamID p0, ByteBuffer p1, int p2, int p3, int p4) {
        return 0;
    }

    public boolean acceptP2PSessionWithUser(SteamID p0) {
        return false;
    }

    public boolean closeP2PSessionWithUser(SteamID p0) {
        return false;
    }

    public boolean closeP2PChannelWithUser(SteamID p0, int p1) {
        return false;
    }

    public boolean getP2PSessionState(SteamID p0, P2PSessionState p1) {
        return false;
    }

    public boolean allowP2PPacketRelay(boolean p0) {
        return false;
    }

    private static native long createCallback(SteamNetworkingCallbackAdapter p0, boolean p1);

    private static native boolean sendP2PPacket(long p0, long p1, ByteBuffer p2, int p3, int p4,
            int p5, int p6);

    private static native boolean isP2PPacketAvailable(long p0, int[] p1, int p2);

    private static native boolean readP2PPacket(long p0, ByteBuffer p1, int p2, int p3, int[] p4,
            long[] p5, int p6);

    private static native boolean acceptP2PSessionWithUser(long p0, long p1);

    private static native boolean closeP2PSessionWithUser(long p0, long p1);

    private static native boolean closeP2PChannelWithUser(long p0, long p1, int p2);

    private static native boolean getP2PSessionState(long p0, long p1, P2PSessionState p2);

    private static native boolean allowP2PPacketRelay(long p0, boolean p1);

    @Override
    public void dispose() {
    }

    public enum API {
        Client,

        Server,

        $VALUES;

        private API(String p0, int p1) {
        }

        @Additional
        API() {

        }
    }

    public enum P2PSend {
        Unreliable,

        UnreliableNoDelay,

        Reliable,

        ReliableWithBuffering,

        $VALUES;

        private P2PSend(String p0, int p1) {
        }

        @Additional
        P2PSend() {

        }
    }

    public enum P2PSessionError {
        None,

        NotRunningApp,

        NoRightsToApp,

        DestinationNotLoggedIn,

        Timeout,

        values,

        $VALUES;

        private P2PSessionError(String p0, int p1) {
        }

        @Additional
        P2PSessionError() {

        }

        public static P2PSessionError byOrdinal(int p0) {
            return null;
        }
    }

    public static class P2PSessionState {
        byte connectionActive;

        byte connecting;

        byte sessionError;

        byte usingRelay;

        int bytesQueuedForSend;

        int packetsQueuedForSend;

        int remoteIP;

        short remotePort;

        public P2PSessionState() {
            super();
        }

        public boolean isConnectionActive() {
            return false;
        }

        public boolean isConnecting() {
            return false;
        }

        public P2PSessionError getLastSessionError() {
            return null;
        }

        public boolean isUsingRelay() {
            return false;
        }

        public int getBytesQueuedForSend() {
            return 0;
        }

        public int getPacketsQueuedForSend() {
            return 0;
        }

        public int getRemoteIP() {
            return 0;
        }

        public short getRemotePort() {
            return 0;
        }
    }
}
