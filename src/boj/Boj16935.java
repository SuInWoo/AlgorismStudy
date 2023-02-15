package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16935 {
	static int[][] arr;
	static int N, M, R;

	static int[][] reverseUD() {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[(N - 1) - j][i] = arr[j][i];

			}
		}

		return tmp;
	}

	static int[][] reverseLR() {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][(M - 1) - j] = arr[i][j];
			}
		}

		return tmp;
	}

	static int[][] rotateR() {
		int[][] tmp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[j][(N - 1) - i] = arr[i][j];
			}
		}

		int temp = M;
		M = N;
		N = temp;
		return tmp;
	}

	static int[][] rotateL() {
		int[][] tmp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[(M - 1) - i][j] = arr[j][i];
			}
		}

		int temp = M;
		M = N;
		N = temp;
		return tmp;
	}

	static int[][] cal5(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i < n / 2) { // 1,2사분면
					if (j < m / 2) { // 1사분면
						tmp[i][j] = arr[i + (n / 2)][j];
					} else { // 2사분면
						tmp[i][j] = arr[i][j - (m / 2)];
					}
				} else { // 3,4사분면
					if (j < m / 2) { // 3사분면
						tmp[i][j] = arr[i][j + (m / 2)];
					} else { // 4사분면
						tmp[i][j] = arr[i - (n / 2)][j];
					}
				}
			}
		}
		return tmp;

	}

	static int[][] cal6(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i < n / 2) { // 1,2사분면
					if (j < m / 2) { // 1사분면
						tmp[i][j] = arr[i][j + (m / 2)];
					} else { // 2사분면
						tmp[i][j] = arr[i + (n / 2)][j];
					}
				} else { // 3,4사분면
					if (j < m / 2) { // 3사분면
						tmp[i][j] = arr[i - (n / 2)][j];
					} else { // 4사분면
						tmp[i][j] = arr[i][j - (m / 2)];
					}
				}
			}
		}
		return tmp;

	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 연산 수

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int type = Integer.parseInt(st.nextToken());

			switch (type) {
			case 1:
				arr = reverseUD();
				break;
			case 2:
				arr = reverseLR();
				break;
			case 3:
				arr = rotateR();
				break;
			case 4:
				arr = rotateL();
				break;
			case 5:
				arr = cal5(arr);
				break;
			case 6:
				arr = cal6(arr);
				break;
			}
		}
		
		print(arr);

	}

}