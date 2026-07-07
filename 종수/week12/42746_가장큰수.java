package 종수.week12;

import java.util.Arrays;


class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }
}

// 31
// 3 31 34 5 9
// 9 5 34 3 31

// 33
// 9 5 34 3 33

// 32
// 9 5 34 3 32
//        32 3

// 3 31 32 33 34
// 34 33 32 31 3