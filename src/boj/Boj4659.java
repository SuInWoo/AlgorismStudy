package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String target = br.readLine();
            if (target.equals("end"))
                break;

            // 모음이 있는지 확인, 없으면 바로 넘어가기
            if (!checkExistMo(target)) {
                sb.append("<").append(target).append("> is not acceptable.\n");
            } else {

                char startChar = target.charAt(0);
                boolean check = checkChar(startChar); // 전글자가 모음이면 true, 자음이면 false
                boolean isPass = true;
                int cnt = 1; // 반복되는 글자 갯수 지정하는 변수

                for (int i = 1; i < target.length(); i++) {
                    // 같은 글자인지 비교
                    if (startChar == target.charAt(i)) {
                        if (startChar != 'e' && startChar != 'o') { // 모음이 아니면, 무조건 붙으면안됨
                            sb.append("<").append(target).append("> is not acceptable.\n");
                            isPass = false;
                            break;
                        } else { // 'ee' or 'oo'
                            check = true;
                            cnt++;
                        }
                    } else if (check == checkChar(target.charAt(i))){ // 자모음이 같은 경우
                        if (cnt == 2) { // 3개붙으면안됨
                            sb.append("<").append(target).append("> is not acceptable.\n");
                            isPass = false;
                            break;
                        } else {
                            cnt++;
                        }
                    } else { // 자음 -> 모음 or 모음 -> 자음
                        check = !check;
                        cnt = 1;
                    }

                    startChar = target.charAt(i);

                }
                if (isPass)
                    sb.append("<").append(target).append("> is acceptable.\n");

            }

        }

        System.out.println(sb.toString());
    }

    public static boolean checkChar(char c) {
        String mo = "aeiou";
        return mo.contains(String.valueOf(c));
    }

    public static boolean checkExistMo(String target) {
        String mo = "aeiou";
        for (int i = 0; i < mo.length(); i++) {
            if (target.contains(String.valueOf(mo.charAt(i)))) {
                return true;
            }
        }

        return false;
    }
}
