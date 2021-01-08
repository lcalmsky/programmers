package io.lcalmsky.programmers.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int truckWeight : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truckWeight);
                    answer += 1;
                    sum += truckWeight;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + truckWeight > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.add(truckWeight);
                        answer++;
                        sum += truckWeight;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
