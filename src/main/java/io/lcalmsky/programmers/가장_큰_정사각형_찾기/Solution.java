package io.lcalmsky.programmers.가장_큰_정사각형_찾기;

public class Solution {
    public int solution(int[][] board) {
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++)
            System.arraycopy(board[i], 0, newBoard[i + 1], 1, board[i].length);
        int max = 0;
        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == 1) {
                    int left = newBoard[i - 1][j];
                    int up = newBoard[i][j - 1];
                    int leftUp = newBoard[i - 1][j - 1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    newBoard[i][j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }
        return max * max;
    }
}
