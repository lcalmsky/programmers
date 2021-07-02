package io.lcalmsky.programmers.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Edge> pq;
    ArrayList<ArrayList<Edge>> adj;
    int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        pq = new PriorityQueue<>();
        adj = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; ++i) adj.add(new ArrayList<>());

        for (int i = 0; i < road.length; ++i) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }

        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        dijkstra();

        for (int distance : dist) {
            if (distance <= K) answer++;
        }

        return answer;
    }

    private void dijkstra() {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            for (Edge ne : adj.get(e.to)) {
                if (dist[ne.to] > dist[e.to] + ne.weight) {
                    dist[ne.to] = dist[e.to] + ne.weight;
                    pq.offer(ne);
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }
}
