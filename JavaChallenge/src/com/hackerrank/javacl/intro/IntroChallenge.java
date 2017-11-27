package com.hackerrank.javacl.intro;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by raistlin on 8/4/2017.
 */
public class IntroChallenge {

    static void calendarDay() {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }

    static void currencyFormat() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }

    private static String getDay(String day, String month, String year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), 0, 0);
        return new SimpleDateFormat("EEEEE").format(cal.getTime()).toUpperCase();
    }

    static void loopChallenge() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int lastVal = a;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                lastVal += (int) Math.pow(2, j) * b;
                sb.append(lastVal).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        in.close();
    }

    static void dataTypeChallenge() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                List<String> types = new ArrayList<>();
                if (x >= -128 && x <= 127) {
                    types.add("byte");
                }
                if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    types.add("short");
                }
                if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    types.add("int");
                }
                types.add("long");
                for (String tp : types) {
                    System.out.println("* " + tp);
                }
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }

    static void inputChallenge() {
        Scanner sc = new Scanner(System.in);

        String line;
        List<String> lines = new ArrayList<>();
        while(sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
            lines.add(line);
        }
        for(int i = 0; i < lines.size(); ++i) {
            System.out.printf("%d %s\n", (i + 1), lines.get(i));
        }
    }

    public static void main(String[] args) {
        currencyFormat();
    }
}
