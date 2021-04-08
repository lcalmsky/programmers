package io.lcalmsky.programmers.땅따먹기;

public class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][2], land[i - 1][3]), land[i - 1][0]);
            land[i][2] += Math.max(Math.max(land[i - 1][3], land[i - 1][0]), land[i - 1][1]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            max = Math.max(land[land.length - 1][i], max);
        }
        return max;
    }
}
