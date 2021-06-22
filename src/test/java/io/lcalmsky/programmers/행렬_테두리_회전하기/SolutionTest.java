package io.lcalmsky.programmers.행렬_테두리_회전하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void testAll() {
        Assertions.assertAll(
                () -> test(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}, new int[]{8, 10, 25}),
                () -> test(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}, new int[]{1, 1, 5, 3}),
                () -> test(100, 97, new int[][]{{1, 1, 100, 97}}, new int[]{1})
        );
    }

    private void test(int rows, int columns, int[][] queries, int[] expected) {
        Solution solution = new Solution();
        assertThat(solution.solution(rows, columns, queries)).containsExactly(expected);
    }

}
