package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_단어변환 {

    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // BFS를 위한 큐와 방문 체크 배열
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // target에 도달한 경우
            if (current.word.equals(target)) {
                return current.count;
            }

            // 한 글자만 다른 단어 찾기
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneCharDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }
            }
        }

        return 0;
    }

    // 두 단어가 한 글자만 다른지 확인
    public boolean isOneCharDiff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    // BFS 노드 클래스
    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}