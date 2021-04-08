package io.lcalmsky.programmers.구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        for (int light = 0, heavy = people.length - 1; light <= heavy; heavy--) {
            if (people[light] + people[heavy] <= limit) light++;
            count++;
        }
        return count;
    }
}
