package com.hackerrank.javacl.datastructures;

import java.util.*;

/**
 * Created by raistlin on 9/10/2017.
 */
class DequeDemo {

    void run() {
        final Scanner in = new Scanner(System.in);
        final Deque<Integer> deque = new ArrayDeque<>();
        final Map<Integer, Integer> occurences = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int maxUniques = 0;
        for (int i = 0; i < n; i++) {
            final int num = in.nextInt();

            deque.offer(num);
            occurences.merge(num, 1, Math::addExact);

            if(deque.size() == m) {
                int currentUniques = occurences.size();
                if(currentUniques > maxUniques) {
                    maxUniques = currentUniques;
                }
                Integer head = deque.remove();
                occurences.merge(head, 1, Math::subtractExact);
                if(occurences.get(head) == 0) {
                    occurences.remove(head);
                }
            }

            if(maxUniques == m) {
                break;
            }
        }

        System.out.println(maxUniques);
    }
}
