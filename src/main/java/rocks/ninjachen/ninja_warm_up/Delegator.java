package rocks.ninjachen.ninja_warm_up;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Delegator implements InvocationHandler {
    private static Method hashCodeMethod;
    private static Method equalsMethod;
    private static Method toStringMethod;

    static {
        try {
            hashCodeMethod = Object.class.getMethod("hashCode", null);
            equalsMethod = Object.class.getMethod("equals", new Class[]{Object.class});
            toStringMethod = Object.class.getMethod("toString", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private Class[] interfaces;
    private Object[] delegates;

    public Delegator(Class[] interfaces, Object[] delegates) {
        this.interfaces = interfaces;
        this.delegates = delegates;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass == Object.class) {
            if (method.equals(hashCodeMethod)) {
                return proxyHashCode(proxy);
            } else if (method.equals(equalsMethod)) {
                return proxyEquals(proxy, args[0]);
            } else if (method.equals(toStringMethod)) {
                return proxyToString(proxy);
            } else {
                throw new InternalError("");
            }
        } else {
            for (int i = 0; i < interfaces.length; i++) {
                if (declaringClass.isAssignableFrom(interfaces[i])) {
                    try {
//                        return method.invoke(proxy, args);
                        return method.invoke(delegates[i], args);
                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                }
            }
            return invokeNotDelegated(proxy, method, args);
        }
    }

    protected Object invokeNotDelegated(Object proxy, Method m,
                                        Object[] args)
            throws Throwable
    {
        throw new InternalError("unexpected method dispatched: " + m);
    }

    protected Integer proxyHashCode(Object proxy) {
        return new Integer(System.identityHashCode(proxy));
    }

    protected Boolean proxyEquals(Object proxy, Object other) {
        return (proxy == other ? Boolean.TRUE : Boolean.FALSE);
    }

    protected String proxyToString(Object proxy) {
        return proxy.getClass().getName() + '@' +
                Integer.toHexString(proxy.hashCode());
    }

    public static void main (String[] args) {
        Class[] proxyInterfaces = new Class[] {Foo.class};
        FooImpl foo1 = new FooImpl();

        Foo foo = (Foo) Proxy.newProxyInstance(
                Foo.class.getClassLoader(),
                proxyInterfaces,
                new Delegator(proxyInterfaces, new Object[] {foo1}));
        int i = foo.hashCode();
        System.out.println("Start to foo equal");
        foo.equals(foo);
        System.out.println("Start to foo equal1");
        foo.equals(foo1);
        int i1 = foo.foobar();
    }
}
