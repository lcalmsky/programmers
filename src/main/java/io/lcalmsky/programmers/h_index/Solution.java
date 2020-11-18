package io.lcalmsky.programmers.h_index;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int numberOfPapers = citations.length;
        for (int i = numberOfPapers - 1, h = 0; i >= 0; i--, h++) {
            if (citations[i] < h + 1) return h;
        }
        return numberOfPapers;
    }
}
