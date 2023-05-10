package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1259_팰린드롬수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String in = br.readLine();
            if(in.equals("0"))
                break;
            int start = 0;
            int end = in.length()-1;
            boolean ans = true;
            while(end-start >= 0) {
                if(in.charAt(start) != in.charAt(end)){
                    ans = false;
                    break;
                }
                start++;
                end--;
            }

            if(ans) {
                System.out.println("yes");
            } else
                System.out.println("no");
        }

    }
}
