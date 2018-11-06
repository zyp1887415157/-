package com.lanou3g.登录注册;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Util {
    public boolean login(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        boolean usernameRighr = username.equals(user.getUsername());
        System.out.println("请输入密码");
        String pwd = scanner.nextLine();
        boolean pwdRight = pwd.equals(user.getPassword());
        return usernameRighr &&pwdRight;
    }
    public User register(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入用户名");
            String username = scanner.nextLine();
            boolean isStartWithNum = false;
            for (int i = 0; i < 100; i++) {
                String num = String.valueOf(i);
                if (username.contains(num)){
                    isStartWithNum = true;
                }
                if (!isStartWithNum){
                    user.setUsername(username);
                    break;
                }
            }
            String pwd = null;
            while (true){
                System.out.println("请输入密码");
                Scanner scanner1 = new Scanner(System.in);
                 pwd = scanner1.nextLine();
                 boolean hasNum = false;
                for (int i = 0; i < 10; i++) {
                    String num = String.valueOf(i);
                    if (pwd.contains(num)){
                        hasNum = true;
                    }
                }
                if (!hasNum){
                    System.out.println("密码必须要包含数字");
                    continue;
                }
                if (pwd.length()<8){
                    System.out.println("密码必须超过8位");
                    continue;
                }
                break;
            }
            while (true){
                System.out.println("请再次输入密码");
                String rePwd = scanner.nextLine();
                if (pwd.equals(rePwd)){
                    user.setPassword(pwd);
                    break;
                }else {
                    System.out.println("密码和确认密码不同");
                }
            }
            return user;
        }
    }
}
