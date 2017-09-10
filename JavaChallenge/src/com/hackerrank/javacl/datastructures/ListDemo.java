package com.hackerrank.javacl.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by raistlin on 9/10/2017.
 */
class ListDemo {
    void run() {
        Scanner in = new Scanner(System.in);
        final int listSize = in.nextInt();

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < listSize; ++i) {
            list.add(in.nextLong());
        }

        final int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            String op = in.next();
            if ("Insert".equals(op)) {
                int pos = in.nextInt();
                long element = in.nextLong();
                list.add(pos, element);
            } else if ("Delete".equals(op)) {
                int pos = in.nextInt();
                list.remove(pos);
            }
        }
        in.close();

        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}