import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(String[] grid) {
        /*
        각 점의 상하좌우로 빛이 들어왔을떄를 탐색
        visited 배열 사용 -> 방향을 포함
        가질수있는 방향값이 유한함 -> 하나의 경로는 언젠가 다시 돌아온다
        두가지 경로가 하나의 경로로 합쳐지는 경우는 없음 -> 하나의 경로는 이전에 하나의 경로를 가짐
        */
        int[] dr = new int[] {-1,1,0,0}; 
        int[] dc = new int[] {0,0,-1,1}; // 상하좌우
        
        int row = grid.length;
        int column = grid[0].length();
        
        boolean visited[][][] = new boolean[row][column][4];
        
        List<Integer> list = new ArrayList<>();
        
        for(int r = 0; r < row; r ++) {
            for(int c = 0; c < column; c++) {
              for(int i = 0; i < 4; i ++) {
                  
                  if(visited[r][c][i]) {
                      continue; // 이미 확인했으면 continue
                  }
                  
                  int count = 0;
                  int currentR = r;
                  int currentC = c;
                  int currentDir = i;
                  
                  while(!visited[currentR][currentC][currentDir]) { // 경로를 다시 돌아올 떄까지 계속 확인
    
                      visited[currentR][currentC][currentDir] = true;
                      
                      char now = grid[currentR].charAt(currentC);
                      
                      if(now == 'L') {
                          if(currentDir == 0) { // 0,1,2,3 상하좌우
                              currentDir = 2; // 상 -> 좌
                          } else if(currentDir == 1) {
                              currentDir = 3; // 하 -> 우
                          } else if(currentDir == 2) {
                              currentDir = 1; // 좌 -> 하
                          } else if(currentDir == 3) {
                              currentDir = 0; // 우 -> 상
                          }
                      } else if (now == 'R') {
                          if(currentDir == 0) {
                              currentDir = 3; 
                          } else if(currentDir == 1) {
                              currentDir = 2;
                          } else if(currentDir == 2) {
                              currentDir = 0;
                          } else if(currentDir == 3) {
                              currentDir = 1;
                          }
                      }
                      
                      currentR = (currentR + dr[currentDir] + row) % row;
                      currentC = (currentC + dc[currentDir] + column) % column;
                      
                      count++;
                      
                  } // while
                  
                  list.add(count);
              } //fori 
            } //forc
        } //forr
        
        return list.stream().sorted().mapToInt(i -> i).toArray();
        
    } //solution
} //class
