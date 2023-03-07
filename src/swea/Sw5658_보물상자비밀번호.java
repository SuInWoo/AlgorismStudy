package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Sw5658_보물상자비밀번호 {

    static int N, K;
    static char[] c;
    static Set<String> hSet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            hSet = new HashSet<>();

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            String str = br.readLine(); // 입력받은 N개의 숫자
            c = str.toCharArray();

            for (int i = 0; i < N / 4; i++) {
                process(i);
            }

            Object[] o = hSet.toArray();
            int[] ans = new int[o.length];

            for (int i = 0; i < o.length; i++) {
                ans[i] = Integer.parseInt((String) o[i],16);
            }

            Arrays.sort(ans);

            sb.append("#").append(tc).append(" ").append(ans[ans.length - K]).append("\n");
        }
        System.out.println(sb);
    }

    static void process(int sy) {
        for (int i = sy; i < N; i += (N / 4) % N) { // 시작점부터 N/4칸
            String s = "";
            for (int j = 0; j < N / 4; j++) {
                s += c[(i + j) % N];
            }
            hSet.add(s);
        }
    }
}
