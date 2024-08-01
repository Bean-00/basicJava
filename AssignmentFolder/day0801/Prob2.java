package AssignmentFolder.day0801;

public class Prob2 {
    static void printGugudan (int num) {
        if (num <= 0 || num >= 10) {
            System.out.println("1 이상 9 이하의 값을 입력하셔야 합니다.");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("주어진 숫자까지의 구구단을 찍습니다");
        System.out.println("----------Sample1-----------");
        printGugudan(4);

        System.out.println("----------Sample2-----------");
        printGugudan(9);

        System.out.println("----------Sample3-----------");
        printGugudan(-1);

        System.out.println("----------Sample4-----------");
        printGugudan(10);
    }
}