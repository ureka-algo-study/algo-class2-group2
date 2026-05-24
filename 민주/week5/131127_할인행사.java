import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], 0);
            wantMap.put(want[i], number[i]);
        }
        
        boolean found = true;
        
        for(int start=0; start<=discount.length-10; start++){
            if(!map.containsKey(discount[start])) continue;
            
            for(int i=0; i<10; i++){
                if(!map.containsKey(discount[start+i])){
                    // System.out.println(start + " : " + "!contain " + discount[start+i] + "(" + (start+i) + ")");
                    found = false;
                    break;
                }
                
                if(map.get(discount[start+i]) + 1 <= wantMap.get(discount[start+i])){
                    map.put(discount[start+i], map.get(discount[start+i]) + 1);
                }
                else{
                    // System.out.println(start + " : " + "trash " + discount[start+i] + "(" + (start+i) + ")");
                    found = false;
                    break;
                }
            }
            if(found){
                answer++;
                // System.out.println(start);
            }
            for(int j=0; j<want.length; j++){
                map.put(want[j], 0);
            }
            found = true;
        }
        return answer;
    }
}