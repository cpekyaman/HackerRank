package com.hackerrank.javacl.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by raistlin on 9/10/2017.
 */
class LeapGame {
    final int leap;
    final int[] array;

    LeapGame(int leap, int[] array) {
        this.leap = leap;
        this.array = array;
    }

    private boolean doPlay(int pos, Set<Integer> visited) {
        if (visited.contains(pos) || pos < 0 || array[pos] != 0) {
            return false;
        }

        if (pos == array.length - 1 || pos + leap >= array.length) {
            return true;
        }

        visited.add(pos);
        return doPlay(pos + 1, visited)
                || doPlay(pos - 1, visited)
                || doPlay(pos + leap, visited);
    }

    boolean play() {
        return doPlay(0, new HashSet<>());
    }
}
