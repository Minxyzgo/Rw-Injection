package com.codedisaster.steamworks;

public strictfp interface SteamRemoteStorageCallback {
    void onFileShareResult(SteamUGCHandle p0, String p1, SteamResult p2);

    void onDownloadUGCResult(SteamUGCHandle p0, SteamResult p1);

    void onPublishFileResult(SteamPublishedFileID p0, boolean p1, SteamResult p2);

    void onUpdatePublishedFileResult(SteamPublishedFileID p0, boolean p1, SteamResult p2);

    void onPublishedFileSubscribed(SteamPublishedFileID p0, int p1);

    void onPublishedFileUnsubscribed(SteamPublishedFileID p0, int p1);

    void onPublishedFileDeleted(SteamPublishedFileID p0, int p1);

    void onFileWriteAsyncComplete(SteamResult p0);

    void onFileReadAsyncComplete(SteamAPICall p0, SteamResult p1, int p2, int p3);
}
