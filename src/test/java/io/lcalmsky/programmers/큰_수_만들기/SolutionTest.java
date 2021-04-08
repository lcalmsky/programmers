package io.lcalmsky.programmers.큰_수_만들기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 반환")
    public void test() {
        assertAll(
                () -> test("1924", 2, "94"),
                () -> test("1231234", 3, "3234"),
                () -> test("4177252841", 4, "775841"),
                () -> test("12", 1, "2"),
                () -> test("21", 1, "2"),
                () -> test("1", 0, "1")

        );
    }

    private void test(String number, int k, String expected) {
        // when
        String actual = new Solution().solution(number, k);

        // then
        assertEquals(expected, actual);
    }
}
