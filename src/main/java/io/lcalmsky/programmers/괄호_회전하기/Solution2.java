package io.lcalmsky.programmers.괄호_회전하기;

import java.util.Stack;

public class Solution2 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) {
                answer++;
            }
            s = String.format("%s%s", s.substring(1), s.charAt(0));
        }
        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if (!isValid(stack, '[')) return false;
                    stack.pop();
                    break;
                case '}':
                    if (!isValid(stack, '{')) return false;
                    stack.pop();
                    break;
                case ')':
                    if (!isValid(stack, '(')) return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

    private boolean isValid(Stack<Character> stack, char c2) {
        if (!stack.isEmpty() && stack.peek() == c2) {
            return true;
        }
        return false;
    }
}