package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6987 {
	static int[] home = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] away = new int[] { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static int[] win, draw, lose;
	static boolean isPossible;
	static int totalGameCnt;

	static void play(int cnt) {

		if(isPossible) // 이미 가능하다고 판별되었을 때
			return;

		if (cnt == totalGameCnt) { // 15번의 경기가 끝나면
			isPossible = true;
			return;
		}

		// 경기 할 두 팀 지정
		int teamA = home[cnt];
		int teamB = away[cnt];

		// teamA 승
		if(win[teamA] > 0 && lose[teamB] > 0) {
			win[teamA]--;
			lose[teamB]--;
			play(cnt+1);
			win[teamA]++;
			lose[teamB]++;
		}

		// 무승부
		if(draw[teamA] > 0 && draw[teamB] > 0) {
			draw[teamA]--;
			draw[teamB]--;
			play(cnt+1);
			draw[teamA]++;
			draw[teamB]++;
		}

		// teamA 패
		if(lose[teamA] > 0 && win[teamB] > 0) {
			lose[teamA]--;
			win[teamB]--;
			play(cnt+1);
			lose[teamA]++;
			win[teamB]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < 4; tc++) {
			int total = 0; // 총 경기 수가 30경기가 안되면 0 출력
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				total += win[i] + draw[i] + lose[i];
			}

			// 30이 안되면 경기 수 부족으로 불가능
			if(total != 30) {
				sb.append("0 ");
				continue;
			}

			totalGameCnt = 15;
			isPossible = false;
			play(0);

			if (isPossible)
				sb.append("1 ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);
	}
}
