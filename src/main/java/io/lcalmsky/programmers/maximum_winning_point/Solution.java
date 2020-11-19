package io.lcalmsky.programmers.maximum_winning_point;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int winningPoint = 0;
        for (int i = 0, a = 0, b = 0; i < A.length; i++) {
            if (A[a] > B[b]) b++;
            else if (A[a] == B[b]) b++;
            else {
                a++;
                b++;
                winningPoint++;
            }
        }

        return winningPoint;
    }
}
