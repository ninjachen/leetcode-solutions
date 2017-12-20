package rocks.ninjachen.hacker_rank_soulutions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

}