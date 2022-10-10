package group.g1th;

import java.io.*;
import java.util.*;

public class Boj8979 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+1][4];
        int rank = 1;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[index][0] = gold;
            arr[index][1] = silver;
            arr[index][2] = bronze;
        }

        for(int i=1; i<=N; i++) {
            if(arr[i][0] > arr[K][0]) {
                rank++;
            }
            else if(arr[i][0] == arr[K][0] && arr[i][1] > arr[K][1]) {
                rank++;
            }
            else if(arr[i][0] == arr[K][0] && arr[i][1] == arr[K][1] && arr[i][2] > arr[K][2]) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}