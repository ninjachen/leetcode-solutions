package rocks.ninjachen.other.booking;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 */
public class Anagram {

    @Test
    public void testcase() {
        Map<int[], String> map = new HashMap<>();
        map.put(new int[]{1,2}, "me");
        map.put(new int[]{1,2}, "ninja");
        System.out.println(map.toString());
    }
}
