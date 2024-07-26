package AssignmentFolder.day0726;

import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("년도를 입력해주세요");
        int year = in.nextInt();

        System.out.println(("월을 입력해주세요"));
        int month = in.nextInt();
        boolean isFeb = month == 2? true : false;

        boolean isThirtyOne =
                ((month == 1) || (month == 3) ||
                  (month == 5) || (month == 7) || (month == 8) ||
                        (month == 10) || (month == 12))? true : false;

        if (isFeb && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + "년 2월의 말일은 29일입니다");
        } else if (isFeb) {
            System.out.println(year + "년 2월의 말일은 28일입니다");
        } else {
            if (isThirtyOne) {
                System.out.println(year + "년 " + month + "월의 말일은 31일입니다");
            } else {
                System.out.println(year + "년 " + month + "월의 말일은 30일입니다");
            }
        }


    }
}