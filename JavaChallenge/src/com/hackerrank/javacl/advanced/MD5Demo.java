package com.hackerrank.javacl.advanced;

import java.math.BigInteger;

/**
 * Created by raistlin on 9/10/2017.
 */
class MD5Demo extends SecureHashDemo {
    void run () {
        byte[] digest = super.digest("MD5");
        System.out.println(new BigInteger(1,digest).toString(16));
    }

    public static void main(String[] args) {
        new MD5Demo().run();
    }
}
