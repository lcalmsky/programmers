package io.lcalmsky.programmers.인형_뽑기;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int rows = board.length;
        int cols = board[0].length;
        int[] lastIndices = new int[cols];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[j][i] != 0) {
                    lastIndices[i] = j;
                    break;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int move : moves) {
            int lastIndex = lastIndices[move - 1];
            if (lastIndex == rows) continue;
            int doll = board[lastIndex][move - 1];
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                result += 2;
            } else {
                stack.push(doll);
            }
            lastIndices[move - 1]++;
        }
        return result;
    }
}
