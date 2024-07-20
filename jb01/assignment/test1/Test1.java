package jb01.assignment.test1;

public class Test1 {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println("나의 이름은 " + args[0] + "입니다.");
            System.out.println(args[0] + "씨의 [hp]는 " + args[1] + "입니다.");
        } else {
            System.out.println("이름과 전화번호 모두 입력해주세요.");
        }
    }
}
