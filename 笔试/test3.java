package 笔试;
import java.util.Scanner;
//华为面试题针它🐎难！！！！！！！！！！
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int container = scanner.nextInt();
        int res[] = new int[24];
        int data[][] = new int[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < num; i++) {
            if (0 <= data[i][0] && data[i][0] < 23 && 1 <= data[i][1] && data[i][1] <= 24 && data[i][2] <= container) {
                for (int j = data[i][0]; j < data[i][1]; j++) {
                    res[j] += data[i][2];
                    if (res[j] > container) {
                        res[j] -= data[i][2];
                        data[i][2] = 0;
                    }
                }
            }
        }
        for (int result : res) {
           // System.out.println(res);
            System.out.print(result +" ");
        }
    }
}
// 4 40
// 9 12 5
// 8 11 10
// 14 16 30
// 15 17 20