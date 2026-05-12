package 종수.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    class Task {
        String subject;
        int remain;

        Task(String subject, int remain) {
            this.subject = subject;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {

        Arrays.sort(plans, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });

        List<String> result = new ArrayList<>();
        Stack<Task> stack = new Stack<>();

        for (int i = 0; i < plans.length - 1; i++) {

            String subject = plans[i][0];

            int start = toMinute(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);

            int nextStart = toMinute(plans[i + 1][1]);

            int availableTime = nextStart - start;

            // 현재 과제를 끝낼 수 있는 경우
            if (playtime <= availableTime) {

                result.add(subject);

                int remainTime = availableTime - playtime;

                // 남는 시간 동안 멈춘 과제 처리
                while (!stack.isEmpty() && remainTime > 0) {

                    Task task = stack.pop();

                    // 남은 과제를 끝낼 수 있으면
                    if (task.remain <= remainTime) {

                        remainTime -= task.remain;
                        result.add(task.subject);

                    } else {

                        // 다 못 끝내면 다시 저장
                        task.remain -= remainTime;
                        remainTime = 0;

                        stack.push(task);
                    }
                }

            } else {

                // 현재 과제를 못 끝냄 -> 남은 시간 저장
                int remain = playtime - availableTime;

                stack.push(new Task(subject, remain));
            }
        }

        // 마지막 과제는 무조건 완료
        result.add(plans[plans.length - 1][0]);

        // 남은 과제들 처리
        while (!stack.isEmpty()) {
            result.add(stack.pop().subject);
        }

        return result.toArray(new String[0]);
    }

    static int toMinute(String time) {

        String[] s = time.split(":");

        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);

        return hour * 60 + minute;
    }
}




// 과목과 과목 사이가 비었을 때 남은 과제의 시간을 고려하지 않고 코드 작성

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Stack;

// class Solution {
//     public String[] solution(String[][] plans) {
//         String[] answer = new String[plans.length];

//         Arrays.sort(plans,(o1, o2) -> {
//             return o1[1].compareTo(o2[1]);
//         });

//         String subject[] = new String[plans.length];
//         int starttime[] = new int[plans.length];
//         int endtime[] = new int[plans.length];

//         List<String> list = new ArrayList<>();

//         for(int i = 0; i < plans.length; i++){

//                 subject[i] = plans[i][0];
//                 starttime[i] = Integer.parseInt(plans[i][1].replace(":", ""));
//                 endtime[i] = changetime(starttime[i], Integer.parseInt(plans[i][2]));            
//         }

//         Stack<String> stack = new Stack<>();


//         for(int i = 0; i < plans.length; i++){
//             stack.push(subject[i]);

//             // if( i == 0)
//             //     continue;
//             if( i == plans.length - 1){
//                 list.add(stack.pop());
//                 continue;
//             }//if
//             else if(i >= 0){
//                 if(endtime[i] <= starttime[i+1]){
//                     list.add(stack.pop());
//                 }//if

//             }//elseif
//         }//for
        
//         while(!stack.isEmpty()){
//             list.add(stack.pop());   
//         }//while
//         int idx = 0;
//         for(String s : list){
//             answer[idx++] = s;
//         }
//         return answer;
//     }//psvm

//     static int changetime(int time, int complete){

//         int hour = time / 100;
//         int min = time % 100; 

//         min += complete;
//         if( min >= 60){
//             hour += 1;
//             min %= 60;
//         }
        
//         return (hour * 100) + min;
//     }//changetime
// }//class