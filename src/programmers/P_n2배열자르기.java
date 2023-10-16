package programmers;

class P_n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        // int[][] arr = new int[n][n];
        int idx = 0;

        for(long i = left; i < right + 1; i++){
            int row = (int) (i / n);
            int col = (int) (i % n);
            answer[idx++] = Math.max(row, col) + 1;
        }

//         // 실제 2차원 배열에 값넣기
//         for(int i = 0; i < n; i++) { // 행
//             int data = n; // 삽입될 값
//             for(int j = n-1; j >= 0; j--) { // 열
//                 arr[i][j] = data;

//                 if(j > i)
//                     data--;
//             }
//         }


        return answer;
    }
}
