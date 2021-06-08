package io.lcalmsky.programmers.문자열_압축;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void testAll() {
        Assertions.assertAll(
                () -> test("aabbaccc", 7),
                () -> test("ababcdcdababcdcd", 9),
                () -> test("abcabcdede", 8),
                () -> test("abcabcabcabcdededededede", 14),
                () -> test("xababcdcdababcdcd", 17)
        );
    }

    private void test(String given, int expected) {
        Solution solution = new Solution();
        int result = solution.solution(given);
        assertThat(result).isEqualTo(expected);
    }
}