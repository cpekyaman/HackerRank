package com.hackerrank.javacl.strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by raistlin on 8/6/2017.
 */
public class StringChallenge {
    // ^(((0|1|2)?[0-9]{1,2})\.){3}((0|1|2)?[0-9]{1,2})$
    private static final class MyRegex {
        private final String ipElement = "((0|1)?\\d{1,2}|25[0-5]|2[0-4]\\d)";
        private final String pattern = "^(" + ipElement + "\\.){3}" + ipElement + "$";
    }

    private static void intro() {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.printf("%s %s", capitalize(A),  capitalize(B));
    }

    private static void substring() {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(S.substring(start, end));
    }

    private static void lexStrings() {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        List<String> substrings = new ArrayList<>();
        for(int i = 0; i <= s.length() - k; i++) {
            substrings.add(s.substring(i, i + k));
        }
        Collections.sort(substrings);
        System.out.printf("%s\n%s", substrings.get(0), substrings.get(substrings.size() -1));
    }

    private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static void palindromeTest() {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.println(isPalindrome(A) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String str) {
        if(str == null) {
            return false;
        }

        if(str.length() <= 1) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() -1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    private static void anagramTest() {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();

        System.out.println( isAnagram(a, b) ? "Anagrams" : "Not Anagrams" );
    }

    private static Map<Character, Integer> letterFreqs(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(Character c : str.toCharArray()) {
            int freq = 0;
            if(freqMap.containsKey(c)) {
                freq = freqMap.get(c);
            }
            freqMap.put(c, ++freq);
        }
        return freqMap;
    }

    private static long charFrequency(String str, char c) {
        return str.codePoints().filter(it -> it == c).count();
    }

    private static boolean isAnagram(String a, String b) {
        if(a == null || b == null || a.length() != b.length()) {
            return false;
        }

        final String aLower = a.toLowerCase();
        final String bLower = b.toLowerCase();
        if(aLower.equals(bLower)) {
            return true;
        }

        final Set<Character> searchedChars = new HashSet<>();
        for(char c : aLower.toCharArray()) {
            if(! searchedChars.contains(c)) {
                if(charFrequency(aLower, c) == charFrequency(bLower, c)) {
                    searchedChars.add(c);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private static void tokenSplit() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        scan.close();

        if(s.isEmpty()) {
            System.out.println(0);
        } else {
            String[] tokens = s.split("[\\W0-9_]+");
            System.out.println(tokens.length);
            for(String token : tokens) {
                System.out.println(token);
            }
        }
    }

    private static void patternSyntaxCheck() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        for(int i = 0; i < testCases; ++i) {
            try {
                Pattern.compile(in.nextLine());
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
    }

    private static void iptest() {
        Scanner in = new Scanner(System.in);
        String IP;
        while(in.hasNext() && !(IP = in.next()).isEmpty()){
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    private static void replaceDupWords() {
        String regex = "(?<word>\\b\\w+\\b)(\\W\\b\\k<word>\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group("word"));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }

    private static void usernameChecker() {
        //String pattern = "((0|1)?\\d{1,2}|25[0-5]|2[0-4]\\d)";
        String pattern = "([a-zA-Z])(\\w){7,29}";
    }

    public static void main(String[] args) {
        // intro();
        // lexStrings();
        // palindromeTest();
        // anagramTest();
        // tokenSplit();
        // patternSyntaxCheck();
        // iptest();
        replaceDupWords();
    }
}
