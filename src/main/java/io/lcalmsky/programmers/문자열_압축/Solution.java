package io.lcalmsky.programmers.문자열_압축;

public class Solution {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            min = Math.min(min, compress(s, i).length());
        }
        return min;
    }

    private CharSequence compress(String original, int lengthToBeCompressed) {
        int count = 1;
        StringBuilder compressed = new StringBuilder();
        String pattern = null;
        for (int i = 0; i < original.length() + lengthToBeCompressed; i += lengthToBeCompressed) {
            String subString = (i >= original.length())
                    ? ""
                    : original.length() < i + lengthToBeCompressed
                    ? original.substring(i)
                    : original.substring(i, i + lengthToBeCompressed);
            if (i != 0) {
                if (subString.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compressed.append(count).append(pattern);
                    count = 1;
                } else {
                    compressed.append(pattern);
                }
            }
            pattern = subString;
        }
        return compressed.toString();
    }
}
