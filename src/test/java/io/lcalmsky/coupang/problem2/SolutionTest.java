package io.lcalmsky.coupang.problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 5, 5}, 6, 9, 2),
                () -> test(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 5, 5}, 9, 6, 3),
                () -> test(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 9, 10, 10, 11, 11}, 16, 13, 3)
        );
    }

    private void test(int[] matches, int me, int opp, int expected) {
        // when
        Solution2 solution = new Solution2();
        int actual = solution.solution(matches, me, opp);

        // then
        assertEquals(expected, actual);
    }
}