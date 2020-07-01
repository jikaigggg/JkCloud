package com.jikaigg.jkcloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        /**
         *  [7864, 284, 347, 7732, 8498]
         */

        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(7864, 284, 347, 7732, 8498));
        System.out.println(list1);

        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if((int)o1<(int)o2)
                    return 1;
                    //注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
                    //		else return 0; //无效
                else return -1;
            }
        });
        System.out.println(list1);

        String str = "";

        for (Integer integer : list1) {
            str+=integer;
        }
        System.out.println(str);
    }

}
