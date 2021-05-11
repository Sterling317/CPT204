package Lab2;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxStretchTest {

    @Test
    public void testSingleMaxStretch() {
        List<Integer> list = Arrays.asList(8, 5, 1, 2, 3, 4, 5, 10);
        assertEquals(6, MaxStretch.maxStretch(list));
    }

    @Test
    public void testOverLap() {
        List<Integer> list = Arrays.asList(2, 3, 2, 3, 3, 2, 2, 3);
        assertEquals(7, MaxStretch.maxStretch(list));
    }

    @Test
    public void testSingletonList() {
        List<Integer> list = Arrays.asList(5555);
        assertEquals(1, MaxStretch.maxStretch(list));
    }

    @Test
    public void testEmptyList() {
        List<Integer> list = Arrays.asList();
        assertEquals(0, MaxStretch.maxStretch(list));
    }


    @Test
    public void testOneWholeStretch() {
        List<Integer> list = Arrays.asList(4, 4, 4, 4);
//        System.out.println(list.lastIndexOf(4));
        assertEquals(4, MaxStretch.maxStretch(list));
    }

    @Test
    public void testSingleOverlapMaxStretch() {
        List<Integer> list = Arrays.asList(2, 7, 1, 2, 3, 7);
        System.out.println(list.lastIndexOf(7));
        System.out.println(list.indexOf(7));
        assertEquals(5, MaxStretch.maxStretch(list));
    }

    // add more test cases


}