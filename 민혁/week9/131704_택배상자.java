import java.util.*;

class Solution {
    public int solution(int[] order) {
// ArrayDeque<Integer> sc = new ArrayDeque<>(); // subContainer
//         int flag = 1;

//         for(int i = 0; i < order.length; i ++) {

//             if(order[i] != flag) {
//                if(sc.isEmpty() || sc.peek() != flag) {
//                    sc.push(order[i]);
//                } else {
//                    sc.pop();
//                    flag++;
//                }
//             } else {
//                 flag++;
//             }
//         } //for
//         return flag - 1;
        ArrayDeque<Integer> sc = new ArrayDeque<>(); // subContainer
        int count = 0; // 완료한 박스
        int curBox = 1; // 이번에 넣을 박스

        for (int i = 0; i < order.length; i++) {
            int flag = order[i]; // 넣으라고 지시한 박스
            // sc에 원하는 박스 있으면 꺼냄
            if (!sc.isEmpty() && sc.peek() == flag) {
                sc.pop();
                count++;
            }
            // 2. 아니면 메인 컨테이너에서 찾아야 함
            else {
                // 원하는 박스 전까지는 보조 컨테이너에 넣음
                if (curBox < flag) {
                    while (curBox < flag) {
                        sc.push(curBox++);
                    }
                }
                // 메인 컨테이너의 현재 박스가 원하는 박스면 실음
                if (curBox == flag) {
                    curBox++;
                    count++;
                }
                // 보조에서도 못 꺼내고, 메인에도 못넣으면 실패
                else {
                    break;
                }
            }
        }
        return count;



    }
}