package com.codedisaster.steamworks;

public strictfp interface SteamHTTPCallback {
    void onHTTPRequestCompleted(SteamHTTPRequestHandle p0, long p1, boolean p2,
            SteamHTTP.HTTPStatusCode p3, int p4);

    void onHTTPRequestHeadersReceived(SteamHTTPRequestHandle p0, long p1);

    void onHTTPRequestDataReceived(SteamHTTPRequestHandle p0, long p1, int p2, int p3);
}
