package io.lcalmsky.programmers.체육복;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] all = new int[n];
        for (int r : reserve) all[r - 1]++;
        for (int l : lost) all[l - 1]--;
        if (all[0] < 0 && all[1] > 0) {
            all[0]++;
            all[1]--;
        }
        if (all[n - 1] < 0 && all[n - 2] > 0) {
            all[n - 1]++;
            all[n - 2]--;
        }
        for (int i = 1; i < n - 1; i++) {
            if (all[i] < 0) {
                if (all[i - 1] > 0) {
                    all[i]++;
                    all[i - 1]--;
                } else if (all[i + 1] > 0) {
                    all[i]++;
                    all[i + 1]--;
                }
            }
        }
        int cnt = 0;
        for (int a : all) if(a > -1) cnt++;
        return cnt;
    }
}
