package io.lcalmsky.programmers._124_나라의_숫자;

public class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rest = n % 3;
            n /= 3;
            if (rest == 0) {
                rest = 4;
                n--;
            }
            sb.append(rest);
        }
        return sb.reverse().toString();
    }
}
