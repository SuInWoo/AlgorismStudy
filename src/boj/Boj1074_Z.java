package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074_Z {

	static int N, sum;

	static void checkArea(int size, int r, int c) {

		if(size == 1)
			return;

		if(r < size/2 && c < size/2) {
			checkArea(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {
			sum += size * size / 4;
			checkArea(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {
			sum += (size * size / 4) * 2;
			checkArea(size/2, r - size/2, c);
		}
		else {
			sum += (size * size / 4) * 3;
			checkArea(size/2, r - size/2, c - size/2);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int pow = (int) Math.pow(2, N);

		sum = 0;
		checkArea(pow, r, c);
		System.out.println(sum);
	}
}