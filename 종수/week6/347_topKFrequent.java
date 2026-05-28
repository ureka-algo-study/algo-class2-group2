package 종수.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> map.get(b) - map.get(a));

        int[] answer = new int[k];

        for(int i = 0; i < k; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}