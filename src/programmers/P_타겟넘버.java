package programmers;

class P_타겟넘버 {
    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(0, 0, target, numbers);

        return answer;
    }

    /**
     * 배열 끝까지 가면서 배열 값들을 더하거나 빼는 메서드
     * @param sum 총합
     * @param depth 배열 idx
     * @param target 내가 찾아야하는 값
     * @param numbers 문제에서 주어진 배열
     */
    static void dfs(int sum, int depth, int target, int[] numbers) {
        if(depth == numbers.length) {
            if(sum == target) // 배열 끝까지 갔을때 sum이 원하는 값이면 카운트 올려줌
                answer++;

            return;
        }

        dfs(sum + numbers[depth], depth + 1, target, numbers); // 더했을 때
        dfs(sum - numbers[depth], depth + 1, target, numbers); // 뺐을 때
    }
}
