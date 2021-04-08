package io.lcalmsky.programmers.카펫;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    @DisplayName("카펫의 가로, 세로 크기를 순서대로 배열에 담아 반환")
    public void test() {
        assertAll(
                () -> test(10, 2, new int[]{4, 3}),
                () -> test(8, 1, new int[]{3, 3}),
                () -> test(24, 24, new int[]{8, 6})
        );
    }

    private void test(int brown, int yellow, int[] expected) {
        // when
        int[] actual = new Solution().solution(brown, yellow);

        // then
        assertArrayEquals(expected, actual);
    }
}
