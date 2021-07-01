package io.lcalmsky.programmers.예상_대진표;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("통합 테스트")
    public void testAll() {
        assertAll(
                () -> test(8, 4, 7, 3),
                () -> test(2, 1, 2, 1),
                () -> test(4, 3, 4, 1)
        );
    }

    private void test(int n, int a, int b, int expected) {
        // given
        Solution solution = new Solution();
        // when
        int actual = solution.solution(n, a, b);
        // then
        assertEquals(expected, actual);
    }

}