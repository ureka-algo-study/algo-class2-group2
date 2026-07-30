import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();
    boolean[] selected;
    String[] user_id;
    String[] banned_id;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        this.user_id = user_id;
        this.banned_id = banned_id;
        selected = new boolean[user_id.length];
        
        dfs(0);
        
        
        return set.size();
    }
    
    public void dfs(int depth){
        if(depth >= banned_id.length) {
            set.add(Arrays.toString(selected));
            // System.out.println(Arrays.toString(selected));
            return ;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!selected[i] && is_banned(banned_id[depth], user_id[i])){
                selected[i] = true;
                dfs(depth+1);
                selected[i] = false;
            }
        }
        
    }
    
    public boolean is_banned(String banned, String user){
        if(banned.length() != user.length()){
            return false;
        }
        
        for(int i=0; i<banned.length(); i++){
            if(banned.charAt(i) == '*') continue;
            if(banned.charAt(i) != user.charAt(i)) return false;
        }
        return true;
        
    }
}