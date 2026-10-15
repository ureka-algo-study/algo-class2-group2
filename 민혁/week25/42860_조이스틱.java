class Solution {
    public int solution(String name) {
        /*
        9번 -> 왼쪽 -> 아래 11번
        9번 -> 오른쪽 -> 오른쪽 -> 아래쪽 12번
        name의 길이 1~20
        A-Z 26개였나
        이동횟수를 최소화하려면 첫번째꺼는 만들어놓고 시작해야함(그래야 추가이동X)
        어차피 문자를 바꾸는 비용은 정해져있으니 나중에 생각
        이동거리만 최적화하면 최소비용을 구할 수 있음
        어떻게 이동할때 이동거리가 가장 짧을까?
        양쪽끝이 이어져있는 원형배열
        한쪽으로 쭉가거나 가다가 되돌아가거나
        되돌아가기, 한칸가고 되돌아가기, 두칸가고 되돌아가기, 세칸가고되돌아가기,
        ...마지막 - 1칸가고 되돌아가기, 마지막 칸까지 가기
        
        왼쪽으로 쭉가기 vs 
        오른쪽으로 쭉가기 vs
        왼쪽한칸 갔다 되돌아가기.... 왼쪽 마지막 - 1칸 갔다 되돌아가기 vs
        오른쪽한칸 갔다 되돌아가기 ... 오른쪽 마지막 - 1칸 갔다 되돌아가기
        */
        int length = name.length();
        boolean[] isA = new boolean[length];
        int shortest = Integer.MAX_VALUE;
        
        for(int i = 0; i < length; i ++) {
            if(name.charAt(i) == 'A') {
                isA[i] = true;
            }
        }
        
        int count = 0;
        isA[0] = true;
        
        // 오른쪽으로 쭉가기
        for(int i = 1; i < length; i ++) {
            if(allChecked(isA,length)) {
                break;
            }
            isA[i] = true;
            count++;
        }
        shortest = Math.min(count,shortest);
       
        // 초기화
        count = 0;
        reset(isA, name);
        
        // 왼쪽으로 쭉가기
        for(int i = length - 1; i > 0; i --) {
            if(allChecked(isA,length)) {
                break;
            }
            isA[i] = true;
            count++;
        }
        shortest = Math.min(count,shortest);
        
        // 초기화
        count = 0;
        reset(isA, name);
        
        // 오른쪽으로 i칸 갔다가 되돌아가기
        for(int i = 1; i < length - 1; i ++) {
            reset(isA, name);
            count = 0;
            int position = 0;
            
            // 오른쪽으로 i칸 이동
            for(int j = 0; j < i; j++) {
                if(allChecked(isA, length)) {
                    break;
                }
                position++;
                isA[position] = true;
                count++;
            }
            // 방향바꿔서 왼쪽으로 도착할때까지 이동
            while(!allChecked(isA, length)) {
                if(position == 0) {
                    position = length - 1;
                } else {
                    position--;
                }
                isA[position] = true;
                count++;
            }
            shortest = Math.min(shortest, count);
        }
        
        // 초기화
        count = 0;
        reset(isA, name);
        
        // 왼쪽으로 i칸 갔다가 오른쪽으로 이동
        for (int i = 1; i < length; i++) {
            reset(isA, name);
            count = 0;
            int position = 0;

            // 왼쪽으로 i칸 이동
            for (int j = 0; j < i; j++) {
                if (allChecked(isA, length)) {
                    break;
                }

                if (position == 0) {
                    position = length - 1;
                } else {
                    position--;
                }

                isA[position] = true;
                count++;
            }

            // 방향 바꿔서 오른쪽으로 쭉가기
            while (!allChecked(isA, length)) {
                position++;
                if (position == length) {
                    position = 0;
                }

                isA[position] = true;
                count++;
            }

            shortest = Math.min(shortest, count);
        }
        
        // 문자변경 비용을 구해 최단경로와 합치기
        int changeAlpha = 0;
        for(int i = 0; i < length; i ++) {
            // 현재 위치에서 올리는게 빠른지 내리는게 빠른지
            changeAlpha += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        }
        
        return shortest + changeAlpha;
        
    }

    public boolean allChecked(boolean[] isA, int length) {
        for(int i = 0; i < length; i ++) {
            if(!isA[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void reset(boolean[] isA, String name) {
        for (int i = 0; i < name.length(); i++) {
            isA[i] = name.charAt(i) == 'A';
        }
        isA[0] = true;
    }
}
