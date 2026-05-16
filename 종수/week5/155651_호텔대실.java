package 종수.week5;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int maxRoom = 0;
        int start[] = new int[book_time.length];
        int end[] = new int[book_time.length];


        Arrays.sort(book_time, (o1, o2) -> {
            return o1[0].compareTo(o2[0]); 
        });

        for(int i = 0; i < book_time.length; i++){
            start[i] = Integer.parseInt(book_time[i][0].replace(":", ""));
            end[i] = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;
            if(end[i] % 100 >= 60){
                end[i] += 40;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < book_time.length; i++){

            while(!pq.isEmpty() && pq.peek() <= start[i]){
                pq.poll();
            }

            pq.offer(end[i]);

            maxRoom = Math.max(maxRoom, pq.size());
        }

        answer = maxRoom;

        return answer;
    }
}





// LocalDate는 24시 이후를 00시로 표기하기 때문에
// 종료 시간 이후에 방 정리시간을 처리하는데 문제가 생김
// import java.time.LocalTime;
// import java.util.Arrays;
// import java.util.PriorityQueue;

// class Solution {

//     public int solution(String[][] book_time) {
//         int answer = 0;
//         int maxRoom = 0;

//         Arrays.sort(book_time, (o1, o2) -> {
//             return o1[0].compareTo(o2[0]);
//         });

//         LocalTime startTime[] = new LocalTime[book_time.length];
//         LocalTime endTime[] = new LocalTime[book_time.length];

//         for(int i = 0; i < book_time.length; i++){

//             startTime[i] = LocalTime.parse(book_time[i][0]);
//             endTime[i] = LocalTime.parse(book_time[i][1]).plusMinutes(10);
//             if(endTime[i].isBefore(LocalTime.parse("00:09"))){
//                 endTime[i] = LocalTime.parse("23:59");
//             }
//         }

//         PriorityQueue<LocalTime> pq = new PriorityQueue<>();

//         for(int i = 0; i < book_time.length; i++){

//             while(!pq.isEmpty() && !pq.peek().isAfter(startTime[i])){
//                 pq.poll();
//             }

//             pq.offer(endTime[i]);

//             maxRoom = Math.max(maxRoom, pq.size());
//         }

//         answer = maxRoom;
//         return answer;
//     }
// }