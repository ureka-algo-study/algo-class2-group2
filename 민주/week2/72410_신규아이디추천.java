import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length(); i++){
            if((new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z') 
              || (new_id.charAt(i) >= '0') && (new_id.charAt(i) <= '9')
              || new_id.charAt(i) == '-' || new_id.charAt(i) == '_'
              || new_id.charAt(i) == '.'){
                sb.append(new_id.charAt(i));
            } //if
        } //for i
        new_id = sb.toString();
        System.out.println(new_id);
        sb = new StringBuilder();
        
        boolean skip = false;
        for(int i=0; i<new_id.length(); i++){
            if(skip && new_id.charAt(i) == '.') continue;
            if(new_id.charAt(i) == '.'){
                skip = true;
            }
            else{
                skip = false;
            }
            sb.append(new_id.charAt(i));
            
        } //for i
        
        new_id = sb.toString();
        System.out.println(new_id);
        
        if (sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        new_id = sb.toString();
        System.out.println(new_id);
        
        if(sb.length() == 0){
            sb.append("a");
        }
        while(sb.length() > 15){
            sb.deleteCharAt(15);
        }
        System.out.println("6: "+ sb.toString());
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        new_id = sb.toString();
        while(sb.length() <= 2){
            sb.append(sb.charAt(sb.length()-1));
        }
        
        return sb.toString();
    }
}