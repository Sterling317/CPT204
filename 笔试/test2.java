package 笔试;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        String newStr = "";
        int index = 0;
        if (scanner.hasNextLine()) {
            str = scanner.nextLine();
        }
        index = str.length();
        for (int i = 0; i < index; i++) {
            if (!newStr.contains(String.valueOf(str.charAt(i)))) {
                newStr += String.valueOf(str.charAt(i));
            } else {
                i++;
            }
        }
        System.out.println(newStr);
    }
}
