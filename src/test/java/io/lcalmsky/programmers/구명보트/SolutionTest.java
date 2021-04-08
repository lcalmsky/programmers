package io.lcalmsky.programmers.구명보트;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("사람을 모두 옮기는데 구명보트를 최소한으로 사용한 횟수 반환")
    public void test() {
        assertAll(
                () -> test(new int[]{50, 70, 50, 80}, 100, 3)
        );
    }

    private void test(int[] people, int limit, int expected) {
        // when
        int actual = new Solution().solution(people, limit);

        // then
        assertEquals(expected, actual);
    }
}
