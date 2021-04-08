package io.lcalmsky.programmers.땅따먹기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 반환")
    public void test() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 3, 5},
                        {5, 6, 7, 8},
                        {4, 3, 2, 1}
                }, 16)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        int actual = new Solution().solution(given);

        // then
        assertEquals(expected, actual);
    }
}
