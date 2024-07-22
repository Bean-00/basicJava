package jb02.assignment;

public class TwoNumSum {
    public static void main(String[] args) {
        if (args.length == 2) {
            int firstNum = Integer.parseInt(args[0]);
            int secondNum = Integer.parseInt(args[1]);

            if (firstNum != secondNum) {
                int big;
                int small;
                int sum = 0;
                if (firstNum > secondNum) {
                    big = firstNum;
                    small = secondNum;
                } else {
                    big = secondNum;
                    small = firstNum;
                }
                for (int i = small; i <= big; i++) {
                    sum += i;
                }
                System.out.println(firstNum + " ~ " + secondNum + "의 합은 " + sum + "입니다.");
            } else {
                System.out.println("입력값이 같습니다. 서로 다른 두 수를 입력해주세요.");
            }
        } else {
            System.out.println("두 수를 입력해주세요.");
        }
    }
}