package io.lcalmsky.programmers.괄호_회전하기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test("[](){}", 3),
                () -> test("}]()[{", 2),
                () -> test("[)(]", 0),
                () -> test("}}}", 0)
        );
    }

    private void test(String s, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.solution(s);
        // then
        assertEquals(expected, actual);
    }
}