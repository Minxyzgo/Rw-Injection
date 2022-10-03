package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.ByteBuffer;

public class SteamHTTP extends SteamInterface {
    public SteamHTTP(SteamHTTPCallback p0, API p1) {
        super(0);
    }

    public SteamHTTPRequestHandle createHTTPRequest(HTTPMethod p0, String p1) {
        return null;
    }

    public boolean setHTTPRequestContextValue(SteamHTTPRequestHandle p0, long p1) {
        return false;
    }

    public boolean setHTTPRequestNetworkActivityTimeout(SteamHTTPRequestHandle p0, int p1) {
        return false;
    }

    public boolean setHTTPRequestHeaderValue(SteamHTTPRequestHandle p0, String p1, String p2) {
        return false;
    }

    public boolean setHTTPRequestGetOrPostParameter(SteamHTTPRequestHandle p0, String p1,
            String p2) {
        return false;
    }

    public SteamAPICall sendHTTPRequest(SteamHTTPRequestHandle p0) {
        return null;
    }

    public SteamAPICall sendHTTPRequestAndStreamResponse(SteamHTTPRequestHandle p0) {
        return null;
    }

    public int getHTTPResponseHeaderSize(SteamHTTPRequestHandle p0, String p1) {
        return 0;
    }

    public boolean getHTTPResponseHeaderValue(SteamHTTPRequestHandle p0, String p1, ByteBuffer p2) {
        return false;
    }

    public int getHTTPResponseBodySize(SteamHTTPRequestHandle p0) {
        return 0;
    }

    public boolean getHTTPResponseBodyData(SteamHTTPRequestHandle p0, ByteBuffer p1) {
        return false;
    }

    public boolean getHTTPStreamingResponseBodyData(SteamHTTPRequestHandle p0, int p1,
            ByteBuffer p2) {
        return false;
    }

    public boolean releaseHTTPRequest(SteamHTTPRequestHandle p0) {
        return false;
    }

    private static native long createCallback(SteamHTTPCallbackAdapter p0, boolean p1);

    private static native long createHTTPRequest(long p0, int p1, String p2);

    private static native boolean setHTTPRequestContextValue(long p0, long p1, long p2);

    private static native boolean setHTTPRequestNetworkActivityTimeout(long p0, long p1, int p2);

    private static native boolean setHTTPRequestHeaderValue(long p0, long p1, String p2, String p3);

    private static native boolean setHTTPRequestGetOrPostParameter(long p0, long p1, String p2,
            String p3);

    private static native long sendHTTPRequest(long p0, long p1, long p2);

    private static native long sendHTTPRequestAndStreamResponse(long p0, long p1);

    private static native int getHTTPResponseHeaderSize(long p0, long p1, String p2);

    private static native boolean getHTTPResponseHeaderValue(long p0, long p1, String p2,
            ByteBuffer p3, int p4, int p5);

    private static native int getHTTPResponseBodySize(long p0, long p1);

    private static native boolean getHTTPResponseBodyData(long p0, long p1, ByteBuffer p2, int p3,
            int p4);

    private static native boolean getHTTPStreamingResponseBodyData(long p0, long p1, int p2,
            ByteBuffer p3, int p4, int p5);

    private static native boolean releaseHTTPRequest(long p0, long p1);

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

    public enum HTTPMethod {
        Invalid,

        GET,

        HEAD,

        POST,

        PUT,

        DELETE,

        OPTIONS,

        $VALUES;

        private HTTPMethod(String p0, int p1) {
        }

        @Additional
        HTTPMethod() {

        }
    }

    public enum HTTPStatusCode {
        Invalid,

        Continue,

        SwitchingProtocols,

        OK,

        Created,

        Accepted,

        NonAuthoritative,

        NoContent,

        ResetContent,

        PartialContent,

        MultipleChoices,

        MovedPermanently,

        Found,

        SeeOther,

        NotModified,

        UseProxy,

        TemporaryRedirect,

        BadRequest,

        Unauthorized,

        PaymentRequired,

        Forbidden,

        NotFound,

        MethodNotAllowed,

        NotAcceptable,

        ProxyAuthRequired,

        RequestTimeout,

        Conflict,

        Gone,

        LengthRequired,

        PreconditionFailed,

        RequestEntityTooLarge,

        RequestURITooLong,

        UnsupportedMediaType,

        RequestedRangeNotSatisfiable,

        ExpectationFailed,

        Unknown4xx,

        TooManyRequests,

        InternalServerError,

        NotImplemented,

        BadGateway,

        ServiceUnavailable,

        GatewayTimeout,

        HTTPVersionNotSupported,

        Unknown5xx,

        code,

        values,

        $VALUES;

        private HTTPStatusCode(String p0, int p1, int p2) {
        }

        @Additional
        HTTPStatusCode() {

        }

        static HTTPStatusCode byValue(int p0) {
            return null;
        }
    }
}
