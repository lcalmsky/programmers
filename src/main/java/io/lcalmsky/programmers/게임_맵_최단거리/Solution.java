package io.lcalmsky.programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final static int[] DX = {-1, 1, 0, 0};
    private final static int[] DY = {0, 0, 1, -1};

    private boolean[][] visited;
    private int height;
    private int width;

    public int solution(int[][] maps) {
        init(maps);
        return bfs(0, 0, maps);
    }

    private void init(int[][] maps) {
        height = maps.length;
        width = maps[0].length;
        visited = new boolean[height][width];
    }

    private int bfs(int x, int y, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == height - 1 && node.y == width - 1) {
                return node.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + DX[i];
                int ny = node.y + DY[i];
                if (nx >= 0 && ny >= 0 && nx < height && ny < width) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
