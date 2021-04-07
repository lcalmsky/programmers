package io.lcalmsky.programmers.올바른_괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') stack.push(c);
            else if (stack.isEmpty()) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
