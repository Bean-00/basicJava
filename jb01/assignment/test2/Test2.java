package jb01.assignment.test2;

public class Test2 {
    public static void main(String[] args) {
        if (args.length == 2) {
            int firstNum = Integer.parseInt(args[0]);
            int secondNum = Integer.parseInt(args[1]);

            System.out.print("첫번째인수: " + firstNum + ", ");
            System.out.print("두번째 인수: " + secondNum + ", ");

            if (firstNum == secondNum) {
                System.out.println("a와 b의 크기가 같아 연산이 불가능합니다.");
            } else if (firstNum < secondNum) {
                System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
            } else {
                System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
            }
        } else {
            System.out.println("두 수를 입력해주세요.");
        }
    }
}