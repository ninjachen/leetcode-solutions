package rocks.ninjachen.ninja_warm_up;

public class FooImpl implements Foo {

    @Override
    public int foobar() {
        System.out.println("Foobar in impl.");
        return 0;
    }
}
