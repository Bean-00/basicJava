package AssignmentFolder.day0726;

import java.util.Scanner;

public class prob2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("하나의 숫자를 입력해주세요 (0, 음수, 짝수가 아닌 홀수만 가능)");

        int star = sc.nextInt();
        if (star <= 0 || star % 2 == 0) {
            System.out.println("하나의 숫자만 입력해주세요");
            return;
        }
        for (int i = 0; i < star; i++) {
            for (int blank = 0; blank <= i; blank++) {
                System.out.print(" ");
            }
            for (int j = star - 2 * i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}