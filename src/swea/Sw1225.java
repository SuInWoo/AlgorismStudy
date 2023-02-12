package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class Sw1225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<10;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int cnt = 0;
            int tc = sc.nextInt();

            for (int j = 0; j < 8; j++) {
                arr.add(sc.nextInt());
            }
            while (true) {
                cnt++;
                int tmp = arr.get(0) - cnt;
                if (tmp <= 0) {
                    arr.add(Integer.valueOf(0));
                    arr.remove(0);
                    break;
                }

                arr.add(tmp);
                arr.remove(0);
                if (cnt == 5)
                    cnt = 0;
            }

            System.out.print("#" + tc + " ");
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }

    }

}
