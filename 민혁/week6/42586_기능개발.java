import java.util.*;
import java.util.stream.*;

class Solution {

    class Task {
        int progress;
        int speed;
        int priority;

        public Task(int progress, int speed, int priority) {
            this.progress = progress;
            this.speed = speed;
            this.priority = priority;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        작업 리스트와, 작업 완료 큐, 결과 리스트
        Task관리 진행도 진행속도 우선순위
        */
        List<Task> toDo = new ArrayList<>();
        PriorityQueue<Task> finished = new PriorityQueue<>( (o1, o2) -> o1.priority - o2.priority );
        List<Integer> result = new ArrayList<>();


        for(int i = 0; i < progresses.length; i ++) {
            toDo.add(new Task(progresses[i], speeds[i], i));
        }

        int commit = 0;


        while(!toDo.isEmpty()) {

            for(int i = 0; i < toDo.size(); i ++) {
                Task task = toDo.get(i);
                task.progress += task.speed;

            }

            for(int i = toDo.size() - 1; i < 0; i --) {
                Task task = toDo.get(i);

                if(task.progress >= 100) {
                    toDo.remove(task);
                    finished.offer(task);
                }
            }



            int count = 0;

            while(!finished.isEmpty() && finished.peek().priority == commit) {
                finished.poll();
                commit++;
                count++;
            }
            result.add(count);
        }


        return result.stream().filter(i -> i != 0).mapToInt(i -> i).toArray();

    }
}