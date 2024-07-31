package AssignmentFolder.day0731;

public abstract class Shape {
    protected double area;
    private String name;

    public Shape () {
    }

    public abstract void calculationArea();

    public void setName(String name) {
        this.name = name;
    }

    public void print () {
        System.out.println(this.name + " 면적은 " + this.area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle (String name, double radius) {
        super.setName(name);
        this.radius = radius;
        calculationArea();
    }

    public void calculationArea() {
        this.area = Math.PI * Math.pow(this.radius, 2);
    }
}

class Rectangular extends Shape {
    private double width;
    private double height;

    public Rectangular (String name, double width, double height) {
        super.setName(name);
        this.width = width;
        this.height = height;
    }

    public void calculationArea() {
        this.area = this.width * this.height;
    }
}