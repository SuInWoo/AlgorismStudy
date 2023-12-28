package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11000_강의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Subject> pqSubjects = new PriorityQueue<>(); // 강의들을 관리할 우선순위 큐
        PriorityQueue<Integer> pqEndTimes = new PriorityQueue<>(); // 강의 종료 시간을 관리할 우선순위 큐

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pqSubjects.offer(new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 우선순위 큐에 강의가 있는 동안
        while (!pqSubjects.isEmpty()) {
            Subject sj = pqSubjects.poll(); // 가장 빨리 시작하는 강의를 가져옴

            if (!pqEndTimes.isEmpty() && pqEndTimes.peek() <= sj.start) { // 강의실이 비어 있거나 강의가 종료되었을 때
                pqEndTimes.poll(); // 강의실을 비워줌
            }

            pqEndTimes.offer(sj.end); // 현재 강의의 종료 시간을 추가
        }

        System.out.println(pqEndTimes.size()); // 필요한 강의실의 수는 pqEndTimes의 크기
    }

    static class Subject implements Comparable<Subject> {
        int start;
        int end;

        public Subject(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Subject o) {
            if (this.start == o.start)
                return this.end - o.end;
            else
                return this.start - o.start;
        }
    }
}

