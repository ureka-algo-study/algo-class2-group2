import java.util.*;


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i), i+1);
        }
        
        for(String skill_tree : skill_trees){
            int idx = 1;
            boolean check = true;
            for(int i=0; i<skill_tree.length(); i++){
                if(!map.containsKey(skill_tree.charAt(i))) continue;
                if(idx < map.get(skill_tree.charAt(i))){
                    // System.out.println(skill_tree + " : " + map.get(skill_tree.charAt(i)));
                    check = false;
                    break;
                }
                else{
                    idx++;
                }
                
            } // for i
            
            if(check) answer++;
        }
        return answer;
    }
}