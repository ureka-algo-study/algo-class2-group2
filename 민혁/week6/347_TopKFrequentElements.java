import java.util.*;
import java.util.Map.Entry; // EntrySet을 써야할 때 import 필요

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map에 저장 -> value를 기준으로 정렬 -> k번째까지에 해당하는 key를 가져오기


        // 초기 저장 변수
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 몇번씩 나왔는지 map에 저장
        for(int i = 0; i < nums.length; i ++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        // EntrySet을 받아오고 value의 내림차순으로 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        // 정렬된 EntrySet 에서 k 만큼 가져오기
        for(int i = 0; i < k; i ++) {
            Entry<Integer,Integer> entry = list.get(i);
            result.add(entry.getKey());
        }


        return result.stream().mapToInt(i -> i).toArray();



    }
}