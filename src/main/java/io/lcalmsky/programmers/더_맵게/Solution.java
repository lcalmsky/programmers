package io.lcalmsky.programmers.더_맵게;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for(int s : scoville) priorityQueue.offer(s);
        int mix, count = 0;
        while(priorityQueue.peek() <= K) {
            if(priorityQueue.size() == 1) return -1;
            int lowest = priorityQueue.poll();
            int nextLower = priorityQueue.poll();
            mix = lowest + 2 * nextLower;
            priorityQueue.offer(mix);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1}, 9));
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1}, 10));
    }
}
