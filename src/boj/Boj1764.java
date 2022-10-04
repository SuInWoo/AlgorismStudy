package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 1764번
 *
 * 입력
 * 3 4
 * ohhenrie
 * charlie
 * baesangwook
 * obama
 * baesangwook
 * ohhenrie
 * clinton
 *
 * 출력
 * 2
 * baesangwook
 * ohhenrie
 */

public class Boj1764 {

    public static int N,M;
    public static HashSet<String> hs = new HashSet<String>();
    public static ArrayList<String> ans = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            hs.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
            String s=br.readLine();
            if(hs.contains(s)) {
                ans.add(s);
            }

        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }

}