package boj;

import java.util.*;
import java.io.*;

public class Boj25757 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int processingCnt = 0;
        int request = Integer.parseInt(st.nextToken());
        String gameOption = st.nextToken();
        Set<String> peoples = new HashSet<>();

        for (int i = 0; i < request; i++) {
            peoples.add(br.readLine());
        }


        if (gameOption.equals("Y")) {
            processingCnt = peoples.size();
        } else if (gameOption.equals("F")) {
            processingCnt = peoples.size() / 2;
        } else {
            processingCnt = peoples.size() / 3;
        }

        System.out.println(processingCnt);
    }
}
