package com.lanou3g.Test;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        Menu menu = new Menu();
        Util util = new Util();
        while (true) {
            menu.showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    user = util.register();
                    break;
                case 2:
                    boolean loginSuccess = util.login(user);
                    if (loginSuccess) {
                        System.out.println("登陆成功");
                        return;
                    } else {
                        System.out.println("用户名或密码错误");
                    }
                    break;
                    default:
                        System.out.println("只能输入1/2");
            }
        }
    }
}
