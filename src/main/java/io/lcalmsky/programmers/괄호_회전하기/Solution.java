package io.lcalmsky.programmers.괄호_회전하기;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Solution {

    private Map<Character, BiFunction<Stack<Character>, Character, Boolean>> functions;

    public int solution(String s) {
        initFunctions();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) {
                answer++;
            }
            s = String.format("%s%s", s.substring(1), s.charAt(0));
        }
        return answer;
    }

    private void initFunctions() {
        functions = new HashMap<>();
        BiFunction<Stack<Character>, Character, Boolean> pushFunction = (stack, c) -> {
            stack.push(c);
            return true;
        };
        functions.put('[', pushFunction);
        functions.put('{', pushFunction);
        functions.put('(', pushFunction);
        functions.put(']', (stack, c) -> isValid(stack, '['));
        functions.put('}', (stack, c) -> isValid(stack, '{'));
        functions.put(')', (stack, c) -> isValid(stack, '('));
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!functions.get(c).apply(stack, c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private Boolean isValid(Stack<Character> stack, char c) {
        if (!stack.isEmpty() && stack.peek() == c) {
            stack.pop();
            return true;
        }
        return false;
    }
}
