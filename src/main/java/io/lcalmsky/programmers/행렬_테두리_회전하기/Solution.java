package io.lcalmsky.programmers.행렬_테두리_회전하기;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] array = new int[rows + 1][columns + 1];
        for (int i = 1, k = 1; i <= rows; i++) for (int j = 1; j <= columns; j++) array[i][j] = k++;
        for (int i = 0; i < queries.length; i++)
            answer[i] = rotate(array, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        return answer;
    }

    private int rotate(int[][] array, int x1, int y1, int x2, int y2) {
        int temp = array[x1][y1];
        int min = temp;
        for (int i = x1; i < x2; i++) {
            array[i][y1] = array[i + 1][y1];
            min = Math.min(min, array[i][y1]);
        }
        for (int i = y1; i < y2; i++) {
            array[x2][i] = array[x2][i + 1];
            min = Math.min(min, array[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            array[i][y2] = array[i - 1][y2];
            min = Math.min(min, array[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            array[x1][i] = array[x1][i - 1];
            min = Math.min(min, array[x1][i]);
        }
        array[x1][y1 + 1] = temp;
        return min;
    }
}
