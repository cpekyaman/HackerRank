package com.hackerrank.javacl.intro;

import java.util.Scanner;

/**
 * Created by raistlin on 8/4/2017.
 */
public class StaticInitChallenge {
    private static final int B;
    private static final int H;
    private static final boolean flag;

    static {
        Scanner in = new Scanner(System.in);
        B = in.nextInt();
        H = in.nextInt();

        if(B <= 0 || H <= 0) {
            flag = false;
            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            flag = true;
        }
    }
}
