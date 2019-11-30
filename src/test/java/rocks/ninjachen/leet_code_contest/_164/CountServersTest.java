package rocks.ninjachen.leet_code_contest._164;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class CountServersTest {
    CountServers solution;

    @Before
    public void setUp() throws Exception {
        solution = new CountServers();
    }

    @Test
    public void countServers() {
        assertEquals(0, solution.countServers(ResourceUtil.parse2dArray("[[1,0],[0,1]]")));
    }

    @Test
    public void countServers2() {
        assertEquals(3, solution.countServers(ResourceUtil.parse2dArray("[[1,0],[1,1]]")));
    }
}