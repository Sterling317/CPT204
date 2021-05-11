package lab3.CountBabaMama;

public class CountBabaMama {

    /**
     * Count the number of occurrences of substrings "baba" or "mama"
     * in the input string recursively. They may overlap.
     * For example, countBabaMama("aba babaa amama ma") → 2,
     * and countBabaMama("bababamamama") → 4.
     * @param input is the input string.
     * @return the number of occurrences.
     */
    public static int countBabaMama(String input) {

        if (input.length() < 4) {
            return 0;
        }

        if (input.substring(0,4).equals("baba") || input.substring(0,4).equals("mama")) {
            return 1 + countBabaMama(input.substring(1));
        } else {
            return countBabaMama(input.substring(1));
        }

    }

    public static void main(String[] args) {
        int res = countBabaMama("aba babaa amama ma");
        System.out.println(res);
    }

}
