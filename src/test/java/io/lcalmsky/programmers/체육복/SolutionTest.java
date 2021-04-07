package io.lcalmsky.programmers.체육복;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("체육 수업을 들을 수 있는 학생의 최댓값을 반환")
    public void test() {
        assertAll(
                () -> test(5, new int[]{2, 4}, new int[]{1, 3, 5}, 5),
                () -> test(5, new int[]{2, 4}, new int[]{3}, 4),
                () -> test(3, new int[]{3}, new int[]{1}, 2),
                () -> test(2, new int[]{1}, new int[]{2}, 2)
        );
    }

    private void test(int n, int[] lost, int[] reserve, int expected) {
        // when
        int actual = new Solution().solution(n, lost, reserve);

        // then
        assertEquals(expected, actual);
    }

}
