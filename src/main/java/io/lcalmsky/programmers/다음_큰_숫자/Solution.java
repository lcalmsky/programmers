package io.lcalmsky.programmers.다음_큰_숫자;

public class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        while (count != Integer.bitCount(++n)) ;
        return n;
    }
}
