package chapter02;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description Cglib代理
 * @date 2018/8/17
 */
public class CglibProxyExample implements MethodInterceptor {

    public Object getProxy(Class cls){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method,Object[] args,
                            MethodProxy methodProxy)throws Throwable{
        System.err.println("调用cglib代理");
        Object result=methodProxy.invokeSuper(proxy,args);
        System.err.println("调用结束");
        return result;
    }

}
