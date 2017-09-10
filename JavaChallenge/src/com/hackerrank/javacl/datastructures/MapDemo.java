package com.hackerrank.javacl.datastructures;

import java.util.*;

/**
 * Created by raistlin on 9/10/2017.
 */
class MapDemo {
    void run() {
        Scanner in = new Scanner(System.in);
        int mapSize = in.nextInt();
        in.nextLine();

        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < mapSize; ++i) {
            String name = in.nextLine();
            int phone = in.nextInt();

            phoneBook.put(name, phone);
            in.nextLine();
        }

        final List<String> queries = new ArrayList<>();
        String line;
        while (in.hasNextLine() && !(line = in.nextLine()).isEmpty()) {
            queries.add(line);
        }
        in.close();

        StringBuilder sb = new StringBuilder();
        queries.forEach(q -> {
            if (phoneBook.containsKey(q)) {
                sb.append(q).append("=").append(phoneBook.get(q)).append("\n");
            } else {
                sb.append("Not found\n");
            }
        });
        System.out.println(sb);
    }
}