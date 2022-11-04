package group.g5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    신기한 소수

    풀이방법
    1. 왼쪽부터 자리마다 소수라고 명시되어있으니 왼쪽을 기준으로 옆에 숫자를 붙이면 된다는 힌트를 얻음
    2. 1~9까지 일의자리이니 이후에 자릿수를 늘려 뒤에 더해주면서 소수인지 체크
    3. N자리까지 갔을때 -> N번 시행했을때 소수이면 stringbuilder에 더해줌(한번시행할때마다 카운트해줌)
 */
public class ReBoj2023 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void nPrime(int num, int cnt) {
        if (cnt == N){
            if (isPrime(num))
                sb.append(Integer.toString(num)+'\n');
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isPrime(num*10+i)) { //소수면 뒤에 숫자를 붙여 다시 검사
                nPrime(num*10+i, cnt+1);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nPrime(0, 0);
        System.out.println(sb.toString());
    }
}
