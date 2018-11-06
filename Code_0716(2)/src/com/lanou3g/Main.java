package com.lanou3g;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computable c = new AddComputer();
        Computable c1 = new SubtractComputable();
        Computable c2 = new MultiplicationComputable();
        Computable c3 = new DivisionComputable();
//        int result = c.compute(3, 5);
//        int result1 = c1.compute(3, 5);
//        int result2 = c2.compute(3, 5);
//        int result3 = c3.compute(5, 5);
//        System.out.println(result);
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);
//
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int x = scanner.nextInt();
        System.out.println("请输入第二个整数");
        int y = scanner.nextInt();
        System.out.println("请输入运算符");
        String s = scanner.next();

        int result4 = 0;
        Computable computable = null;
        switch (s) {
            case "+":
                computable = new AddComputer();
                break;
            case "-":
                computable = new  SubtractComputable();
                break;
            case "*":
                computable = new MultiplicationComputable();
                break;
            case "/":
                computable = new DivisionComputable();
                break;
            case "^":
                computable = new PowerComputable();
        }
        if (computable!=null){
            result4 = computable.compute(x,y);
        }
        System.out.println(result4);
    }
}
