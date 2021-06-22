package io.lcalmsky.programmers.뉴스_클러스터링;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static final int INT = 65536;

    public int solution(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) return 1;
        Map<String, Integer> map1 = createMapFrom(str1);
        Map<String, Integer> map2 = createMapFrom(str2);
        Set<String> keySet1 = map1.keySet();
        Set<String> keySet2 = map2.keySet();
        int intersection = 0;
        for (String key1 : keySet1) {
            for (String key2 : keySet2) {
                if (key1.equals(key2)) {
                    intersection += Math.min(map1.get(key1), map2.get(key2));
                }
            }
        }
        for (String key : keySet2) {
            map1.put(key, Math.max(map1.getOrDefault(key, 0), map2.get(key)));
        }
        int union = map1.keySet().stream().mapToInt(map1::get).sum();
        if (intersection == 0 && union == 0) return INT;
        return (int) ((float) intersection / union * INT);
    }

    private Map<String, Integer> createMapFrom(String str1) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String substring = str1.substring(i, i + 2).toLowerCase();
            if (containsOnlyAlphabet(substring.toCharArray())) {
                map.compute(substring, (k, v) -> map.getOrDefault(k, 0) + 1);
            }
        }
        return map;
    }

    private boolean containsOnlyAlphabet(char[] chars) {
        for (char c : chars) {
            if (!Character.isAlphabetic(c)) return false;
        }
        return true;
    }
}
