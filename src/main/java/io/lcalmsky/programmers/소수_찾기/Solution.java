package io.lcalmsky.programmers.소수_찾기;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    private int[] numberArray;
    private TreeSet<Integer> set;
    private boolean[] visited;
    private int answer = 0;
    private String numbers;

    public int solution(String numbers) {
        numberArray = new int[numbers.length()];
        set = new TreeSet<>();
        visited = new boolean[numberArray.length];
        this.numbers = numbers;

        for (int i = 0; i < numberArray.length; i++) numberArray[i] = numbers.charAt(i) - '0';

        Arrays.sort(numberArray);

        for (int i = 0; i < numbers.length(); i++) {
            int[] list = new int[i + 1];
            combination(0, i + 1, list);
        }

        boolean[] prime = new boolean[set.last() + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(set.last()); i++) {
            if (prime[i]) continue;
            for (int j = i + i; j <= set.last(); j += i) prime[j] = true;
        }
        for (Integer i : set) if (!prime[i]) answer++;

        return answer;
    }

    private void combination(int depth, int length, int[] list) {
        if (depth == length) {
            StringBuilder tmp = new StringBuilder();
            for (int j : list) tmp.append(j);
            set.add(Integer.parseInt(tmp.toString()));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = numberArray[i];
                combination(depth + 1, length, list);
                visited[i] = false;
            }
        }
    }
}
