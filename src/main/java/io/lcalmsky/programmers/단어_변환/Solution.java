package io.lcalmsky.programmers.단어_변환;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * 문제 설명
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 * 입출력 예
 * begin	target	words	return
 * hit	cog	[hot, dot, dog, lot, log, cog]	4
 * hit	cog	[hot, dot, dog, lot, log]	0
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.
 * </pre>
 */
public class Solution {

    private int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        dfs(new boolean[length], 0, begin, target, words);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public void dfs(boolean[] visited, int cnt, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOnlyOneAlphabetDifferent(begin, words[i])) {
                visited[i] = true;
                dfs(visited, cnt + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }

    private boolean isOnlyOneAlphabetDifferent(String begin, String word) {
        char[] beginChars = begin.toCharArray();
        char[] wordChars = word.toCharArray();
        int cnt = 0;
        for (int i = 0; i < beginChars.length; i++) {
            if (beginChars[i] != wordChars[i]) cnt++;
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }

    @Test
    public void ex01() {
        Solution solution = new Solution();
        int actual = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        Assert.assertEquals(4, actual);
    }

    @Test
    public void ex02() {
        Solution solution = new Solution();
        int actual = solution.solution("hot", "hit", new String[]{"hit", "dot", "dog", "lot", "log", "cog"});
        Assert.assertEquals(1, actual);
    }

    @Test
    public void methodTest() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isOnlyOneAlphabetDifferent("hit", "hot"));
        Assert.assertTrue(solution.isOnlyOneAlphabetDifferent("hot", "dot"));
        Assert.assertTrue(solution.isOnlyOneAlphabetDifferent("dot", "dog"));
        Assert.assertTrue(solution.isOnlyOneAlphabetDifferent("dog", "cog"));
    }
}
