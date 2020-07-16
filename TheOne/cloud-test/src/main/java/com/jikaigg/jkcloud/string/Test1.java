package com.jikaigg.jkcloud.string;

public class Test1 {

    public static void main(String[] args) {
        String i = "1";
        int j = 6;
        Object o = i+=j;
        System.out.println(o);
        System.out.println(o.getClass().toString());
    }
}
