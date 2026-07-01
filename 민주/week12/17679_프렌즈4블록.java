import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        
        char[][] new_board = new char[m][n];
        
        for(int i=0; i<m; i++){
            new_board[i] = board[i].toCharArray();
        }
        
        // int test = 0;
        while(true){ //test++ < 5
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(new_board[i][j] == '#') continue;
                    if(new_board[i][j] != new_board[i][j+1]) continue;
                    if(new_board[i][j] != new_board[i+1][j]) continue;
                    if(new_board[i][j] != new_board[i+1][j+1]) continue;

                    set.add(i+","+j);
                    set.add(i+","+(j+1));
                    set.add((i+1)+","+j);
                    set.add((i+1)+","+(j+1));
                }
            }

            answer += set.size();

            if(set.size() == 0) break;
            
            for(String cur : set){
                StringTokenizer token = new StringTokenizer(cur,",");
                int i = Integer.parseInt(token.nextToken());
                int j = Integer.parseInt(token.nextToken());
                new_board[i][j] = '#';
            }

            
            // for(int i=0; i<m; i++){
            //     System.out.println(Arrays.toString(new_board[i]));
            // }
            // System.out.println("****************************" + set.size());
            
            for(int i=m-1; i>=0; i--){
                for(int j=0; j<n; j++){
                    if(new_board[i][j] == '#'){
                        int ni = i-1;
                        while(ni>=0 && (new_board[ni][j] == '#')){
                            ni--;
                        }
                        if(ni>=0){
                            new_board[i][j] = new_board[ni][j];
                            new_board[ni][j] = '#';
                        }
                    }
                }
            }
            
            // for(int i=0; i<m; i++){
            //     System.out.println(Arrays.toString(new_board[i]));
            // }
            // System.out.println("------------------------------");
        }
        return answer;
    }
}