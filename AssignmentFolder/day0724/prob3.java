package AssignmentFolder.day0724;

import java.util.Scanner;

public class prob3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1보다 크고 10보다 작은 정수를 입력하세요");

        int inputInt = keyboard.nextInt();
        if (inputInt < 2 || inputInt > 9) {
            System.out.println("잘못된 숫자가 입력되었습니다.");
            return;
        }

        int keyNum = 1;
        while (keyNum <= inputInt){
            int result = 1;
            for (int i = 1; i <= keyNum; i++) {
                result *= i;
            }
            System.out.println(keyNum + "! = " + result);
            keyNum++;
        }
    }
}