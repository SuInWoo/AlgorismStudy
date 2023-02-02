package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> treeMap = new HashMap<>();
        int treeCnt = 0;
        String in;

        while((in = br.readLine()) != null) {
            if(in.isEmpty()) {
                break;
            }

            if(treeMap.containsKey(in)) {
                treeMap.put(in, treeMap.get(in)+1.0);
            } else
                treeMap.put(in, 1.0);

            treeCnt++;
        }

        List<String> keySet = new ArrayList<>(treeMap.keySet());
        Collections.sort(keySet);

        for (String string : keySet) {
            System.out.print(string + " ");
            System.out.printf("%.4f\n", treeMap.get(string)/treeCnt*100);
        }
    }
}
