package rocks.ninjachen.other.booking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem
 * Given a list of numbers, e.g.:
 *
 * 25626 25757 24367 24267 16 100 2 7277
 *
 * Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:
 *
 * 25626 131 -1390 -100 -24251 84 -98 7275
 *
 * However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then, instead of the difference, we would like to use an escape token, printing it.
 *
 * This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte different value.
 *
 * For this exercise, we'll declare -128 as the escape token.
 *
 * Following the same example above, the final result would be:
 *
 * 25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 */
public class DeltaEncoding {
    @Test
    public void testcase() {
        Assert.assertArrayEquals(
                new int[]{25626, -128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128, 7275},
                deltaEncoding(new int[]{25626, 25757, 24367, 24267, 16, 100, 2, 7277}));
    }

    private static int[] deltaEncoding(int... data) {
        final int ESCAPE_TOKEN = -128;
        List<Integer> encodedList = new ArrayList<>();
        encodedList.add(data[0]);
        int before = data[0];
        for (int i = 1; i < data.length; i++) {
            int delta = data[i] - before;
            if (delta < -127 || delta > 127) {
                encodedList.add(ESCAPE_TOKEN);
            }
            encodedList.add(delta);
            before = data[i];
        }
        return encodedList.stream().mapToInt(i -> i).toArray();
    }
}
