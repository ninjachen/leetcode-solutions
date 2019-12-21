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
        System.out.println(new ReverseSolution().reverse(1534236469));
    }

    class ReverseSolution {
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
            reserve(array);
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

        private void reserve(int[] array) {
            for(int a = 0, b = array.length - 1; a < b; a++, b-- ) {
                int temp = array[a];
                array[a] = array[b];
                array[b] = temp;
            }
        }

        private boolean isOverflow(int[] array) {
            int[] arrayMax = new int[]{2,1,4,7,4,8,3,6,4,7};
            reserve(arrayMax);
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
    public void testFullPerMutation() {
        // full permutation
        List<String> result = fullPerMutation(new int[]{2,3,4,7,9}, 3);
        for (String i : result) {
            System.out.println(i);
        }
    }

    private List<String> fullPerMutation(int[] array, int num) {
        List<String> allSolutions = new ArrayList<>();
        for (int i = 0; i < array.length - num + 1; i++) {
            List<Integer> curSolution = new ArrayList<>();
            curSolution.add(array[i]);
            fullPerMutation(array, i + 1, num, curSolution, allSolutions);
            curSolution.remove(curSolution.size() - 1);
        }
        return allSolutions;
    }

    private void fullPerMutation(int[] array, int curIndex, int targetNum, List<Integer> curSolution, List<String> allSolutions) {
        for (int i = curIndex; i < array.length; i++) {
            curSolution.add(array[i]);
            if (curSolution.size() == targetNum) {
                StringBuffer sb = new StringBuffer();
                for (Integer item : curSolution) {
                    sb.append(item);
                }
                allSolutions.add(sb.toString());
            } else {
                fullPerMutation(array, i + 1, targetNum, curSolution, allSolutions);
            }
            curSolution.remove(curSolution.size() - 1);
        }
    }

    @Test
    public void testHeapPermutation() {
        // full permutation
//        heapPermutation(new int[]{1, 2, 3}, 3);
        List<int[]> permutations = permutation(new int[]{1, 2, 3});
        for (int[] arr : permutations) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Generating permutation using Heap Algorithm
     * https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
     * https://en.wikipedia.org/wiki/Heap%27s_algorithm#cite_note-3
     * @param a
     * @param size
     */
    void heapPermutation(int a[], int size)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1){
            for (int i : a)
                System.out.print(i);
            System.out.println();
        }

        for (int i=0; i<size; i++)
        {
            heapPermutation(a, size-1);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            }

            // If size is even, swap ith and last
            // element
            else
            {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
    }

    private List<int[]> permutation(int a[]) {
        List<int[]> prv = new ArrayList<>();
        prv.add(new int[]{a[0]});
        for (int i = 1; i < a.length; i++) {
            List<int[]> cur = new ArrayList<>();
            int val = a[i];
            // put val into prv arr
            for (int[] arr : prv) {
                for (int index = 0; index < i + 1; index++) {
                    int[] newArr = new int[i + 1];
                    int oldIndex = 0;
                    for (int ii = 0; ii < i + 1; ii++) {
                        if (ii == index) {
                            newArr[ii] = val;
                        } else {
                            newArr[ii] = arr[oldIndex++];
                        }
                    }
                    cur.add(newArr);
                }
            }
            prv = cur;
        }
        return prv;
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
