package com.hackerrank.javacl.datastructures;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
class StackDemo {
    void run() {
        Scanner sc = new Scanner(System.in);

        Map<Character, Character> parens = new HashMap<>();
        parens.put(')', '(');
        parens.put(']', '[');
        parens.put('}', '{');

        while (sc.hasNext()) {
            String input = sc.next();
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                if (parens.values().contains(c)) {
                    stack.push(c);
                } else if (!stack.isEmpty() && stack.peek() == parens.get(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            System.out.println(stack.isEmpty());
        }
    }
}
