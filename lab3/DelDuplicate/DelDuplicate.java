package lab3.DelDuplicate;

public class DelDuplicate {
	
    /**
     * Remove adjacent duplicate characters in a string.
     * For example, delDuplicate("aaabbc") → "abc".
     * @param input is the input string.
     * @return the resulting string.
     */
    public static String delDuplicate(String input) {
        // base case
        if (input.length() == 0) {
            return "";
        }
        if (input.length() == 1) {
            return input;
        }
        // recursive step
        if (input.substring(0,1).equals(input.substring(1,2))) {
            return delDuplicate(input.substring(1));
        } else {
            return input.charAt(0) + delDuplicate(input.substring(1));
        }

    }

    public static void main(String[] args) {
        String res = delDuplicate("aaabbcbaa");
        System.out.println(res);
    }
}
