package com.lanou3g;

public class text {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + " ");
            }
            System.out.println();
        }

        int[] arr = {3, 6, 7, 4, 3, 7, 32, 8,};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i + 1] < arr[i]) {
                    int c = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = c;
                }
            }

        }
    }
}
