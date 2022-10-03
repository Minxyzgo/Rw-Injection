package com.codedisaster.steamworks;

import rwij.annotations.Additional;

/**
 * lost enum classes:
 */
public enum SteamResult {
    OK,

    Fail,

    NoConnection,

    InvalidPassword,

    LoggedInElsewhere,

    InvalidProtocolVer,

    InvalidParam,

    FileNotFound,

    Busy,

    InvalidState,

    InvalidName,

    InvalidEmail,

    DuplicateName,

    AccessDenied,

    Timeout,

    Banned,

    AccountNotFound,

    InvalidSteamID,

    ServiceUnavailable,

    NotLoggedOn,

    Pending,

    EncryptionFailure,

    InsufficientPrivilege,

    LimitExceeded,

    Revoked,

    Expired,

    AlreadyRedeemed,

    DuplicateRequest,

    AlreadyOwned,

    IPNotFound,

    PersistFailed,

    LockingFailed,

    LogonSessionReplaced,

    ConnectFailed,

    HandshakeFailed,

    IOFailure,

    RemoteDisconnect,

    ShoppingCartNotFound,

    Blocked,

    Ignored,

    NoMatch,

    AccountDisabled,

    ServiceReadOnly,

    AccountNotFeatured,

    AdministratorOK,

    ContentVersion,

    TryAnotherCM,

    PasswordRequiredToKickSession,

    AlreadyLoggedInElsewhere,

    Suspended,

    Cancelled,

    DataCorruption,

    DiskFull,

    RemoteCallFailed,

    PasswordUnset,

    ExternalAccountUnlinked,

    PSNTicketInvalid,

    ExternalAccountAlreadyLinked,

    RemoteFileConflict,

    IllegalPassword,

    SameAsPreviousValue,

    AccountLogonDenied,

    CannotUseOldPassword,

    InvalidLoginAuthCode,

    AccountLogonDeniedNoMail,

    HardwareNotCapableOfIPT,

    IPTInitError,

    ParentalControlRestricted,

    FacebookQueryError,

    ExpiredLoginAuthCode,

    IPLoginRestrictionFailed,

    AccountLockedDown,

    AccountLogonDeniedVerifiedEmailRequired,

    NoMatchingURL,

    BadResponse,

    RequirePasswordReEntry,

    ValueOutOfRange,

    UnexpectedError,

    Disabled,

    InvalidCEGSubmission,

    RestrictedDevice,

    RegionLocked,

    RateLimitExceeded,

    AccountLoginDeniedNeedTwoFactor,

    ItemDeleted,

    AccountLoginDeniedThrottle,

    TwoFactorCodeMismatch,

    TwoFactorActivationCodeMismatch,

    AccountAssociatedToMultiplePartners,

    NotModified,

    NoMobileDevice,

    TimeNotSynced,

    SmsCodeFailed,

    AccountLimitExceeded,

    AccountActivityLimitExceeded,

    PhoneActivityLimitExceeded,

    RefundToWallet,

    EmailSendFailure,

    NotSettled,

    NeedCaptcha,

    GSLTDenied,

    GSOwnerDenied,

    InvalidItemType,

    IPBanned,

    GLSTExpired,

    UnknownErrorCode_NotImplementedByAPI,

    code,

    valuesLookupTable,

    $VALUES;

    private SteamResult(String p0, int p1, int p2) {
    }

    @Additional
    SteamResult() {

    }

    public static SteamResult byValue(int p0) {
        return null;
    }
}
