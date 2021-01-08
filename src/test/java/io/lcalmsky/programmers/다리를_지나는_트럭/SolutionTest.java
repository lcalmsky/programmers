package io.lcalmsky.programmers.다리를_지나는_트럭;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    private Solution solution = new Solution();

    public void testCase01() {
        assertEquals(solution.solution(2, 10, new int[]{7, 4, 5, 6}), 8);
    }
    public void testCase02() {
        assertEquals(solution.solution(100, 100, new int[]{10}), 101);
    }
    public void testCase03() {
        assertEquals(solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }

}
