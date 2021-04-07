package io.lcalmsky.programmers.올바른_괄호;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("올바른 괄호이면 true를, 그렇지 않으면 false를 반환")
    public void test() {
        assertAll(
                () -> test("()()", true),
                () -> test("(())()", true),
                () -> test(")()(", false),
                () -> test("(()(", false)
        );
    }

    private void test(String given, boolean expected) {
        // when
        boolean actual = new Solution().solution(given);

        // then
        assertEquals(expected, actual);
    }

}
