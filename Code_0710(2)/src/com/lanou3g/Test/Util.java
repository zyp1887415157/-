package com.lanou3g.Test;

import java.util.Scanner;

public class Util {
    public boolean login(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        boolean usernameRight = username.equals(user.getUsername());

        System.out.println("请输入密码");
        String pwd = scanner.nextLine();
        boolean pwdRight = pwd.equals(user.getPwd());
        return usernameRight && pwdRight;
    }

    public User register() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名");
            String username = scanner.nextLine();
            boolean isStartWithNum = false;
            for (int i = 0; i < 100; i++) {
                String num = String.valueOf(i);
                if (username.startsWith(num)) {
                    isStartWithNum = true;
                }
                if (!isStartWithNum) {
                    user.setUsername(username);
                    break;
                }
            }
            String pwd = null;
            while (true) {
                System.out.println("请输入密码");
                pwd = scanner.nextLine();

                boolean hasNum = false;
                for (int i = 0; i < 10; i++) {
                    String num = String.valueOf(i);
                    if (pwd.contains(num)) {
                        hasNum = true;
                    }
                }
                if (!hasNum) {
                    System.out.println("密码必须包含数字");
                    continue;
                }
                if (pwd.length()<8){
                    System.out.println("密码不够8位");
                    continue;
                }
                boolean hasLowercase = false;
                for (char c = 'a'; c <= 'z'; c++) {
                    String letter = String.valueOf(c);
                    if (pwd.contains(letter)) {
                        hasLowercase = true;
                    }
                    if (!hasLowercase) {
                        System.out.println("密码要包含小写字母");
                        continue;
                    }
                    break;
                }
                while (true) {
                    System.out.println("请在次输入密码");
                    String rePwd = scanner.nextLine();
                    if (pwd.equals(rePwd)) {
                        user.setPwd(pwd);
                        break;
                    } else {
                        System.out.println("密码和确认密码不同");
                    }
                }
                return user;
            }
        }
    }
}
