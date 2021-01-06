package io.lcalmsky.programmers.cp.a;

import java.util.Arrays;

public class Solution5 {

    public static void main(String[] args) {
        System.out.println(new Solution5().solution(new int[]{5, 3, 9, 13}, 8));
    }

    /**
     * 배열을 정렬한 뒤 작은 값에서 큰 값으로, 큰 값에서 작은 값으로 탐색하며 합을 찾는다.
     *
     * @param arr 서로 다른 자연수로 이루어진 배열
     * @param n   합하여 만들 숫자
     * @return 가능 여부
     */
    public boolean solution(int[] arr, int n) {
        Arrays.sort(arr);
        int leftValue, rightValue, sum;
        for (int left = 0, right = arr.length - 1; left < right; ) {
            leftValue = arr[left];
            rightValue = arr[right];
            sum = leftValue + rightValue;
            if (sum == n) return true;
            if (sum > n) right--;
            else left++;
        }
        return false;
    }
}
