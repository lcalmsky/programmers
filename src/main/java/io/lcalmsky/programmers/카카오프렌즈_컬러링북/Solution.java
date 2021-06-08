package io.lcalmsky.programmers.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final static int[] DX = {1, -1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};
    private boolean[][] visited;
    private Queue<Node> queue;
    private int size;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    size = 1;
                    bfs(picture, i, j, m, n);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void bfs(int[][] picture, int x, int y, int m, int n) {
        queue.add(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentNode.x + DX[i];
                int nextY = currentNode.y + DY[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (picture[x][y] == picture[nextX][nextY] && !visited[nextX][nextY]) {
                        queue.add(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                        size++;
                    }
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}