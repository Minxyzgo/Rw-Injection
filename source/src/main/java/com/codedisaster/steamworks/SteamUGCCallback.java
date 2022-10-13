package com.codedisaster.steamworks;

public strictfp interface SteamUGCCallback {
    void onUGCQueryCompleted(SteamUGCQuery p0, int p1, int p2, boolean p3, SteamResult p4);

    void onSubscribeItem(SteamPublishedFileID p0, SteamResult p1);

    void onUnsubscribeItem(SteamPublishedFileID p0, SteamResult p1);

    void onRequestUGCDetails(SteamUGCDetails p0, SteamResult p1);

    void onCreateItem(SteamPublishedFileID p0, boolean p1, SteamResult p2);

    void onSubmitItemUpdate(boolean p0, SteamResult p1);

    void onDownloadItemResult(int p0, SteamPublishedFileID p1, SteamResult p2);

    void onUserFavoriteItemsListChanged(SteamPublishedFileID p0, boolean p1, SteamResult p2);

    void onSetUserItemVote(SteamPublishedFileID p0, boolean p1, SteamResult p2);

    void onGetUserItemVote(SteamPublishedFileID p0, boolean p1, boolean p2, boolean p3,
            SteamResult p4);

    void onStartPlaytimeTracking(SteamResult p0);

    void onStopPlaytimeTracking(SteamResult p0);

    void onStopPlaytimeTrackingForAllItems(SteamResult p0);
}
