package test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null)
            return null;
        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while (columns > start * 2 && rows > start * 2){
            printMatrixIncricle(matrix,columns,rows,start);
            ++start;
        }
        return (ArrayList<Integer>) list;


    }

    private void printMatrixIncricle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印第一行
        for (int i = start; i <= endX; ++i){
            list.add(matrix[start][i]);
        }
        //从上到下打印第一列
        if (start < endY){
            for (int i = start + 1; i <= endY; ++i){
                list.add(matrix[i][endX]);
            }
        }
        //从右到左打印第二行
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; --i){
                list.add(matrix[endY][i]);
            }
        }
        //从下到上打印第二列
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; --i){
                list.add(matrix[i][start]);
            }

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3}
        };
        List list = solution.printMatrix(matrix);
        for (int i = 0; i < list.size(); i++ ){
            System.out.println(list.get(i));
        }
    }
}