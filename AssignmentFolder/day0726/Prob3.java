package AssignmentFolder.day0726;

import java.util.Scanner;

public class Prob3 {
    public int abs(int num1, int num2) {

        int result = num1 - num2;
        result = result > 0 ? result : -result;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("차를 구할 두 숫자를 입력해주세요.");
        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();
        Prob3 prob3 = new Prob3();

        System.out.println("두 수의 차는 " + prob3.abs(firstNum, secondNum));
    }

}