package chapter02;

import java.lang.reflect.Method;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description
 * @date 2018/8/17
 */
public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object[] args);
    public void around(Object proxy, Object target, Method method, Object[] args);
    public void after(Object proxy, Object target, Method method, Object[] args);
}
