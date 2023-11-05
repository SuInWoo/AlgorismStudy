package boj;

import java.util.Scanner;

public class Boj9655_돌게임 {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        if(in%2 == 0) {
            System.out.println("CY");
        } else
            System.out.println("SK");
    }
}
