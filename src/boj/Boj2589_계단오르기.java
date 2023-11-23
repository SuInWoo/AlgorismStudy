package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2589_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int[] arr = new int[total];

		for (int i = 0; i < total; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// end init

		if(total == 1) { // 배열 인덱스 벗어나지 않기 위해 1개의 계단인 경우 바로 처리해줌
			System.out.println(arr[0]);
			return;
		}

		int[][] dp = new int[total + 1][2]; // 0번 열은 옆칸에서 온 친구, 1번 열은 2칸지나 온 친구
		dp[1][0] = arr[0];
		dp[2][0] = dp[1][0] + arr[1];
		dp[2][1] = arr[1];

		for (int i = 3; i < total + 1; i++) {
			dp[i][0] = dp[i - 1][1] + arr[i - 1]; // 전 계단에서 2칸지나온 계단
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i - 1]; // 전전 계단 둘 중 큰거
		}

		System.out.println(Math.max(dp[total][0], dp[total][1]));

	}
}
