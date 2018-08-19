package chapter02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description JDK代理
 * @date 2018/8/17
 */
public class JDKProxyExample implements InvocationHandler {

    private Object target=null;

    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        System.out.println("正在使用代理！");
        Object object=method.invoke(target,args);
        System.out.println("代理结束！");
        return object;
    }
}
