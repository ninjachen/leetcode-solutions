package rocks.ninjachen.ninja_warm_up;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NinjaProxy implements InvocationHandler {
    private Object obj;

    public static void main (String[] args) {
        Foo foo = new FooImpl();
        Foo o2 = (Foo) NinjaProxy.newInstance(foo);
        o2.foobar();
        System.out.println("2nd ...");
        Foo o = (Foo) Proxy.newProxyInstance(foo.getClass().getClassLoader(), foo.getClass().getInterfaces(), new NinjaProxy(foo));
        o.foobar();
    }

    public static Object newInstance (Object object) {
        return java.lang.reflect.Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new NinjaProxy(object));
    }

    private NinjaProxy(Object able) {
        this.obj = able;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoke .... in handler");
        Object result;
        try {
            result = method.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
//            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("After invoke");
        }
        return result;
    }

}
