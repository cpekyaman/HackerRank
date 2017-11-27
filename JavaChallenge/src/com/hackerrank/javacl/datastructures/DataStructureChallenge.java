package com.hackerrank.javacl.datastructures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raistlin on 8/7/2017.
 */
public class DataStructureChallenge {

    private static void leapGame() {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();

        s.nextLine();
        for (int i = 0; i < q; ++i) {
            String[] leapAndN = s.nextLine().split(" ");
            List<Integer> numbers = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            //System.out.println(new LeapGame(Integer.parseInt(leapAndN[1]), numbers.toArray()).play());
        }
    }

    public static void main(String[] args) {
        new DequeDemo().run();
    }
}
