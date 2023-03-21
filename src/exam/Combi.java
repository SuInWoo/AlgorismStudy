package exam;

import java.util.Arrays;

public class Combi {

    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[6];

        com(0);
    }

    static void com(int depth) {
        if (depth == 6) {
            System.out.println(Arrays.toString(visited));
            return;
        }

        visited[depth] = true;
        com(depth + 1);
        visited[depth] = false;
        com(depth + 1);
    }
}