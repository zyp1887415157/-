package com.lanou3g.homework;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        User user = new User();
//        user.dl();


        Goods g1 = new Goods(2, "商品1", 10);
        Goods g2 = new Goods(4, "商品2", 20);
        Goods g3 = new Goods(1, "商品3", 30);
        Goods g4 = new Goods(8, "商品4", 40);

        ShoppingCart cart = new ShoppingCart();
        cart.add(g1);
        cart.add(g2);
        cart.add(g3);
        cart.add(g4);

        CashierDesk desk = new CashierDesk(cart);
        desk.setDiscountable(new EightDiscount());
        System.out.println(desk.checkout());

//        consumer1.buy();
//        consumer1.empty();

//        CollectMoney collectMoney = new CollectMoney(consumer1);
//        collectMoney.setDiscountable(new Discount1());
//        System.out.println(collectMoney.checkout());
//        collectMoney.add();

        List coll = new ArrayList();

        coll.add(1);
        coll.add(g1);


        System.out.println(coll.size());

        System.out.println(coll.get(0));

        //用的最多的情况  集合中放的都是同一种数据类型的对象
        //使用泛型
        //规定集合中能存放的数据类型   Goods
        List<Goods> goods = new LinkedList<>();
//        goods.add(1);  只能放  Goods对象
        goods.add(g1);
        goods.add(g2);
        goods.add(g3);
        //数据还在集合里面   根据下标获取数据
        Goods goods4 = goods.get(1);
        goods.remove(g2);//把某个元素从集合中移除
        goods.remove(1);//根据下标移除元素
        System.out.println(goods.size());//获取集合中元素的个数

        /*
        ArrayList  内部是数组实现的,查找效率高,因为内存是连续的
        当删除或插入某个元素的时候,其他大部分元素都会发生移动,所以效率比较低.
        LinkedList  内部是使用联表实现 查找某个元素时只能从头开始,效率低,
        但是插入或删除某个元素时不用移动位置,效率较高
         */

        //判断集合中有没有这个对象
        boolean b = goods.contains(g1);
        //清空集合
//        goods.clear();
        //判断某个元素在集合中的下标
        int i = goods.indexOf(g1);//  -1
        //判断集合是不是空的
        boolean empty = goods.isEmpty();
        Goods[] array = goods.toArray(new Goods[goods.size()]);//转换为数组

        goods.removeAll(goods);

//        List<Goods> subList = goods.subList(0, 3);
////        subList.remove(1);
////        System.out.println(goods.size());

        //集合的遍历  for循环
        for (int i1 = 0; i1 < goods.size(); i1++) {
            Goods g = goods.get(i1);


//            //移除商品价格为10的
//            if (g.getPrice()==10F){
//                goods.remove(g);
//                i1--;
//            }
        }
        //2.增强for循环
        //在循环中不能更改集合的长度
        //前提:集合中的元素一定是可比较大小的
        //实现了Comparable接口的类可以自定义比较规则
        Collections.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getId() != o2.getId()) {
                    return o1.getId() - o2.getId();
                }
                return o1.getPrice() - o2.getPrice() > 0 ? 1 : -1;
            }
        });
        for (Goods good : goods) {
            if (good.getPrice() >= 30 && good.getPrice() <= 50) {
                System.out.println(good.getName());
            }
        }


//        //直接集合的sort方法也行,效果相同
//        goods.sort(new Comparator<Goods>() {
//            @Override
//            public int compare(Goods o1, Goods o2) {
//                return 0;
//            }
//        });



        //3.使用迭代器   判断是否有下一个元素,有就取,
        Iterator<Goods> iterator = goods.iterator();
        while (iterator.hasNext()) {
            Goods g = iterator.next();

        }
        //4.java8  之后
        //在匿名内不类中引用成员变量 属性必须要加final
        goods.forEach(new java.util.function.Consumer<Goods>() {
            @Override
            public void accept(Goods goods) {

            }
        });

        //4.java8   lambda  表达式
        goods.forEach(g -> {
        });

        //java8  中的集合处理
        //函数式编程
        List<String> names = goods.stream()
                //过滤
                .filter(goods1 -> goods1.getPrice() >= 20 && goods1.getPrice() <= 50)
                //排序
                .sorted((o1, o2) -> o1.getId() - o2.getId())
                //类型转换
                .map(Goods::getName)
                //转成集合(有返回值)
                .collect(Collectors.toList());
        System.out.println(names);
//                .forEach(goods1 -> System.out.println(goods1));


        List<Integer> integers = new ArrayList<>();
        Integer i1 = new Integer(2);
        integers.add(i1);
        integers.add(4);
        integers.add(6);
        integers.add(8);
        integers.remove(i1);
        System.out.println(integers);


    }
}
