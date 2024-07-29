package AssignmentFolder.day0729.c.modeling.ex01.ans;

public class Rectangle {
    String color;
    int width;
    int length;
    int area;
    int parimeter;

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String area() {
        this.area = width * length;
        return String.valueOf((area));
    }

    public String parimeter() {
        this.parimeter = 2 * (width + length);
        return String.valueOf(parimeter);
    }

    public String getColor() {
        return color;
    }

}

