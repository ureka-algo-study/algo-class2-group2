import java.util.*;
class Solution {

    static int count = 0;

    public int solution(String[] want, int[] number, String[] discount) {

        // want number map
        Map<String, Integer> need = new HashMap<>();
        for(int i = 0; i < want.length; i ++) {
            need.put(want[i],number[i]);
        }

        // discount 10 순회
        for(int i = 0; i <= discount.length - 10; i ++) {
            Set<String> keys = need.keySet();


            String[] target = new String[10];
            if(keys.contains(discount[i])) {
                for(int j = 0; j < 10; j ++) {
                    target[j] = discount[i + j];
                }
            } // String[] target

            Map<String, Integer> targetMap = new HashMap<>();
            for(String s : target) {
                targetMap.put(s,targetMap.getOrDefault(s,0) + 1);
            } // Map<String,Integer> targetMap

            if(need.equals(targetMap)) {
                count++;
            }

        }

        return count;

    }
}