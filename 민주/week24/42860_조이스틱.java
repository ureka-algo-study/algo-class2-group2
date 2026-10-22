class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move = name.length() - 1;
        
        for(int i=0; i<name.length(); i++){
            int dif = name.charAt(i) - 'A';
            answer += Math.min(26 - dif, dif);
            
            // 현재 위치 뒤에 A가 얼마나 연속되는지 찾기
            int next = i + 1;
            
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // 커서 이동 방향을 바꿔보면서 최솟값 찾기
            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, i + (name.length() - next) * 2);
        }
        
        return answer + move;
    }
}