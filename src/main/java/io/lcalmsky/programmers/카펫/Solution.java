package io.lcalmsky.programmers.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width, height;
        for (int i = 3; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                width = sum / i;
                height = i;
                if (width * 2 + height * 2 - 4 == brown) return new int[]{width, height};
            }
        }
        return null;
    }
}
