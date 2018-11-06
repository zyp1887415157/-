package com.lanou3g.demo;

/**
 * @author liushuqing
 * Created by  18/7/9 上午10:49
 * 计算器类
 */
public class Calculatar {
    //如果调用某个方法之后,需要有一个执行的结果,
    //那么该结果就叫做返回值
    //在方法的返回值类型位置明确指出该类型
    //如果某个方法有返回值类型,那么必须使用return关键字,将结果返回

    /**
     * 两个数的和
     *
     * @param x
     * @param y
     */
    public int add(int x, int y) {
        return x + y;
    }

    public int abs(int n) {
//        if (n > 0) {
//            return n;
//        } else {
//            return -n;
//        }
        return n > 0 ? n : -n;
    }

    //计算两个数的绝对值的和
    public int ageAdd(int x, int y) {
//        abs   绝对值
//        int x1 = abs(x);
//        int y1 = abs(y);
//        return add(x, y);
//        this   可以省略
        return add(abs(x), this.abs(y));
    }

    /*
    如果某个方法的返回值类型为void,
    那么在方法体中可以写return,但是后面不能有值
    在某个方法中如果遇到了return,那么会直接结束该方法
    如果该return不是必要的,可以省略
     */
    //注:1.方法不能嵌套
    //   2.在方法之外,不能写逻辑代码(逻辑代码只能写在方法内)
    //   3.传递参数时,不能带类型
    public void a(int n) {
        if (n % 2 == 0) {
            return;//该return的意思是:结束当前方法,后面的都不会执行,写了会报错
            //return后不可写代码
        }
        System.out.println(n);

    }
}
