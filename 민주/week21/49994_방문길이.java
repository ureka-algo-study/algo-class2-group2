import java.util.*;

class Solution {
    public int solution(String dirs) {
        // int answer = 0;
        HashSet<String> set = new HashSet<>();
        
        int x = 0;
        int y = 0;
        
        int[] di = {0,0,1,-1}; // RLDU
        int[] dj = {1,-1,0,0};
        int idx = -1;
        
        for(int i=0; i<dirs.length(); i++){
            
            if(dirs.charAt(i) == 'U'){
                idx = 2;
            }
            else if(dirs.charAt(i) == 'D'){
                idx = 3;
            }
            else if(dirs.charAt(i) == 'L'){
                idx = 1;
            }
            else if(dirs.charAt(i) == 'R'){
                idx = 0;
            }
            int nx = x + di[idx];
            int ny = y + dj[idx];
            
            if(nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;
            
            // System.out.println(x + "," +y + "=>" + nx + "," + ny);
            set.add(new String(nx + "," +ny + "=>" + x + "," + y));
            set.add(new String(x + "," +y + "=>" + nx + "," + ny));
            x = nx;
            y = ny;
            
        }
        return set.size()/2;
    }
}