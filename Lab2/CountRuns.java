package Lab2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.*;

public class CountRuns {
    public static int countRuns(List<Integer> list) {
        int totalCount = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : list) {
            int num = 0;
            if (map.containsKey(i)) {
//                System.out.println(i + "----" + map);
                num = map.get(i);
                map.put(i, num + 1);
            } else {
                map.put(i, num + 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) >= 2) {
                totalCount++;
            }
        }
        return totalCount;
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 5, 5);
        assertEquals(2,countRuns(list));
    }
}
