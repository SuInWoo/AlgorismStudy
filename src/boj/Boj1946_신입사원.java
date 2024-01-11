package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1946_신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            int result = 1; // 첫 번째 최대 친구는 무조건 뽑히니
            PriorityQueue<Person> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pq.offer(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // logic
            Person compare = pq.poll(); // 비교 대상(기준)
            while (!pq.isEmpty()) {
                Person target = pq.poll(); // 현재 체크할 사람

                if (compare.second >= target.second) { // 면접 기준으로 비교
                    result++;
                    compare = new Person(target.first, target.second);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static class Person implements Comparable<Person> {
        int first;
        int second;

        public Person(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Person o) { // 내림차순 정렬

            if (this.first == o.first) {
                return this.second - o.second;
            } else {
                return this.first -o.first;
            }
        }
    }
}
