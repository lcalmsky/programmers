package io.lcalmsky.coupang.problem3;

/**
 * <pre>
 * 잠겨 있는 다이얼 자물쇠가 있습니다. 이 자물쇠를 풀기 위해서는 비밀번호를 눈금선에 맞추어야 합니다. 현재 눈금선에 맞추어져 있는 수의 각 자리를 정방향, 또는 역방향으로 회전하여 비밀번호의 수와 맞출 수 있습니다. 이 때, 자물쇠를 풀기 위해 회전시키는 횟수의 최솟값을 구하려고 합니다. 예를 들어, 현재 눈금선의 숫자는 "82195" 이고, 비밀번호가 "64723" 이라면 다음과 같은 연산을 거쳐 자물쇠를 풀 수 있습니다.
 *
 * 1번째 비밀번호 : 8→ 7→ 6 (역방향 2회)
 * 2번째 비밀번호 : 2→ 3→ 4 (정방향 2회)
 * 3번째 비밀번호 : 1→ 0→ 9→ 8→ 7 (역방향 4회)
 * 4번째 비밀번호 : 9→ 0→ 1→ 2 (정방향 3회)
 * 5번째 비밀번호 : 5→ 4→ 3 (역방향 2회)
 * 총 횟수 : 13회
 * 물론 이 방법 이외에도 다른 방법으로 회전시켜 자물쇠를 풀 수 있지만, 해당 방법보다 더 작은 횟수로 자물쇠를 푸는 방법은 없습니다. 따라서 최솟값은 13이 됩니다. 현재 눈금선에 있는 숫자 P와, 비밀번호 S가 매개변수로 주어질 때, 자물쇠를 풀기 위한 최소 회전 횟수를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 비밀번호의 길이 : 1000 자리 이하의 자연수
 * </pre>
 */
public class Solution {
    public int solution(String p, String s) {
        int[] currentNumbers = new int[p.length()];
        mapStringToNumbers(p, currentNumbers, p.length());
        int[] passwordNumbers = new int[s.length()];
        mapStringToNumbers(s, passwordNumbers, passwordNumbers.length);

        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            int currentNumber = currentNumbers[i];
            int passwordNumber = passwordNumbers[i];
            int diff = Math.abs(currentNumber - passwordNumber);
            count += currentNumber >= passwordNumber
                    ? Math.min(passwordNumber + 10 - currentNumber, diff)
                    : Math.min(currentNumber + 10 - passwordNumber, diff);
        }

        return count;
    }

    private void mapStringToNumbers(String p, int[] currentNumbers, int length) {
        for (int i = 0; i < length; i++) {
            char c = p.charAt(i);
            currentNumbers[i] = c - '0';
        }
    }
}
