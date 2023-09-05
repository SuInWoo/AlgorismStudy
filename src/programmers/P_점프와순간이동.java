package programmers;

public class P_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n%2 == 0) { // n이 짝수면 /2 하고 ans는 증가 x
                n /= 2;
            } else { // n이 홀수면 -1 하고 ans + 1
                n -= 1;
                ans++;
            }
            
        }

        return ans;
    }
}