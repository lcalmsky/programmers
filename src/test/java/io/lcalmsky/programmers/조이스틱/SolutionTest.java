package io.lcalmsky.programmers.조이스틱;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 반환")
    public void test() {
        assertAll(
                () -> test("JEROEN", 56),
                () -> test("JAN", 23),
                () -> test("AAA", 0),
                () -> test("BBAAA", 3),
                () -> test("AAAB", 2)

        );
    }

    private void test(String given, int expected) {
        // when
        int actual = new Solution().solution(given);

        // then
        assertEquals(expected, actual);
    }
}
