package jb02.assignment;

public class MultiplicationTable {
    public static void main(String[] args) {
        if (args.length == 2) {
            int firstNum = Integer.parseInt(args[0]);
            int secondNum = Integer.parseInt(args[1]);

            if ((1 <= firstNum && firstNum <= 9) || (1 <= secondNum && secondNum <= 9)) {
                for (int i = 1; i <= firstNum; i++) {
                    System.out.println(i + " * " + secondNum + " = " + i * secondNum);
                }
            } else {
                System.out.println("입력값은 1~9만 가능합니다.");
            }

        } else {
            System.out.println("두 수를 입력해주세요");
        }
    }
}