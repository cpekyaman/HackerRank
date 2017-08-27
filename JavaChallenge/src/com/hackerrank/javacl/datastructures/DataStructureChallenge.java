package com.hackerrank.javacl.datastructures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raistlin on 8/7/2017.
 */
public class DataStructureChallenge {
    private static int hourglassSum(int arr[][], int row, int column) {
        int sum = 0;

        sum += arr[row][column] + arr[row][column + 1] + arr[row][column + 2];
        sum += arr[row + 1][column + 1];
        sum += arr[row + 2][column] + arr[row + 2][column + 1] + arr[row + 2][column + 2];

        return sum;
    }

    private static void twoDimArrayHourGlass() {
        findMaxHourglassSum(fillHourGlassArray());
    }

    private static void findMaxHourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row <= 3; ++row) {
            for (int column = 0; column <= 3; column++) {
                int currentSum = hourglassSum(arr, row, column);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    private static int[][] fillHourGlassArray() {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        return arr;
    }

    private static int subArraysForSize(int[] arr, int size) {
        int count = 0;

        for (int i = 0; i <= arr.length - size; ++i) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += arr[i + j];
            }
            if (sum < 0) {
                count++;
            }
        }

        return count;
    }

    private static void negativeSubArrays() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        int negativeCount = 0;
        for (int sz = 1; sz < arr.length; sz++) {
            negativeCount += subArraysForSize(arr, sz);
        }

        if (Arrays.stream(arr).sum() < 0) {
            negativeCount++;
        }

        System.out.println(negativeCount);
    }

    private static void listOfArrays() {
        Scanner in = new Scanner(System.in);
        int arrayCount = in.nextInt();
        List<int[]> rows = new ArrayList<>(arrayCount);

        for (int i = 0; i < arrayCount; i++) {
            int arrSize = in.nextInt();
            int[] arr = new int[arrSize];
            rows.add(arr);
            if (arrSize > 0) {
                for (int j = 0; j < arrSize; ++j) {
                    arr[j] = in.nextInt();
                }
            }
        }

        int queryCount = in.nextInt();
        for (int q = 0; q < queryCount; ++q) {
            int row = in.nextInt();
            int col = in.nextInt();
            if (rows.size() < row || rows.get(row - 1).length < col) {
                System.out.println("ERROR!");
            } else {
                System.out.println(rows.get(row - 1)[col - 1]);
            }
        }
    }

    private static void listPlay() {
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

    private static void mapPlay() {
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

    private static void setPlay() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> uniquePairs = new HashSet<>();
        for (int i = 0; i < t; ++i) {
            uniquePairs.add(Integer.toHexString(pair_left[i].hashCode()).concat("-").concat(Integer.toHexString(pair_right[i].hashCode())));
            System.out.println(uniquePairs.size());
        }
    }

    private static void leapGame() {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();

        s.nextLine();
        for(int i = 0; i < q; ++i) {
            String[] leapAndN = s.nextLine().split(" ");
            List<Integer> numbers = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            //System.out.println(new LeapGame(Integer.parseInt(leapAndN[1]), numbers.toArray()).play());
        }
    }

    private static void stackPlay() {
        Scanner sc = new Scanner(System.in);

        Map<Character, Character> parens = new HashMap<>();
        parens.put(')', '(');
        parens.put(']', '[');
        parens.put('}', '{');

        while (sc.hasNext()) {
            String input = sc.next();
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(char c : input.toCharArray()) {
                if(parens.values().contains(c)) {
                    stack.push(c);
                } else if(! stack.isEmpty() && stack.peek() == parens.get(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            System.out.println(stack.isEmpty());
        }
    }

    private static void bitsetPlay() {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int opers = in.nextInt();

        in.nextLine();
        for(int i = 0; i < opers; ++i) {
            String[] input = in.nextLine().split(" ");

            String op = input[0];

        }
    }

    public static void main(String[] args) {
        // twoDimArrayHourGlass();
        // negativeSubArrays();
        // listOfArrays();
        // listPlay();
        // mapPlay();
        // setPlay();
        // leapGame();
        stackPlay();
    }
}

class LeapGame {
    final int leap;
    final int[] array;

    LeapGame(int leap, int[] array) {
        this.leap = leap;
        this.array = array;
    }

    private boolean doPlay(int pos, Set<Integer> visited) {
        if(visited.contains(pos) || pos < 0 || array[pos] != 0) {
            return false;
        }

        if(pos == array.length - 1 || pos + leap >= array.length) {
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

class Printer {
    <T> void printArray(T[] arr) {
        for (T e : arr) {
            System.out.println(e);
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o1.score > o2.score ? -1 : 1;
        }
    }
}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int result = Double.compare(o2.getCgpa(), o1.getCgpa());
        if (result == 0) {
            result = o1.getFname().compareTo(o2.getFname());
            if (result == 0) {
                result = Integer.valueOf(o1.getId()).compareTo(o2.getId());
            }
        }
        return result;
    }
}
