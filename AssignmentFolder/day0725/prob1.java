package AssignmentFolder.day0725;

import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        int number = 0;
        int count = 0;
        int sum = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("양의 정수를 입력하세요");
        number = keyboard.nextInt();

        for (int i = 1; i <= 1000; i++) {
            if (i % number == 0) {
                count++;
                sum += i;
            }
        }

        System.out.println(number + "의 배수 개수 = " + count);
        System.out.println(number + "의 배수 합 = " + sum);
    }
}