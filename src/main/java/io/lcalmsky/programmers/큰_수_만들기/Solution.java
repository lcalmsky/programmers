package io.lcalmsky.programmers.큰_수_만들기;

public class Solution {
    public String solution(String number, int k) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';
                if (current > max) {
                    max = current;
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
