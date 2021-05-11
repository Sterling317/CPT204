package lab3.CheckSubstring;

public class CheckSubstring {

    /**
     * Check if at least n copies of a substring occur in input string.
     * They may overlap.
     * For example, checkSubstring("ababaxxxaba", "aba", 3) → true
     *
     * @param input is the input string.
     * @param subs  is the non-empty substring.
     * @param n     is non-negative number of occurrences.
     * @return true iff at least n copies of subs occur in input.
     */
    public static boolean checkSubstring(String input, String subs, int n) {
        // base case
        if (!input.contains(subs)) {
            if (n <= 0) {
                return true;
            } else {
                return false;
            }
        }
        // recursive step
        if (input.contains(subs)) {
            if (input.substring(0,subs.length()).contains(subs)){
                return checkSubstring(input.substring(1), subs, n - 1);
            } else {
                return checkSubstring(input.substring(1), subs, n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "abcxxxxabc";
        String subs = "abc";
        int n = 2;
        boolean res = checkSubstring(input, subs, n);
        System.out.println(res);

    }
}
