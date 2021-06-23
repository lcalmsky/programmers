package io.lcalmsky.programmers.수식_최대화;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        splitExpression(expression, numbers, operators);
        List<Character> uniqueOperators = new ArrayList<>(new HashSet<>(operators));
        List<List<Character>> permutations = new ArrayList<>();
        initPermutations(permutations, new ArrayList<>(), new boolean[uniqueOperators.size()], uniqueOperators);
        long max = Long.MIN_VALUE;
        for (List<Character> permutation : permutations) {
            max = Math.max(max, calculate(permutation, numbers, operators));
        }
        return max;
    }

    public void splitExpression(String exp, List<Long> numbers, List<Character> operators) {
        char[] charArray = exp.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : charArray) {
            if (c == '*' || c == '+' || c == '-') {
                long number = Long.parseLong(builder.toString());
                numbers.add(number);
                operators.add(c);
                builder.setLength(0);
            } else {
                builder.append(c);
            }
        }
        numbers.add(Long.parseLong(builder.toString()));
    }

    public void initPermutations(List<List<Character>> permutations, List<Character> list, boolean[] picked, List<Character> uniqueOperators) {
        if (list.size() == uniqueOperators.size()) {
            permutations.add(list);
            return;
        }

        for (int i = 0; i < uniqueOperators.size(); i++) {
            if (!picked[i]) {
                picked[i] = true;
                list.add(uniqueOperators.get(i));
                initPermutations(permutations, list, picked, uniqueOperators);
                list.remove(list.size() - 1);
                picked[i] = false;
            }
        }
    }

    private long calculate(List<Character> list, List<Long> numbers, List<Character> operators) {
        List<Long> copiedNumbers = new ArrayList<>(numbers);
        List<Character> copiedOperators = new ArrayList<>(operators);
        for (char currentOperator : list) {
            for (int i = 0; i < copiedOperators.size(); i++) {
                if (copiedOperators.get(i) != currentOperator)
                    continue;
                long left = copiedNumbers.get(i);
                long right = copiedNumbers.get(i + 1);
                copiedNumbers.remove(i + 1);
                copiedNumbers.remove(i);
                copiedOperators.remove(i);
                copiedNumbers.add(i, calculate(left, right, currentOperator));
                i--;
            }
        }
        return Math.abs(copiedNumbers.get(0));
    }

    public long calculate(long left, long right, char operator) {
        switch (operator) {
            case '*':
                return left * right;
            case '+':
                return left + right;
            default:
                return left - right;
        }
    }
}
