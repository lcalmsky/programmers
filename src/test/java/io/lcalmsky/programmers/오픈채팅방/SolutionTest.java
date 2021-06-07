package io.lcalmsky.programmers.오픈채팅방;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        String[] result = solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }

}
