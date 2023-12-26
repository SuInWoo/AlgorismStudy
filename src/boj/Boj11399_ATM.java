package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399_ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // init
        int[] peoples = new int[N];
        int time = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        // end init

        // logic
        Arrays.sort(peoples);

        int myTime = 0;
        for(int i = 0; i < N; i++) {
            myTime = myTime + peoples[i];
            time += myTime;
        }

        System.out.println(time);
    }
}
