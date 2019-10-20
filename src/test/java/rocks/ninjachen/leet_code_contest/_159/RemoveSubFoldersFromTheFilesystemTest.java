package rocks.ninjachen.leet_code_contest._159;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

public class RemoveSubFoldersFromTheFilesystemTest {
    RemoveSubFoldersFromTheFilesystem solution;

    @Before
    public void setUp() throws Exception {
        solution = new RemoveSubFoldersFromTheFilesystem();
    }

    @Test
    public void testcase1() {
        List<String> output = solution.removeSubfolders(ResourceUtil.parseLineToStringArray("[\"/a\",\"/a/b\",\"/c/d\",\"/c/d/e\",\"/c/f\"]"));
        System.out.println(output);
        Assert.assertArrayEquals(ResourceUtil.parseLineToStringArray("[\"/a\",\"/c/d\",\"/c/f\"]"), output.stream().toArray(String[]::new));
    }

    @Test
    public void testcase2() {
        String name = Constants.BASE_DIR_LEETCODE + "remove-sub-folders-from-the-filesystem1";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        String[] input = ResourceUtil.parseLineToStringArray(lines.get(0));
//        Arrays.sort(input);
        List<String> output = solution.removeSubfolders(input);
        System.out.println(output);
    }

    @Test
    public void testcase3() {
        String name = Constants.BASE_DIR_LEETCODE + "remove-sub-folders-from-the-filesystem2";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        String[] input = ResourceUtil.parseLineToStringArray(lines.get(0));
//        Arrays.sort(input);
        List<String> output = solution.removeSubfolders(input);
        System.out.println(output);
    }
}