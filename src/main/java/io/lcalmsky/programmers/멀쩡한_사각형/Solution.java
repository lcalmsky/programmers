package io.lcalmsky.programmers.멀쩡한_사각형;

public class Solution {
    public long solution(int w, int h) {
        long min = Math.min(w, h);
        long max = Math.max(w, h);

        long value = 1;
        while (value > 0) {
            value = max % min;
            max = min;
            min = value;
        }

        return (long) w * (long) h - ((long) w + (long) h - max);
    }
}
