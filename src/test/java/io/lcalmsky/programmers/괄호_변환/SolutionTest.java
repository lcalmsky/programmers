package io.lcalmsky.programmers.괄호_변환;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test("(()())()", "(()())()"),
                () -> test(")(", "()"),
                () -> test("()))((()", "()(())()")
        );
    }

    private void test(String given, String expected) {
        // given
        Solution solution = new Solution();
        // when
        String actual = solution.solution(given);
        // then
        assertEquals(expected, actual);
    }
}