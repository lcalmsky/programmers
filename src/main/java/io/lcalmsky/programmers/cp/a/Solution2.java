package io.lcalmsky.programmers.cp.a;

/**
 * <pre>
 * 문제 설명
 * N개의 원소를 가진 수열 A가 있습니다. 수열의 i 번째 수부터 j 번째 수까지의 합이 S가 되도록 하는 (i, j) 쌍의 개수를 구하려고 합니다(단, i ≤ j ). 1차원 배열 형태의 수열 A와 자연수 S가 매개변수로 주어질 때, 가능한 (i, j) 쌍의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * A는 자연수가 들어있는 1차원 배열이며, 길이는 100,000 이하입니다.
 * A의 원소는 2,000 이하의 자연수입니다.
 * S는 2,000 이하의 자연수입니다.
 * 입출력 예
 * A	S	result
 * [1,1,1,1]	3	2
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 첫 번째 수부터 세 번째 수까지의 합이 3입니다.
 * 두 번째 수부터 네 번째 수까지의 합이 3입니다.
 * 따라서, 수열의 i 번째 수부터 j 번째 수까지의 합이 S가 되도록 하는 (i, j) 쌍은 (1, 3), (2, 4)로 두 개가 있습니다.
 * </pre>
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new int[]{1, 1, 1, 1}, 3));
    }

    /**
     * A 배열의 원소를 순차적으로 더해 sum과 같아질 때 쌍의 갯수를 1 더하고 그렇지 않으면 다음 차순의 원소부터 다시 시작한다.
     *
     * @param A 자연수가 들어있는 1차원 배열, 길이는 100,000 이하, 2,000 이하의 자연수
     * @param S 배열의 i~j번 째 원소의 합, 2,000 이하의 자연수
     * @return (i, j)의 쌍 갯수
     */
    public int solution(int[] A, int S) {
        int answer = 0, sum;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum > S) break;
                if (sum == S) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
