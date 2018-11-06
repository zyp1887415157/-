package com.lanou.demo;

import com.lanou.demo.proxy.TimerProxy;
import com.lanou.demo.service.OrderService;
import com.lanou.demo.service.OrderServiceLog;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class OrderServiceProxyTest {
    @Test
    public void findALl(){
        OrderService orderService = new OrderService();
        //使用CGLib进行动态代理
        Class<? extends OrderService> clazz = orderService.getClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(enhancer.getClassLoader());
        //使用Enhancer目的是创建出来一个目标类的一个子类,所以superclass就得填目标类;
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new TimerProxy(orderService));
        orderService = (OrderService) enhancer.create();
        orderService.findAll();
    }
}
