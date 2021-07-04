package io.lcalmsky.coupang.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test("82195", "64723", 13)
//                () -> test("00000000000000000000", "91919191919191919191", 20)
        );
    }

    private void test(String p, String s, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.solution(p, s);

        // then
        assertEquals(expected, actual);
    }
}