package rocks.ninjachen.leet_code_solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.Collections;
import java.util.List;

public class WordLadder2Test {

    WordLadder2 solution;

    @Before
    public void setUp() throws Exception {
        solution = new WordLadder2();
    }

    @Test
    public void testcase1() {
        List<List<String>> ans = solution.findLadders("hit", "cog", ResourceUtil.parseLineToStringList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"));
        Assert.assertEquals("[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"], [\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]]", ResourceUtil.printList(ans));
    }

    @Test
    public void testcase2() {
        List<List<String>> ans = solution.findLadders("a", "c", ResourceUtil.parseLineToStringList("[\"a\",\"b\",\"c\"]"));
        Assert.assertEquals("[[\"a\",\"c\"]]", ResourceUtil.printList(ans));
    }

    @Test
    public void testcase3() {
        List<List<String>> ans = solution.findLadders("cat", "fin", ResourceUtil.parseLineToStringList("[\"ion\",\"rev\",\"che\",\"ind\",\"lie\",\"wis\",\"oct\",\"ham\",\"jag\",\"ray\",\"nun\",\"ref\",\"wig\",\"jul\",\"ken\",\"mit\",\"eel\",\"paw\",\"per\",\"ola\",\"pat\",\"old\",\"maj\",\"ell\",\"irk\",\"ivy\",\"beg\",\"fan\",\"rap\",\"sun\",\"yak\",\"sat\",\"fit\",\"tom\",\"fin\",\"bug\",\"can\",\"hes\",\"col\",\"pep\",\"tug\",\"ump\",\"arc\",\"fee\",\"lee\",\"ohs\",\"eli\",\"nay\",\"raw\",\"lot\",\"mat\",\"egg\",\"cat\",\"pol\",\"fat\",\"joe\",\"pis\",\"dot\",\"jaw\",\"hat\",\"roe\",\"ada\",\"mac\"]"));
        Assert.assertEquals("[[\"cat\",\"fat\",\"fit\",\"fin\"],[\"cat\",\"fat\",\"fan\",\"fin\"],[\"cat\",\"can\",\"fan\",\"fin\"]]", ResourceUtil.printList(ans));
    }

    @Test
    public void testcase4() {
        String name = Constants.BASE_DIR_LEETCODE + "word-ladder-ii";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        List<String> dict = ResourceUtil.parseLineToStringList(lines.get(2));
        List<List<String>> ans = solution.findLadders(ResourceUtil.parseString(lines.get(0)), ResourceUtil.parseString(lines.get(1)), dict);
        Assert.assertEquals("[]", ResourceUtil.printList(ans));
    }

    @Test
    public void testcase5() {
        String name = Constants.BASE_DIR_LEETCODE + "word-ladder-ii";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        List<String> dict = ResourceUtil.parseLineToStringList(lines.get(2));
        List<List<String>> ans = new WordLadder22().findLadders(ResourceUtil.parseString(lines.get(0)), ResourceUtil.parseString(lines.get(1)), dict);
        Assert.assertEquals("[]", ResourceUtil.printList(ans));
    }
}