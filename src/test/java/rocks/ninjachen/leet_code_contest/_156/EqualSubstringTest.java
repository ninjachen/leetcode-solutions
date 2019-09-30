package rocks.ninjachen.leet_code_contest._156;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EqualSubstringTest {
    EqualSubstring solution;

    @Before
    public void setUp() throws Exception {
        solution = new EqualSubstring();
    }

    @Test
    public void testCase1() {
        String s = "kkujxwtrlwvkkyccrimpiiinzyzcpuqnretofvouicbqwmuypaynwfjztmjugihipeyfasclggdzzofbcfbuazeppmxswdvuzlnwckkzzlqkphusagqmxfvjlpxgjwoprahezgrrlwtxbbhehvmvwcoyngwsgegcelpgehdzecxsrwozlvtogajxmbqhgljxerdgierc";
        String t = "jynhwjttmbcelakawdfwqkfhgxxqzvpmsczlklzqnrxkpupmajzfcfgxhgzqzbbgvgmjtaiekkdbdnudnichmricfokewmxtlvdiqmuybpgsmcdhybwlxdqkhnfjfonilzohukpwztipmuroiknsnodvegbiugxsmcxqccccdcripyfrzqcmqtblowvkkbnagkgsftau";
        Assert.assertEquals(94, solution.equalSubstring(s, t, 715));
    }
}