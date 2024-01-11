package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj12904_A와B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());

        // A 만나면 그냥 삭제
        // B 만나면 바꾸고 삭제

        // logic
        while (s.length() < t.length()) {
            char c = t.charAt(t.length() - 1);
            if (c == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else if (c == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        } else
            System.out.println(0);
    }
}
