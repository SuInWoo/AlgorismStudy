package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj11478 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; i+j < str.length(); j++) {

                String in = str.substring(i, i+j+1);
                hs.add(in);
            }
        }

        System.out.println(hs.size());


    }
}
