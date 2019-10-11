package rocks.ninjachen.other;

import org.junit.Assert;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class QuickSortTest {
    QuickSort solution = new QuickSort();

    @Test
    public void testcase1() {
        int[] nums = ResourceUtil.parseLineToIntArray("[5,2,3,1]");
        solution.sortArray(nums);
        Assert.assertEquals("[1,2,3,5]", ResourceUtil.printArray(nums));
    }

    @Test
    public void testcase2() {
        int[] nums = ResourceUtil.parseLineToIntArray("[-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39]");
        solution.sortArray(nums);
        Assert.assertEquals("[1,2,3,5]", ResourceUtil.printArray(nums));
    }
}