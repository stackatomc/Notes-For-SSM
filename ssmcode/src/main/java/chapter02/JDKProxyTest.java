package chapter02;


/**
 * @author MayerFang
 * @file ${FILE}
 * @Description
 * @date 2018/8/17
 */
public class JDKProxyTest {

    public static void main(String[] args) {

        JDKProxyExample proxyExample=new JDKProxyExample();
        HelloWorld proxy=(HelloWorld)proxyExample.bind(new HelloWorldImpl());
        proxy.sayHello();
    }
}
