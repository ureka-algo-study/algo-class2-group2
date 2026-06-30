import java.util.*;

class Solution {
    class string {
        String str;
        String head;
        int num;
        
        string(String str, String head, int num){
            this.str = str;
            this.head = head;
            this.num = num;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<string> list = new ArrayList<>();
        
        
        for(int i=0; i<files.length; i++){
            boolean is_num = false;
            String file = files[i];
            int start = 0;
            int end = 0;
            for(int j=0; j<file.length(); j++){
                if('0' <= file.charAt(j) && file.charAt(j) <= '9'){
                    if(!is_num){
                        start = j;
                    }
                    is_num = true;
                }
                else if(is_num){
                    end = j;
                    break;
                }
                
            }
            
            if(end == 0){
                end = file.length();
            }
            list.add(new string(file, file.substring(0, start), Integer.parseInt(file.substring(start, end))));
            
            // System.out.println(file.substring(num[i][0], num[i][1]));
        }
        
        Collections.sort(list, Comparator.comparing(a -> a.num));
        Collections.sort(list, Comparator.comparing( a -> a.head.toLowerCase() ) );
        
        for(int i=0; i<files.length; i++){
            answer[i] = list.get(i).str;
        }
        return answer;
    }
}