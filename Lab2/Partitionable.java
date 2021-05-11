package Lab2;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partitionable {
    public static boolean isPartitionable(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) {
            return true;
        }
        int leftSum = 0;
        int rightSum = 0;
        boolean isEqual = false;
        int i = 0;
        int j = list.size() - 1;
        leftSum += list.get(i);
//        System.out.println(leftSum);
        rightSum += list.get(j);
//        System.out.println(rightSum);
        while (i != j) {
            if (leftSum <= rightSum) {
                if (i == j - 1) {
                    break;
                }
                i += 1;
                leftSum += list.get(i);
            } else if (leftSum > rightSum) {
                if (i == j - 1) {
                    break;
                }
                j -= 1;
                rightSum += list.get(j);
//                System.out.println(rightSum);
            }
            if (i == j - 1 && list.size() == 3) {
                rightSum += list.get(i);
                System.out.println(111);
            }
        }
        if (leftSum != rightSum) {
            isEqual = false;
        } else {
            isEqual = true;
        }
        return isEqual;
    }

//    @Test
//    public void test() {
//        List<Integer> list = Arrays.asList(2, 1, 1, 2, 1);
//        assertEquals(false, isPartitionable(list));
//    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,0,0,0);
        boolean res = isPartitionable(list);
        System.out.println(res);
    }
}
