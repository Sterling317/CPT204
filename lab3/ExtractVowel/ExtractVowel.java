package lab3.ExtractVowel;

public class ExtractVowel {
    /**
     * Extract the vowels from the input string.
     * For example, extractVowel("i love you 3000") → "ioeou".
     *
     * @param str is the input string.
     * @return the vowels of the input string.
     */
    public static String extractVowel(String str) {
        // call your recursive helper method
        return extractVowelHelper(str, 0, "");
    }

    private static String extractVowelHelper(String str, int start, String vowels) {
        // base case
        if (str.length() == 0) {
            return vowels;
        }
        // recursive step
        if (isVowel(str.charAt(start))) {
//            return vowels + str.charAt(start) + str.substring(start + 1);
            return extractVowelHelper(str.substring(start + 1),start,vowels + str.charAt(start));
        } else {
            return extractVowelHelper(str.substring(start+1),start,vowels);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String res = extractVowel("aiueo");
        System.out.println(res);
    }
}
