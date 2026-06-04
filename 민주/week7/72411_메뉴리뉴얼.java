import java.util.*;

class Solution {
    char[] combi;
    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>(); 
        
        for(int len : course){
            map = new HashMap<>();
            combi = new char[len];
            
            for(String order : orders){
                char[] sort = order.toCharArray();
                
                Arrays.sort(sort);
                order = new String(sort);
                
                combination(order, 0, 0, len);
            }
            
            int max = 0;
            for(int cnt : map.values()){
                if(cnt >= 2){
                    max = Math.max(max, cnt);
                }
            }
            
            for(String key : map.keySet()){
                if(map.get(key) == max && max >= 2){
                    ans.add(key);
                }
            }
            
        }
        
        Collections.sort(ans);
        answer = ans.toArray(new String[0]);
        return answer;
    }
    
    
    void combination(String str, int n, int idx, int len){
        if(idx >= len){
            String tmp = "";
            for(int i=0; i<len; i++){
                tmp += combi[i];
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            return ;
        }
        for(int i=n; i<str.length(); i++){
            combi[idx] = str.charAt(i);
            combination(str, i+1, idx+1, len);
        }
    }
}