package io.lcalmsky.programmers.기능개발;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution()
                .solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))
        );
        ;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            queue.add(remain % speeds[i] == 0 ?
                    remain / speeds[i] :
                    remain / speeds[i] + 1
            );
        }
        List<Integer> list = new ArrayList<>();
        int previousWork = queue.poll();
        int numberOfWorks = 1;
        while (!queue.isEmpty()) {
            int currentWork = queue.poll();
            if (previousWork >= currentWork) {
                numberOfWorks++;
            } else {
                list.add(numberOfWorks);
                numberOfWorks = 1;
                previousWork = currentWork;
            }
        }
        list.add(numberOfWorks);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
