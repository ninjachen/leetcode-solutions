package rocks.ninjachen.leet_code_solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class WordLadderTest {
    WordLadder solution;


    @Before
    public void setUp() throws Exception {
        solution = new WordLadder();
    }

    @Test
    public void ladderLength() {
        int answer = solution.ladderLength("hit", "cog", ResourceUtil.parseLineToStringList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"));
        Assert.assertEquals(5, answer);
    }
}