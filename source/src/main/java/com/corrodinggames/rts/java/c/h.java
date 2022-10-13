package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;

public class h implements SteamUGCCallback {
    final g a = null;

    public h(g p0) {
        super();
    }

    @Override
    public void onUGCQueryCompleted(SteamUGCQuery p0, int p1, int p2, boolean p3, SteamResult p4) {
    }

    @Override
    public void onSubscribeItem(SteamPublishedFileID p0, SteamResult p1) {
    }

    @Override
    public void onUnsubscribeItem(SteamPublishedFileID p0, SteamResult p1) {
    }

    @Override
    public void onRequestUGCDetails(SteamUGCDetails p0, SteamResult p1) {
    }

    @Override
    public void onCreateItem(SteamPublishedFileID p0, boolean p1, SteamResult p2) {
    }

    @Override
    public void onSubmitItemUpdate(boolean p0, SteamResult p1) {
    }

    @Override
    public void onDownloadItemResult(int p0, SteamPublishedFileID p1, SteamResult p2) {
    }

    @Override
    public void onUserFavoriteItemsListChanged(SteamPublishedFileID p0, boolean p1,
            SteamResult p2) {
    }

    @Override
    public void onSetUserItemVote(SteamPublishedFileID p0, boolean p1, SteamResult p2) {
    }

    @Override
    public void onGetUserItemVote(SteamPublishedFileID p0, boolean p1, boolean p2, boolean p3,
            SteamResult p4) {
    }

    @Override
    public void onStartPlaytimeTracking(SteamResult p0) {
    }

    @Override
    public void onStopPlaytimeTracking(SteamResult p0) {
    }

    @Override
    public void onStopPlaytimeTrackingForAllItems(SteamResult p0) {
    }

    public void a(String p0, SteamResult p1) {
    }
}
