package Lab1;

import org.junit.jupiter.api.Test;

public class stringTest {
    public int concatContain(String source, String target) {
        int count = 0;
        String newSource = source;
        if (source != null && target != null) {
            if (newSource.contains(target)) {
                return 0;
            }else {
                while (true) {
                    newSource += source;
                    count++;
                    if (newSource.contains(target)) {
                        break;
                    }
                    if (count > 100) {
                        return -1;
                    }
                }
            }
        }
        return count;

    }

    @Test
    public void test() {
        int res = concatContain("abc", "ab");
        System.out.println(res);
    }
}
