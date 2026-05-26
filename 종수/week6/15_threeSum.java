package 종수.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        // 1. 정렬
        Arrays.sort(nums);

        int n = nums.length;

        // 2. 하나 고정
        for (int i = 0; i < n - 2; i++) {

            // 중복 제거
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            // 3. 투포인터
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // 합이 0이면
                if (sum == 0) {

                    answer.add(
                            Arrays.asList(
                                    nums[i],
                                    nums[left],
                                    nums[right]
                            )
                    );

                    // left 중복 제거
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // right 중복 제거
                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                // 합이 너무 작음
                else if (sum < 0) {
                    left++;
                }

                // 합이 너무 큼
                else {
                    right--;
                }
            }
        }

        return answer;
    }
}