package 笔试;

import java.util.ArrayList;
import java.util.List;
//Tecent
public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom + 1; row >= top - 1; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return order;
    }

//    public static void main(String[] args) {
//
//        spiralMatrix spiralMatrix = new spiralMatrix();
//        spiralMatrix.spiralOrder([1,2,3],[4,5,6],[7,8,9]);
//    }
}
