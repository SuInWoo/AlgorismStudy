package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[cnt+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[cnt+1];

        for (int i = 1; i <= cnt; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        } // end init

        visited[1] = true;
        for (int j = 0; j < list[1].size(); j++) {
            int select = list[1].get(j);
            q.add(select);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (!visited[num]) {
                visited[num] = true;
                count++;
            }

            for (int j = 0; j < list[num].size(); j++) {
                int select = list[num].get(j);
                if (!visited[select])
                    q.add(select);
            }
        }
        System.out.println(count);

    }
}
