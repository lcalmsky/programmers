package io.lcalmsky.programmers.두_개_뽑아서_더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < length - 1; i++) for (int j = i + 1; j < length; j++) sumSet.add(numbers[i] + numbers[j]);
        int[] result = new int[sumSet.size()];
        int i = 0;
        for (Iterator<Integer> iterator = sumSet.iterator(); iterator.hasNext(); i++) result[i] = iterator.next();
        Arrays.sort(result);
        return result;
    }
}
