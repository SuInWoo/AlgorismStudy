package group.g6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    기타레슨
 */
public class Boj2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lecture = new int[N];

        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            if (start < lecture[i])
                start = lecture[i]; // 최소값 지정
            end += lecture[i];  // 최대값 지정
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;    // 블루레이 갯수를 담을 변수
            int compareSum = 0; // 블루레이 개당 크기를 비교할 변수

            for (int i = 0; i < lecture.length; i++) {
                if ((compareSum+lecture[i]) > mid){ // 지금 크기에 다음 강의 길이를 더해서 넘치면
                    cnt++;  // 갯수 올려주고
                    compareSum = lecture[i];    // 새로 초기화
                } else
                    compareSum += lecture[i];
            }

            if (cnt >= M) {  // 갯수가 크거나 같으면 블루레이 개당 크기가 작다는 의미
                start = mid + 1;  // start를 오른쪽으로 옮겨서 mid의 값을 높여줌
            }
            else
                end = mid - 1;  // 반대로 블루레이 개당 크기가 큰 것이므로 end를 왼쪽으로 옮겨 mid의 값을 낮춰줌
        }

        System.out.println(start);
    }
}
