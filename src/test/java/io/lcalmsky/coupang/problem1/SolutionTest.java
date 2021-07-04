package io.lcalmsky.coupang.problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test(new String[]{"13123820 BusinessManagement AAA", "15047648 Economics AAA", "17869244 ComputerScience AAA", "19000000 ElectronicEngineering AAA", "14281264 Law AAA", "19000000 ElectronicEngineering BBB", "16188768 BusinessManagement BBB", "14634411 Law BBB", "16628760 Economics BBB", "14863606 BusinessManagement CCC", "13165700 Law CCC", "15215218 ComputerScience CCC"},
                        4,
                        3,
                        3,
                        1)
        );
    }

    private void test(String[] given, int n, int m, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.solution(given, n, m, k);

        // then
        assertEquals(expected, actual);
    }
}