package com.hackerrank.javacl.advanced;

/**
 * Created by raistlin on 9/4/2017.
 */
public class Varargs {
    public static void main(String[] args) {
        new Add().add(1, 2, 3);
    }
}

class Add {
    void add(int... args) {
        StringBuilder output = new StringBuilder();
        int total = 0;
        for(int arg : args) {
            total += arg;
            output.append(arg).append("+");
        }
        output.deleteCharAt(output.length() - 1).append("=").append(total);
        System.out.println(output);
    }
}
