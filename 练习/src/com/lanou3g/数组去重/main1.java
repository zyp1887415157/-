package com.lanou3g.数组去重;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {

        //第一种方法   先放到一个集合中并判断是包含 判断后放到新数组中
//        int [] arr = {1,2,3,4,5,6,2,5,4,3,1,3,4,6,7,8};
////       List<Integer> list = new ArrayList<>();
////        for (int i = 0; i < arr.length; i++) {
////            if (!list.contains(arr[i])){
////                list.add(arr[i]);
////            }
////        }
////        // 集合变数组
////        Integer[] newArr = list.toArray(new Integer[1]);
////        for (Integer integer : newArr) {
////            System.out.println(integer);
////        }

        //判断数组中是否有相同的,如果有将重复的设为0,判断如果不为0 放到新数组中
        int[] a=new int[10];
        int[] b = new int[a.length];
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ten numbers:");
        for(int i=0;i<a.length;i++){
            a[i]=input.nextInt();
        }
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length-1;j++){
                if(a[i]==a[j+1]){
                    a[j+1]=0;
                }
            }
        }
        //java.util.Arrays.sort(a);
        System.out.print("The distinct numbers are:");
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
               b[i] = a[i];
            }
        }
        System.out.println(Arrays.toString(b));


    }
}
