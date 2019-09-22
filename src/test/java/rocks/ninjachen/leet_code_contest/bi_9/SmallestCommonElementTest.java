package rocks.ninjachen.leet_code_contest.bi_9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

public class SmallestCommonElementTest {
    SmallestCommonElement soulution;

    @Before
    public void setUp() throws Exception {
        soulution = new SmallestCommonElement();
    }

    @Test
    public void smallestCommonElement1() {
        String intput = "[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]";
        Assert.assertEquals(5, soulution.smallestCommonElement(ResourceUtil.parse2dArray(intput)));
    }

//    @Test
//    public void smallestCommonElement2() {
//        String intput = "[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]";
//        System.out.println(soulution.smallestCommonElement(ResourceUtil.parse2dArray(intput)));;
//    }
}