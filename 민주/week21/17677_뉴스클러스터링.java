import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        HashSet<String> set = new HashSet<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        String sub1 = "";
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) < 'A' || str1.charAt(i) > 'Z') {
                sub1 = "";
                continue;
            }
            
            sub1 += str1.charAt(i) + "";
            
            if(sub1.length() == 2){
                // System.out.println(sub1);
                set.add(sub1);
                map1.put(sub1, map1.getOrDefault(sub1, 0)+1);
                sub1 = str1.charAt(i) + "";
            }
            
        }
        
        System.out.println("================");
        String sub2 = "";
        
        for(int i=0; i<str2.length(); i++){
            if(str2.charAt(i) < 'A' || str2.charAt(i) > 'Z') {
                sub2 = "";
                continue;
            }
            
            sub2 += str2.charAt(i) + "";
            
            if(sub2.length() == 2){
                // System.out.println(sub2);
                set.add(sub2);
                map2.put(sub2, map2.getOrDefault(sub2, 0)+1);
                sub2 = str2.charAt(i) + "";
            }
            
        }
        
        if(map1.size() + map2.size() == 0){
            return 65536;
        }
        
        int hap = 0;
        int gyo = 0;
        
        for(String key : set){
            int min = 987654321;
            int max = 0;
            
            if(map1.containsKey(key) && map2.containsKey(key)){
                min = map1.get(key);
                max = map1.get(key);
                min = Math.min(min, map2.get(key));
                max = Math.max(max, map2.get(key));
                gyo += min;
                hap += max;
            }
            else if (map1.containsKey(key)){
                hap += map1.get(key);
            }
            else {
                hap += map2.get(key);
            }
        }
        
        
        
        double div = (double) gyo/hap;
        // System.out.println(gyo + " / " + hap + " = " + div);
        return (int) (div * 65536);
    }
}