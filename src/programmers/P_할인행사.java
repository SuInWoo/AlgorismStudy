package programmers;

import java.util.*;

class P_할인행사 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		boolean plus = false;

		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		for(int i = 0; i < discount.length - 9; i++) {
			HashMap<String, Integer> checkMap = new HashMap<>();
			for(int j = i; j < i + 10; j++) {
				if(!checkMap.containsKey(discount[j])) { // 없으면
					checkMap.put(discount[j], 1);
				} else { // 존재하면 ++
					checkMap.put(discount[j], checkMap.get(discount[j]) + 1);
				}
			}

			if(endCheck(map, checkMap)) {
				answer++;
			}
		}
		return answer;
	}

	static boolean endCheck(HashMap<String, Integer> map, HashMap<String, Integer> checkMap) {

		for (String key : map.keySet()) {
			if(!checkMap.containsKey(key) || checkMap.get(key) != map.get(key)) {
				return false;
			}
		}

		return true;
	}
}
