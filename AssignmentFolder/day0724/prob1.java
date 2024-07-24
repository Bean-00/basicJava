package AssignmentFolder.day0724;

import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("1보다 크고 10보다 작은 정수를 입력하세요: ");
        int inputInt = keyboard.nextInt();
        if (inputInt < 2 || inputInt > 9) {
            System.out.println("잘못된 숫자가 입력되었습니다.");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            System.out.println(inputInt + " * " + i + " = " + inputInt * i);
        }
    }
}