package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
	
	static int[][] map; // 0 => . , 1 => x
	static boolean[][] visited;
	static int[] my = {-1, 0, 1}; // 상 우 하
	static int[] mx = {1, 1,  1};
	static int R, C, cnt;
	
	static boolean insertPipe(int y, int x) {
		
		visited[y][x] = true;
		
		if(x == C-1) {
			cnt++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nY = y + my[i];
			int nX = x + mx[i];
			
			if(nY < 0 || nY >= R || nX < 0 || nX >= C || visited[nY][nX] || map[nY][nX] == 1)
				continue;
			
			if(insertPipe(nY, nX))
				return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == '.')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		
		// end input
		
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			insertPipe(i, 0);
		}
		
		System.out.println(cnt);
		
	}
}	