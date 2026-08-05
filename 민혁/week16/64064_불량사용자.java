import java.util.*;

class Solution {
    
    static String[] userId;
    static String[] bannedId;
    static boolean[] visitedUser;
    static Set<String> set = new HashSet<>();
    static Set<Set<String>> result = new HashSet<>();
    // 안에 있는 set은 순서제거, 밖에 있는 set은 중복제거
    
    public int solution(String[] user_id, String[] banned_id) {
        /*
        응모자 아이디 8개
        벤 아이디 8개
        하나의 벤 아이디에 여러개의 응모자 아이디가 매칭될 수 있음
        기준을 응모자로 잡을지 벤 아이디로 잡을지...
        응모자 아이디가 벤 아이디와 매칭이 되는지 여부
        매칭이 됐을때 선택을 할수도있고 안할수도 있음
        */
        
      /*  
        boolean[] visitedUser = new boolean[user_id.length];
        boolean[] visitedBanned = new boolean[banned_id.length];
        int result = 0;
        
        for(int i = 0; i < user_id.length; i ++) {
            for(int j = 0; j < banned_id.length; j ++) {
                if(
                    isMatch(user_id[i], banned_id[j])
                    && !visitedUser[i]
                    && !visitedBanned[j]
                ) {
                    visitedUser[i] = true;
                    visitedBanned[j] = true;
                    break;
                } //if if문만큼 백트래킹
            } // for banned_id
        } //for user_id
        
        boolean flag = true; // 벤 아이디가 모두 처리됐는지 확인하는 flag
        for(int i = 0; i < visitedBanned.length; i ++) {
            if(!visitedBanned[i]) {
                flag = false;
            }
        }
        
        if(flag) {
            result++;
        }
        
        
        return result;
        
        
    }
    
    private boolean isMatch(String s1, String s2) {
        
        // 길이가 다르면 끝
        if(s1.length() != s2.length()) {
            return false;
        }
        
        // 같은 부분 문자열이 다름, *로 매칭이 안되면 끝
        for(int i = 0; i < s1.length(); i ++) {
            if(s1.charAt(i) != s2.charAt(i) && s2.charAt(i) != '*') {
                return false;
            }
        }
        
        // 필터를 모두 통과하면 매칭
        return true;
    }
    
    private void dfs(int start, int target, ) {
        if(
            isMatch(user_id[start], banned_id[target])
            && !visitedUser[start]
            && !visitedBanned[target]
        ) {
            visitedUser[start] = true;
            visitedBanned[target] = true;
        } //if if문만큼 백트래킹        
        
    }
    */
        userId = user_id;
        bannedId = banned_id;
        visitedUser = new boolean[userId.length];
        dfs(0);
        // System.out.println(result);
        return result.size();
    }
    
    private void dfs(int n) {
    
        // 종료조건
        if(n == bannedId.length) {
            result.add(new HashSet<>(set));
            return;
        }
        // 실행
        
        for(int i = 0; i < userId.length; i ++) {
                if(!visitedUser[i] && isMatch(userId[i], bannedId[n])) {
                    visitedUser[i] = true;
                    set.add(userId[i]);
                    dfs(n + 1);
                    set.remove(userId[i]);
                    visitedUser[i] = false;
            } // 1for
        } // 2for
    }
        
    private boolean isMatch(String s1, String s2) {

        // 길이가 다르면 끝
        if(s1.length() != s2.length()) {
            return false;
        }
        // 같은 부분 문자열이 다름, *로 매칭이 안되면 끝
        for(int i = 0; i < s1.length(); i ++) {
                if(s1.charAt(i) != s2.charAt(i) && s2.charAt(i) != '*') {                                   return false;
            }
        }

        // 필터를 모두 통과하면 매칭
        return true;        
    }
}
