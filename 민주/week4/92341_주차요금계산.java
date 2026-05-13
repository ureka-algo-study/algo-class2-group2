import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(int i=0; i<records.length; i++){
            StringTokenizer token = new StringTokenizer(records[i]);
            String[] time = token.nextToken().split(":");
            String num = token.nextToken();
            String oper = token.nextToken();
            
            if(oper.equals("IN")){
                map.put(num, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            }
            else{
                if(result.containsKey(num)){
                    result.put(num, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - map.get(num) + result.get(num));
                }
                else{
                    result.put(num, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - map.get(num));
                }
                map.remove(num);
            }
        }
        
        for(String key : map.keySet()){
            if(result.containsKey(key)){
                result.put(key, 23*60 + 59 - map.get(key) + result.get(key));
            }
            else{
                result.put(key, 23*60 + 59- map.get(key));
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
        list.sort(Map.Entry.comparingByKey());
        int[] answer = new int[list.size()];
        int idx =0;
        for(Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getValue());
            int fee = fees[1];
            if(entry.getValue() > fees[0]){
                fee += Math.ceil((double)(entry.getValue() - fees[0]) / fees[2]) * fees[3];
            }
            answer[idx++] = fee;
            
        }
        
        return answer;
    }
}