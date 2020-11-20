package io.lcalmsky.programmers.전화번호_목록;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(new Solution().solution(new String[]{"123", "456", "789"}));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        String criteria = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(criteria)) return false;
        }
        return true;
    }
}
