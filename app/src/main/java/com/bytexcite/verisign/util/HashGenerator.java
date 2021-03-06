package com.bytexcite.verisign.util;

import android.os.Build;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class to generate hashes of strings. Used to encrypt passwords.
 *
 * @author saifkhichi96
 * @version 1.0
 */
public class HashGenerator {

    public static String md5(String s) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                digest.update(s.getBytes(StandardCharsets.US_ASCII), 0, s.length());
            }
            else {
                digest.update(s.getBytes(Charset.forName("US-ASCII")), 0, s.length());
            }
            byte[] magnitude = digest.digest();
            BigInteger bi = new BigInteger(1, magnitude);
            return String.format("%0" + (magnitude.length << 1) + "x", bi);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
