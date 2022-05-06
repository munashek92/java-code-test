package se.teamengine.java.test.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class HMacUtil {
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private static final String HMAC_PRE_SHARED_KEY ="Super secret key";


    public static String generateHMAC(String msg) {
        return doCreateHMAC(msg);
    }

    public static void assertHMacValid(String msg, String strMac) {

        if (!verifyHMac(msg, strMac)) {
            throw new IllegalArgumentException("HMac verification failed");
        }
    }

    private static boolean verifyHMac(String msg, String strMac) {
        String calcedMac = doCreateHMAC(msg);
        return strMac.equals(calcedMac);
    }

    private static String doCreateHMAC(String msg) {
        // Validate input
        if(msg == null || msg.isEmpty()) {
            throw new RuntimeException("Message should not be empty");
        }

        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((HMacUtil.HMAC_PRE_SHARED_KEY).getBytes(StandardCharsets.UTF_8), HMAC_SHA256_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes(StandardCharsets.UTF_8));

            StringBuilder hash = new StringBuilder();
            for (byte aByte : bytes) {
                String hex = Integer.toHexString(0xFF & aByte);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failure in crypto stuff:", e);
        }
        return digest;
    }

}
