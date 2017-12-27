package rocks.ninjachen.hacker_rank_soulutions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by ninja on 12/24/17.
 */
public class AnagramTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }


    @Test
    public void main() throws Exception {
        InputStream inputIn = getClass().getClassLoader().getResourceAsStream("rocks/ninjachen/hacker_rank_solutions/anagram-input1.txt");
        System.setIn(inputIn);
        Anagram.main(null);
        InputStream expectIn = getClass().getClassLoader().getResourceAsStream("rocks/ninjachen/hacker_rank_solutions/anagram-expect1.txt");
        Scanner sc = new Scanner(expectIn).useDelimiter("\\A");
//        BufferedReader br = new BufferedReader(new InputStreamReader(expectIn));
//        StringBuffer sb = new StringBuffer();
//        String str;
//        while((str = br.readLine()) != null){
//            sb.append(str);
//        }
        // Match with last \n char
        assertEquals(sc.next()+"\n", outContent.toString());
        // Clean up
        inputIn.close();
        expectIn.close();
    }

}