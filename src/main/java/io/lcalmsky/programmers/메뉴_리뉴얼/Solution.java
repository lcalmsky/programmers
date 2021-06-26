package io.lcalmsky.programmers.메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println("result = " + Arrays.toString(result));
    }

    public String[] solution(String[] orders, int[] course) {
        Map<Character, Integer> menuMap = new HashMap<>();
        for (String order : orders) {
            for (char menu : order.toCharArray()) {
                menuMap.put(menu, menuMap.getOrDefault(menu, 0) + 1);
            }
        }
        List<Map.Entry<Character, Integer>> entries = menuMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue)))
                .collect(Collectors.toList());
        System.out.println("entries = " + entries);
        List<String> combinations = new ArrayList<>();
        int entrySize = entries.size();
        StringBuilder menuBuilder;
        boolean[] peeked;
        for (int i = 0; i < course.length; i++) {
            int numberOfMenu = course[i];
            menuBuilder = new StringBuilder();
            peeked = new boolean[entrySize];
            addMenuRecursively(peeked, entries, menuBuilder, numberOfMenu, i, combinations);
//            if (numberOfMenu == menuBuilder.length()) {
//                char[] chars = menuBuilder.toString().toCharArray();
//                Arrays.sort(chars);
//                combinations.add(new String(chars));
//            }
        }
        return combinations.toArray(new String[0]);
    }

    private void addMenuRecursively(boolean[] peeked, List<Map.Entry<Character, Integer>> entries, StringBuilder menuBuilder, int numberOfMenu, int index, List<String> combinations) {
        if (menuBuilder.length() == numberOfMenu) {
            combinations.add(menuBuilder.toString());
            return;
        }
        if (index == combinations.size() - 1) {
            return;
        }
        if (!peeked[index]) {
            peeked[index] = true;
            menuBuilder.append(entries.get(index).getKey());
            addMenuRecursively(peeked, entries, menuBuilder, numberOfMenu, index + 1, combinations);
        }
    }
}
