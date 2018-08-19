package chapter02;

import java.lang.reflect.Method;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description
 * @date 2018/8/17
 */
public class MyInterceptor implements Interceptor{
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法before()");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法around()");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法after()");
    }
}
