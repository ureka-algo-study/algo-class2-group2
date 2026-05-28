class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int idx = 0;
        for(Map.Entry<Integer, Integer> entry: list){
            if(idx >= k) return answer;
            answer[idx++] = entry.getKey();
        }
        return answer;
    }
}