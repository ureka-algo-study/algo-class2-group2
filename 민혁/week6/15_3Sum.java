import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> set = new LinkedHashSet<>();

        // Arrays.sort(nums);

        // for (int i = 0; i < nums.length - 2; i++) {
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             int sum = nums[i] + nums[j] + nums[k];

        //             if (sum == 0) {
        //                 set.add(List.of(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(set); 시간초과


        Set<List<Integer>> resultSet = new LinkedHashSet<>();

        Arrays.sort(nums);

        // 하나 고정
        for (int i = 0; i < nums.length - 2; i++) {

            // 정렬에서 같은 값이 선택될 수 있음
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            Set<Integer> set = new HashSet<>();
            // 지나온 거 저장


            // 숫자 두개를 골랐을 때 0을 만들기 위해 need 가 필요
            for (int j = i + 1; j < nums.length; j++) {
                int need = -nums[i] - nums[j];

                // 지나오면서 need를 봤었나?
                if (set.contains(need)) {
                    resultSet.add(List.of(nums[i], need, nums[j]));
                }
                // 확인했다는 표시
                set.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);


    }
}