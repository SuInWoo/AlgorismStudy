package boj;
/**
 * 숫자카드2
 *
 * 입력
 * 10
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8
 * 10 9 -5 2 3 4 5 -10
 *
 * 출력
 * 3 0 0 1 2 0 0 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> cardMap = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int in = Integer.parseInt(st.nextToken());
            if (!cardMap.containsKey(in)){
                cardMap.put(in, 1);
            } else{
                cardMap.put(in,(cardMap.get(in)+1));
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int out = Integer.parseInt(st.nextToken());
            if (cardMap.containsKey(out))
                sb.append(cardMap.get(out)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
