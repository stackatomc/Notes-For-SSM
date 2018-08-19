package chapter02;

/**
 * @author MayerFang
 * @file ${FILE}
 * @Description
 * @date 2018/8/17
 */
public class TestInterceptor {
    public static void main(String[] args) {
        HelloWorld proxy=(HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),"chapter02.MyInterceptor");
        proxy.sayHello();

    }
}
