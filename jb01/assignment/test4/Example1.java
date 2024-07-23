package jb01.assignment.test4;

public class Example1 {
    public static void main(String[] args) {
        if (args.length == 1) {
            int score = Integer.parseInt(args[0]);
            if (score > 100 || score < 0) {
                System.out.println("올바른 점수가 아닙니다. 0점과 100점 사이의 점수를 입력해주세요");
            } else if (90 <= score) {
                System.out.println("입력하신 값 " + score + "점은 수입니다.");
            } else if (80 <= score && score < 90) {
                System.out.println("입력하신 값 " + score + "점은 우입니다.");
            } else if (70 <= score && score < 80) {
                System.out.println("입력하신 값 " + score + "점은 미입니다.");
            } else if (60 <= score && score < 70) {
                System.out.println("입력하신 값 " + score + "점은 양입니다.");
            } else {
                System.out.println("입력하신 값 " + score + "점은 가입니다.");
            }
        } else {
            System.out.println("하나의 점수만 입력해주세요.");
        }
    }
}