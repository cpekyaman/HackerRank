package com.hackerrank.javacl.advanced;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
abstract class SecureHashDemo {
    byte[] digest(String algorithm) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {

        }
        return null;
    }
}
