package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.util.Collection;

public class SteamUGC extends SteamInterface {
    public SteamUGC(SteamUGCCallback p0) {
        super(0);
    }

    public SteamUGCQuery createQueryUserUGCRequest(long p0, UserUGCList p1, MatchingUGCType p2,
            UserUGCListSortOrder p3, int p4, int p5, int p6) {
        return null;
    }

    public SteamUGCQuery createQueryAllUGCRequest(UGCQueryType p0, MatchingUGCType p1, int p2,
            int p3, int p4) {
        return null;
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(SteamPublishedFileID p0) {
        return null;
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(Collection p0) {
        return null;
    }

    public SteamAPICall sendQueryUGCRequest(SteamUGCQuery p0) {
        return null;
    }

    public boolean getQueryUGCResult(SteamUGCQuery p0, int p1, SteamUGCDetails p2) {
        return false;
    }

    public String getQueryUGCPreviewURL(SteamUGCQuery p0, int p1) {
        return null;
    }

    public String getQueryUGCMetadata(SteamUGCQuery p0, int p1) {
        return null;
    }

    public long getQueryUGCStatistic(SteamUGCQuery p0, int p1, ItemStatistic p2) {
        return 0;
    }

    public int getQueryUGCNumAdditionalPreviews(SteamUGCQuery p0, int p1) {
        return 0;
    }

    public boolean getQueryUGCAdditionalPreview(SteamUGCQuery p0, int p1, int p2,
            ItemAdditionalPreview p3) {
        return false;
    }

    public int getQueryUGCNumKeyValueTags(SteamUGCQuery p0, int p1) {
        return 0;
    }

    public boolean getQueryUGCKeyValueTag(SteamUGCQuery p0, int p1, int p2, String[] p3) {
        return false;
    }

    public boolean releaseQueryUserUGCRequest(SteamUGCQuery p0) {
        return false;
    }

    public boolean addRequiredTag(SteamUGCQuery p0, String p1) {
        return false;
    }

    public boolean addExcludedTag(SteamUGCQuery p0, String p1) {
        return false;
    }

    public boolean setReturnOnlyIDs(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnKeyValueTags(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnLongDescription(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnMetadata(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnChildren(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnAdditionalPreviews(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setReturnTotalOnly(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setLanguage(SteamUGCQuery p0, String p1) {
        return false;
    }

    public boolean setAllowCachedResponse(SteamUGCQuery p0, int p1) {
        return false;
    }

    public boolean setCloudFileNameFilter(SteamUGCQuery p0, String p1) {
        return false;
    }

    public boolean setMatchAnyTag(SteamUGCQuery p0, boolean p1) {
        return false;
    }

    public boolean setSearchText(SteamUGCQuery p0, String p1) {
        return false;
    }

    public boolean setRankedByTrendDays(SteamUGCQuery p0, int p1) {
        return false;
    }

    public boolean addRequiredKeyValueTag(SteamUGCQuery p0, String p1, String p2) {
        return false;
    }

    @Deprecated
    public SteamAPICall requestUGCDetails(SteamPublishedFileID p0, int p1) {
        return null;
    }

    public SteamAPICall createItem(int p0, SteamRemoteStorage.WorkshopFileType p1) {
        return null;
    }

    public SteamUGCUpdateHandle startItemUpdate(int p0, SteamPublishedFileID p1) {
        return null;
    }

    public boolean setItemTitle(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean setItemDescription(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean setItemUpdateLanguage(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean setItemMetadata(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean setItemVisibility(SteamUGCUpdateHandle p0,
            SteamRemoteStorage.PublishedFileVisibility p1) {
        return false;
    }

    public boolean setItemTags(SteamUGCUpdateHandle p0, String[] p1) {
        return false;
    }

    public boolean setItemContent(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean setItemPreview(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean removeItemKeyValueTags(SteamUGCUpdateHandle p0, String p1) {
        return false;
    }

    public boolean addItemKeyValueTag(SteamUGCUpdateHandle p0, String p1, String p2) {
        return false;
    }

    public SteamAPICall submitItemUpdate(SteamUGCUpdateHandle p0, String p1) {
        return null;
    }

    public ItemUpdateStatus getItemUpdateProgress(SteamUGCUpdateHandle p0, ItemUpdateInfo p1) {
        return null;
    }

    public SteamAPICall setUserItemVote(SteamPublishedFileID p0, boolean p1) {
        return null;
    }

    public SteamAPICall getUserItemVote(SteamPublishedFileID p0) {
        return null;
    }

    public SteamAPICall addItemToFavorites(int p0, SteamPublishedFileID p1) {
        return null;
    }

    public SteamAPICall removeItemFromFavorites(int p0, SteamPublishedFileID p1) {
        return null;
    }

    public SteamAPICall subscribeItem(SteamPublishedFileID p0) {
        return null;
    }

    public SteamAPICall unsubscribeItem(SteamPublishedFileID p0) {
        return null;
    }

    public int getNumSubscribedItems() {
        return 0;
    }

    public int getSubscribedItems(SteamPublishedFileID[] p0) {
        return 0;
    }

    public Collection getItemState(SteamPublishedFileID p0) {
        return null;
    }

    public boolean getItemInstallInfo(SteamPublishedFileID p0, ItemInstallInfo p1) {
        return false;
    }

    public boolean getItemDownloadInfo(SteamPublishedFileID p0, ItemDownloadInfo p1) {
        return false;
    }

    public boolean downloadItem(SteamPublishedFileID p0, boolean p1) {
        return false;
    }

    public boolean initWorkshopForGameServer(int p0, String p1) {
        return false;
    }

    public void suspendDownloads(boolean p0) {
    }

    public SteamAPICall startPlaytimeTracking(SteamPublishedFileID[] p0) {
        return null;
    }

    public SteamAPICall stopPlaytimeTracking(SteamPublishedFileID[] p0) {
        return null;
    }

    public SteamAPICall stopPlaytimeTrackingForAllItems() {
        return null;
    }

    private static native long createCallback(SteamUGCCallbackAdapter p0);

    private static native long createQueryUserUGCRequest(long p0, long p1, int p2, int p3, int p4,
            int p5, int p6, int p7);

    private static native long createQueryAllUGCRequest(long p0, int p1, int p2, int p3, int p4,
            int p5);

    private static native long createQueryUGCDetailsRequest(long p0, long[] p1, int p2);

    private static native long sendQueryUGCRequest(long p0, long p1, long p2);

    private static native boolean getQueryUGCResult(long p0, long p1, int p2, SteamUGCDetails p3);

    private static native String getQueryUGCPreviewURL(long p0, long p1, int p2);

    private static native String getQueryUGCMetadata(long p0, long p1, int p2);

    private static native long getQueryUGCStatistic(long p0, long p1, int p2, int p3);

    private static native int getQueryUGCNumAdditionalPreviews(long p0, long p1, int p2);

    private static native boolean getQueryUGCAdditionalPreview(long p0, long p1, int p2, int p3,
            ItemAdditionalPreview p4);

    private static native int getQueryUGCNumKeyValueTags(long p0, long p1, int p2);

    private static native boolean getQueryUGCKeyValueTag(long p0, long p1, int p2, int p3,
            String[] p4);

    private static native boolean releaseQueryUserUGCRequest(long p0, long p1);

    private static native boolean addRequiredTag(long p0, long p1, String p2);

    private static native boolean addExcludedTag(long p0, long p1, String p2);

    private static native boolean setReturnOnlyIDs(long p0, long p1, boolean p2);

    private static native boolean setReturnKeyValueTags(long p0, long p1, boolean p2);

    private static native boolean setReturnLongDescription(long p0, long p1, boolean p2);

    private static native boolean setReturnMetadata(long p0, long p1, boolean p2);

    private static native boolean setReturnChildren(long p0, long p1, boolean p2);

    private static native boolean setReturnAdditionalPreviews(long p0, long p1, boolean p2);

    private static native boolean setReturnTotalOnly(long p0, long p1, boolean p2);

    private static native boolean setLanguage(long p0, long p1, String p2);

    private static native boolean setAllowCachedResponse(long p0, long p1, int p2);

    private static native boolean setCloudFileNameFilter(long p0, long p1, String p2);

    private static native boolean setMatchAnyTag(long p0, long p1, boolean p2);

    private static native boolean setSearchText(long p0, long p1, String p2);

    private static native boolean setRankedByTrendDays(long p0, long p1, int p2);

    private static native boolean addRequiredKeyValueTag(long p0, long p1, String p2, String p3);

    private static native long requestUGCDetails(long p0, long p1, long p2, int p3);

    private static native long createItem(long p0, long p1, int p2, int p3);

    private static native long startItemUpdate(long p0, int p1, long p2);

    private static native boolean setItemTitle(long p0, long p1, String p2);

    private static native boolean setItemDescription(long p0, long p1, String p2);

    private static native boolean setItemUpdateLanguage(long p0, long p1, String p2);

    private static native boolean setItemMetadata(long p0, long p1, String p2);

    private static native boolean setItemVisibility(long p0, long p1, int p2);

    private static native boolean setItemTags(long p0, long p1, String[] p2, int p3);

    private static native boolean setItemContent(long p0, long p1, String p2);

    private static native boolean setItemPreview(long p0, long p1, String p2);

    private static native boolean removeItemKeyValueTags(long p0, long p1, String p2);

    private static native boolean addItemKeyValueTag(long p0, long p1, String p2, String p3);

    private static native long submitItemUpdate(long p0, long p1, long p2, String p3);

    private static native int getItemUpdateProgress(long p0, long p1, long[] p2);

    private static native long setUserItemVote(long p0, long p1, long p2, boolean p3);

    private static native long getUserItemVote(long p0, long p1, long p2);

    private static native long addItemToFavorites(long p0, long p1, int p2, long p3);

    private static native long removeItemFromFavorites(long p0, long p1, int p2, long p3);

    private static native long subscribeItem(long p0, long p1, long p2);

    private static native long unsubscribeItem(long p0, long p1, long p2);

    private static native int getNumSubscribedItems(long p0);

    private static native int getSubscribedItems(long p0, long[] p1, int p2);

    private static native int getItemState(long p0, long p1);

    private static native boolean getItemInstallInfo(long p0, long p1, ItemInstallInfo p2);

    private static native boolean getItemDownloadInfo(long p0, long p1, long[] p2);

    private static native boolean downloadItem(long p0, long p1, boolean p2);

    private static native boolean initWorkshopForGameServer(long p0, int p1, String p2);

    private static native void suspendDownloads(long p0, boolean p1);

    private static native long startPlaytimeTracking(long p0, long p1, long[] p2, int p3);

    private static native long stopPlaytimeTracking(long p0, long p1, long[] p2, int p3);

    private static native long stopPlaytimeTrackingForAllItems(long p0, long p1);

    @Override
    public void dispose() {
    }

    public static class ItemAdditionalPreview {
        private String urlOrVideoID;

        private String originalFileName;

        private int previewType;

        public ItemAdditionalPreview() {
            super();
        }

        public String getUrlOrVideoID() {
            return null;
        }

        public String getOriginalFileName() {
            return null;
        }

        public ItemPreviewType getPreviewType() {
            return null;
        }
    }

    public static class ItemDownloadInfo {
        long bytesDownloaded;

        long bytesTotal;

        public ItemDownloadInfo() {
            super();
        }

        public long getBytesDownloaded() {
            return 0;
        }

        public long getBytesTotal() {
            return 0;
        }
    }

    public static class ItemInstallInfo {
        private String folder;

        private int sizeOnDisk;

        public ItemInstallInfo() {
            super();
        }

        public String getFolder() {
            return null;
        }

        public int getSizeOnDisk() {
            return 0;
        }
    }

    public enum ItemPreviewType {
        Image,

        YouTubeVideo,

        Sketchfab,

        EnvironmentMap_HorizontalCross,

        EnvironmentMap_LatLong,

        ReservedMax,

        UnknownPreviewType_NotImplementedByAPI,

        value,

        values,

        $VALUES;

        private ItemPreviewType(String p0, int p1, int p2) {
        }

        @Additional
        ItemPreviewType() {

        }

        static ItemPreviewType byValue(int p0) {
            return null;
        }
    }

    public enum ItemState {
        None,

        Subscribed,

        LegacyItem,

        Installed,

        NeedsUpdate,

        Downloading,

        DownloadPending,

        bits,

        values,

        $VALUES;

        private ItemState(String p0, int p1, int p2) {
        }

        @Additional
        ItemState() {

        }

        static Collection fromBits(int p0) {
            return null;
        }
    }

    public enum ItemStatistic {
        NumSubscriptions,

        NumFavorites,

        NumFollowers,

        NumUniqueSubscriptions,

        NumUniqueFavorites,

        NumUniqueFollowers,

        NumUniqueWebsiteViews,

        ReportScore,

        NumSecondsPlayed,

        NumPlaytimeSessions,

        NumComments,

        $VALUES;

        private ItemStatistic(String p0, int p1) {
        }

        @Additional
        ItemStatistic() {

        }
    }

    public static class ItemUpdateInfo {
        long bytesProcessed;

        long bytesTotal;

        public ItemUpdateInfo() {
            super();
        }

        public long getBytesProcessed() {
            return 0;
        }

        public long getBytesTotal() {
            return 0;
        }
    }

    public enum ItemUpdateStatus {
        Invalid,

        PreparingConfig,

        PreparingContent,

        UploadingContent,

        UploadingPreviewFile,

        CommittingChanges,

        values,

        $VALUES;

        private ItemUpdateStatus(String p0, int p1) {
        }

        @Additional
        ItemUpdateStatus() {

        }

        static ItemUpdateStatus byOrdinal(int p0) {
            return null;
        }
    }

    public enum MatchingUGCType {
        Items,

        ItemsMtx,

        ItemsReadyToUse,

        Collections,

        Artwork,

        Videos,

        Screenshots,

        AllGuides,

        WebGuides,

        IntegratedGuides,

        UsableInGame,

        ControllerBindings,

        GameManagedItems,

        All,

        value,

        $VALUES;

        private MatchingUGCType(String p0, int p1, int p2) {
        }

        @Additional
        MatchingUGCType() {

        }

        static int access$000(MatchingUGCType p0) {
            return 0;
        }
    }

    public enum UGCQueryType {
        RankedByVote,

        RankedByPublicationDate,

        AcceptedForGameRankedByAcceptanceDate,

        RankedByTrend,

        FavoritedByFriendsRankedByPublicationDate,

        CreatedByFriendsRankedByPublicationDate,

        RankedByNumTimesReported,

        CreatedByFollowedUsersRankedByPublicationDate,

        NotYetRated,

        RankedByTotalVotesAsc,

        RankedByVotesUp,

        RankedByTextSearch,

        RankedByTotalUniqueSubscriptions,

        RankedByPlaytimeTrend,

        RankedByTotalPlaytime,

        RankedByAveragePlaytimeTrend,

        RankedByLifetimeAveragePlaytime,

        RankedByPlaytimeSessionsTrend,

        RankedByLifetimePlaytimeSessions,

        $VALUES;

        private UGCQueryType(String p0, int p1) {
        }

        @Additional
        UGCQueryType() {

        }
    }

    public enum UserUGCList {
        Published,

        VotedOn,

        VotedUp,

        VotedDown,

        WillVoteLater,

        Favorited,

        Subscribed,

        UsedOrPlayed,

        Followed,

        $VALUES;

        private UserUGCList(String p0, int p1) {
        }

        @Additional
        UserUGCList() {

        }
    }

    public enum UserUGCListSortOrder {
        CreationOrderDesc,

        CreationOrderAsc,

        TitleAsc,

        LastUpdatedDesc,

        SubscriptionDateDesc,

        VoteScoreDesc,

        ForModeration,

        $VALUES;

        private UserUGCListSortOrder(String p0, int p1) {
        }

        @Additional
        UserUGCListSortOrder() {

        }
    }
}
