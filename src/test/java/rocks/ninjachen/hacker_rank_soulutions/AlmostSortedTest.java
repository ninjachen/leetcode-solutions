package rocks.ninjachen.hacker_rank_soulutions;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by ninja on 12/20/17.
 */
public class AlmostSortedTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void cleanUpStreams() {
//        System.setOut(null);
//        System.setErr(null);
//    }

    @org.junit.Test
    public void testCase1() throws Exception {
        // 3 1 2 should be YES
        int[] input = {4, 2};
        assertEquals("yes\nswap 1 2", AlmostSorted.almostSorted(input));
    }

    @org.junit.Test
    public void testCase2() throws Exception {
        // 3 1 2 should be YES
        int[] input = {1, 5, 4, 3, 2, 6};
        assertEquals("yes\nreverse 2 5", AlmostSorted.almostSorted(input));
    }

    @org.junit.Test
    public void testCase3() throws Exception {
        InputStream inputIn = getClass().getClassLoader().getResourceAsStream("rocks/ninjachen/hacker_rank_solutions/almost-sorted-input1.txt");
        InputStream expectIn = getClass().getClassLoader().getResourceAsStream("rocks/ninjachen/hacker_rank_solutions/almost-sorted-expect1.txt");
        HashMap<int[], String> testCases = new HashMap<>();
        try {
            BufferedReader inputreader = new BufferedReader(new InputStreamReader(inputIn));
            BufferedReader expectreader = new BufferedReader(new InputStreamReader(expectIn));
            /** Read test case file into map(named testCases), structure is <input, expect> **/
            if (inputreader != null && expectreader != null) {
                String str;
                Integer amount = 1;
                // Read inputs and their expect into
                for (int i = 0; i < amount; i++) {
                    str = inputreader.readLine(); // number of ints, never used
                    if ((str = inputreader.readLine()) != null) {
                        String[] strs = str.trim().split("\\s+");
                        int[] nums = new int[strs.length];
                        for (int j = 0; j < strs.length; j++) {
                            nums[j] = Integer.valueOf(strs[j]);
                        }
                        testCases.put(nums, expectreader.readLine().trim());
                    }
                }
            }
        } finally {
            try {
                inputIn.close();
                expectIn.close();
            } catch (Throwable ignore) {
            }
        }

        /** Assert algorithm **/
        for (Map.Entry<int[], String> entry : testCases.entrySet()) {
            assertEquals(entry.getValue(), AlmostSorted.almostSorted(entry.getKey()));
        }
    }

}