package rocks.ninjachen.leet_code_contest.bi_15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationIteratorTest {

    @Test
    public void testcase() {
        CombinationIterator solution = new CombinationIterator("abc", 2);
        solution.next();
        solution.hasNext();
        solution.next();
        solution.hasNext();
        solution.next();
        solution.hasNext();
    }
}