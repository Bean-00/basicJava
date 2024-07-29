package AssignmentFolder.day0729;

import java.util.Scanner;

public class FactorialUtil {
    int result = 1;
    String factorialResult;

    public int factorial(int n) {

        if (n != 0) {
            this.result *= n;
            if (this.factorialResult == null)
                factorialResult = (String.valueOf(n) + " * ");
            else if (this.factorialResult != null && n != 1)
                factorialResult += (String.valueOf(n) + " * ");
            else
                factorialResult += (String.valueOf(n));
            return (factorial(--n));
        } else {
            return this.result;
        }

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input   = ");

        FactorialUtil util = new FactorialUtil();
        int inputInt = keyboard.nextInt();

        if (inputInt < 2 || inputInt > 9) {
            System.out.println("잘못된 숫자가 입력되었습니다.");
            return;
        }
        System.out.print("팩토리얼 결과 값 = " + util.factorial(inputInt) + "  ( "
            + util.factorialResult + " )");

    }
}