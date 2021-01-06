package io.lcalmsky.programmers.cp.a;

import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution4().solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"})));
    }

    /**
     * 성적을 파싱해 과목과 등급으로 나눈 뒤 등급을 기준으로 정렬한다.
     * 이 때 map에 넣어둔 값을 이용해 내림차순으로 정렬한다.
     * 수강한 과목은 중복될 수 없으므로 Set에 넣어주면서 중복되지 않은 경우에만 리스트에 추가한 뒤 배열로 변환해 반환한다.
     *
     * @param grades 정리되기 전 성적표
     * @return 정리된 성적표
     * 정확성  테스트
     * 테스트 1 〉	통과 (1.04ms, 52.3MB)
     * 테스트 2 〉	통과 (1.31ms, 52.7MB)
     * 테스트 3 〉	통과 (2.48ms, 52.3MB)
     * 테스트 4 〉	통과 (5.66ms, 52.7MB)
     * 테스트 5 〉	통과 (19.37ms, 54.4MB)
     * 테스트 6 〉	통과 (18.07ms, 57MB)
     * 테스트 7 〉	통과 (58.00ms, 67.7MB)
     * 테스트 8 〉	통과 (191.24ms, 89.3MB)
     * 테스트 9 〉	통과 (334.23ms, 130MB)
     * 테스트 10 〉	통과 (350.88ms, 158MB)
     * 테스트 11 〉	통과 (337.24ms, 153MB)
     * 테스트 12 〉	통과 (271.69ms, 122MB)
     * 테스트 13 〉	통과 (375.25ms, 153MB)
     * 테스트 14 〉	통과 (380.90ms, 166MB)
     * 테스트 15 〉	통과 (356.31ms, 163MB)
     * 테스트 16 〉	통과 (374.77ms, 163MB)
     * 테스트 17 〉	통과 (342.70ms, 132MB)
     * 테스트 18 〉	통과 (94.00ms, 78.9MB)
     * 테스트 19 〉	통과 (319.75ms, 158MB)
     * 테스트 20 〉	통과 (350.24ms, 171MB)
     */
    public String[] solution(String[] grades) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A+", 13);
        map.put("A0", 12);
        map.put("A-", 11);
        map.put("B+", 10);
        map.put("B0", 9);
        map.put("B-", 8);
        map.put("C+", 7);
        map.put("C0", 6);
        map.put("C-", 5);
        map.put("D+", 4);
        map.put("D0", 3);
        map.put("D-", 2);
        map.put("F", 1);

        Arrays.sort(grades, (o1, o2) -> {
            int o1SpaceIndex = o1.indexOf(' ');
            int o2SpaceIndex = o2.indexOf(' ');
            return Integer.compare(map.get(o2.substring(o1SpaceIndex + 1)), map.get(o1.substring(o2SpaceIndex + 1)));
        });

        Set<String> set = new HashSet<>();
        List<String> unique = new ArrayList<>();
        for (String grade : grades) {
            int spaceIndex = grade.indexOf(' ');
            if (set.add(grade.substring(0, spaceIndex))) unique.add(grade);
        }

        String[] answer = new String[unique.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = unique.get(i);
        }

        return answer;
    }
}
