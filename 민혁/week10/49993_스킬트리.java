import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        List<String> list = new ArrayList<>();
        String rgxSkill = "[^"+skill+"]";
        for(String skillTree : skill_trees) {
            String tf = skillTree.replaceAll(rgxSkill,"");
            list.add(tf);
        }
        int count = 0;
        for(String s : list) {
            if(skill.startsWith(s)) {
                count++;
            }
        }
        return count;

    }
}