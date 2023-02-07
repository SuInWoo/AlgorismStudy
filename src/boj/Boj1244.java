package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {
    static void change(int sex, int num, boolean[] sw) {
        if(sex == 1) { // 남자일때
            for (int i = num; i < sw.length; i+=num) {
                sw[i] = !sw[i];
            }
        } else { // 여자일때
            sw[num] = !sw[num]; //일단 자기 자신 변경

            int left = num-1;
            int right = num+1;
            while(true) {

                if(left >= 1 && right < sw.length && sw[left] == sw[right]) {
                    sw[left] = !sw[left];
                    sw[right] = !sw[right];
                } else
                    break;

                left--;
                right++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int swCnt = Integer.parseInt(br.readLine());
        boolean[] sw = new boolean[swCnt+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= swCnt; i++) {
            if(st.nextToken().equals("1"))
                sw[i] = true;
        }

        int stCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < stCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            change(sex, num, sw);
        }

        //print
        for (int i = 1; i <= swCnt; i++) {

            if(sw[i])
                System.out.print("1 ");
            else
                System.out.print("0 ");

            if(i%20 == 0) {
                System.out.println();
            }


        }
    }
}
