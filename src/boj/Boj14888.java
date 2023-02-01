package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14888 {
    static ArrayList<String> OPSTR = new ArrayList<>();

    public static void dfs(String[] opall, boolean[] visited, int depth, int start, int end, String str) {
        if(depth == end) {
            OPSTR.add(str);
            return;
        }

        for (int i = 0; i < start; i++) {
            if(!visited[i]) {
                String temp = "";
                visited[i] = true;
                temp = str;
                str += opall[i];
                dfs(opall, visited, depth+1, start, end, str);
                str = temp;
                visited[i] = false;
            }
        }
    }

    public static int cal(char op, int num1, int num2) {

        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else if(op == '*') {
            return num1 * num2;
        } else {
            int rnt = Math.abs(num1)/num2;
            if(num1 < 0) {
                return -1*rnt;
            }
            return rnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] nums = new int[n];
        boolean[] visited = new boolean[n-1];
        String[] opall = new String[n-1];
        String[] op = new String[]{"+", "-", "*", "/"};

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int j = 0;
        for (int i = 0; i < 4; i++) {
            String next = st.nextToken();
            int cnt = Integer.parseInt(next);
            while(cnt != 0) {
                opall[j++] = op[i];
                cnt--;
            }
        }

        dfs(opall, visited, 0, n-1, n-1, "");

        for (int i = 0; i < OPSTR.size(); i++) {
            int rnt = cal(OPSTR.get(i).charAt(0), nums[0], nums[1]);
            for (int k = 1; k < OPSTR.get(0).length(); k++) {
                rnt = cal(OPSTR.get(i).charAt(k), rnt, nums[k+1]);
            }
            if(rnt > max)
                max = rnt;
            if(rnt < min)
                min = rnt;
        }
        System.out.println(max);
        System.out.println(min);
    }
}
