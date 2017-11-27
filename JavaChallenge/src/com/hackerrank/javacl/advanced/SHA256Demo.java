package com.hackerrank.javacl.advanced;

/**
 * Created by raistlin on 9/10/2017.
 */
public class SHA256Demo extends SecureHashDemo {
    void run() {
        byte[] digest = super.digest("SHA-256");
        System.out.println(String.format("%064x", new java.math.BigInteger(1, digest)));
    }

    public static void main(String[] args) {
        new SHA256Demo().run();
    }
}
