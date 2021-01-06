package io.lcalmsky.programmers.위장;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        String kinds;
        for (String[] cloth : clothes) {
            kinds = cloth[1];
            clothesMap.put(kinds, clothesMap.getOrDefault(kinds, 0) + 1);
        }
        Integer sum = clothesMap.values()
                .stream()
                .map(i -> i + 1)
                .reduce(1, (a, b) -> a * b);
        return sum - 1;
    }
}
