import java.util.*;
class Solution {
    public long solution(int[] weights) {
        /*
        1:1 1:2 1:3/2 1:4/3
        */
    
        long answer = 0;
        Arrays.sort(weights);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = weights.length - 1; i >= 0; i--) {
            
            int lookingAt = weights[i];
            
            answer += map.getOrDefault(weights[i], 0);
            answer += map.getOrDefault(weights[i] * 2, 0);
            if(lookingAt % 2 == 0) {
                answer += map.getOrDefault(weights[i] * 3 / 2, 0);    
            }
            if(lookingAt % 3 == 0) {
                answer += map.getOrDefault(weights[i] * 4 / 3, 0);   
            }
            
            map.put(weights[i],map.getOrDefault(weights[i], 0) + 1);
        }
                    
        return answer;
        // 100 100 180 270 360 -> 360 270 180 100 100
        // map 360 : 1 270 : 1
        // answer 2
    }
}
