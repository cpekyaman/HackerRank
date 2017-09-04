package com.hackerrank.javacl.advanced;

/**
 * Created by raistlin on 9/4/2017.
 */
public class InnerClass {
    public static void main(String[] args) {
        Object o;
        System.out.printf("%d is %s\n", 8, ((Inner.Private)(o = new Inner().new Private())).powerof2(8));
        System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
    }
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }
}
