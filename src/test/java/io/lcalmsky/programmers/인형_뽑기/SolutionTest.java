package io.lcalmsky.programmers.인형_뽑기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("크레인을 모두 작동시킨 뒤 터려져 사라진 인형 갯수를 구하라")
    public void test() {
        assertAll(
                () -> test(new int[][]{
                                {0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 3},
                                {0, 2, 5, 0, 1},
                                {4, 2, 4, 4, 2},
                                {3, 5, 1, 3, 1}
                        }, new int[]{1, 5, 3, 5, 1, 2, 1, 4},
                        4
                )
        );
    }

    private void test(int[][] board, int[] moves, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.solution(board, moves);

        // then
        assertEquals(expected, actual);
    }
}
