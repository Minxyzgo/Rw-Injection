package com.codedisaster.steamworks;

import rwij.annotations.Additional;

public class SteamAuth {
    public SteamAuth() {
        super();
    }

    public enum AuthSessionResponse {
        OK,

        UserNotConnectedToSteam,

        NoLicenseOrExpired,

        VACBanned,

        LoggedInElseWhere,

        VACCheckTimedOut,

        AuthTicketCanceled,

        AuthTicketInvalidAlreadyUsed,

        AuthTicketInvalid,

        PublisherIssuedBan,

        values,

        $VALUES;

        private AuthSessionResponse(String p0, int p1) {
        }

        @Additional
        AuthSessionResponse() {

        }

        static AuthSessionResponse byOrdinal(int p0) {
            return null;
        }
    }

    public enum BeginAuthSessionResult {
        OK,

        InvalidTicket,

        DuplicateRequest,

        InvalidVersion,

        GameMismatch,

        ExpiredTicket,

        values,

        $VALUES;

        private BeginAuthSessionResult(String p0, int p1) {
        }

        @Additional
        BeginAuthSessionResult() {

        }

        static BeginAuthSessionResult byOrdinal(int p0) {
            return null;
        }
    }

    public enum UserHasLicenseForAppResult {
        HasLicense,

        DoesNotHaveLicense,

        NoAuth,

        values,

        $VALUES;

        private UserHasLicenseForAppResult(String p0, int p1) {
        }

        @Additional
        UserHasLicenseForAppResult() {

        }

        static UserHasLicenseForAppResult byOrdinal(int p0) {
            return null;
        }
    }
}
