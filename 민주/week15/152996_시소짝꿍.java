import java.util.*;


class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++){
            if(map.size() == 0){
                map.put(weights[i], 1);
                continue;
            }
            
            if(map.containsKey(weights[i])){
                answer += map.get(weights[i]);
            }
            if(weights[i] % 2 == 0 && map.containsKey(weights[i]/2)){
                answer += map.get(weights[i]/2);
            }
            if(weights[i] % 3 == 0 && map.containsKey(weights[i]/3 * 2)){
                answer += map.get(weights[i]/3 * 2);
            }
            if(weights[i] % 4 == 0 && map.containsKey(weights[i]/4 * 3)){
                answer += map.get(weights[i]/4 * 3);
            }
            map.put(weights[i], map.getOrDefault(weights[i], 0) +1);
        }
        return answer;
    }
}