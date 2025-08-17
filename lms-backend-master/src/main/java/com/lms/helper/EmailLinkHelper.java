package com.lms.helper;

public class EmailLinkHelper {

    public static String getLinkForEmailVerification(String emailToken) {
        String link = "https://lmsbackend-production-3f74.up.railway.app/auth/emailVerification?token=" + emailToken;
        return link;
    }
}
