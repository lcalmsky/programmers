package io.lcalmsky.programmers.짝지어_제거하기;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void testAll() {
        Assertions.assertAll(
                () -> test("baabaa", 1),
                () -> test("cdcd", 0)
        );
    }

    private void test(String given, int expected) {
        Solution solution = new Solution();
        assertThat(solution.solution(given)).isEqualTo(expected);
    }
}