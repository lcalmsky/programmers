package io.lcalmsky.programmers.프린터;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int task : priorities) {
            queue.add(task);
            System.out.println(queue);
        }
        //{2,5,4,1,3};

        System.out.println(queue);
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!queue.isEmpty() && priorities[i] == queue.peek()) {
                    if (i == location) return answer;
                    queue.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}
