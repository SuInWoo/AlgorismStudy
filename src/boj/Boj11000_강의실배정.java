package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11000_강의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // init
        int N = Integer.parseInt(br.readLine());
        ArrayList<Subject> list = new ArrayList<>(); // 시작 시간으로 강의 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 제일 빨리 끝나는 시간이 언제인지 알려주는 pq
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 정렬
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            Subject sj = list.get(i);

            if (!pq.isEmpty() && pq.peek() <= sj.start) { // 아무 강의도 하지않거나, 강의 시간이 종료되었을때
                pq.poll();
            }

            pq.offer(sj.end); // 강의 종료시간 넣어주기

        }

        System.out.println(pq.size());

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
