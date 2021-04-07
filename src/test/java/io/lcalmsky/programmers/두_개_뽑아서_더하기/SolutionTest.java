package io.lcalmsky.programmers.두_개_뽑아서_더하기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    @DisplayName("정수 배열의 서로 다른 인덱스에 있는 두 수를 더해 만들 수 있는 모든 수를 오름차순 정렬하여 반환")
    public void test() {
        assertAll(
                () -> test(new int[]{2, 1, 3, 4, 1}, new int[]{2, 3, 4, 5, 6, 7}),
                () -> test(new int[]{5, 0, 2, 7}, new int[]{2, 5, 7, 9, 12})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.solution(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
