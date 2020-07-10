package com.jikaigg.jkcloud.string;

public class Test1 {

    public static void main(String[] args) {
        String str1 = new String("yaojikai");
        String str2 = new String("yaojikai");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        new Object();


    }
}

