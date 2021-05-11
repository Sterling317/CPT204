package lab3.CheckSubstring;

import org.junit.Test;
import static org.junit.Assert.*;


public class CheckSubstringTest {

    @Test
    public void testCheckSubstringTrue() {
        String input = "abcxxxxabc";
        String subs = "abc";
        int n = 2;
        boolean expected = true;
        assertEquals(expected, CheckSubstring.checkSubstring(input, subs, n));
    }
    @Test
    public void testCheckSubstringFalse() {
        String input = "abcxxxxabc";
        String subs = "abc";
        int n = 3;
        boolean expected = false;
        assertEquals(expected, CheckSubstring.checkSubstring(input, subs, n));
    }
    @Test
    public void testCheckSubstringOverlap() {
        String input = "ababaxxxaba";
        String subs = "aba";
        int n = 3;
        boolean expected = true;
        assertEquals(expected, CheckSubstring.checkSubstring(input, subs, n));
    }
	
	// add more test cases
	@Test
    public void test1() {
        assertEquals(true,CheckSubstring.checkSubstring("aaaaaa","aa",4));
        assertEquals(true,CheckSubstring.checkSubstring("aaaaaa","aa",5));
        assertEquals(false,CheckSubstring.checkSubstring("aaaaaa","aa",6));
    }

    @Test
    public void test2() {
        assertEquals(true,CheckSubstring.checkSubstring("fexfe","ef",0));
    }
	
	
}
