package Lab2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EvenAppend {

    /**
     * Append words that appear the 2nd, 4th, 6th, etc. time in a list.
     * For example, evenAppend(["a", "b", "b", "a", "a", "b", "b"]) → "bab".
     * @param list is a list of words.
     * @return a concatenation of even appearing words.
     */
    public static String evenAppend(List<String> list) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        String res = "";
        for (String str : list) {
            int count = 0;
            if (!map1.containsKey(str)) {
                map1.put(str, count + 1);
//                System.out.println(map1);
            } else {
                int num = map1.get(str);
                if (num % 2 == 0){
                    map1.put(str, num + 1);
//                    System.out.println(map1);
                } else {
                    res += str;
                    map1.put(str, num + 1);
//                    System.out.println(map1);
                }
            }
        }
//        System.out.println(res);
        return res;
    }

}