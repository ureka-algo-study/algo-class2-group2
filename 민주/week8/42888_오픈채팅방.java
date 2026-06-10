import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        String[] oper = new String[record.length];
        String[] id = new String[record.length];
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            StringTokenizer token = new StringTokenizer(record[i]);
            
            oper[i] = token.nextToken();
            id[i] = token.nextToken();
            
            if(oper[i].equals("Leave")) continue;
            
            map.put(id[i], token.nextToken());
            
        }
        
        for(int i=0; i<record.length; i++){
            if(oper[i].equals("Enter")){
                ans.add(map.get(id[i]) + "님이 들어왔습니다.");
            }
            else if(oper[i].equals("Leave")){
                ans.add(map.get(id[i]) + "님이 나갔습니다.");
            }
        }
        answer = ans.toArray(new String[0]);
        return answer;
    }
}