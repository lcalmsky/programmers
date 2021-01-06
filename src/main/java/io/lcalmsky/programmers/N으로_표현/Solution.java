package io.lcalmsky.programmers.N으로_표현;

public class Solution {
    public int solution(int N, int number) {
        if(N == 1) return number;
        int answer = 0;
        int[] dp = new int[32001];
        dp[N] = 1;
        dp[0] = dp[N] + 1;
        dp[1] = dp[N] + 1;
        int length = dp.length;
        for (int i = N + 1; i < length; i++) {
            if(i - N >= 0) dp[i] = dp[i - N] + 1;
            if(i + N < length) dp[i] = dp[i + N] + 1;
            dp[i] = dp[i / N] + 1;
            dp[i] = dp[i * N] + 1;
        }
        return answer;
    }
}
