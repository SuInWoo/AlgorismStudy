package ssafy_class;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576_토마토_ver2 {
	static int[][] map;
	static int ans; // 모든 토마토가 익는데 걸린 시간
	static int M, N; // M:가로=j, N:세로=i

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		Queue<Tomato> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 처음부터 익어있는 토마토는 0일차에 익었다고
					queue.add(new Tomato(i, j)); // day=0으로 객체 만들어서 큐에 싹 담기.
				}
			}
		}

		int day=0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s=0; s<size; s++) {
				Tomato now = queue.poll(); // 현재 익어있는 토마토가 나옴.

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d]; // 옆에 익혀야 하는 아직 안익은 토마토 찾기
					int nextj = now.j + dj[d];
					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 0) {
						queue.add(new Tomato(nexti, nextj));
						map[nexti][nextj] = 1;
					}
				}
			}
			day++;
//			System.out.println(day+"일이 흘렀음.");
//			print();
		}
		ans = day-1; // day가 마지막날 익은 토마토 poll하고 굳이 하루 ++ 하고 while을 끝내서 ;; 
		// 스케줄에 잡힌 즉 익힐수 있는 모든 토마토에게 시도함. 이제 안익은 토마토 있나 체크하자.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					ans = -1;
			}
		}
		System.out.println(ans);
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

	static class Tomato {
		int i, j;

		public Tomato(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}