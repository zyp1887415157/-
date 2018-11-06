package com.lanou3g.demo;

public class test {
    public static void main(String[] args) {
        String a = "alsdjfl;djsfl;ds";
        char b = 's';
        //  转成数组方式
        char[] chars = a.toCharArray();
        for (int i =0;i<chars.length;i++){
            if (b==chars[i]){
                System.out.println(i);
            }
        }
//        不用转成数组方式
        for (int i =0;i<a.length();i++){
            if (b==a.charAt(i)){
                System.out.println(i);
            }
        }



        int idx = -1;
        do {
            idx = a.indexOf(b,idx + 1);
           if (idx!=-1){
               System.out.println(idx);
           }else {
               break;
           }
        }while (true);

    }
}
