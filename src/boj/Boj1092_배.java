package boj;

import java.util.*;

/**
 * N: 크레인 개수
 * 크레인 무게를 입력받음
 * M: 박스 개수
 *
 * 1분에 박스를 하나씩 배에 실을 수 있음 -> 변수: 모든 크레인은 동시에 움직임
 */
public class Boj1092_배 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // init
        int N = sc.nextInt();
        Integer[] cranes = new Integer[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            list.add(sc.nextInt());
        }

        int time = 0;
        Arrays.sort(cranes, Collections.reverseOrder());
        list.sort(Collections.reverseOrder());

        // logic
        if (list.get(0) > cranes[0]) { // 박스 무게 최대가 크레인 가능 무게 최대보다 크면 못 옮김
            time = -1;
        } else {
            while (!list.isEmpty()) { // 전체 박스를 다 옮기면
                int boxIdx = 0;
                for (int i = 0; i < N;) { // 크레인 전체 탐색
                    if (boxIdx == list.size()) // 이미 박스를 돌아봤으면
                        break;
                    else if (cranes[i] >= list.get(boxIdx)) { // 옮길 수 있으면 옮기기
                        list.remove(boxIdx);
                        i++;
                    } else { // 못 옮기는 친구지만 아직 더 봐야하는 박스가 남아있으므로
                        boxIdx++;
                    }
                }
                time++;
            }
        }

        System.out.println(time);
    }
}