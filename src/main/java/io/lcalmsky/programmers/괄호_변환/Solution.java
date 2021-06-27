package io.lcalmsky.programmers.괄호_변환;

import java.util.Stack;

public class Solution {

    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        int index = findIndex(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        return isValid(u)
                ? String.format("%s%s", u, solution(v))
                : String.format("(%s)%s", solution(v), validate(u));
    }

    private int findIndex(String parentheses) {
        char[] chars = parentheses.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException("invalid parentheses");
    }

    private boolean isValid(String parentheses) {
        if (parentheses.startsWith(")")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = parentheses.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String validate(String parentheses) {
        StringBuilder parenthesesBuilder = new StringBuilder();
        char[] chars = parentheses.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            char c = chars[i];
            parenthesesBuilder.append(c == '(' ? ')' : '(');
        }
        return parenthesesBuilder.toString();
    }
}
