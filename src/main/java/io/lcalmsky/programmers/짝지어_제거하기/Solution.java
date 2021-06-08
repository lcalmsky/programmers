package io.lcalmsky.programmers.짝지어_제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else if (stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
