package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.ByteBuffer;

public class SteamRemoteStorage extends SteamInterface {
    public SteamRemoteStorage(SteamRemoteStorageCallback p0) {
        super(0);
    }

    public boolean fileWrite(String p0, ByteBuffer p1, int p2) {
        return false;
    }

    public boolean fileRead(String p0, ByteBuffer p1, int p2) {
        return false;
    }

    public SteamAPICall fileWriteAsync(String p0, ByteBuffer p1) {
        return null;
    }

    public SteamAPICall fileReadAsync(String p0, int p1, int p2) {
        return null;
    }

    public boolean fileReadAsyncComplete(SteamAPICall p0, ByteBuffer p1, int p2) {
        return false;
    }

    public boolean fileForget(String p0) {
        return false;
    }

    public boolean fileDelete(String p0) {
        return false;
    }

    public SteamAPICall fileShare(String p0) {
        return null;
    }

    public boolean setSyncPlatforms(String p0, RemoteStoragePlatform p1) {
        return false;
    }

    public SteamUGCFileWriteStreamHandle fileWriteStreamOpen(String p0) {
        return null;
    }

    public boolean fileWriteStreamWriteChunk(SteamUGCFileWriteStreamHandle p0, ByteBuffer p1,
            int p2) {
        return false;
    }

    public boolean fileWriteStreamClose(SteamUGCFileWriteStreamHandle p0) {
        return false;
    }

    public boolean fileWriteStreamCancel(SteamUGCFileWriteStreamHandle p0) {
        return false;
    }

    public boolean fileExists(String p0) {
        return false;
    }

    public boolean filePersisted(String p0) {
        return false;
    }

    public int getFileSize(String p0) {
        return 0;
    }

    public long getFileTimestamp(String p0) {
        return 0;
    }

    public RemoteStoragePlatform[] getSyncPlatforms(String p0) {
        return null;
    }

    public int getFileCount() {
        return 0;
    }

    public String getFileNameAndSize(int p0, int[] p1) {
        return null;
    }

    public boolean getQuota(long[] p0, long[] p1) {
        return false;
    }

    public boolean isCloudEnabledForAccount() {
        return false;
    }

    public boolean isCloudEnabledForApp() {
        return false;
    }

    public void setCloudEnabledForApp(boolean p0) {
    }

    public SteamAPICall ugcDownload(SteamUGCHandle p0, int p1) {
        return null;
    }

    public boolean getUGCDownloadProgress(SteamUGCHandle p0, int[] p1, int[] p2) {
        return false;
    }

    public int ugcRead(SteamUGCHandle p0, ByteBuffer p1, int p2, int p3, UGCReadAction p4) {
        return 0;
    }

    public int getCachedUGCCount() {
        return 0;
    }

    public SteamUGCHandle getCachedUGCHandle(int p0) {
        return null;
    }

    public SteamAPICall publishWorkshopFile(String p0, String p1, int p2, String p3, String p4,
            PublishedFileVisibility p5, String[] p6, WorkshopFileType p7) {
        return null;
    }

    public SteamPublishedFileUpdateHandle createPublishedFileUpdateRequest(
            SteamPublishedFileID p0) {
        return null;
    }

    public boolean updatePublishedFileFile(SteamPublishedFileUpdateHandle p0, String p1) {
        return false;
    }

    public boolean updatePublishedFilePreviewFile(SteamPublishedFileUpdateHandle p0, String p1) {
        return false;
    }

    public boolean updatePublishedFileTitle(SteamPublishedFileUpdateHandle p0, String p1) {
        return false;
    }

    public boolean updatePublishedFileDescription(SteamPublishedFileUpdateHandle p0, String p1) {
        return false;
    }

    public boolean updatePublishedFileVisibility(SteamPublishedFileUpdateHandle p0,
            PublishedFileVisibility p1) {
        return false;
    }

    public boolean updatePublishedFileTags(SteamPublishedFileUpdateHandle p0, String[] p1) {
        return false;
    }

    public SteamAPICall commitPublishedFileUpdate(SteamPublishedFileUpdateHandle p0) {
        return null;
    }

    private static native long createCallback(SteamRemoteStorageCallbackAdapter p0);

    private static native boolean fileWrite(long p0, String p1, ByteBuffer p2, int p3);

    private static native boolean fileRead(long p0, String p1, ByteBuffer p2, int p3);

    private static native long fileWriteAsync(long p0, long p1, String p2, ByteBuffer p3, int p4);

    private static native long fileReadAsync(long p0, long p1, String p2, int p3, int p4);

    private static native boolean fileReadAsyncComplete(long p0, long p1, ByteBuffer p2, int p3);

    private static native boolean fileForget(long p0, String p1);

    private static native boolean fileDelete(long p0, String p1);

    private static native long fileShare(long p0, long p1, String p2);

    private static native boolean setSyncPlatforms(long p0, String p1, int p2);

    private static native long fileWriteStreamOpen(long p0, String p1);

    private static native boolean fileWriteStreamWriteChunk(long p0, long p1, ByteBuffer p2,
            int p3);

    private static native boolean fileWriteStreamClose(long p0, long p1);

    private static native boolean fileWriteStreamCancel(long p0, long p1);

    private static native boolean fileExists(long p0, String p1);

    private static native boolean filePersisted(long p0, String p1);

    private static native int getFileSize(long p0, String p1);

    private static native long getFileTimestamp(long p0, String p1);

    private static native int getSyncPlatforms(long p0, String p1);

    private static native int getFileCount(long p0);

    private static native String getFileNameAndSize(long p0, int p1, int[] p2);

    private static native boolean getQuota(long p0, long[] p1, long[] p2);

    private static native boolean isCloudEnabledForAccount(long p0);

    private static native boolean isCloudEnabledForApp(long p0);

    private static native void setCloudEnabledForApp(long p0, boolean p1);

    private static native long ugcDownload(long p0, long p1, long p2, int p3);

    private static native boolean getUGCDownloadProgress(long p0, long p1, int[] p2, int[] p3);

    private static native int ugcRead(long p0, long p1, ByteBuffer p2, int p3, int p4, int p5);

    private static native int getCachedUGCCount(long p0);

    private static native long getCachedUGCHandle(long p0, int p1);

    private static native long publishWorkshopFile(long p0, long p1, String p2, String p3, int p4,
            String p5, String p6, int p7, String[] p8, int p9, int p10);

    private static native long createPublishedFileUpdateRequest(long p0, long p1);

    private static native boolean updatePublishedFileFile(long p0, long p1, String p2);

    private static native boolean updatePublishedFilePreviewFile(long p0, long p1, String p2);

    private static native boolean updatePublishedFileTitle(long p0, long p1, String p2);

    private static native boolean updatePublishedFileDescription(long p0, long p1, String p2);

    private static native boolean updatePublishedFileVisibility(long p0, long p1, int p2);

    private static native boolean updatePublishedFileTags(long p0, long p1, String[] p2, int p3);

    private static native long commitPublishedFileUpdate(long p0, long p1, long p2);

    @Override
    public void dispose() {
    }

    public enum PublishedFileVisibility {
        Public,

        FriendsOnly,

        Private,

        $VALUES;

        private PublishedFileVisibility(String p0, int p1) {
        }

        @Additional
        PublishedFileVisibility() {

        }
    }

    public enum RemoteStoragePlatform {
        None,

        Windows,

        OSX,

        PS3,

        Linux,

        Reserved2,

        All,

        mask,

        values,

        $VALUES;

        private RemoteStoragePlatform(String p0, int p1, int p2) {
        }

        @Additional
        RemoteStoragePlatform() {

        }

        static RemoteStoragePlatform[] byMask(int p0) {
            return null;
        }

        static int access$000(RemoteStoragePlatform p0) {
            return 0;
        }
    }

    public enum UGCReadAction {
        ContinueReadingUntilFinished,

        ContinueReading,

        Close,

        $VALUES;

        private UGCReadAction(String p0, int p1) {
        }

        @Additional
        UGCReadAction() {

        }
    }

    public enum WorkshopFileType {
        Community,

        Microtransaction,

        Collection,

        Art,

        Video,

        Screenshot,

        Game,

        Software,

        Concept,

        WebGuide,

        IntegratedGuide,

        Merch,

        ControllerBinding,

        SteamworksAccessInvite,

        SteamVideo,

        GameManagedItem,

        values,

        $VALUES;

        private WorkshopFileType(String p0, int p1) {
        }

        @Additional
        WorkshopFileType() {

        }

        static WorkshopFileType byOrdinal(int p0) {
            return null;
        }
    }
}
