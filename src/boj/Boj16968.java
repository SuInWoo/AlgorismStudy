package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj16968 {
    static ArrayList<Character> number; // d 와 c를 받을 배열
    static int[] type; // 0번방은 d = 10, 1번방은 c = 26
    static boolean toggle; // false: 한번도 빼준적이 없다, true: 빼줬다
    static int rnt; // 결과를 저장할 변수 초기값은 1이여야함
    static char select1;
    static char select2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inStr = sc.nextLine();
        number = new ArrayList<>();

        for (int i = 0; i < inStr.length(); i++) {
            number.add(inStr.charAt(i));
        }

        // end input


        type = new int[] { 10, 26 };
        rnt = 1;

        if (number.size() == 1) {// 한 글자 일때
            if (number.get(0) == 'd')
                rnt *= type[0];
            else
                rnt *= type[1];
        } else { // 한 글자 이상일때
            for (int i = 1; i < number.size(); i++) {
                select1 = number.get(i - 1); // 앞에 값 (실질적으로 곱해질 값)
                select2 = number.get(i); // 뒤에 값

                if (select1 != select2) { // 두 개가 다를 때
                    if (select1 == 'd') {
                        rnt *= type[0];
                        type[0] = 10;
                    } else {
                        rnt *= type[1];
                        type[1] = 26;
                    }

                    toggle = false;
                } else {
                    if (select1 == 'd') {
                        rnt *= type[0];
                        if(!toggle)
                            type[0]--;
                    } else {
                        rnt *= type[1];
                        if(!toggle)
                            type[1]--;
                    }

                    toggle = true;

                }
            }
            if (select2 == 'd') {
                rnt *= type[0];
            } else {
                rnt *= type[1];
            }
        } // end else

        System.out.println(rnt);
    }
}
