import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 주어지는 과제는 시간순으로 정렬이 안되어 있을 수 있음 -> 시간순 정렬 필요
        // 과제의 시간 포맷은 hh:mm -> 하루 24시간은 0000(m) - 1440(m)
        // 과제를 하다 중간에 멈출 수 있음 -> 멈춰둔 과제의 남은 시간을 시간순으로 정렬해야함
        // 최근에 멈춘 과제 stack 필요 [과제 이름, 남은 시간] 으로 저장 Task 생성


        List<Subject> subjects = new ArrayList<>(); // 해야할 과제
        Deque<Subject> paused = new ArrayDeque<>(); // 하다만 과제
        List<String> completed = new ArrayList<>(); // 완료한 과제

        for(String[] plan : plans) {

            String subject = plan[0];
            int time = Integer.valueOf(plan[1].substring(0,2)) * 60 + Integer.valueOf(plan[1].substring(3,5));
            int remaining = Integer.valueOf(plan[2]);

            subjects.add(new Subject(subject,time,remaining));
        } // parsing 해서 Subject로 만들기

        subjects.sort((o1,o2) -> o1.start - o2.start); // 시간 순으로 정렬

        // 과제를 하나 꺼내고 현재시각을 정해놓고 시작
        Subject firstTask = subjects.remove(0);
        int currentTime = firstTask.start;  // 현재시각(첫번쨰 과제 시작시간)
        paused.push(firstTask);

        while(!paused.isEmpty() || !subjects.isEmpty() ) { // 남은 과제가 없을 때까지 반복

            if(subjects.isEmpty()) { // 더이상 할 과제가 없으면 남겨둔 과제 끝내기
                while(!paused.isEmpty()) {
                    Subject left = paused.pop();
                    completed.add(left.name);
                }
                break;
            }

            if(paused.isEmpty()) { // 하다만 과제가 없다
                Subject nextTask = subjects.remove(0); // 앞으로 해야할 과제 수행
                currentTime = nextTask.start;
                paused.push(nextTask);
                continue;
            }

            int remain = subjects.get(0).start - currentTime; // 다음과제까지 남은 시간

            if(paused.peek().running <= remain) { // 전에 하던 과제를 그 사이에 끝낼 수 있다 ?
                Subject task = paused.pop();
                completed.add(task.name);
                currentTime += task.running;
                continue; // continue 로 다음 과제도 할 수 있는지 다시 체크
            } else {
                Subject task = paused.pop();
                task.running -= remain;
                currentTime = subjects.get(0).start;
                paused.push(task); // 하다만거 다시 넣기
                Subject nextTask = subjects.remove(0);
                paused.push(nextTask);
            } // 하다만거 다시 stack에 넣어놓기 그 다음 과제 새삥으로 stack에 넣기
        }
        return completed.stream().toArray(String[]::new);
    }

    class Subject {
        String name;
        int start;
        int running;

        Subject(String name, int start, int running) {
            this.name = name;
            this.start = start;
            this.running = running;
        }
    }
}