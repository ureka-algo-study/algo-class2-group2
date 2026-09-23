import java.util.*;

class Solution {
    
    static int[][] BOARD;
    
    class Drone {
        public int position; //0이면 가로 1이면 세로라 하자
        public int[] left_wing;
        public int[] right_wing;

        public Drone() {
            this.position = 0;
            this.left_wing = new int[]{0, 0};
            this.right_wing = new int[]{0, 1};
        }
        
        public Drone(Drone drone) {
            this.position = drone.position;

            this.left_wing = new int[]{
                drone.left_wing[0],
                drone.left_wing[1]
            };

            this.right_wing = new int[]{
                drone.right_wing[0],
                drone.right_wing[1]
            };
        }
        
        public void up() {
            if(
                left_wing[0] - 1 < 0 ||
                right_wing[0] -1 < 0 ||
                BOARD[left_wing[0] - 1][left_wing[1]] == 1 ||
                BOARD[right_wing[0] - 1][right_wing[1]] == 1
            ) {
                return;
            }
            left_wing[0]--;
            right_wing[0]--;
        }
        
        public void down() {
            if(
                left_wing[0] + 1 >= BOARD.length ||
                right_wing[0] + 1 >= BOARD.length ||
                BOARD[left_wing[0] + 1][left_wing[1]] == 1 ||
                BOARD[right_wing[0] + 1][right_wing[1]] == 1
            ) {
                return;
            }
            left_wing[0]++;
            right_wing[0]++;
        }
        
        public void left() {
            if(
                left_wing[1] - 1 < 0 ||
                right_wing[1] - 1 < 0 ||
                BOARD[left_wing[0]][left_wing[1] - 1] == 1 ||
                BOARD[right_wing[0]][right_wing[1] - 1] == 1
              ) {
                return;
            }
            left_wing[1]--;
            right_wing[1]--;
        }
        
        public void right() {
            if(
                right_wing[1] + 1 == BOARD.length ||
                right_wing[1] + 1 == BOARD.length ||
                BOARD[left_wing[0]][left_wing[1] + 1] == 1 ||
                BOARD[right_wing[0]][right_wing[1] + 1] == 1
              ) {
                return;
            }
            left_wing[1]++;
            right_wing[1]++;
        }
        
        public void left_up() {
            if (position == 0) {
                if (
                    left_wing[0] - 1 < 0 ||
                    right_wing[0] - 1 < 0 ||
                    BOARD[left_wing[0] - 1][left_wing[1]] == 1 ||
                    BOARD[right_wing[0] - 1][right_wing[1]] == 1
                ) {
                    return;
                }
                right_wing[0]--;
                right_wing[1]--;

                int[] temp = left_wing;
                left_wing = right_wing;
                right_wing = temp;
                position = 1;
            } else {
                if (
                    left_wing[1] + 1 >= BOARD[0].length ||
                    right_wing[1] + 1 >= BOARD[0].length ||
                    BOARD[left_wing[0]][left_wing[1] + 1] == 1 ||
                    BOARD[right_wing[0]][right_wing[1] + 1] == 1
                ) {
                    return;
                }
                right_wing[0]--;
                right_wing[1]++;
                position = 0;
            }
        }

        public void left_down() {
            if (position == 0) {
                if (
                    left_wing[0] + 1 >= BOARD.length ||
                    right_wing[0] + 1 >= BOARD.length ||
                    BOARD[left_wing[0] + 1][left_wing[1]] == 1 ||
                    BOARD[right_wing[0] + 1][right_wing[1]] == 1
                ) {
                    return;
                }
                right_wing[0]++;
                right_wing[1]--;
                position = 1;
            } else {
                if (
                    left_wing[1] - 1 < 0 ||
                    right_wing[1] - 1 < 0 ||
                    BOARD[left_wing[0]][left_wing[1] - 1] == 1 ||
                    BOARD[right_wing[0]][right_wing[1] - 1] == 1
                ) {
                    return;
                }
                right_wing[0]--;
                right_wing[1]--;

                int[] temp = left_wing;
                left_wing = right_wing;
                right_wing = temp;
                position = 0;
            }
        }

        public void right_up() {
            if (position == 0) {
                if (
                    left_wing[0] - 1 < 0 ||
                    right_wing[0] - 1 < 0 ||
                    BOARD[left_wing[0] - 1][left_wing[1]] == 1 ||
                    BOARD[right_wing[0] - 1][right_wing[1]] == 1
                ) {
                    return;
                }
                left_wing[0]--;
                left_wing[1]++;
                position = 1;
            } else {
                if (
                    left_wing[1] - 1 < 0 ||
                    right_wing[1] - 1 < 0 ||
                    BOARD[left_wing[0]][left_wing[1] - 1] == 1 ||
                    BOARD[right_wing[0]][right_wing[1] - 1] == 1
                ) {
                    return;
                }
                left_wing[0]++;
                left_wing[1]--;
                position = 0;
            }
        }

        public void right_down() {
            if (position == 0) {
                if (
                    left_wing[0] + 1 >= BOARD.length ||
                    right_wing[0] + 1 >= BOARD.length ||
                    BOARD[left_wing[0] + 1][left_wing[1]] == 1 ||
                    BOARD[right_wing[0] + 1][right_wing[1]] == 1
                ) {
                    return;
                }
                left_wing[0]++;
                left_wing[1]++;

                int[] temp = left_wing;
                left_wing = right_wing;
                right_wing = temp;
                position = 1;

            } else {
                if (
                    left_wing[1] + 1 >= BOARD[0].length ||
                    right_wing[1] + 1 >= BOARD[0].length ||
                    BOARD[left_wing[0]][left_wing[1] + 1] == 1 ||
                    BOARD[right_wing[0]][right_wing[1] + 1] == 1
                ) {
                    return;
                }
                left_wing[0]++;
                left_wing[1]++;

                int[] temp = left_wing;
                left_wing = right_wing;
                right_wing = temp;
                position = 0;
            }
        }
        public String pos() {
            return 
                left_wing[0] +
                "," +
                left_wing[1] +
                "," +
                right_wing[0] +
                "," +
                right_wing[1];
        }
    }
    
    public int solution(int[][] board) {
        /*
        로봇(드론?)이 이동할 수 있는 경우의 수 
        -> 왼쪽 날개 오른쪽 날개를 정의해야할까? 
        -> 왼쪽오른쪽 상태가 계속바뀜
        위, 아래, 오른쪽, 왼쪽, 왼쪽 회전(왼쪽축), 오른쪽 회전(왼쪽축), 왼쪽 회전(오른축), 오른쪽 회전(오른축)
        로봇이 정면을 보고있다는걸 어떻게 정의할지 혹은 정의하는게 필요한지?
        visited 배열을 활용? -> 이미 방문했다는 것을 어떻게 정의할지 고민
        방문좌표가 두개 모두 겹칠때를 방문했다고 생각 hashSet
        n,n 도착은 배열상으로 n-1, n-1에 도착
        
        회전할때 계속 상태가 바뀌는 문제가 생김
        드론이 가로상태일때 세로상태일때를 분기해서 생각해야할듯
        가로 상태일때 8가지 세로 상태일때 8가지 총 16가지??? 
        */
        BOARD = board;
        Drone drone = new Drone();
        
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<Drone> q = new ArrayDeque<>();
        int count = 0;
        
        q.offer(drone);
        visited.add(drone.pos());
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                Drone current = q.poll();
                String currentPos = current.pos();

                if(
                    (current.left_wing[0] == BOARD.length - 1 &&
                    current.left_wing[1] == BOARD.length - 1) 
                    ||
                    (current.right_wing[0] == BOARD.length - 1 &&
                    current.right_wing[1] == BOARD.length - 1)
                ) {
                    return count;
                } // if

                Drone next;
                String nextPos;

                //상
                next = new Drone(current);
                next.up();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //하
                next = new Drone(current);
                next.down();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //좌
                next = new Drone(current);
                next.left();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //우
                next = new Drone(current);
                next.right();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //좌고정회전
                next = new Drone(current);
                next.left_up();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //좌고정회전
                next = new Drone(current);
                next.left_down();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //우고정회전
                next = new Drone(current);
                next.right_up();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
                //우고정회전
                next = new Drone(current);
                next.right_down();
                nextPos = next.pos();
                if(!currentPos.equals(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.offer(next);
                }
            }
            count++;
        } //whle
        return -1;
    }
}
