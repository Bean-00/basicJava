package jb02.assignment;

public class TwoNumSum {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 수를 입력해주세요.");
            return;
        }

        int firstNum = Integer.parseInt(args[0]);
        int secondNum = Integer.parseInt(args[1]);

        if (firstNum == secondNum) {
            System.out.println("입력값이 같습니다. 서로 다른 두 수를 입력해주세요.");
            return;
        }

        int max = firstNum > secondNum ? firstNum : secondNum;
        int min = firstNum > secondNum ? secondNum : firstNum;
        int sum = 0;

        for (int i = min; i <= max; i++) {
            sum += i;
        }
        System.out.println(firstNum + " ~ " + secondNum + "의 합은 " + sum + "입니다.");
    }
}