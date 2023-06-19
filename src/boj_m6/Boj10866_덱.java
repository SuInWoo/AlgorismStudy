package boj_m6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj10866_덱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front": {
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "push_back": {
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop_front": {
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollFirst() + "\n");
                    break;
                }
                case "pop_back": {
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollLast() + "\n");
                    break;
                }
                case "size": {
                    sb.append(dq.size() + "\n");
                    break;
                }
                case "empty": {
                    if (dq.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                }
                case "front": {
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.getFirst() + "\n");
                    break;
                }
                case "back": {
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.getLast() + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
