package rocks.ninjachen.other;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void test2() {
        System.out.println(new Solution().reverse(1534236469));
    }
    class Solution {
        public int reverse(int x) {
            boolean isPositive = ( x > 0);
            x = Math.abs(x);
            int i = 0;
            for(;;i++) {
                if (Math.pow(10, i) > x) {
                    break;
                }
            }
            if (i == 0) {
                return 0;
            }
            int[] array = new int[i];
            i--;
            for(;i >= 0;i--){
                array[i] = x / (int)Math.pow(10, i);
                x = x % (int)Math.pow(10, i);
            }
            // reserve array
            resrve(array);
            // check overflow
            if(isOverflow(array)) {
                return 0;
            }
            int result = 0;
            for(i = 0; i < array.length; i++) {
                result += array[i] * Math.pow(10, i);
            }
            return isPositive ? result : -result;
        }

        private void resrve(int[] array) {
            for(int a = 0, b = array.length - 1; a < b; a++, b-- ) {
                int temp = array[a];
                array[a] = array[b];
                array[b] = temp;
            }
        }

        private boolean isOverflow(int[] array) {
            int[] arrayMax = new int[]{2,1,4,7,4,8,3,6,4,7};
            resrve(arrayMax);
            if(array.length == arrayMax.length) {
                for (int i = array.length - 1; i >= 0; i--) {
                    if (array[i] > arrayMax[i]) {
                        return true;
                    } else if (array[i] < arrayMax[i]) {
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
    }

    @Test
    public void testCAS() {
        AtomicInteger integer = new AtomicInteger(1);
        int start = (int) (System.currentTimeMillis() / 1000);
        AtomicStampedReference<Integer> i = new AtomicStampedReference<>(1, start);
        int now = (int) (System.currentTimeMillis() / 1000);
        assertEquals(true, integer.compareAndSet(1, 2));
        // Fix ABA issue in CAS . use a timestamp
        assertEquals(true, i.compareAndSet(1, 2, start, now));
    }
}
