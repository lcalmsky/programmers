package io.lcalmsky.programmers.삼각_달팽이;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int max = 0;
        for (int i = 1; i <= n; i++) max += i;
        for (int i = 0; i < n; i++) for (int j = 0; j <= i; j++) arr[i][j] = -1;

        int[] answer = new int[max];
        int i = 0, j = 0, k = 1;

        arr[i][j] = k;

        while (k < max) {
            while (i + 1 < n && k < max && arr[i + 1][j] < 0) arr[++i][j] = ++k;
            while (j + 1 < n && k < max && arr[i][j + 1] < 0) arr[i][++j] = ++k;
            while (i - 1 > 0 && k < max && arr[i - 1][j - 1] < 0) arr[--i][--j] = ++k;
        }

        k = 0;

        for (i = 0; i < n; i++) for (j = 0; j <= i; j++) answer[k++] = arr[i][j];
        return answer;
    }
}
