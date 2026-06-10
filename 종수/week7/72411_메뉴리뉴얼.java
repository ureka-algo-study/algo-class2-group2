package 종수.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, Integer> map;
    int max;

    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        for (int len : course) {

            map = new HashMap<>();
            max = 0;

            for (String order : orders) {

                if (order.length() < len) {
                    continue;
                }

                char[] arr = order.toCharArray();
                Arrays.sort(arr);

                comb(arr, 0, 0, len, "");
            }

            if (max < 2) {
                continue;
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    private void comb(char[] arr, int start, int depth, int r, String result) {

        if (depth == r) {

            int count = map.getOrDefault(result, 0) + 1;
            map.put(result, count);

            max = Math.max(max, count);

            return;
        }

        for (int i = start; i < arr.length; i++) {
            comb(arr, i + 1, depth + 1, r, result + arr[i]);
        }
    }
}