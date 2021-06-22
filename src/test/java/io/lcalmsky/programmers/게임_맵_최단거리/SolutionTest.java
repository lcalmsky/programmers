package io.lcalmsky.programmers.게임_맵_최단거리;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("통합 테스트")
    void test() {
        assertAll(
                () -> test(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                }, 11),
                () -> test(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}
                }, -1)
        );
    }

    private void test(int[][] maps, int expected) {
        // given
        Solution solution = new Solution();
        // when
        int actual = solution.solution(maps);
        // then
        assertEquals(expected, actual);
    }

}
