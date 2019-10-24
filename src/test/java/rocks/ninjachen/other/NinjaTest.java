package rocks.ninjachen.other;

import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

public class NinjaTest {

    /**
     * 输出一个int的二进制数
     *
     * @param num
     */
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    @Test
    public void test() {
        new HashMap<>(1023).put(1, 1);
        int number = -10;
        //原始数二进制
        printInfo(number);
        //左移一位
        printInfo(number << 1);
        //右移一位
        printInfo(number >> 1);
        //右移一位
        printInfo(number >>> 1);
    }
}
