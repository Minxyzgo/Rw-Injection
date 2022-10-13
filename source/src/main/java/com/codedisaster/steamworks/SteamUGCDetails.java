package com.codedisaster.steamworks;

public class SteamUGCDetails {
    long publishedFileID;

    int result;

    int fileType;

    String title;

    String description;

    long ownerID;

    int timeCreated;

    int timeUpdated;

    boolean tagsTruncated;

    String tags;

    long fileHandle;

    long previewFileHandle;

    String fileName;

    int fileSize;

    int previewFileSize;

    String url;

    int votesUp;

    int votesDown;

    public SteamUGCDetails() {
        super();
    }

    public SteamPublishedFileID getPublishedFileID() {
        return null;
    }

    public SteamResult getResult() {
        return null;
    }

    public SteamRemoteStorage.WorkshopFileType getFileType() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public SteamID getOwnerID() {
        return null;
    }

    public int getTimeCreated() {
        return 0;
    }

    public int getTimeUpdated() {
        return 0;
    }

    public boolean areTagsTruncated() {
        return false;
    }

    public String getTags() {
        return null;
    }

    public SteamUGCHandle getFileHandle() {
        return null;
    }

    public SteamUGCHandle getPreviewFileHandle() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public int getFileSize() {
        return 0;
    }

    public int getPreviewFileSize() {
        return 0;
    }

    public String getURL() {
        return null;
    }

    public int getVotesUp() {
        return 0;
    }

    public int getVotesDown() {
        return 0;
    }
}
