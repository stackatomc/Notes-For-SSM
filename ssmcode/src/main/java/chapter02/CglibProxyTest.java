package chapter02;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description
 * @date 2018/8/17
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        CglibProxyExample proxyExample=new CglibProxyExample();
        ReflectServiceImpl serviceImpl=(ReflectServiceImpl)proxyExample.getProxy(ReflectServiceImpl.class);
        serviceImpl.sayservice();

    }
}
