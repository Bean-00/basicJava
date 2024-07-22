package jb02.assignment;

public class Example4 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "단을 출력합니다.");
            for (int j = 1; j < 10; j++) {
                System.out.println(j + " * " + i + " = " + j * i);
            }
        }
    }
}