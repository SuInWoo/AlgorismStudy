import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14890_경사로 {

    static int N, L, ans;
    static int[][] map;
    static boolean[][] visitedW, visitedH;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitedW = new boolean[N][N];
        visitedH = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            boolean wCheck = true; // 그 줄이 가능한지 아닌지
            for (int j = 1; j < N; j++) { // 가로 검사
                if(!wCheck)
                    break;

                if(map[i][j] > map[i][j-1]) { // 현재 기준 이전이 작으면
                    wCheck = checkLoad(i, j, -1, false);
                } else if (map[i][j] < map[i][j-1]) { // 현재 기준 이전이 크면
                    wCheck = checkLoad(i, j-1, 1, false);
                }
            }
            if(wCheck)
                ans++;

            boolean hCheck = true;
            for (int j = 1; j < N; j++) { // 세로 검사
                if(!hCheck)
                    break;

                if(map[j][i] > map[j-1][i]) { // 현재 기준 이전이 작으면
                    hCheck = checkLoad(j, i, -1, true);
                } else if (map[j][i] < map[j-1][i]) { // 현재 기준 이전이 크면
                    hCheck = checkLoad(j-1, i, 1, true);
                }
            }
            if(hCheck)
                ans++;
        }

        System.out.println(ans);
    }

    static boolean checkLoad(int cy, int cx, int plusIdx, boolean type) { // 가로 검사면 false, 세로면 true
        int targetNum = map[cy][cx]; // 기준이될 숫자
        for (int i = 0; i < L; i++) { // 경사로 길이만큼 for문 돔
            if (type) { // 세로검사
                cy += plusIdx;

                if(cy < 0 || cy >= N || visitedH[cy][cx] || Math.abs(map[cy][cx] - targetNum) != 1) // 범위 바깥으로 나가면
                    return false;

                visitedH[cy][cx] = true;
            } else { // 가로검사
                cx += plusIdx;

                if(cx < 0 || cx >= N || visitedW[cy][cx] || Math.abs(map[cy][cx] - targetNum) != 1) // 범위 바깥으로 나가면
                    return false;

                visitedW[cy][cx] = true;
            }
        }
        return true;
    }
}