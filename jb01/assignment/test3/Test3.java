package jb01.assignment.test3;

public class Test3 {
    public static void main(String[] args) {
        if (args.length == 2) {
            int firstNum = Integer.parseInt(args[0]);
            int secondNum = Integer.parseInt(args[1]);

            System.out.print("입력하신 1번째 인자값 " + firstNum + "은 ");
            if (firstNum % 2 == 0) {
                System.out.print("짝수이며 ");
                if (firstNum % 3 == 0) {
                    System.out.println("3의 배수입니다.");
                } else {
                    System.out.println("3의 배수가 아닙니다.");
                }
            } else {
                System.out.print("홀수이며 ");
                if (firstNum % 3 == 0) {
                    System.out.println("3의 배수입니다.");
                } else {
                    System.out.println("3의 배수가 아닙니다.");
                }
            }

            System.out.print("입력하신 2번째 인자값 " + secondNum + "은 ");
            if (secondNum % 2 == 0) {
                System.out.print("짝수이며 ");
                if (secondNum % 3 == 0) {
                    System.out.println("3의 배수입니다.");
                } else {
                    System.out.println("3의 배수가 아닙니다.");
                }
            } else {
                System.out.print("홀수이며 ");
                if (secondNum % 3 == 0) {
                    System.out.println("3의 배수입니다.");
                } else {
                    System.out.println("3의 배수가 아닙니다.");
                }
            }
        }else {
            System.out.println("두 수를 입력해주세요.");
        }
    }
}
