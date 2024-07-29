package AssignmentFolder.day0729;

import AssignmentFolder.day0729.c.modeling.ex01.ans.Rectangle;
import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Rectangle rec1 = new Rectangle();
        System.out.println("첫번째 직사각형의 색깔 ");
        rec1.setColor(keyboard.next());

        System.out.println("첫번째 직사각형의 가로 ");
        rec1.setWidth(keyboard.nextInt());

        System.out.println("첫번째 직사각형의 세로 ");
        rec1.setLength(keyboard.nextInt());

        Rectangle rec2 = new Rectangle();

        System.out.println("두번째 직사각형의 색깔 ");
        rec2.setColor(keyboard.next());

        System.out.println("두번째 직사각형의 가로 ");
        rec2.setWidth(keyboard.nextInt());

        System.out.println("두번째 직사각형의 세로 ");
        rec2.setLength(keyboard.nextInt());

        System.out.println(rec1.getColor() + " 직사각형의 넓이는 " + rec1.area() + "이고 둘레는 "
                + rec1.parimeter() + "입니다.");

        System.out.println(rec2.getColor() + " 직사각형의 넓이는 " + rec2.area() + "이고 둘레는 "
                + rec2.parimeter() + "입니다.");

        String maxArea;
        String maxParimeter;

        maxArea = Integer.valueOf(rec1.area()) > Integer.valueOf(rec2.area())?
                rec1.getColor(): rec2.getColor();
        System.out.println("크기가 더 큰 직사각형은 " + maxArea + "입니다.");

        maxParimeter = Integer.valueOf(rec1.parimeter()) > Integer.valueOf(rec2.parimeter())?
                rec1.getColor(): rec2.getColor();
        System.out.println("둘레가 더 큰 직사각형은 " + maxParimeter + "입니다.");
    }
}

