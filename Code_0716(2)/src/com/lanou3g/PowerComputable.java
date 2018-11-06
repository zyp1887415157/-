package com.lanou3g;

public class PowerComputable implements Computable {
    @Override
    public int compute(int x, int y) {
        if (y==0){
            return 1;
        }else if (y==1){
            return x;
        }
        int a = x;
        for (int i =2;i<=y;i++){
            x = x * a;
        }
        return x;

    }
}

