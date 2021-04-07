package io.lcalmsky.programmers.다음_큰_숫자;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 반환")
    public void test() {
        assertAll(
                () -> test(78, 83),
                () -> test(15, 23)
        );
    }

    private void test(int given, int expected) {
        // when
        int actual = new Solution().solution(given);

        // then
        assertEquals(expected, actual);
    }
}
