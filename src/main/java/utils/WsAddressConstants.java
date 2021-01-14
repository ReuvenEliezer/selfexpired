package utils;

/**
 * Created by erezm on 27/12/2016.
 */
public class WsAddressConstants {

    private static final String localhost = "http://localhost:3001";

    public static final String selfExpiredLogicalUrl = "/selfExpired/";
    public static final String selfExpiredFullUrl = localhost + selfExpiredLogicalUrl;

    public static final String aSyncLogicalUrl = "/aSync/";
    public static final String aSyncFullUrl = localhost + aSyncLogicalUrl;

    public static final String dateTimeLogicalUrl = "/dateTime/";
    public static final String dateTimeFullUrl = localhost + dateTimeLogicalUrl;
}