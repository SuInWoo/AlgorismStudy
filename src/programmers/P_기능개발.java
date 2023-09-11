package programmers;

import java.util.*;

class P_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> list = new ArrayList<>();

		int[] deployCnt = new int[progresses.length];

		for(int i = 0; i < deployCnt.length; i++) {
			int day = (100 - progresses[i]) / speeds[i];
			if((100 - progresses[i]) % speeds[i] != 0) { // 나머지 있으면
				day++;
			}
			deployCnt[i] = day;
		}

		int cnt = 0;
		int target = deployCnt[0];
		for(int i = 1; i < deployCnt.length; i++) {
			cnt++;
			if(target < deployCnt[i]) {
				list.add(cnt);
				cnt = 0;
				target = deployCnt[i];
			}

		}
		list.add(cnt + 1);

		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
