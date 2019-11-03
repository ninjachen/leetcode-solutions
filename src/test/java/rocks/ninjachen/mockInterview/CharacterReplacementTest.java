package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterReplacementTest {
    CharacterReplacement solution;

    @Before
    public void setUp() throws Exception {
        solution = new CharacterReplacement();
    }

    @Test
    public void characterReplacement() {
        assertEquals(4, solution.characterReplacement("ABAB", 2));
    }
}