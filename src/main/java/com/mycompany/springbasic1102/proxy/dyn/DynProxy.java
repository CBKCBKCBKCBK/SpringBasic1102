package com.mycompany.springbasic1102.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynProxy {

    private Object object;

    public DynProxy(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        //  獲取當前類別的類加載器 用來加載代理物件所屬的類別
        ClassLoader loader = object.getClass().getClassLoader();
        //  獲取當前物件所實作的介面
        Class[] interfaces = object.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            //public Object invoke(被代理的物件,調用方法,調用方法的參數)
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.printf("Log A...呼叫的方法: %s,放置的參數: %s\n",method.getName(),Arrays.toString(args));
                MyLogger.before(object.getClass(), method.getName(), args);
                Object result = method.invoke(object, args);  //代理調用目標物件的方法
//                System.out.println("Log B...");
                MyLogger.end(object.getClass(), method.getName(),result);
                return result;
            }
        };
        return Proxy.newProxyInstance(loader, interfaces, h);
    }
}
