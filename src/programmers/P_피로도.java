package programmers;

class P_피로도 {
	static boolean[] visited;
	static int anwser = 0;

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		dfs(0, k, dungeons);
		return anwser;
	}

	private void dfs(int depth, int present, int[][] dungeons){
		for (int i = 0; i < dungeons.length; i++){
			if (visited[i] || dungeons[i][0] > present) {
				continue;
			}
			visited[i] = true;
			dfs(depth + 1, present - dungeons[i][1], dungeons);
			visited[i] = false;
		}
		anwser = Math.max(anwser, depth);
	}
}
