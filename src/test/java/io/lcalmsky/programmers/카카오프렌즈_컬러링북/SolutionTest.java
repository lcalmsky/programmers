package io.lcalmsky.programmers.카카오프렌즈_컬러링북;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] result = solution.solution(6, 4, new int[][]{
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        });
        assertThat(result).containsExactly(4, 5);
    }
}