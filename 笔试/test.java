package 笔试;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext() ) {
            num1 = Integer.parseInt(scanner.next());
            num2 = Integer.parseInt(scanner.next());
        }
        int res = num1 + num2;
        System.out.println(res);
    }
}
