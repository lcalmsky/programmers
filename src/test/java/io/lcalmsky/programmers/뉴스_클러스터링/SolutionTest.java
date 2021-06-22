package io.lcalmsky.programmers.뉴스_클러스터링;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    @DisplayName("통합 테스트")
    public void testAll() {
        assertAll(
                () -> test("FRANCE", "french", 16384),
                () -> test("handshake", "shake hands", 65536),
                () -> test("aa1+aa2", "AAAA12", 43690),
                () -> test("E=M*C^2", "e=m*c^2", 65536)
        );
    }

    private void test(String s1, String s2, int expected) {
        // given
        Solution solution = new Solution();
        // when
        int actual = solution.solution(s1, s2);
        // then
        assertEquals(expected, actual);
    }
}
