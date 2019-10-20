package rocks.ninjachen.leet_code_contest.bi_11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

import static org.junit.Assert.*;

public class MeetingSchedulerTest {
    MeetingScheduler solution;

    @Before
    public void setUp() throws Exception {
        solution = new MeetingScheduler();
    }

    @Test
    public void testcase1() {
        List<Integer> result = solution.minAvailableDuration(
                ResourceUtil.parse2dArray("[[10,50],[60,120],[140,210]]"),
                ResourceUtil.parse2dArray("[[0,15],[60,70]]"),
                8);
        Assert.assertArrayEquals(new int[]{60, 68}, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void testcase2() {
        List<Integer> result = solution.minAvailableDuration(
                ResourceUtil.parse2dArray("[[216397070,363167701],[98730764,158208909],[441003187,466254040],[558239978,678368334],[683942980,717766451]]"),
                ResourceUtil.parse2dArray("[[50490609,222653186],[512711631,670791418],[730229023,802410205],[812553104,891266775],[230032010,399152578]]"),
                456085);
        Assert.assertArrayEquals(
                ResourceUtil.parseLineToIntArray("[98730764,99186849]"),
                result.stream().mapToInt(i -> i).toArray());
    }
}