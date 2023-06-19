package boj_m6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10845_큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        int lastNum = 0;

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push": {
                    lastNum = Integer.parseInt(st.nextToken());
                    q.offer(lastNum);
                    break;
                }
                case "pop": {
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.poll() + "\n");
                    break;
                }
                case "size": {
                    sb.append(q.size() + "\n");
                    break;
                }
                case "empty": {
                    if (q.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                }
                case "front": {
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.peek() + "\n");
                    break;
                }
                case "back": {
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(lastNum + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
